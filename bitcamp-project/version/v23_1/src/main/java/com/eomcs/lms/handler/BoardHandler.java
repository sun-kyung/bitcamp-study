package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;

public class BoardHandler {
  List<Board> boardList;
  public Prompt prompt;

  public BoardHandler(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }

  public void addBoard() {
    Board board = new Board();

    board.setNo(prompt.inputInt("번호?"));
    board.setTitle(prompt.inputString("내용?"));
    board.setDate(new Date(System.currentTimeMillis())); 
    board.setViewCount(0);

    boardList.add(board);
    System.out.println("저장하였습니다");
  }

  public void listBoard() {
    /*// BoardList의 보관된 값을 받을 배열을 준비한다
    Board[] arr = new Board[this.boardList.size()];
    // toArray()에게 빈 배열을 넘겨서 복사받는다
    this.boardList.toArray(arr);*/
    Board[] arr = boardList.toArray(new Board[this.boardList.size()]);
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }
  public void detailBoard() {
    int index = indexOfBoard(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    Board board = this.boardList.get(index);

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  public void deleteBoard() {
    int index = indexOfBoard(prompt.inputInt("게시글 번호?"));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다");
  }

  public void updateBoard() {
    int index = indexOfBoard(prompt.inputInt("게시물 번호?"));
    Board newBoard = new Board();

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    Board oldBoard = this.boardList.get(index);
    newBoard.setTitle(prompt.inputString(String.format("내용(%s)? ", 
        oldBoard.getTitle()),oldBoard.getTitle()));

    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setDate(oldBoard.getDate()); 

    if(oldBoard.equals(newBoard)) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }
    boardList.set(index, newBoard);
    System.out.println("게시물을 변경했습니다");
  }
  
  private int indexOfBoard(int no) {
    for (int i = 0; i< this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
