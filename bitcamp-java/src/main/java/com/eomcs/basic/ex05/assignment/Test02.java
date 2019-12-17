package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test02{
  public static void main (String[] args){
    Scanner keyboard = new Scanner(System.in);

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    System.out.print("입력? ");
    int no1 = keyboard.nextInt();
    int no2 = keyboard.nextInt();
    int no3 = keyboard.nextInt();
    int no4 = keyboard.nextInt();
    int no5 = keyboard.nextInt();

    keyboard.nextLine();

    int[] data = {no1, no2, no3, no4, no5};
    for (int i = 0; i < data.length; i++) {
      if (data[i] > max) {
        max = data[i];
      }
      if (data[i] < min){
        min = data[i];
      }
    }

    System.out.printf("최소값: %d\n최대값: %d", min, max);

    keyboard.close();
  }
}