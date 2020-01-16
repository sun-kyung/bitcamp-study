package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {
  // 목록을 다루는 객체를 지정할 때 
  // 특정 클래스(AbstractList, LinkedList, ArrayList)를 지정하는 대신에
  // 사용 규칙(List)을 준수하는 객체를 지정함으로써 객체를 더 폭넓게 교체할 수 있도록 한다
  // => List사용규칙을 구현한 객체라면 어떤 클래스의 객체든지 사용할 수 있다
  // 결국 유지보수를 더 유연하게 하기 위함이다
  
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
    
    Iterator<Board> iterator = boardList.iterator();
    while (iterator.hasNext()) {
      Board b = iterator.next();
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
