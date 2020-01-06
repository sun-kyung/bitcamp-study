// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam04_11 {
  public static void main(String[] args) {
    System.out.println(3 << 1);
    System.out.println(3 << 33);
    System.out.println(3 << 65);
    System.out.println(3 << 97);
    
    // int값에 대한 비트이동은 0 ~ 31 이다
    // long값에 대한 비트이동은 0 ~ 63 이다
    // 비트이동유효범위를 벗어난다면?
    // => int 데이터인 경우 비트이동값은 하위 5비트만 유효하다
    // => long 데이터인 경우 비트이동값은 하위 6비트만 유효하다
    // => 공식)
    //     n << s
    //     - n이 int 타입이라면, s & 0b11111 = 비트 이동
    //     - n이 long 타입이라면, s & 0b111111 = 비트 이동
  }
}