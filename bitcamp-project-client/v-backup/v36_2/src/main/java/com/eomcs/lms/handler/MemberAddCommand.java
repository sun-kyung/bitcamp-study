package com.eomcs.lms.handler;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Prompt;

public class MemberAddCommand implements Command {
  Prompt prompt;
  MemberDao memberDao;

  public MemberAddCommand(MemberDao memberDao, Prompt prompt) {
    this.prompt = prompt;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    Member member = new Member();

    member.setName(prompt.inputString("이름?"));
    member.setEmail(prompt.inputString("이메일?"));
    member.setPassword(prompt.inputString("암호?"));
    member.setPhoto(prompt.inputString("사진?"));
    member.setTel(prompt.inputString("전화?"));

    try {
      memberDao.insert(member);
      System.out.println("저장하였습니다");
    } catch (Exception e) {
      System.out.println("통신 오류 발생");
    }
  }
}
