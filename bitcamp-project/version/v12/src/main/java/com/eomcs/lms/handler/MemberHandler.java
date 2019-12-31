package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member; 

public class MemberHandler {

  static final int MEMBER_SIZE = 100;
  static Member[] members = new Member[MEMBER_SIZE];
  static int memberCount = 0;
  public static Scanner keyboard;
  
  public static void addMember() {
    Member member = new Member();

    System.out.print("번호?");
    member.no = keyboard.nextInt();
    keyboard.nextLine(); 
    System.out.print("이름?");
    member.name = keyboard.nextLine();

    System.out.print("이메일?");
    member.email = keyboard.nextLine();

    System.out.print("암호?");
    member.password = keyboard.nextLine();

    System.out.print("사진?");
    member.photo = keyboard.nextLine();

    System.out.print("전화?");
    member.tel = keyboard.nextLine();

    member.registeredDate = new Date(System.currentTimeMillis());

    members[memberCount++] = member;
    System.out.println("저장하였습니다");

  }
  public static void listMember() {
    for (int i = 0; i < memberCount; i++) {
      Member m = members[i];

      System.out.printf("\n번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s\n", 
          m.no, m.name, m.email, m.password, m.photo, 
          m.tel, m.registeredDate);
    }
  }

}
