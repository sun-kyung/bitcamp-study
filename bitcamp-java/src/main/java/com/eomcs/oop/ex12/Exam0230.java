// 람다(lambda)문법
package com.eomcs.oop.ex12;

public class Exam0230 {
  static interface Player {
    // 추상 메서드가 두 개는 안 됨 (람다는 무조건 추상메서드 하나)
    void play();

    void stop();
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("Hello!");
    p1.play();

  }
}
