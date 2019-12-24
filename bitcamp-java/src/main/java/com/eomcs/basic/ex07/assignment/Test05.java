package com.eomcs.basic.ex07.assignment;
import java.util.Scanner;
// 과제: 재귀호출을 이용하여 직삼각형을 출력하라.
// 실행)
// 밑변의 길이? 5
// *
// **
// ***
// ****
// *****
//
public class Test05 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int base = 0;
    

    printTriangle(base);
    
    
    keyboard.close();
  }
  
  static void printTriangle(int base) {
    if (base <= 0)
      return;
    printTriangle(base - 1);
    System.out.print("*");
  }
}





