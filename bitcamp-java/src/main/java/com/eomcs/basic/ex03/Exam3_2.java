package com.eomcs.basic.ex03;

//부동소수점 리터럴(literal) - 메모리 크기

public class Exam3_2 {
  public static void main(String[] args) {
    // 부동소수점 : 4바이트, 8바이트(기본)
    System.out.println(3.14159653589793); //8바이트 부동소수점
    System.out.println(3.14159653589793D); //8바이트 부동소수점
    System.out.println(3.14159653589793d); //8바이트 부동소수점
    
    // 4바이트 부동소수점
    // -부동소수점의 경우 큰 값을 자은 메모리에 넣더라도 컴파일 오류가 일어나지 않음
    // -그냥 값이 잘려서 들어가 뿐이라서 개발자가 잘못된 값을 넣었다는 것을 인지하지 못함
    System.out.println(3.14159653589793f);
    System.out.println(3.14159653589793F);




  }
}