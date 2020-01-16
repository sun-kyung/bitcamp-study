package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  static final int LESSON_SIZE = 100;
  static Lesson[] lessons = new Lesson[LESSON_SIZE];
  static int lessonCount = 0;
  public static Scanner keyboard;
  
  public static void addLesson() {
    Lesson lesson = new Lesson();
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

    lessons[lessonCount++] = lesson;
    System.out.println("저장하였습니다");
  }
  public static void listLesson() {
    for (int i = 0; i < lessonCount; i++) {
      Lesson l = lessons[i];
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간\n일수업시간: %d시간\n", 
          l.no, l.title, l.description, 
          l.startDate, l.endDate, l.totalHours, l.dayHours);
    }
  }
}
