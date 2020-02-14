package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  public LessonListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/lesson/list");
      out.flush();
      String response = in.readUTF();

      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      List<Lesson> lessons = (List<Lesson>) in.readObject();
      for (Lesson l : lessons) {
        System.out.printf("번호: %d\n수업명: %s\n설명: %s\n기간: %s ~ %s\n총수업시간: %d 시간\n일수업시간: %d시간\n",
            l.getNo(), l.getTitle(), l.getDescription(), l.getStartDate(), l.getEndDate(),
            l.getTotalHours(), l.getDayHours());
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생");
    }
  }
}
