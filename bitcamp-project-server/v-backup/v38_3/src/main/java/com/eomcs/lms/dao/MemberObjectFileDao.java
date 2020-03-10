package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberObjectFileDao extends AbstractObjectFileDao<Member> implements MemberDao {

  public MemberObjectFileDao(String filename) {
    super(filename);
  }

  @Override
  public int insert(Member member) throws Exception {

    if (indexOf(member.getNo()) > -1) { // 같은 번호의 게시물이 있다면
      return 0;
    }
    list.add(member); // 새 게시물을 등록한다
    saveData();
    return 1;
  }

  @Override
  public List<Member> findAll() throws Exception {
    return list;
  }

  @Override
  public Member findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Member member) throws Exception {
    int index = indexOf(member.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, member); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }

    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i;
      }
    }
    return -1;
  }
}