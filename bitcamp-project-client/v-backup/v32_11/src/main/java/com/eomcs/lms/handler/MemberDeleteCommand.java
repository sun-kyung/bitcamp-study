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

      memberDao.delete(no);
      System.out.println("게시글을 삭제했습니다");
    } catch (Exception e) {
      System.out.println("삭제 실패");
    }
  }
}
