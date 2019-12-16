package com.eomcs.basic.ex04;


//  형변환 : 정수 변수 -> 부동소수점 변수
public class Exam9_1{
  public static void main(String[] args) {
    byte b = 100;
    short s = 200;
    int i = 18_3456_6789;
    long l = 334_9876_9998_7654_3219L;
    
    // 메모리 크기에 상관없이 정수변수의 값을 부동소수점 변수에 넣을 때 컴파일오류가 발생하지 않음
    // 단, 실행할 때 유효자릿수가 넘어가면 값이 잘릴 수 있다
    float f;
    f = b;
    System.out.println(f);
    f = s;
    System.out.println(f);
    f = i;
    System.out.println(f);
    f = l;
    System.out.println(f);
    
    double d;
    d = b;
    System.out.println(d);
    d = s;
    System.out.println(d);
    d = i;
    System.out.println(d);
    d = l;
    System.out.println(d);
    
    
  }
}