package com.eomcs.lms.handler;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Prompt;

public class MemberDetailCommand implements Command {
  Prompt prompt;
  MemberDao memberDao;

  public MemberDetailCommand(MemberDao memberDao, Prompt prompt) {
    this.prompt = prompt;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("회원 번호? ");

      Member member = memberDao.findByNo(no);

      System.out.printf("번호: %d\n", member.getNo());
      System.out.printf("이름: %s\n", member.getName());
      System.out.printf("이메일: %s\n", member.getEmail());
      System.out.printf("암호: %s\n", member.getPassword());
      System.out.printf("사진: %s\n", member.getPhoto());
      System.out.printf("전화: %s\n", member.getTel());
      System.out.printf("가입일: %s\n", member.getRegisteredDate());
    } catch (Exception e) {
      System.out.println("조회 실패");
    }
  }
}
