package com.eomcs.basic.ex02;

public class Exam3 {
  public static void main(String[] args) {
    // multi-line comments
    System.out.println("애노테이션");
    
    Class c = Exam3.class;
  }

  @Override //<-컴파일러에게 메서드 재정의함을 알리는 명령어(애노테이션 annotation)
  public String toString() {
    return "okok";
  }
}