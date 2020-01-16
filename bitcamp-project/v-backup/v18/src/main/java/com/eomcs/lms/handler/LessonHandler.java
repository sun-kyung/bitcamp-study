package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  ArrayList<Lesson> lessonList;
  public Scanner input;
  
  public LessonHandler(Scanner input) {
    this.input = input;
    lessonList = new ArrayList<>();
  }
  public LessonHandler(Scanner input, int capacity) {
    this.input = input;
    lessonList = new ArrayList<>(capacity);
  }

  
  public void addLesson() {
    Lesson lesson = new Lesson();
    System.out.print("번호? ");
    lesson.setNo(input.nextInt());


    input.nextLine(); 

    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine());

    System.out.print("설명? ");
    lesson.setDescription(input.nextLine());

    System.out.print("시작일? "); 
    lesson.setStartDate(Date.valueOf(input.next()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(input.nextInt());

    System.out.print("일수업시간? ");
    lesson.setDayHours(input.nextInt());
    input.nextLine();

    lessonList.add(lesson);
    System.out.println("저장하였습니다");
  }
  public void listLesson() {
    //수업객체목록을 복사받을 배열을 준비하고 toArray()를 실행한다
    //toArray()의 리턴값은 파라미터로 넘겨준 배열의 주소이다
    Lesson[] arr = lessonList.toArray(new Lesson[this.lessonList.size()]);
    for (Lesson l : arr) {
      System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간\n일수업시간: %d시간\n", 
          l.getNo(), l.getTitle(), l.getDescription(), 
          l.getStartDate(), l.getEndDate(), l.getTotalHours(), l.getDayHours());
    }
  }
}
