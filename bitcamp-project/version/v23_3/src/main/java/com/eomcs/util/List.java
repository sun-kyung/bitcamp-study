package com.eomcs.util;

public interface List<E> {
  public abstract void add(E e);
  public abstract void add(int index, E value);
  public  E get(int index);
  abstract E set(int index, E e);
  E remove(int index);
  Object[] toArray();
  E[] toArray(E[] arr);
  int size();
}
