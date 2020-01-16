package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member; 

public class MemberHandler {

  //인스턴스 필드(개별적으로 관리해야 하는 변수) - new명령을 통해 생성
  Member[] members;
  int memberCount = 0;
  
  //클래스 필드(공유하는 변수) - 클래스가 메모리에 로딩될 때 자동으로 생성
  static final int MEMBER_SIZE = 100;
  public Scanner input;
  
  public MemberHandler(Scanner input) {
    this.input = input;
    this.members = new Member[MEMBER_SIZE];
  }
  
  public void addMember() {
    Member member = new Member();

    System.out.print("번호?");
    member.setNo(input.nextInt());
    input.nextLine(); 
    System.out.print("이름?");
    member.setName(input.nextLine());

    System.out.print("이메일?");
    member.setEmail(input.nextLine());

    System.out.print("암호?");
    member.setPassword(input.nextLine());

    System.out.print("사진?");
    member.setPhoto(input.nextLine());

    System.out.print("전화?");
    member.setTel(input.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.members[this.memberCount++] = member;
    System.out.println("저장하였습니다");

  }
  public void listMember() {
    for (int i = 0; i < this.memberCount; i++) {
      Member m = this.members[i];

      System.out.printf("\n번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getPassword(), m.getPhoto(), 
          m.getTel(), m.getRegisteredDate());
    }
  }

}
