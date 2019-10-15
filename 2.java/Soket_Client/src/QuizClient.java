import java.io.*;
import java.net.*;
 
public class QuizClient {
       public static void main(String[] args) throws IOException {
 
             Socket quizSocket = null;
             PrintWriter out = null;
             BufferedReader in = null;
 
             try {//소캣을 생성하고, 소켓에 입력 스트림과 출력 스트림을 붙인다
                    quizSocket = new Socket("localhost",5555);
                    out = new PrintWriter(quizSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(quizSocket
                                 .getInputStream()));
             } catch (UnknownHostException e) {
                    System.err.println("localhost에  접근할 수 없습니다.");
                    System.exit(1);
             } catch (IOException e) {
            	 	e.printStackTrace();
                    System.err.println("입출력 오류");
                    System.exit(1);
             }
  	       BufferedReader user = new BufferedReader(new InputStreamReader(
                   System.in));
     String fromServer;
     String fromUser;
     //서버로 부터 문자열을 읽고 사용자의 입력을 서버로 보낸다
     while ((fromServer = in.readLine()) != null) {
            System.out.println("서버: " + fromServer);
            if (fromServer.equals("quit"))
                   break;

            fromUser = user.readLine();
            if (fromUser != null) {
                   System.out.println("클라이언트: " + fromUser);
                   out.println(fromUser);
            }
     }

     out.close();
     in.close();
     quizSocket.close();
}
}
