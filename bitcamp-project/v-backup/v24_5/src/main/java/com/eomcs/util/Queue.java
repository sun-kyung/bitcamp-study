package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable{
  public void offer(E value) {
    this.add(value);
  }
  public E poll() {
    return this.remove(0);
  }

  @Override
  public Queue<E> clone(){
    Queue<E> temp = new Queue<E>();
    for (int i = 0;  i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
  public Iterator<E> iterator() {
    // anonymous class
    
    return new Iterator<E>() {
      // 인스턴스 블록 대신 변수 초기화(variable initializer)문법으로 필드값을 설정한다
      Queue<E> queue = (Queue<E>) Queue.this.clone();
      
      @Override
      public boolean hasNext() {
        return queue.size() > 0;
      }
      @Override
      public E next() {
        return queue.poll();
      }
    };
  }
}
