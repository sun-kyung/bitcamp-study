package com.eomcs.oop.ex08.test;


public class J3{
  // 서브클래스에서 반드시 재정의해야하는 메서드는 문법으로 강제시킬 수 있다
  // => 추상메서드
  abstract class Member{
    String email;
    String pwd;
    String name;
    String tel;
    
    abstract void print();
    // 추상 메서드는 구현된 게 아니기때문에 호출할 수 없다
    // 그래서 인스턴스를 생성할 수 있는 일반클래스는 추상메서드를 가질 수 없다
    // 오직 추상클래스(또는 인터페이스)만이 추상 메서드를 가질 수 있다
    // 추상 메서드의 의미는 서브클래스에게 구현을 미루는 것이다
    // 그것도 구현을 강제시키는 문법이다
  }
  
  // 수퍼클래스의 추상메서드를 구현하지 않으면 추상클래스가 되어야한다
  abstract class Student extends Member{
    int grade;
    boolean working;
  }
  
  // 수퍼클래스의 모든 추상메서드를 구현해야만 일반클래스(concrete class)가 될 수 있다
  // => 즉 메서드의 구현을 강제시킬 수 있다
  class Teacher extends Member{
    int pay;
    String major;
    
    @Override
    void print() {
      System.out.println("강사 정보");
    }
  }
}












