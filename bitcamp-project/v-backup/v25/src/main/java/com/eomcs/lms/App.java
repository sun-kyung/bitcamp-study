package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;

public class App {
  // java.util.Stack에서 제공하는 Iterator 객체는 FIFO방식으로 값을 꺼내준다
  // LIFO 방식으로 꺼내는 Iterator가 필요하다면
  // java.util.Deque 구현체를 사용하라
  static Scanner keyboard = new Scanner(System. in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);
    
    LinkedList<Board> boardList = new LinkedList<>();
    BoardHandler boardHandler = new BoardHandler(prompt, boardList);
    
    ArrayList<Lesson> lessonList = new ArrayList<>();
    LessonHandler lessonHandler = new LessonHandler(prompt,lessonList);
    
    LinkedList<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(prompt, memberList);
    String command;
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      if (command.length() == 0)
        continue;

      commandStack.push(command);
      commandQueue.offer(command);

      switch(command) {
        case "/lesson/add":
          lessonHandler.addLesson();
          break;
        case "/lesson/list":
          lessonHandler.listLesson();
          break;
        case "/lesson/detail":
          lessonHandler.detailLesson();
          break;
        case "/lesson/update":
          lessonHandler.updateLesson();
          break;
        case "/lesson/delete":
          lessonHandler.deleteLesson();
          break;
        case "/member/add":
          memberHandler.addMember();
          break;
        case "/member/list":
          memberHandler.listMember();
          break;
        case "/member/detail":
          memberHandler.detailMember();
          break;
        case "/member/delete":
          memberHandler.deleteMember();
          break;
        case "/member/update":
          memberHandler.updateMember();
          break;
        case "/board/add":
          boardHandler.addBoard();
          break;
        case "/board/list":
          boardHandler.listBoard();
          break;
        case "/board/detail":
          boardHandler.detailBoard();
          break;
        case "/board/update":
          boardHandler.updateBoard();
          break;
        case "/board/delete":
          boardHandler.deleteBoard();
          break;
        case "history":
          printCommandHistory(commandStack.iterator());
          break;
        case "history2":
          printCommandHistory(commandQueue.iterator());
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
  private static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;
      if((count % 5) == 0) {
        System.out.println(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

}

