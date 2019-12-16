package com.eomcs.basic.ex04;


//  변수의 종류
public class Exam7_1{
  
  int instanceVar; //인스턴스 필드(변수) = new 명령을 실행할 때 준비되는 변수
  static int classVar; //클래스 필드 = 스태틱 필드
  
  public static void main (String[] args /*로컬 변수(파라미터)*/){
    // 로컬 변수 = 메서드를 실행할 때 준비, 메서드 블록 안에 선언, 메서드 블록을 벗어나서 사용할 수 없다
    int local; //로컬 변수
    int local2;
    
    classVar = 200; //OK!
    // intanceVar = 300; 
  }
  //클래스 메서드 = 스태틱 메서드
  static void m1() {
    //메서드 블록이 다르면 변수도 다르다 - 그래서 같은 이름의 변수를 선언할 수 있다
    int local;
    
    //다른 메서드 블록에 있는 변수를 사용할 수 없다
    //locla2 = 100; //컴파일 오류!
    
    //같은 static 멤버는 사용할 수 있다
    classVar = 100; //OK!
    // intanceVar = 300;
  }
  //인스턴스 메서드
  void m2() {
    int local; //OK!
    classVar = 200; //static 멤버 가능
    instanceVar = 300; //OK!
    
  }
}