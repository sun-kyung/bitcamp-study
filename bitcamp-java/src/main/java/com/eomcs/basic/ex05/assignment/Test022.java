package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

// #과제2 : 다섯 개의 정수 값을 입력받고 최소, 최대값을 구하라
// 실행 예)
// 입력? 4 17 -1 6 9
// 최소값: -1
// 최대값: 17

public class Test022{
  public static void main (String[] args){
    Scanner keyScan = new Scanner(System.in);

    int min = 0, max = 0;

    System.out.print("입력? ");
    for (int i = 0; i < 5; i++){
    int no = keyScan.nextInt();
    if (i == 0){
      min = no;
      max = no;
    }
    if (no < min) {
      min = no;
    } else if (no > max) {
      max =  no;
    }
  }
   
    System.out.printf("최소값: %d\n", min);
    System.out.printf("최대값: %d\n", max);

    keyScan.close();
  }
}