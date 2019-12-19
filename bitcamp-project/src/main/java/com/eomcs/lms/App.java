package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {


  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System. in);
    class Lesson{
    int no;
    String title;
    String description;
    Date startDate;
    Date endDate;
    int totalHours;
    int dayHours;
    }
    
    String response;
    final int SIZE = 100;
    Lesson[] lessons = new Lesson[SIZE];
    for(int i = 0; i < SIZE; i++) {
      lessons[i] = new Lesson();
    }
    int count = 0;
    
    for(int i = 0; i < SIZE; i++){
      Lesson lesson = lessons[i];
     
      System.out.print("번호? ");
      lesson.no = keyboard.nextInt();

      keyboard.nextLine(); 

      System.out.print("수업명? ");
      lesson.title = keyboard.nextLine();

      System.out.print("설명? ");
      lesson.description = keyboard.nextLine();

      System.out.print("시작일? "); 
      lesson.startDate = Date.valueOf(keyboard.next());

      System.out.print("종료일? ");
      lesson.endDate = Date.valueOf(keyboard.next());

      System.out.print("총수업시간? ");
      lesson.totalHours = keyboard.nextInt();

      System.out.print("일수업시간? ");
      lesson.dayHours = keyboard.nextInt();
      keyboard.nextLine();

      lessons[i] = lesson;
      count++;


      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y/N)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("Y")) {
        break;
      }
    }

    System.out.println();

    for (int i = 0; i < count; i++){
      Lesson lesson = lessons[i];
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간\n일수업시간: %d시간\n", 
      lesson.no, lesson.title, lesson.description, lesson.startDate, 
      lesson.endDate, lesson.totalHours, lesson.dayHours);

    keyboard.close();
    }

  }
}
