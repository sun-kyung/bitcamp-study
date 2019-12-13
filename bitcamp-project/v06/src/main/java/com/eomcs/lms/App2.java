package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int count = 0;
    int[] no = new int [100];
    String[] name = new String[100];
    String[] email = new String[100];
    String[] password = new String[100];
    String[] photo = new String[100];
    String[] tel = new String[100];
    Date[] registeredDate = new Date[100];
    String response;

    for (int i = 0; i < 5; i++) {
      System.out.print("번호?");
      no[i] = keyboard.nextInt();
      keyboard.nextLine(); 
      System.out.print("이름?");
      name[i] = keyboard.nextLine();

      System.out.print("이메일?");
      email[i] = keyboard.nextLine();

      System.out.print("암호?");
      password[i] = keyboard.nextLine();

      System.out.print("사진?");
      photo[i] = keyboard.nextLine();

      System.out.print("전화?");
      tel[i] = keyboard.nextLine();

      System.out.print("가입일?");
      registeredDate[i] = Date.valueOf(keyboard.next());
      keyboard.nextLine();

      count++;
      System.out.println();
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) {
        break;
      }
    }
    System.out.println();
    for (int i = 0; i < count; i++) 
      System.out.printf("번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s", 
          no[i], name[i], email[i], password[i], photo[i], tel[i], registeredDate[i]);

    keyboard.close();
  }
}

