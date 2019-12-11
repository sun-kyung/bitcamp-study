package com.eomcs.basic.ex04;

public class Exam151{
  public static void main (String[] args){
    // 변수 사용
    int i; 
    i = 100; 

    System.out.println(i);

    int j;
    j = i; // i 변수에 들어있는 값을 j 변수에 넣어라

    // 할당연산자 '=' 변수에 값을 넣는 일을 한다
    // 문법 l-value = r-value;
    // l-value : 변수가 와야한다. 값이 올 수 없다.
    // r-value : 값, 변수, 표현식(expression)이 올 수 있다.

    i = 100;
    //200 = 300;
    //200 = i;
    j = 300; //값
    j = i; // 변수
    j = i * 3; //표현식
    j = Math.abs(-200);
    j = (i > 100) ? 1 : -1;
    // j = System.out.println(100); // 표현식이 아니라 그냥 문장

    // 문장(statement) -자바 언어로 작성한 명령어
    // 표현식(expression) -문장 중 실행할 때 값을 리턴하는 문장


  }
}