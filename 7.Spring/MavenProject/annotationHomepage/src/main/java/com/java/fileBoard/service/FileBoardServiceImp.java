package com.java.fileBoard.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.fileBoard.dao.FileBoardDao;
import com.java.fileBoard.dto.FileBoardDto;

/**
 * @author KimJinsu
 * @date 2019. 12. 2.
 * @apiNote FileBoard Service
 */
@Component
public class FileBoardServiceImp implements FileBoardService {

	@Autowired
	private FileBoardDao fileBoardDao;
	@Autowired
	private FileBoardDto fileBoardDto;

	/**
	 * @apiNote 작성전 번호부여
	 */
	@Override
	public void fileBoardWrite(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		// 부모글 root글
		int boardNumber = 0; // 글번호 (DB가 결정)
		int groupNumber = 1; // 그룹번호
		int sequenceNumber = 0; // 글순서
		int sequenceLevel = 0; // 글레벨
		String getBn = request.getParameter("boardNumber");

		// 답글
		if (getBn != null) {
			boardNumber = Integer.parseInt(getBn);
			groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber = Integer
					.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel = Integer
					.parseInt(request.getParameter("sequenceLevel"));
		}

		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequencelevel", sequenceLevel);

		if (request.getParameter("pageNumber") != null) {
			request.setAttribute("pageNumber",
					request.getParameter("pageNumber"));
		} else {
			request.setAttribute("pageNumber", 1);
		}

		modelAndView.setViewName("fileboard/write");
	}

