package com.eomcs.basic.ex03;

//정수 리터럴(literal) - 메모리 크기와 유효 값 범위

public class Exam2_3 {
  public static void main(String[] args) {
    // 리터럴 : 4바이트 (기본), 8바이트
    // 리터럴에 아무런 표시를 안 하면 기본이 4바이트 정수를 의미한다
    System.out.println(100); //jvm에서 4바이트메모리에 저장
    System.out.println(-2147483648); //-2^31 :4바이트 최소 음수값
    System.out.println(2147483647); // 2^31 - 1 :4바이트 최대 양수

    //System.out.println(-2147483649); // 4바이트 메모리 크기 초과
    //System.out.println(21474836478); // 4바이트 메모리 크기 초과

    // 8바이트(64비트) 정수 리터럴
    // 숫자 뒤에 접미사 L,l을 붙인다
    System.out.println(-9_223_372_036_854_775_808L);
    System.out.println(-9_223_372_036_854_775_808l);
    System.out.println(9_223_372_036_854_775_807L);
    System.out.println(9_223_372_036_854_775_807L);

    System.out.println(100); // 4바이트 정수 리터럴
    System.out.println(100L); // 8바이트 정수 리터럴

    System.out.println(Integer.MIN_VALUE); // 4바이트 최소 정수값
    System.out.println(Integer.MAX_VALUE); // 4바이트 최대 정수값
    System.out.println(Long.MIN_VALUE); // 8바이트 최소 정수값
    System.out.println(Long.MAX_VALUE); // 8바이트 최대 정수값


  }
}