// 게시판 관리 - 등록
package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n) y
// 등록하였습니다.
// 등록하시겠습니까?(Y/n) n
// 등록을 취소 하였습니다.
// ----------------------------
public class Exam0110 {

  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;

    try (Scanner keyScan = new Scanner(System.in)) {

      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.println("내용? ");
      contents = keyScan.nextLine();

      System.out.println("등록하시겠습니까?(Y/N) ");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소하였습니다");
        return;
      }
    }
    try (
        Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();) {

      String sql = String.format("insert into x_board(title, contents, args) values('%s', '%s')",
          title, contents);
      int count = stmt.executeUpdate(sql);
      System.out.printf("%d개 등록하였습니다", count);
    }
  }
}


