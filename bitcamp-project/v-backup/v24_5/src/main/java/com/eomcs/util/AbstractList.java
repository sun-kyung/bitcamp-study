package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{
  protected int size;
  public int size() {
    return size;
  }
  public Iterator<E> iterator() {
    // anonymous class 인스턴스는 한 개만 생성할 거면 익명 클래스로 정의하라
    return new Iterator<E>() {
      List<E> list;
      int cursor;
      // 익명 클래스는 생성자를 만들 수 없기 때문에
      // 인스턴스 필드를 초기화시키기 위해서는
      // 다음과 같이 인스턴스 블록을 사용해야 한다
      // (물론 단순히 값을 할당하는 경우에는 인스턴스 블록에 넣지 않고
      // 필드 선언에 바로 할당 연산자를 사용할 수 있다)
      
      {
        this.list = (List<E>) AbstractList.this;
      }
      
      @Override
      public boolean hasNext() {
        return cursor < list.size();
      }
      @Override
      public E next() {
        return list.get(cursor++);
      }
    };
  }
}
