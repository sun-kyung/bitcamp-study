// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위  (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//
// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.
//
package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    //가위 0 바위 1 보 2

    int computer = (int)(Math.random()*10) % 3;

    System.out.print("가위,바위,보? ");
    String user = keyboard.nextLine();
    
    System.out.print("컴퓨터: ");
    if(computer == 0) {
      System.out.print("가위");
      if(user.equals("가위")) 
        System.out.println("\n비겼습니다");
      else if(user.equals("바위")) 
        System.out.println("\n이겼습니다");
      else if(user.equals("보")) 
        System.out.println("\n졌습니다");
      else
        System.out.println("잘못된 값");
    } 
    else if(computer == 1) {
      System.out.print("바위");
      if(user.equals("가위")) 
        System.out.println("\n졌습니다");
      else if(user.equals("바위")) 
        System.out.println("\n비겼습니다");
      else if(user.equals("보")) 
        System.out.println("\n이겼습니다");
      else
        System.out.println("잘못된 값");
    } 
    else if(computer == 2) {
      System.out.print("보");
      if(user.equals("가위")) 
        System.out.println("\n이겼습니다");
      else if(user.equals("바위")) 
        System.out.println("\n졌습니다");
      else if(user.equals("보")) 
        System.out.println("\n비겼습니다");
      else
        System.out.println("잘못된 값");
    }
    
    
    
    keyboard.close();
  }
}
