package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {
  ArrayList<Board> boardList;
  Scanner input;

  public BoardHandler(Scanner input){
    this.input = input;
    this.boardList = new ArrayList<>();
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호?");
    board.setNo(input.nextInt());
    input.nextLine();
    System.out.print("내용?");
    board.setTitle(input.nextLine());
    board.setDate(new Date(System.currentTimeMillis())); 
    board.setViewCount(0);

    boardList.add(board);
    System.out.println("저장하였습니다");
  }

  public void listBoard() {
    // BoardList의 보관된 값을 받을 배열을 준비한다
    Board[] arr = new Board[this.boardList.size()];
    // toArray()에게 빈 배열을 넘겨서 복사받는다
    this.boardList.toArray(arr);
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }
  public void detailBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    // 게시글 번호로 객체를 찾는다
    int index = indexOfBoard(no);

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
    System.out.print("게시글 번호?");
    int no = input.nextInt();
    input.nextLine();

    // 게시글 번호로 객체를 찾는다
    int index = indexOfBoard(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다");
  }

  public void updateBoard() {
    System.out.print("게시물 번호?");
    int no = input.nextInt();
    input.nextLine();
    Board newBoard = new Board();
    // 게시글 번호로 객체를 찾는다
    int index = indexOfBoard(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    Board oldBoard = this.boardList.get(index);
    System.out.printf("내용(%s)?", oldBoard.getTitle());
    String title = input.nextLine();

    if (title.length() == 0) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setTitle(title);
    newBoard.setDate(new Date(System.currentTimeMillis())); 

    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다");
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
