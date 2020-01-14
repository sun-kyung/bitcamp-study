package com.eomcs.util;

// 목록객체의 사용규칙을 따로 정의
// => 문법
//       interface 규칙명{...}
public interface List<E> {

  // 사용규칙 (호출할 메서드의 시그너처)이기때문에 모든 메서드는 추상메서드이다
  // 또한 규칙은 공개되어야하기 때문에 모든 메서드는 public이다
  // => 문법
  //    public abstract 리턴타입 메서드명(파라미터,...);
  // => public을 생략할 수 있다
  //      abstract 리턴타입 메서드명(파라미터, ...);
  //=> abstract을 생략할 수 있다
  //      리턴타입 메서드명(파라미터, ...);

  public abstract void add (E e);
  public /*abstract*/ E get(int index);
  /*public*/ abstract E set(int index, E value);
  /*public abstract*/ E remove(int index);
  Object[] toArray();
  E[] toArray(E[] arr);
  int size();
}
