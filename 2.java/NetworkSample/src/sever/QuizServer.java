package sever;

import java.net.*;
import java.io.*;
//스레드풀 사용을 위한 패키지들
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;


public class QuizServer {
	private static final int PORT = 8989; //연결할 포트지정
	private static final int THREAD_CNT = 5; //스레드풀의 최대 스레드 수 지정
	//스레드풀 생성. 코어 스레드 수, 최대 스레드 수, 생존시간, 시간단위, 블록킹큐의 수
	private static ExecutorService threadPool = new ThreadPoolExecutor(THREAD_CNT, THREAD_CNT, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(15));
	private static ServerSocket serverSocket = null; //서버소켓
    public static void main(String[] args) throws IOException {
    	try {
			serverSocket = new ServerSocket(PORT); // 서버의 소켓 생성
			while (true) {
				Socket connectSocket = serverSocket.accept(); // 소켓의 접속 요청이 올때까지 대기
				try {
					//요청이 오면 스레드풀의 스레드로 소켓을 넣어줌
					//이후 처리는 스레드 내에서 처리
					threadPool.execute(new ConnectSocket(connectSocket));
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("accept() 실패");
				}
			} // while end
		} catch (IOException e) {
			System.err.println("다음의 포트 번호에 연결할 수 없습니다: " + PORT);
			System.exit(1);
		} finally {
			threadPool.shutdown(); //스레드풀 종료
			serverSocket.close(); //서버 소켓 종료
		}
	}
	
   static class ConnectSocket implements Runnable {
    	
    	private Socket clientSocket = null; //클라이언트 소켓 생성
    	
    	public ConnectSocket(Socket socket) {
    		clientSocket = socket; //메인에서 받아온 클라이언트 소켓을 생성
    	}
    	
    	@Override
    	public void run() {

    		try {
    			System.out.println("사용자 접속");
    			// 소켓에 입력 스트림과 출력 스트림을 연결한다
    			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    			String inputLine, outputLine;
    			QuizProtocol qp = new QuizProtocol();

    			outputLine = qp.process(null);
    			out.println(outputLine);

    			while ((inputLine = in.readLine()) != null) {
    				outputLine = qp.process(inputLine);
    				out.println(outputLine);
    				if (outputLine.equals("quit"))
    					break;
    			} // 클라이언트로 부터 요청을 읽어서, 퀴즈를 내고 답을 읽는다
    			//소켓들 종료
    			out.close();
    			in.close();
    			clientSocket.close();
    			System.out.println("사용자 접속종료"); //서버에 사용자가 접속을 종료하였음을 알림
    		} catch (IOException e) {
    			e.printStackTrace();
    		} 
    	}//run end
    }//ConnectSocket end
}



