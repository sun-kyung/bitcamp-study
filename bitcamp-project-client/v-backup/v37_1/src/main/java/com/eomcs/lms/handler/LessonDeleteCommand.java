package com.eomcs.lms.handler;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.util.Prompt;

public class LessonDeleteCommand implements Command {
  Prompt prompt;
  LessonDao lessonDao;

  public LessonDeleteCommand(LessonDao lessonDao, Prompt prompt) {
    this.prompt = prompt;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("수업 번호?");

      if (lessonDao.delete(no) > 0) {
        System.out.println("수업을 삭제했습니다");
      } else {
        System.out.println("해당 번호의 수업이 없습니다");
      }
    } catch (Exception e) {
      System.out.println("삭제 실패");
      e.printStackTrace();
    }
  }
}
