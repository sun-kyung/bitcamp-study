package com.eomcs.util;

import java.util.Arrays;

public class Stack <E> implements Cloneable {
  private static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size;
  
  public Stack() {
    this.elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }
  public void push(E value) {
    if (this.size == elementData.length) {
      grow();
    }
    this.elementData[size++] = value;
  }
  private void grow() {
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }
  private int newCapacity() {
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }
  @SuppressWarnings("unchecked")
  public E pop() {
    if (this.empty())
      return null;
    E value = (E) this.elementData[--this.size];
    this.elementData[this.size] = null;
    return value;
  }
  public boolean empty() {
    return this.size == 0;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone(){
    try {
    Stack<E> temp = (Stack<E>) super.clone();
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    temp.elementData = arr;
    return temp;
    }
     catch (CloneNotSupportedException ex) {
      System.out.println(ex.toString());
      return null;
     }
  }
  public Iterator<E> iterator() {
    // this = 인스턴스 주소;
    // local class 특정 메서드 내에서만 쓰는 클래스라면 로컬클래스로 선언하라
    class StackIterator<T> implements Iterator<T> {
      Stack<T> stack;
      
      @SuppressWarnings("unchecked")
      public StackIterator() {
        this.stack = (Stack<T>) Stack.this.clone();
      }
      
      @Override
      public boolean hasNext() {
        return !stack.empty();
      }
      @Override
      public T next() {
        return stack.pop();
      }
    }
    return new StackIterator<E>();
  }
  /*
  static void m1() {
    // 스태틱 메서드는 다음과 같이 클래스이름으로 바로 호출할 수 있기때문에 this 변수가 없다
    // 예) Stack.m1();
     // 스태틱 메서드에서 로컬클래스를 정의한다면
     // 그 로컬클래스는 바깥 클래스의 인스턴스를 직접 정의할 수 없다
    class A {
      A() {
        Stack s;
        s = Stack.this; // 컴파일 오류
        // 이 로컬클래스는 m1()에서 사용할 것이다
        // m1()은 바깥 클래스의 인스턴스 주소를 모른다
        // 그런데 로컬클래스에서 위와 같이 바깥 클래스의 인스턴슬르 사용하려 한다면
        // 문제가 될 것이다
        // 이런 상황을 방지하고자 자바는 컴파일 오류를 발생시킨다
      }
    }
  }*/
}
