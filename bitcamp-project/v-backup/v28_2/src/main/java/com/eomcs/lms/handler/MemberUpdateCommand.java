package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberUpdateCommand implements Command {
  List<Member> memberList;
  public Prompt prompt;

  public MemberUpdateCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    memberList = list;
  }

  @Override
  public void execute() {
    int index = indexOfMember(prompt.inputInt("회원 번호? "));

    Member oldMember = this.memberList.get(index);
    if (oldMember == null) {
      System.out.println("회원 인덱스가 유효하지 않습니다");
      return;
    }
    Member newMember = new Member();
    newMember.setNo(oldMember.getNo());

    newMember.setName(
        prompt.inputString(String.format("이름(%s)?", oldMember.getName()), oldMember.getName()));

    newMember.setEmail(
        prompt.inputString(String.format("이메일(%s)?", oldMember.getEmail()), oldMember.getEmail()));

    newMember.setPassword(
        prompt.inputString(String.format("암호?", oldMember.getPassword()), oldMember.getPassword()));

    newMember.setPhoto(
        prompt.inputString(String.format("사진(%s)?", oldMember.getPhoto()), oldMember.getPhoto()));

    newMember.setTel(
        prompt.inputString(String.format("전화(%s)?", oldMember.getTel()), oldMember.getTel()));

    newMember.setRegisteredDate(oldMember.getRegisteredDate());

    if (oldMember.equals(newMember)) {
      System.out.println("회원정보 변경을 취소했습니다");
      return;
    }
    memberList.set(index, newMember);
    System.out.println("회원정보를 변경했습니다");
  }

  private int indexOfMember(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      if (this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
