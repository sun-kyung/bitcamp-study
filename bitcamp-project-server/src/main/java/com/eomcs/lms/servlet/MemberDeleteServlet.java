package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.MemberFileDao;
import com.eomcs.lms.domain.Member;

public class MemberDeleteServlet implements Servlet {
  MemberFileDao memberDao;

  public MemberDeleteServlet(MemberFileDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    int no = in.readInt();
    Member member = memberDao.findByNo(no);
    if (member != null) { // 삭제하려는 번호의 게시물을 찾았다면
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다");
    }
  }

}