	/**
	 * @apiNote fileBoard DB값 입력
	 */
	@Override
	public void fileBoardWriteOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		fileBoardDto = (FileBoardDto) modelMap.get("fileBoardDto");
		// MultipartHttpServletRequest:
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) modelMap
				.get("request");

		fileBoardWriteUpdateNumbers(fileBoardDto);
		fileBoardDto.setWriteDate(new Date());
		fileBoardDto.setBoardNumber(0);

		MultipartFile uploadFile = request.getFile("file");
		if (uploadFile.getSize() > 0) {
			fileBoardUploadFile(uploadFile);
		}

		LogAspect.logger.info(LogAspect.logMsg + fileBoardDto.toString());

		int check = fileBoardDao.insert(fileBoardDto);

		modelAndView.addObject("check", check);
		modelAndView.setViewName("fileboard/writeOk");
	}

	/**
	 * @apiNote 시퀀스레벨 계산 및 DB연동
	 * @param boardDto
	 */
	private void fileBoardWriteUpdateNumbers(FileBoardDto boardDto) {
		int boardNumber = boardDto.getBoardNumber();
		int groupNumber = boardDto.getGroupNumber();
		int sequenceNumber = boardDto.getSequenceNumber();
		int sequenceLevel = boardDto.getSequenceLevel();

		if (boardNumber == 0) {
			int max = fileBoardDao.findMaxGroupNumber();

			if (max != 0) {
				boardDto.setGroupNumber(max + 1);
			}
		} else {
			Map<String, Integer> sequenceAndGroupMap = new HashMap<String, Integer>();
			sequenceAndGroupMap.put("groupNumber", groupNumber);
			sequenceAndGroupMap.put("sequenceNumber", sequenceNumber);
			LogAspect.logger.info(LogAspect.logMsg + sequenceAndGroupMap);

			int check = fileBoardDao.sequenceNumberUpdate(sequenceAndGroupMap);
			LogAspect.logger.info(LogAspect.logMsg + check);

			boardDto.setSequenceNumber(sequenceNumber + 1);
			boardDto.setSequenceLevel(sequenceLevel + 1);
		}
	}

	/**
	 * @apiNote fileBoard의 List를 불러와서 게시판 목록을 작성
	 */
	@Override
	public void fileBoardList(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null || pageNumber == "") {
			pageNumber = "1";
		}

		int currentPage = Integer.parseInt(pageNumber); // 1page
		int boardSize = 10; // page당 출력 게시물 수
		int startRow = (currentPage - 1) * boardSize + 1; // start num
		int endRow = boardSize * currentPage; // end num
		LogAspect.logger.info(LogAspect.logMsg + currentPage);

		int count = fileBoardDao.getCount();
		LogAspect.logger.info(LogAspect.logMsg + count);
		List<FileBoardDto> boardList = null;

		if (count > 0) {
			boardList = fileBoardDao.getBoardList(startRow, endRow);
		}

		LogAspect.logger.info(LogAspect.logMsg + boardList.size());

		request.setAttribute("boardList", boardList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("count", count);

		modelAndView.setViewName("fileboard/list");
	}

	/**
	 * @apiNote fileBoard의 글을 불러와 읽음
	 */
	@Override
	public void fileBoardRead(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		LogAspect.logger
				.info(LogAspect.logMsg + boardNumber + "\t" + pageNumber);

		fileBoardDto = fileBoardDao.read(boardNumber);
		LogAspect.logger.info(LogAspect.logMsg + fileBoardDto.toString());

		if (fileBoardDto.getFileName() != null) {

			fileBoardDto.setFileName(fileBoardDto.getFileName().split("_")[1]);
			LogAspect.logger
					.info(LogAspect.logMsg + fileBoardDto.getFileName());
		}

		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("boardDto", fileBoardDto);

		modelAndView.setViewName("fileboard/read");
	}

	/**
	 * @apiNote fileBoard Download
	 */
	@Override
	public void fileBoardDownload(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		HttpServletResponse response = (HttpServletResponse) modelMap
				.get("response");

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));

		fileBoardDto = fileBoardDao.getBoard(boardNumber);
		try {
			String dbName = fileBoardDto.getFileName().split("_")[1];
			String fileName = new String(dbName.getBytes("UTF-8"),
					"ISO-8859-1");

			response.setHeader("Content-Disposition",
					"attachment;filename=" + fileName);
			response.setContentType("application/octet-stream");
			response.setContentLength((int) fileBoardDto.getFileSize());

			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;

			bis = new BufferedInputStream(
					new FileInputStream(fileBoardDto.getPath()));
			bos = new BufferedOutputStream(response.getOutputStream());

			while (true) {
				int data = bis.read();
				if (data == -1)
					break;
				bos.write(data);
			}

			bos.flush();

			if (bos != null)
				bos.close();
			if (bis != null)
				bis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @apiNote fileBoard Update전 게시판의 값을 읽음
	 */
	@Override
	public void fileBoardUpdate(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		fileBoardDto = fileBoardDao.getBoard(boardNumber);
		fileBoardDto.setFileName(fileBoardDto.getFileName().split("_")[1]);

		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("boardDto", fileBoardDto);
		request.setAttribute("pageNumber", request.getParameter("pageNumber"));

		modelAndView.setViewName("fileboard/update");
	}

	/**
	 * @apiNote fileBoard Update 완료
	 */
	@Override
	public void fileBoardUpdateOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		// new
		fileBoardDto = (FileBoardDto) modelMap.get("fileBoardDto");
		// old
		FileBoardDto oldFileBoardDto = fileBoardDao
				.getBoard(fileBoardDto.getBoardNumber());
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) modelMap
				.get("request");

		fileBoardDto.setWriteDate(new Date());

		MultipartFile uploadFile = request.getFile("file");
		if (uploadFile.getSize() > 0) {
			fileBoardUploadFile(uploadFile);
			deleteFile(oldFileBoardDto.getPath());
		} else {
			fileBoardDto.setFileSize(oldFileBoardDto.getFileSize());
			fileBoardDto.setFileName(oldFileBoardDto.getFileName());
			fileBoardDto.setPath(oldFileBoardDto.getPath());
		}

		int check = fileBoardDao.update(fileBoardDto);

		modelAndView.addObject("check", check);
		modelAndView.setViewName("fileboard/updateOk");

	}

	/**
	 * @apiNote fileBoard Delete
	 */
	@Override
	public void fileBoardDelete(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		fileBoardDto = fileBoardDao.getBoard(boardNumber);
		int check = 0;
		if (fileBoardDto.getFileName() != null) {
			deleteFile(fileBoardDto.getPath());
		}

		check = fileBoardDao.delete(boardNumber);

		request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		request.setAttribute("check", check);
		modelAndView.setViewName("fileboard/delete");
	}

	/**
	 * @apiNote file삭제
	 * @param path
	 */
	private void deleteFile(String path) {
		File oldFile = new File(path);
		if (oldFile.exists() && oldFile.isFile()) {
			LogAspect.logger.info(LogAspect.logMsg + oldFile.delete());
		}
	}

	/**
	 * @apiNote file업로드 제어
	 * @param request
	 */
	private void fileBoardUploadFile(MultipartFile uploadFile) {

		String uploadFileName = Long.toString(System.currentTimeMillis()) + "_"
				+ uploadFile.getOriginalFilename();

		File uploadFilePath = new File("C:\\pds");
		uploadFilePath.mkdir();

		if (uploadFilePath.exists() && uploadFilePath.isDirectory()) {
			File file = new File(uploadFilePath, uploadFileName);

			try {
				uploadFile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			fileBoardDto.setFileSize(uploadFile.getSize());
			fileBoardDto.setFileName(uploadFileName);
			fileBoardDto.setPath(file.getAbsolutePath());
		}

	}
}
