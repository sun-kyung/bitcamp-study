package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {
  static Scanner keyboard = new Scanner(System. in);

  public static void main(String[] args) {

    
    //BoardHandler의 메서드가 사용할 메모리만 게시판마다 따로 생성한다
    BoardHandler 게시판1 = new BoardHandler(keyboard);
    BoardHandler 게시판2 = new BoardHandler(keyboard, 200);
    BoardHandler 게시판3 = new BoardHandler(keyboard, 1000);
    BoardHandler 게시판4 = new BoardHandler(keyboard);
    BoardHandler 게시판5 = new BoardHandler(keyboard, 9000);
    BoardHandler 게시판6 = new BoardHandler(keyboard, 20000);
    
    LessonHandler 정규수업 = new LessonHandler(keyboard);
    MemberHandler 일반회원 = new MemberHandler(keyboard);
    String command;
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      switch(command) {
        case "/lesson/add":
          //다른 클래스로 분리한 메서드를 호출할 때는 클래스 이름을 지정해야 한다
          정규수업.addLesson();
          break;

        case "/lesson/list":
          정규수업.listLesson();
          break;

        case "/member/add":
          일반회원.addMember();
          break;

        case "/member/list":
          일반회원.listMember();
          break;

        case "/board/add":
          게시판1.addBoard();
          break;
        case "/board/list":
          게시판1.listBoard();
          break;
        case "/board/detail":
          게시판1.detailBoard();
          break;
          
        case "/board2/add":
          게시판2.addBoard();
          break;
        case "/board2/list":
          게시판2.listBoard();
          break;
        case "/board2/detail":
          게시판2.detailBoard();
          break;
          
        case "/board3/add":
          게시판3.addBoard();
          break;
        case "/board3/list":
          게시판3.listBoard();
          break;
        case "/board3/detail":
          게시판3.detailBoard();
          break;
          
        case "/board4/add":
          게시판4.addBoard();
          break;
        case "/board4/list":
          게시판4.listBoard();
          break;
        case "/board4/detail":
          게시판4.detailBoard();
          break;
          
        case "/board5/add":
          게시판5.addBoard();
          break;
        case "/board5/list":
          게시판5.listBoard();
          break;
        case "/board5/detail":
          게시판5.detailBoard();
          break;
          
        case "/board6/add":
          게시판6.addBoard();
          break;
        case "/board6/list":
          게시판6.listBoard();
          break;
        case "/board6/detail":
          게시판6.detailBoard();
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    } while(!command.equalsIgnoreCase("quit"));
    System.out.println("안녕!");
    keyboard.close();
  }
}

