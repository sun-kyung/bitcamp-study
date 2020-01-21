// 람다(lambda)문법
package com.eomcs.oop.ex12;

public class Exam0240 {
  // 람다는 인터페이스만 된다 (추상 메서드 한 개짜리 인터페이스)
  static abstract class Player {
    public abstract void play();
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("Hello!"); // 컴파일 오류
    p1.play();

  }
}
