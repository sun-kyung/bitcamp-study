package com.eomcs.lms.handler;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Prompt;

public class MemberUpdateCommand implements Command {
  Prompt prompt;
  MemberDao memberDao;

  public MemberUpdateCommand(MemberDao memberDao, Prompt prompt) {
    this.prompt = prompt;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("회원 번호? ");

      Member oldMember = null;
      try {
        oldMember = memberDao.findByNo(no);
      } catch (Exception e) {
        System.out.println("해당 번호의 회원이 없습니다");
        return;
      }
      Member newMember = new Member();
      newMember.setNo(oldMember.getNo());

      newMember.setName(
          prompt.inputString(String.format("이름(%s)?", oldMember.getName()), oldMember.getName()));

      newMember.setEmail(prompt.inputString(String.format("이메일(%s)?", oldMember.getEmail()),
          oldMember.getEmail()));

      newMember.setPassword(prompt.inputString(String.format("암호?", oldMember.getPassword()),
          oldMember.getPassword()));

      newMember.setPhoto(
          prompt.inputString(String.format("사진(%s)?", oldMember.getPhoto()), oldMember.getPhoto()));

      newMember.setTel(
          prompt.inputString(String.format("전화(%s)?", oldMember.getTel()), oldMember.getTel()));

      newMember.setRegisteredDate(oldMember.getRegisteredDate());

      if (oldMember.equals(newMember)) {
        System.out.println("회원정보 변경을 취소했습니다");
        return;
      }
      memberDao.update(newMember);
      System.out.println("회원정보를 변경했습니다");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생");
    }
  }
}
