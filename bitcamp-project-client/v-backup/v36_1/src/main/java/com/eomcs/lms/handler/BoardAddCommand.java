package com.eomcs.lms.handler;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Prompt;

public class BoardAddCommand implements Command {

  Prompt prompt;
  BoardDao boardDao;

  public BoardAddCommand(BoardDao boardDao, Prompt prompt) {
    this.prompt = prompt;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    Board board = new Board();

    board.setTitle(prompt.inputString("내용?"));
    board.setViewCount(0);

    try {
      boardDao.insert(board);
      System.out.println("저장하였습니다");
    } catch (Exception e) {
      System.out.println("통신 오류 발생");
    }
  }
}
