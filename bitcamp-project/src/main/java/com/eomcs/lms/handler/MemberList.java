package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Member;

public class MemberList {
  static final int DEFAULT_CAPACITY = 100;
  Member[] list;
  int size = 0;

  public MemberList() {
    this.list = new Member[DEFAULT_CAPACITY];
  }

  public MemberList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Member[DEFAULT_CAPACITY];
    this.list = new Member[capacity];
  }

  public Member[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  public void add(Member member) {
    this.list[this.size++] = member;
    int oldCapacity = this.list.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    this.list = Arrays.copyOf(this.list, newCapacity);
  }
  public Member get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
}
