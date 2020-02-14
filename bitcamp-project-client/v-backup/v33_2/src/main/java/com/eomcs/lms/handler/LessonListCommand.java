package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  LessonDao lessonDao;

  public LessonListCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    try {
      List<Lesson> lessons = lessonDao.findAll();
      for (Lesson l : lessons) {
        System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간\n일수업시간: %d시간\n",
            l.getNo(), l.getTitle(), l.getDescription(), l.getStartDate(), l.getEndDate(),
            l.getTotalHours(), l.getDayHours());
      }
    } catch (Exception e) {
      System.out.println("목록 조회 실패");
    }
  }
}
