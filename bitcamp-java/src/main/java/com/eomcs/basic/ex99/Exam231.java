package com.eomcs.basic.ex99;

public class Exam231{
  public static void main (String[] args){
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    // nextInt() 다음에 nextLine()을 호출할 때 공백문자가 읽히는 문제해결
    System.out.print("입력>");
    int i1 = scanner.nextInt();
    int i2 = scanner.nextInt();

    //공백만 그냥 읽는다 next()
    //한 개의 토큰token(단어)을 읽는다
    //공백을 만날 때까지 읽는다 - 물론 nextInt와 달리 값을 읽은 후 공백 제거
    
    String s1 = scanner.next();
    String s2 = scanner.next();

    int i3 = scanner.nextInt();
    String s3 = scanner.next();



    
    System.out.println("---------------------------------------------");

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(i3);
    System.out.println(s3);

    //nextInt() =>space, tab, new line기호를 만나면 그 앞까지 읽은 입력값을 int로 만들어 리턴
    //          =>현재 커서의 위치는 공백(white space; space/tab/new line)에 있다
    //            즉 값을 읽고난 후 공백을 제거하지 않는다

  }
}