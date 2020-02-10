package com.eomcs.lms.handler;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.util.Prompt;

public class BoardDeleteCommand implements Command {
  Prompt prompt;
  BoardDao boardDao;

  public BoardDeleteCommand(BoardDao boardDao, Prompt prompt) {
    this.prompt = prompt;
    this.boardDao = boardDao;
  }


  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("게시글 번호?");
      boardDao.delete(no);
      System.out.println("게시글을 삭제했습니다");
    } catch (Exception e) {
      System.out.println("삭제 실패");
    }
  }

}
