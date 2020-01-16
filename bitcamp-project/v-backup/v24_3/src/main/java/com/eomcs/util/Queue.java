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
    // this = 인스턴스 주소;
    // inner class의 생성자를 호출할 때는 바깥 클래스의 인스턴스 주소를 파라미터로 넘기지 말고
    // 앞에서 넘겨라
    return this.new QueueIterator<>();
  }
  
  // non-static nested class = inner class
  class QueueIterator<T> implements Iterator<T> {
    Queue<T> queue;
    int cursor;
    
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
}
