package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Prompt;

public class BoardUpdateCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public BoardUpdateCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("게시물 번호?");

      // 기존의 게시물을 가져온다
      out.writeUTF("/board/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      Board oldBoard = (Board) in.readObject();
      Board newBoard = new Board();

      newBoard.setTitle(
          prompt.inputString(String.format("내용(%s)? ", oldBoard.getTitle()), oldBoard.getTitle()));
      newBoard.setNo(oldBoard.getNo());
      newBoard.setViewCount(oldBoard.getViewCount());
      newBoard.setDate(oldBoard.getDate());

      if (oldBoard.equals(newBoard)) {
        System.out.println("게시물 변경을 취소했습니다");
        return;
      }
      out.writeUTF("/board/update");
      out.writeObject(newBoard);
      out.flush();
      response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("게시물을 변경했습니다");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생");
    }
  }
}

