package com.eomcs.util;

import java.util.Arrays;

public class ArrayList2<E> {
  private static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size;

  public ArrayList2() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  public ArrayList2(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = this.elementData.length + (oldSize >> 1);
      this.elementData = Arrays.copyOf(this.elementData, newSize);
    }
    this.elementData[this.size++] = e;
  }
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index > this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index > this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return (E) oldValue;
  }
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index > this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    System.arraycopy(elementData, index + 1, 
        elementData, index, this.size - (index + 1));
    this.size--;
    return oldValue;
  }
  public int size() {
    return this.size;
  }
  public Object[] toArray() {
    return Arrays.copyOf(elementData, size);
  }
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      return(E[]) Arrays.copyOf(elementData, size, arr.getClass());
    }
    System.arraycopy(elementData, 0, arr, 0, size);
    return arr;
  }
}
