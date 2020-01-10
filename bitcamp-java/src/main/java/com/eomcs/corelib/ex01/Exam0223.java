// Wrapper 클래스 - auto-boxing/auto-unboxing 
package com.eomcs.corelib.ex01;

public class Exam0223 {

  static class Member{
    String name;
    String tel;

    @Override
    public String toString() {
      return name + "," + tel;
    }
  }
  public static void main(String[] args) {
    int i = 100;
    Member member = new Member();
    member.name = "홍길동";
    member.tel = "010-1111-2222";
    String str = new String("Hello");
    // 자바가 wrapper 클래스를 이용하여 auto-boxing, auto-unboxing기능을 제공함으로써
    // primitive data type 또는 클래스의 인스턴스 구분없이 값을 저장할 수 있게 되었다
    Object obj;
    obj = member;
    obj = str;
    obj = i;
    Integer obj2 = (Integer)obj;
    System.out.println(obj);
    System.out.println(i);
  }
}




