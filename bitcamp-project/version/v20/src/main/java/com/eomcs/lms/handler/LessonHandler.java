package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Prompt;

public class LessonHandler {

  LinkedList<Lesson> lessonList;
  public Prompt prompt;

  public LessonHandler(Prompt prompt) {
    this.prompt = prompt;
    lessonList = new LinkedList<>();
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    lesson.setNo(prompt.inputInt("번호? "));
    lesson.setTitle(prompt.inputString("수업명? "));
    lesson.setDescription(prompt.inputString("설명? "));
    lesson.setStartDate(prompt.inputDate("시작일? "));
    lesson.setEndDate(prompt.inputDate("종료일? "));
    lesson.setTotalHours(prompt.inputInt("총수업시간? "));
    lesson.setDayHours(prompt.inputInt("일수업시간? "));

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

  public void detailLesson() {

    int index = indexOfLesson(prompt.inputInt("수업 번호? "));

    Lesson lesson = this.lessonList.get(index);

    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", lesson.getNo());
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getDescription());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }

  public void deleteLesson() {
    int index = indexOfLesson(prompt.inputInt("수업 번호?"));

    if (index == -1) {
      System.out.println("수업 인덱스가 유효하지 않습니다");
      return;
    }
    this.lessonList.remove(index);
    System.out.println("수업을 삭제했습니다");
  }

  public void updateLesson() {
    int index = indexOfLesson(prompt.inputInt("수업 번호?"));

    Lesson oldLesson = this.lessonList.get(index);
    if (oldLesson == null) {
      System.out.println("수업 인덱스가 유효하지 않습니다");
      return;
    }
    Lesson newLesson = new Lesson();

    newLesson.setNo(oldLesson.getNo());

    newLesson.setTitle(prompt.inputString(String.format("수업명(%s)? ", 
        oldLesson.getTitle()),oldLesson.getTitle()));

    newLesson.setDescription(prompt.inputString(String.format("설명? ", 
        oldLesson.getDescription()),oldLesson.getDescription()));

    newLesson.setStartDate(prompt.inputDate(String.format("시작일(%s)?", 
        oldLesson.getStartDate()),oldLesson.getStartDate()));

    newLesson.setEndDate(prompt.inputDate(String.format("종료일(%s)? ", 
        oldLesson.getEndDate()),oldLesson.getEndDate()));

    newLesson.setTotalHours(prompt.inputInt(String.format("총수업시간(%d)? ", 
        oldLesson.getTotalHours()),oldLesson.getTotalHours()));

    newLesson.setDayHours(prompt.inputInt(String.format("일수업시간(%d)? ", 
        oldLesson.getDayHours()),oldLesson.getDayHours()));


    if(oldLesson.equals(newLesson)) {
      System.out.println("수업 변경을 취소했습니다");
      return;
    }
    lessonList.set(index, newLesson);
    System.out.println("수업을 변경했습니다");


  }
  private int indexOfLesson(int no) {
    for (int i = 0; i< this.lessonList.size(); i++) {
      if (this.lessonList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
