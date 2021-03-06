package com.eomcs.oop.ex01;

//# 클래스 사용 - import III
//
public class Exam0460 {
  public static void main(String[] args) {
    java.lang.Integer obj1; //OK!
    java.lang.System obj2; //OK!
    java.io.File obj3; //OK!
    
    Integer obj4; //OK!
    System obj5; //OK!
    // File obj3; // 컴파일 오류!
    
    // java.lang 패키지에 있는 클래스는 패키지를 지정하지 않아도 된다
    // 즉 패키지명을 명시하지 않아도 컴파일 오류가 발생하지 않는다

    // 그 외 다른 패키지의 클래스는 패키지명을 명시하지 않으면 컴파일 오류가 발생한다.
  }
}

// 이유?
// - java.lang 패키지에 소속된 클래스를 사용할 때는 
//   패키지 이름을 명시하지 않는다.
// - 왜냐하면 java.lang 패키지의 클래스들은 가장 많이 사용하는 
//   기본 클래스이기 때문이다.
// - 그 외의 모든 패키지 클래스들은 반드시 패키지명을 지정해야 한다.
// - 지정하기 싫으면 import 명령을 사용하여 소스 파일 서두에 선언해야 한다.
//


