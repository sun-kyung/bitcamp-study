// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test011 {
  public static void main(String[] args) {
    Scanner keyScann = new Scanner(System.in);

    System.out.println("값1? 10");
    int a = keyScann.nextInt();

    System.out.println("값2? 20");
    int b = keyScann.nextInt();

    System.out.println("연산자 (+,-,*,/)? +");
    String op = keyScann. next();

    System.out.println("=> 10 + 20 = 30");
   
    keyScann.close();

    System.out.printf("=> %d %s %d = 30\n", a, op, b);
}
