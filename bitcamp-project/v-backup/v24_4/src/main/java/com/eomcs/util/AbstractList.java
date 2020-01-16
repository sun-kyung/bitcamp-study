package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{
  protected int size;
  public int size() {
    return size;
  }
  /*다음은 로컬클래스에 대한
   * '의미전달을 위해서 간략하게 작성한 코드(pseudo;의사코드=가짜코드)이다
   *  class 클래스{
   *  필드
   *  블록
   *  생성자
   *  메서드 {
   *    this사용
   *    로컬 변수
   *    중첩 (중첩)클래스 {
   *      바깥클래스.this 접근 불가!
   *      로컬변수 접근 가능
   *    }
   *  }
   *  중첩클래스 {
   *    바깥클래스.this 사용
   *    }
   *  }
   */
  
  public Iterator<E> iterator() {
    // local class : 특정 메서드 안에서만 사용하는 중첩클래스라면 그 메서드 안에 둔다
    class ListIterator<T> implements Iterator<T> {
      List<T> list;
      int cursor;
      
      @SuppressWarnings("unchecked")
      public ListIterator() {
        this.list = (List<T>) AbstractList.this;
      }
      
      @Override
      public boolean hasNext() {
        return cursor < list.size();
      }
      @Override
      public T next() {
        return list.get(cursor++);
      }
    }
    // 로컬 클래스는 인스턴스 멤버가 아니기때문에
    // 앞쪽에 인스턴스 주소를 전달해서는 안된다
    // 즉 this. 을 붙여서는 안된다
    return new ListIterator<E>();
  }
}
