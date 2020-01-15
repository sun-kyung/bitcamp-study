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
      
    // 1) 'shallow copy'를 통해 이 객체의 인스턴스 변수는 그대로 복제한다
    Stack<E> temp = (Stack<E>) super.clone();
    
    // 2) elementData 배열을 복제한다
    // => 배열만 복제하고 그 배열에 저장된 객체(ex: Member, 문자열 등)까지는 복제하지 않는다
    // => 어디까지 복제(deep copy의 수준)할 것인지는 상황에 따라 결정한다
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    // 3) 복제한 스택 객체가 새로 만든 배열을 가리키도록 한다
    temp.elementData = arr;
    return temp;
    }
     catch (CloneNotSupportedException ex) {
      System.out.println(ex.toString());
      return null;
     }
  }
  public Iterator<E> iterator() {
    return new StackIterator<E>(this);
  }
}
