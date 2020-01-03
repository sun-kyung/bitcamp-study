package com.eomcs.oop.ex06.c;

public class D2 extends D {
  @Override
  void m() {
    System.out.println("D2의 m()");
  }

  void test() {
    // this 레퍼런스로 메서드를 호출하면 
    // => 현재 클래스부터 메서드를 찾아 호출한다
    // => 현재 클래스에 메서드가 없으면 수퍼 클래스에서 메서드를 찾는다
    // => 최상위 클래스를 만날 때까지 계속 반복한다
    this.m();

    // super 레퍼런스로 메서드를 호출하면
    // => 수퍼 클래스에서 메서드를 찾아 호출한다
    // => 수퍼 클래스에 없으면 그 상위 클래스로 따라 올라간다
    // => 오버라이딩 하기 전에 메서드를 호출하고 싶을 때 유용하다
    super.m();
  }
}






