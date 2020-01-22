package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonDeleteCommand implements Command {

  List<Lesson> lessonList;
  public Prompt prompt;

  public LessonDeleteCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    lessonList = list;
  }

  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("수업 번호?"));

    if (index == -1) {
      System.out.println("수업 인덱스가 유효하지 않습니다");
      return;
    }
    this.lessonList.remove(index);
    System.out.println("수업을 삭제했습니다");
  }

  private int indexOfLesson(int no) {
    for (int i = 0; i < this.lessonList.size(); i++) {
      if (this.lessonList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
