package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberListServlet implements Servlet {
  MemberDao memberDao;

  public MemberListServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Member> members = memberDao.findAll();
    for (Member m : members) {
      out.printf("\n %d, %s, %s, %s, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          m.getPassword(), m.getPhoto(), m.getTel(), m.getRegisteredDate());
    }
  }

}
