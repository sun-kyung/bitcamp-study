package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    class Member{
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date registeredDate;
    }

    final int SIZE = 100;
    Member[] members = new Member[SIZE];
    for (int i = 0; i < SIZE; i++) {
      members[i] = new Member();
    }

    int count = 0;
    for(int i = 0; i < SIZE; i++) {
      Member member = members[i];

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


      count++;
      members[i] = member;

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      String response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) 
        break;
    }

    keyboard.close();


    System.out.println();
    for (int i = 0; i < count; i++) {
      Member member = members[i];
      System.out.printf("\n번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s\n", 
          member.no, member.name, member.email, member.password, member.photo, 
          member.tel, member.registeredDate);
    }
  }
}

