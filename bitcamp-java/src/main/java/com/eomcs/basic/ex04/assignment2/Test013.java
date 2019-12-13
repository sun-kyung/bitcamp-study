// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test013 {
  public static void main(String[] args) {
    Scanner keyScann = new Scanner(System.in);

    System.out.print("값1? ");
    int a = keyScann.nextInt();

    System.out.print("값2? ");
    int b = keyScann.nextInt();

    System.out.print("연산자 (+,-,*,/)? +");
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
      System.out.println("=> 사용할 수 없는 연산자입니다.");
      return;
    }
    
    System.out.printf("=> %d %s %d = %d\n", a, op, b, result);
  }
}
