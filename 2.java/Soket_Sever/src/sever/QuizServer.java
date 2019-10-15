package sever;

import java.net.*;
import java.io.*;
//������Ǯ ����� ���� ��Ű����
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;


public class QuizServer {
	private static final int PORT = 5555; //������ ��Ʈ����
	private static final int THREAD_CNT = 5; //������Ǯ�� �ִ� ������ �� ����
	//������Ǯ ����. �ھ� ������ ��, �ִ� ������ ��, �����ð�, �ð�����, ���ŷť�� ��
	private static ExecutorService threadPool = new ThreadPoolExecutor(THREAD_CNT, THREAD_CNT, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(15));
	private static ServerSocket serverSocket = null; //��������
    public static void main(String[] args) throws IOException {
    	try {
			serverSocket = new ServerSocket(PORT); // ������ ���� ����
			while (true) {
				Socket connectSocket = serverSocket.accept(); // ������ ���� ��û�� �ö����� ���
				try {
					//��û�� ���� ������Ǯ�� ������� ������ �־���
					//���� ó���� ������ ������ ó��
					threadPool.execute(new ConnectSocket(connectSocket));
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("accept() ����");
				}
			} // while end
		} catch (IOException e) {
			System.err.println("������ ��Ʈ ��ȣ�� ������ �� �����ϴ�: " + PORT);
			System.exit(1);
		} finally {
			threadPool.shutdown(); //������Ǯ ����
			serverSocket.close(); //���� ���� ����
		}
	}
	
   static class ConnectSocket implements Runnable {
    	
    	private Socket clientSocket = null; //Ŭ���̾�Ʈ ���� ����
    	
    	public ConnectSocket(Socket socket) {
    		clientSocket = socket; //���ο��� �޾ƿ� Ŭ���̾�Ʈ ������ ����
    	}
    	
    	@Override
    	public void run() {

    		try {
    			System.out.println("����� ����");
    			// ���Ͽ� �Է� ��Ʈ���� ��� ��Ʈ���� �����Ѵ�
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
    			} // Ŭ���̾�Ʈ�� ���� ��û�� �о, ��� ���� ���� �д´�
    			//���ϵ� ����
    			out.close();
    			in.close();
    			clientSocket.close();
    			System.out.println("����� ��������"); //������ ����ڰ� ������ �����Ͽ����� �˸�
    		} catch (IOException e) {
    			e.printStackTrace();
    		} 
    	}//run end
    }//ConnectSocket end
}



