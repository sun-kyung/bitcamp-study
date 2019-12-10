package com.eomcs.basic.ex03;

// 논리 리터럴(literal)
public class Exam5 {
  public static void main(String[] args) {
    // 참 : true
    // 거짓 : false
    // - 자바는 대소문자를 구분하여 처리한다
    System.out.println(true);
    System.out.println(false);
    // System.out.println(TRUE); //컴파일 오류!

    // 보통 비교연산의 결과로 논리값이 리턴된다.
    System.out.println(4 < 5);
    System.out.println(4 > 5);

    // 논리연산의 결과도 논리값이다
    System.out.println(true && true); //and
    System.out.println(true && false);
    System.out.println(true || true); //or
    System.out.println(true || false);

    // 문자코드와 연산
    // '문자' 단독으로 사용될 때는 문자로 취급하지만
    // 다른 값과 연산을 수행하면 해당 문자코드는 그냥 정수로 간주
    System.out.println('가' == 44032);
    System.out.println('가' == 44033);
  
  
  }
}

// boolean(논리) 값을 다룰 때 메모리 크기
// - JVM은 논리 값을 저장할 때 4바이트 정수 메모리 사용
// - true(1), false(0) 저장한다
// - 배열인 경우 1바이트 정수 메모리를 사용한다