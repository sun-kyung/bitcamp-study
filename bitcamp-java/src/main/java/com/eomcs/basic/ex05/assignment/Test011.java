package com.eomcs.basic.ex05.assignment;

// #과제1 : 입력받은 두 정수 사이의 합계를 구하라
// 실행 예)
// 입력? 2 5
// 2에서 5까지의 합은 14입니다
import java.util.Scanner;
public class Test011{
  public static void main(String[] args){
    Scanner keyScan = new Scanner(System.in);

    System.out.print("입력? ");
    int start = keyScan.nextInt();
    int end = keyScan.nextInt();

    int sum = 0;
    for (int no = start; no <= end; no++) {
      sum += no;
      no++;
    }
    
    System.out.printf("%d에서 %d까지의 합은 %d입니다.\n", start, end, sum);

    keyScan.close();
  }
}