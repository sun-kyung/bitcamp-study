// 다형적 변수와 오버라이딩
package com.eomcs.oop.ex06.d;

public class Exam01 {
  public static void main(String[] args) {
    A a = new A();

    a.m(); // A의 멤버 호출
    ((A2)a).x(); // A객체를 A2객체라 우기면 컴파일러는 통과, 실행은 오류
    System.out.println("----------------");
    
    A2 a2 = new A2();
    a2.m(); // A2가 수퍼클래스인 A의 메서드 호출 OK
    a2.x(); // A2의 메서드 호출 OK
    
    A a3 = new A2();
    a3.m(); // A2의 m 호출
    // 레퍼런스가 하위 클래스의 인스턴스를 가르킬 때
    // => 레퍼런스를 통해 호출하는 메서드가 하위 클래스에서 오버라이딩한 것이라면 그 오버라이딩한 메서드를 호출
    
    // 그렇다고 해서 A2에 추가한 메서드를 호출할 수는 없다
    // => 즉 레퍼런스의 클래스에서 벗어날 수 없다/ 컴파일러가 허락하지 않는다
    //a3.x();//컴파일 오류
    
    System.out.println("----------------");

    // 다형적 변수와 오버라이딩 메서드
    A p = a2; // 수퍼 클래스의 래퍼런스는 서브 클래스의 객체 주소를 담을 수 있다.
    // 수퍼 클래스의 레퍼런스는 서브 클래스의 객체를 가리킬 수 있다.

    //p.x(); // 컴파일 오류!
    // 비록 p에는 실제로 A2 객체의 주소가 저장되어 있지만,
    // 컴파일러는 p가 실제 가리키는 객체에 관심이 없고,
    // p가 어떤 클래스의 변수인지만 확인한다.
    // p는 A 클래스의 변수이기 때문에
    // 오직 A 클래스의 멤버(변수,메서드)만 사용할 수 있다.

    // 주의!
    p.m(); // 단, p가 실제 가리키는 객체의 클래스가
    // p 클래스의 메서드를 오버라이딩 했다면,
    // 그때는 실제 가리키는 객체의 클래스가 오버라이딩 한 메서드를 호출한다.

  }
}





