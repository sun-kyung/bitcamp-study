// 다형적 변수와 오버라이딩
package com.eomcs.oop.ex06.e;

public class Exam02 {
  public static void main(String[] args) {
    A a = new A3();

    a.m(); // A의 멤버 호출
    // a가 실제 가르키는 A3 클래스부터 상위클래스로 따라 올라가면서 첫 번째로 만난 m()을 호출한다
    System.out.println("----------------");
  }
}






