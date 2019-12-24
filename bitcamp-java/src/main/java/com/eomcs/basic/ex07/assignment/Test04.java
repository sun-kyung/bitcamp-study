package com.eomcs.basic.ex07.assignment;
import java.util.Scanner;

// 과제: 재귀호출을 이용하여 n! 을 계산하라.
// 실행)
// 입력? 5
// 5! = 1 * 2 * 3 * 4 * 5 = 120
//
public class Test04 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
      int n = 0;

    int result = factorial(n);
    System.out.println(result);
    keyScan.close();
  }
  
  static int factorial(int n) {
    if (n == 1)
    return 1;
    
    return n * factorial(n - 1);
  }
}





