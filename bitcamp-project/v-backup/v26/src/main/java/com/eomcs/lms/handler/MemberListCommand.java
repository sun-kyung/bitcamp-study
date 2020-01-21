package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {
  List<Member> memberList;

  public MemberListCommand(List<Member> list) {
    memberList = list;
  }


  @Override
  public void execute() {
    Iterator<Member> iterator = memberList.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("\n번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s\n", m.getNo(),
          m.getName(), m.getEmail(), m.getPassword(), m.getPhoto(), m.getTel(),
          m.getRegisteredDate());
    }
  }

}
