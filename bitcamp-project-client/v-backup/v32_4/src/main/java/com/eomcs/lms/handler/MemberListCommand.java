package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;

  public MemberListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }


  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/member/list");
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      List<Member> members = (List<Member>) in.readObject();
      for (Member m : members) {
        System.out.printf("\n번호: %d\n이름: %s\n이메일: %s\n암호: %s\n사진: %s\n전화: %s\n가입일: %s\n", m.getNo(),
            m.getName(), m.getEmail(), m.getPassword(), m.getPhoto(), m.getTel(),
            m.getRegisteredDate());
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생");
    }
  }
}
