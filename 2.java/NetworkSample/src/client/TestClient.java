package client;
import java.net.*;
import java.io.*;

public class TestClient {
	public static void main(String[] args) {
		Socket sc = new Socket();
		System.out.println("접속 요청");
		System.out.print("ip:");
		String ip = getString();
		
		try {
			sc.connect(new InetSocketAddress(ip, 8989));
			System.out.println("서버 연결 성공");
			System.out.println(sc.getRemoteSocketAddress());
			
			//데이터 전달을 위한 byte선언
			byte[] bytes = null;
					
			OutputStream os = sc.getOutputStream();
			String message = getString();
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("메세지전송완료");
			
			InputStream in = sc.getInputStream();
			bytes = new byte[100];
			int rbc = in.read(bytes);
			message = new String(bytes, 0, rbc, "UTF-8");
			System.out.println("Sever MSG: " + message);
			
			os.close();
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(sc.isClosed()) {
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//insert String
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
