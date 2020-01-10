// Wrapper 클래스 - auto-boxing/auto-unboxing 
package com.eomcs.corelib.ex01;

public class Exam0221 {
  public static void main(String[] args) {

    // 자바는 primitive data type 값을 Wrapper 클래스의 인스턴스에 바로 할당할 수 있다
    Integer obj = 100; 
    // obj는 레퍼런스인데 어떻게 가능한다?
    // 내부적으로 new Integer(i1)으로 바뀐다.
    // 즉 int 값이 obj3에 저장되는 것이 아니라,
    // 내부적으로 Integer 객체가 생성되어 그 주소가 저장된다.

    // 이렇게 int값을 자동으로 Integer객체로 만드는 것을 "오토박싱(auto-boxing)"이라 한다
    // JDK1.5부터 auto-boxing, auto-unboxing 기능을 제공한다.
    
    // => auto-unboxing
    //    Integer 객체에서 값을 꺼내 리턴한다.
    //    이렇게 객체 안에 들어 있는 값을 자동으로 꺼낸다고 해서 "오토언박싱"이라 부른다.
    Integer obj4 = Integer.valueOf(300);
    int i3 = obj4;  // 내부적으로 obj4.intValue()로 바뀐다.
    // 즉 obj4에 들어있는 인스턴스 주소가 i3에 저장되는 것이 아니라,
    // obj4 인스턴스에 들어 있는 값을 꺼내 i3에 저장하는 것이다.


  }
}






