// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test012 {
  public static void main(String[] args) {
    Scanner keyScann = new Scanner(System.in);

    System.out.println("값1? 10");
    int a = keyScann.nextInt();

    System.out.println("값2? 20");
    int b = keyScann.nextInt();

    System.out.println("연산자 (+,-,*,/)? +");
    String op = keyScann. next();

    keyScann.close();

    int result = 0;

    if(op.equals("+")){
      result = a + b;
    } else if(op.equals("-")) {
      result = a - b;
    } else if(op.equals("*")) {
      result = a * b;
    } else if(op.equals("/")) {
      result = a / b;
    } else {
      System.out.println("사용할 수 없는 연산자입니다.");
    }
    
    System.out.printf("=> %d %s %d = %d\n", a, op, b, result);
  }
}
