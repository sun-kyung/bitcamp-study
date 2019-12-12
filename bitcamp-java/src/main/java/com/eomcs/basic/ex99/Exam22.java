package com.eomcs.basic.ex99;

public class Exam22{
  public static void main (String[] args){
    // 키보드 정보를 가져온다
    java.io.InputStream keyboard = System.in;
    
    // 키보드 객체에 정수, 부동소수점, 논리값, 문자열을 끊어서 읽어주는 도우미 객체를 붙임
    java.util.Scanner scanner = new java.util.Scanner(keyboard);

    System.out.print("입력>");
    int i1 = scanner.nextInt();
    int i2 = scanner.nextInt();
    int i3 = scanner.nextInt();


    
    System.out.println("---------------------------------------------");

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);

    // nextInt() 
    // => space, tab, new line을 만나면 그 앞까지 입력한 문자열을 int값으로 바꿔 리턴
    // => 입력한 문자열이 숫자를 의미하는 문자열이 아니라면 int값으로 바꿀 수 없기때문에 실행오류
  }
}