package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  static final int BOARD_SIZE = 100;

  Board[] boards = new Board[BOARD_SIZE];
  int boardCount = 0;

  public static Scanner keyboard;

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호?");
    board.no = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("내용?");
    board.title = keyboard.nextLine();
    board.date = new Date(System.currentTimeMillis()); 
    board.viewCount = 0;

    this.boards[this.boardCount++] = board;
    System.out.println("저장하였습니다");
  }
  public void detailBoard() {
    System.out.print("게시물 번호?");
    int no = keyboard.nextInt();
    keyboard.nextLine();

    Board board = null;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break;
      }
    }

    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다");
      return;
    }
    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("등록일: %s\n", board.date);
    System.out.printf("조회수: %d\n", board.viewCount);
  }

  public void listBoard() {
    for (int i = 0; i < this.boardCount; i++) {
      Board b = this.boards[i];
      System.out.printf("%d, %s, %s, %d\n", b.no, b.title, b.date, b.viewCount);
    }
  }
}
