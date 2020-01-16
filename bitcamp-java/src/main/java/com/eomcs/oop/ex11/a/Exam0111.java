// static nested class
package com.eomcs.oop.ex11.a;

public class Exam0111 {

  // 스태틱 멤버
  static int sValue;
  static void sm() {    }

  //인스턴스 멤버
  int iValue;
  void im() {    }
  // static nested class는 스태틱 멤버이다
  // 따라서 같은 static 멤버만 사용할 수 있다
  static class A {
    void m1() {
    }
  }
  public static void main(String[] args) {
    
  }

}
