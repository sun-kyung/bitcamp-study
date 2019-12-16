package com.eomcs.basic.ex04.assignment3;

// 입력? n m
// n 부터 m 까지의 합은  입니다
import java.util.Scanner;
public class Test01{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    int sum = 0;
    
    System.out.print("입력?");
    int no1 = keyboard.nextInt();
    int no2 = keyboard.nextInt();

    keyboard.nextLine();

    for(int i = no1; i <= no2; i++){
      sum += i;
    }

    System.out.printf("%d 에서 %d 까지의 합은 %d 입니다.", no1, no2, sum);
    keyboard.close();


  }
}