package com.eomcs.basic.ex04;

public class Exam2_2{
  public static void main (String[] args){
    // 변수의 크기와 리터럴의 크기

    // 자바의 정수 리터럴은 4바이트와 8바이트만 있다
    // 그런데 변수의 값을 저장할 수 있다면 허락한다
    byte b;
    b = 127;  
    // 127은 4바이트 정수리터럴이다 그러나 b변수에 넣을 수 있는 값이기 때문에 허락한다

    // b = 128; //int를 byte메모리에 넣으려 해서 오류
    // b = 10L; //long 리터럴은 변수에 값을 저장할 수 있더라도 허락하지 않는다
  }
}