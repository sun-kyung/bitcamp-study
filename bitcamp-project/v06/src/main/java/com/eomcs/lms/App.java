package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {


  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System. in);

    int count = 0;
    final int SIZE = 100;
    int[] no = new int [SIZE];
    String[] title = new String[SIZE];
    String[] description = new String[SIZE];
    Date[] startDate = new Date[SIZE];
    Date[] endDate = new Date[SIZE];
    int[] totalHours = new int [SIZE];
    int[] dayHours = new int [SIZE];
    String response;

    for(int i = 0; i < 5; i++) {
      count++;
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();


      keyboard.nextLine(); 

      System.out.print("수업명? ");
      title[i] = keyboard.nextLine();

      System.out.print("설명? ");
      description[i] = keyboard.nextLine();

      System.out.print("시작일? "); 
      startDate[i] = Date.valueOf(keyboard.next());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboard.next());

      System.out.print("총수업시간? ");
      totalHours[i] = keyboard.nextInt();

      System.out.print("일수업시간? ");
      dayHours[i] = keyboard.nextInt();
      keyboard.nextLine();


      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y/N)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) {
        break;
      }
    }

    System.out.println();

    for (int i = 0; i < count; i++)
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간\n일수업시간: %d시간\n", 
          no[i], title[i], description[i], startDate[i], endDate[i], totalHours[i], dayHours[i]);

    keyboard.close();

  }
}
