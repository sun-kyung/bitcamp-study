// LMS 서버
package com.eomcs.lms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class ServerApp {
  Set<ApplicationContextListener> listeners = new HashSet<>();

  Map<String, Object> context = new HashMap<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  @SuppressWarnings("unchecked")
  public void service() {

    notifyApplicationInitialized();

    List<Board> boardList = (List<Board>) context.get("boardList");
    List<Lesson> lessonList = (List<Lesson>) context.get("lessonList");
    List<Member> memberList = (List<Member>) context.get("memberList");

    notifyApplicationDestroyed();

  } // service()


  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다");
    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
/*
      try (ServerSocket serverSocket = new ServerSocket(9999)) {
      System.out.println("클라이언트 연결 대기중... "); while (true) { Socket socket = serverSocket.accept();
      System.out.println("클라이언트와 연결되었음");

      // 클라이언트의 요청 처리 processRequest(socket); System.out.println("----------------------------"); }
      } catch (Exception e) { System.out.println("서버 준비 중 오류 발생!"); }
*/

  }

  static void processRequest(Socket clientSocket) {
/*
    try ( // 요청 처리가 끝난 후 클라이언트와 연결된 소켓을 자동으로 담으려면 // 이 괄호 안에 별도의 로컬 변수에 담는ㄷ Socket socket =
        clientSocket;

        // 클라이언트의 메세지를 수신하고 클라이언트로 전송할 입출력 도구 준비 Scanner in = new Scanner(socket.getInputStream());

        PrintStream out = new PrintStream(socket.getOutputStream())) {
      System.out.println(" 통신을 위한 입출력 스트림을 준비하였음");
      String message = in.nextLine();

      System.out.println("클라이언트가 보낸 메세지를 수신하였음");

      System.out.println("클라이언트: " + message);

      // 클라이언트에게 메세지를 전송한다 // => 클라이언트가 메세지를 모두 읽을 때까지 리턴하지 않는다 out.println("Hi(이선경)");
      System.out.println("클라이언트로 메세지를 전송하였음");
    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
    }
*/
  }
}
