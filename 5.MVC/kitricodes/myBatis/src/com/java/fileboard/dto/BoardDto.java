package com.java.fileboard.dto;

import java.util.Date;
import java.util.HashMap;

public class BoardDto {
	private int boardNumber;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private String password;

	private Date writeDate;
	private int readCount;
	private int groupNumber;
	private int sequenceNumber;
	private int sequenceLevel;

	private String fileName;
	private String path;
	private long fileSize;

	private HashMap<String, String> dataMap;

	public BoardDto() {
	}

	public BoardDto(int boardNumber, String writer, String email, String subject, String content, String password,
			Date writeDate, int readCount, int groupNumber, int sequenceNumber, int sequenceLevel, String fileName,
			String path, long fileSize) {
		super();
		this.boardNumber = boardNumber;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.password = password;
		this.writeDate = writeDate;
		this.readCount = readCount;
		this.groupNumber = groupNumber;
		this.sequenceNumber = sequenceNumber;
		this.sequenceLevel = sequenceLevel;
		this.fileName = fileName;
		this.path = path;
		this.fileSize = fileSize;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date write_date) {
		this.writeDate = write_date;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public int getSequenceLevel() {
		return sequenceLevel;
	}

	public void setSequenceLevel(int sequenceLevel) {
		this.sequenceLevel = sequenceLevel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public HashMap<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(HashMap<String, String> dataMap) {
		if (dataMap.get("boardNumber") != null)
			this.setBoardNumber(Integer.parseInt(dataMap.get("boardNumber")));
		if (dataMap.get("groupNumber") != null)
			this.setGroupNumber(Integer.parseInt(dataMap.get("groupNumber")));
		if (dataMap.get("sequenceNumber") != null)
			this.setSequenceNumber(Integer.parseInt(dataMap.get("sequenceNumber")));
		if (dataMap.get("sequenceLevel") != null)
			this.setSequenceLevel(Integer.parseInt(dataMap.get("sequenceLevel")));

		if (dataMap.get("writer") != null)
			this.setWriter(dataMap.get("writer"));
		if (dataMap.get("subject") != null)
			this.setSubject(dataMap.get("subject"));
		if (dataMap.get("email") != null)
			this.setEmail(dataMap.get("email"));
		if (dataMap.get("content") != null)
			this.setContent(dataMap.get("content"));
		if (dataMap.get("password") != null)
			this.setPassword(dataMap.get("password"));
	}

	@Override
	public String toString() {
		return "BoardDto [boardNumber=" + boardNumber + ", writer=" + writer + ", email=" + email + ", subject="
				+ subject + ", content=" + content + ", password=" + password + ", writeDate=" + writeDate
				+ ", readCount=" + readCount + ", groupNumber=" + groupNumber + ", sequenceNumber=" + sequenceNumber
				+ ", sequenceLevel=" + sequenceLevel + ", fileName=" + fileName + ", path=" + path + ", fileSize="
				+ fileSize + "]";
	}

}
