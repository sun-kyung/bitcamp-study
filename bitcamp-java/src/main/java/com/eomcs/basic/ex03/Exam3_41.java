package com.eomcs.basic.ex03;

//부동소수점 리터럴(literal) - 부동소수점을 메모리에 저장하기

public class Exam341 {
  float f = 12.375f;
  // 컴파일러가 바이트코드로 바꿀 때 12.375또한 정규화하여 변환된다
  // 12.375의 2진수는 0x41460000 이다
  // .class 파일을 읽어서 이 값을 찾아보라
  public static void main(String[] args) {

  }
}

// 부동소수점은 정수와 달리 유효자릿수일지라도 정확하게 메모리에 저장되지 않는다
// JVM이 부동소수점 교정작업을 함
