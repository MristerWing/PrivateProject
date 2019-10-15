package sever;

import java.net.*;
import java.io.*;

public class TestSever {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.14.16", 8989));
			
			while(true) {
				System.out.println("연결대기...");
				Socket socket = ss.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("연결완료. IP: " + isa.getHostName() + ":" + isa.getPort());
				
				
				//input
				InputStream is = socket.getInputStream();
				byte[] bytes = null;
				bytes = new byte[100];
				int readByteCnt = is.read(bytes);
				String msg = null;
				msg = new String(bytes, 0, readByteCnt, "UTF-8");
				System.out.println(isa.getHostName() + "'s MSG: " + msg);
				
				//OutputStream 통해서 전달 할 수 있도록 구성
				OutputStream os = socket.getOutputStream();
				String outMSG = getString();
				bytes = outMSG.getBytes("UTF-8");
				os.write(bytes);
				os.close();
				is.close();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//Socket close
			if(!ss.isClosed()) {
				ss.close();
			}
		}
		
		
	}

	// insert String
	public static String getString() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input;

		try {
			input = br.readLine();
			return input;
		} catch (IOException e) {
			System.err.println(e);
		}

		return "";
	}

}
