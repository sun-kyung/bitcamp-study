// 예외 처리 문법을 적용하기 전 - 리턴 값으로 오류를 알릴 때의 오류를 극복
package com.eomcs.exception.ex1;

public class Exam0131 {
  public static void main(String[] args) {

    // 아무리 희귀한 값을 리턴한다 하더라도 결국에는 그 희귀한 값 또한
    // 정상 값일 수 있다. 이것은 해결할 수 없다.
    // => 다음 예는 계산 결과가 -1212121212 이다.
    // => 그런데도 연산자가 유효하지 않다고 처리한다.
    int result = Calculator2.compute("+", -2078654356, 866533144);
    if (result == -1212121212) {
      System.out.println("유효하지 않은 연산자입니다!");
    } else {
      System.out.println(result);
    }
    // 결국 리턴 값을 검사하여 오류 여부를 처리하는 것으로는
    // 이런 문제를 해결할 순 없다.

    // 리턴 값으로 작업 오류를 알려줄 때 그 한계를 극복하기 위해 만든 문법이
    // "예외처리" 문법이다.
    // => 예외 상황이 발생했을 때 호출자에게 예외 정보를 던져주는 문법이다.
  }
}


