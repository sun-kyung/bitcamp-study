package com.eomcs.lms.handler;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.util.Prompt;

public class MemberDeleteCommand implements Command {
  Prompt prompt;
  MemberDao memberDao;

  public MemberDeleteCommand(MemberDao memberDao, Prompt prompt) {
    this.prompt = prompt;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("회원 번호? ");

      if (memberDao.delete(no) > 0) {
        System.out.println("게시글을 삭제했습니다");
      } else {
        System.out.println("해당 번호의 회원이 없습니다");
      }
    } catch (Exception e) {
      System.out.println("삭제 실패");
    }
  }
}
