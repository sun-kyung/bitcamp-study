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
    // local class
    class QueueIterator<T> implements Iterator<T> {
      Queue<T> queue;
      
      @SuppressWarnings("unchecked")
      public QueueIterator() {
        this.queue = (Queue<T>) Queue.this.clone();
      }
      
      @Override
      public boolean hasNext() {
        return queue.size() > 0;
      }
      @Override
      public T next() {
        return queue.poll();
      }
    }
    // 로컬 클래스는 인스턴스 멤버가 아니다
    // 따라서 로컬클래스의 생성자를 호출할 때 앞쪽에 this를 지정해서는 안 된다
    return new QueueIterator<>();
  }
  
  // non-static nested class = inner class

}
