package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailServlet implements Servlet {
  LessonDao lessonDao;

  public LessonDetailServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");

    int no = Integer.parseInt(in.nextLine());
    Lesson lesson = lessonDao.findByNo(no);

    if (lesson != null) {
      out.printf("번호: %d\n", lesson.getNo());
      out.printf("수업명: %s\n", lesson.getTitle());
      out.printf("설명: %s\n", lesson.getDescription());
      out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
      out.printf("총수업시간: %d\n", lesson.getTotalHours());
      out.printf("일수업시간: %d\n", lesson.getDayHours());
    } else {
      out.println("조회 실패");
    }
  }

}
