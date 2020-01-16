package com.eomcs.util;

// Generalization 2단계:
// => 서브클래스에 공통분모(멤버)를 물려주는 용도의 클래스는 직접 인스턴스를 생성하지 못하도록
//    추상클래스로 선언한다
// => 개발자가 추상클래스 여부를 즉각적으로 확인할 수 있도록 보통 클래스 이름을
//    "AbstractXxxx"형식으로 짓는다
// => 서브클래스에서 구현할 메서드를 그냥 메서드로 정의하면
//    서브클래스를 정의하는 개발자가 해당 메서드를 오버라이딩한다는 보장을 하지 못한다
// => 상속받는 메서드 중에서 반드시 서브클래스에서 오버라이딩해야 할 메서드라면
//    문법으로 표시를 하는 것이 좋다
//    이런 용도로 만든 문법이 "추상 메서드이다"
// => 추상 메서드의 오버라이딩은 선택사항이 아니라 필수사항이다
// => 따라서 서브클래스를 만드는 개발자는 반드시 이 추상메서드를 구현해야 한다


public abstract class AbstractList<E> {
  protected int size;
  
  public int size() {
    return size;
  }
  public abstract void add (E e);
  public abstract E get(int index);
  public abstract E set(int index, E value);
  public abstract E remove(int index);
  public abstract Object[] toArray();
  public abstract E[] toArray(E[] arr);
}
