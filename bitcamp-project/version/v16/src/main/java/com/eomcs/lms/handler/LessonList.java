package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int DEFAULT_CAPACITY = 100;
  Lesson[] list;
  int size = 0;
  
  public LessonList() {
    this.list = new Lesson[DEFAULT_CAPACITY];
  }
  
  public LessonList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Lesson[DEFAULT_CAPACITY];
    this.list = new Lesson[capacity];
  }
  
  public void add(Lesson lesson) {
    this.list[this.size++] = lesson;
    int oldCapacity = this.list.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    this.list = Arrays.copyOf(this.list, newCapacity);
  }
  
  public Lesson[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
}
