// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("값1? ");
    int no1 = keyboard.nextInt();

    keyboard.nextLine();

    System.out.print("연산자(+,-,*,/)? ");
    String calculation  = keyboard.nextLine();

    System.out.print("값2? ");
    int no2 = keyboard.nextInt();

    System.out.println();

    if(calculation.equals("+")){
      int result = no1 + no2;
      System.out.printf("%d %s %d = %d", no1, calculation, no2, result);
    }

    else if(calculation.equals("-")){
      int result = no1 - no2;
      System.out.printf("%d %s %d = %d", no1, calculation, no2, result);
    }

    else if(calculation.equals("*")){
      int result = no1 * no2;
      System.out.printf("%d %s %d = %d", no1, calculation, no2, result);
    }
    else if(calculation.equals("/")){
      int result = no1 / no2;
      System.out.printf("%d %s %d = %d", no1, calculation, no2, result);
    }
    else {
      System.out.println("잘못된 값"); 
    }
    keyboard.close();



  }
}
