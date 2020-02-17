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
        System.out.printf("%d, %s, %s, %s ~ %s, %d, %d시간\n", l.getNo(), l.getTitle(),
            l.getDescription(), l.getStartDate(), l.getEndDate(), l.getTotalHours(),
            l.getDayHours());
      }
    } catch (Exception e) {
      System.out.println("목록 조회 실패");
    }
  }
}
