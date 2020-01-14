// Worker 구현체 사용
package com.eomcs.oop.ex09.a.after;

// 작업
// 1) worker객체의 사용규칙을 정의한다
//    => worker 인터페이스 정의
// 2) 클래스를 정의할 때 Worker 규칙에 따라 만든다
//    => BlueWorkder, WhiteWorker, JubuWorker 클래스 변경
// 3) worker를 사용하는 측에서는 Worker인터페이스에 정의된대로 메서드를 호출한다
//    => Exam01 클래스 변경
public class Exam01 {
  public static void main(String[] args) {
    // 같은 사용규칙에 따라 만든 클래스는
    // 인터페이스를 레퍼런스에 그 객체 주소를 저장할 수 있어 편리하다
    // 인터페이스 레퍼런스
    // => 인터페이스를 구현한 클래스의 객체 주소를 저장하는 변수
    Worker w1 = new BlueWorker();

    // 인터페이스를 구현하지 않은 클래스의 인스턴스 주소를 저장할 수 없다. 
    //Worker w2 = new String();// 컴파일 오류!

    Worker w2 = new WhiteWorker();
    Worker w3 = new JubuWorker();

    // 인터페이스 구현체 호출
    w1.execute();
    w2.execute();
    w3.execute();

    // 역할?
    // caller : Exam01
    // callee : BlueWorker, WhiteWorker, JubuWorker
    // 규칙: Worker

  }
}



