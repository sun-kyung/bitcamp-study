package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class ServerAppTest {
  public static void main(String[] args) {


    // 키보드 스캐너 준비
    String serverAddr = null;
    int port = 0;
    Scanner keyScan = new Scanner(System.in);
    try {

      // 사용자로부터 접속할 서버의 주소와 포트번호를 입력받는다
      System.out.print("서버? ");
      serverAddr = keyScan.nextLine();
      System.out.print("포트? ");
      port = Integer.parseInt(keyScan.nextLine());

    } catch (Exception e) {
      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다");
      keyScan.close();
      return;
    }

    // try문 안에는 autoclosable 구현체만 올 수 있음
    try (
        // 서버와 연결
        Socket socket = new Socket(serverAddr, port);

        // 소켓을 통해 데이터를 읽고 쓰는 도구를 준비한다
        PrintStream out = new PrintStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      System.out.println("서버와 연결되었음");

      System.out.println("서버에 보낼 메시지: ");
      String sendMsg = keyScan.nextLine();


      out.println(sendMsg);
      System.out.println("서버에 메세지를 전송하였음");

      String message = in.readUTF();
      System.out.println("서버로부터 응답 결과를 수신하였음");

      System.out.println("서버: " + message);
      if (message.equals("OK")) {
        List<Board> list = (List<Board>) in.readObject();
        for (Board b : list) {
          System.out.println(b);
        }
      }

      System.out.println("서버와 연결을 끊었음");
    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
    }
    keyScan.close();
  }
}
