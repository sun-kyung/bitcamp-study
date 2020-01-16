package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member; 

public class MemberHandler {
  MemberList memberList = new MemberList();
  public Scanner input;
  
  public MemberHandler(Scanner input) {
    this.input = input;
    memberList = new MemberList();
  }
  
  public MemberHandler(Scanner input, int capacity) {
    this.input = input;
    memberList = new MemberList(capacity);
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

    memberList.add(member);
    System.out.println("저장하였습니다");

  }
  public void listMember() {
    Member[] members = memberList.toArray();
    for (Member m : members) {
      System.out.printf("\n번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getPassword(), m.getPhoto(), 
          m.getTel(), m.getRegisteredDate());
    }
  }
}
