// Wrapper 클래스 - auto-boxing/auto-unboxing 
package com.eomcs.corelib.ex01;

public class Exam0224 {

  static class Member{
    String name;
    String tel;

    @Override
    public String toString() {
      return name + "," + tel;
    }
  }
  public static void main(String[] args) {
    int v1 = 100;
    Member v2 = new Member();
    v2.name = "홍길동";
    v2.tel = "010-1111-2222";

    // auto-boxing, auto-unboxin 기능이 없다면
    // print() 처럼 primitive data type과 클래스를 구분하여 메서드를 정의해야한다

    print(100);
    print(new Member());

    // auto-boxing, auto-unboxin 기능이 있기 때문에
    // printObject()처럼 한 개의 메서드로 primitive data type과 클래스를 모두 처리할 수 있는 것이다
    printObject(new Member());
    // 파라미터 타입이 Object이면 자바 컴파일러는 auto-boxing코드로 변환한다
    // 즉 Integer.valueOf(100)으로 바꾼다
  }
  static void print(int i) {
    System.out.print("정수: ");
    System.out.println(i);
  }
  static void print(Member m) {
    System.out.print("회원: ");
    System.out.println(m);
  }
  static void printObject(Object obj) {

  }
}






