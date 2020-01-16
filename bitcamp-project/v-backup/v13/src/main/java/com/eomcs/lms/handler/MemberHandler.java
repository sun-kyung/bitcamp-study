package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member; 

public class MemberHandler {

  //인스턴스 필드(개별적으로 관리해야 하는 변수) - new명령을 통해 생성
  Member[] members = new Member[MEMBER_SIZE];
  int memberCount = 0;
  
  //클래스 필드(공유하는 변수) - 클래스가 메모리에 로딩될 때 자동으로 생성
  static final int MEMBER_SIZE = 100;
  public static Scanner keyboard;
  
  public void addMember() {
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

    this.members[this.memberCount++] = member;
    System.out.println("저장하였습니다");

  }
  public void listMember() {
    for (int i = 0; i < this.memberCount; i++) {
      Member m = this.members[i];

      System.out.printf("\n번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s\n", 
          m.no, m.name, m.email, m.password, m.photo, 
          m.tel, m.registeredDate);
    }
  }

}
