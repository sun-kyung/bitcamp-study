// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;
import com.eomcs.generic.ex01.Exam0223.A;
import com.eomcs.generic.ex01.Exam0223.B1;

public class Exam0231 {
  static class A{}
  static class B1 extends A{}
  static class B2 extends A{}
  static class C extends B1{}
  /*
  *
  *    Object
  *      |
  *      A
  *    /   \
  *   B1   B2
  *   |
  *   C
  */
  public static void main(String[] args) {
    ArrayList<B1> list1 = new ArrayList<>();
    
    // ArrayList가 Object타입의 데이터를 다루기로 했으면
    // ArrayList의 메서드 파라미터나 리턴 타입이 Object로 설정된다
    
    // add(B1)
    list1.add(new Object());
    list1.add(new String());
    list1.add(new Integer(100));
    list1.add(new Member("홍길동", 20));
    list1.add(new B1());
    list1.add(new B2());
    list1.add(new C());
    
    System.out.println("종료");

  }
}








