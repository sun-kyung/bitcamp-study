# 24_4 - `Iterator` 구현체와 로컬클래스 (local class)

## 학습 목표

- 로컬 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스와 논스태틱 중첩 클래스 사이의 차이점을 이해한
- 논스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.


## 실습 소스 및 결과

- src/main/java/com/eomcs/util/AbstractList.java 변경
- src/main/java/com/eomcs/util/Stack.java 변경
- src/main/java/com/eomcs/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 중첩 클래스를 로컬클래스로 만들라.

- AbstractList.java
  - interator() 메서드를 변경한다.

### 훈련2. QueueIterator 중첩 클래스를 로컬클래스로 만들라.

- Queue.java
  - interator() 메서드를 변경한다.

### 훈련3. StackIterator 중첩 클래스를 로컬클래스로 만들라.

- Stack.java
  - interator() 메서드를 변경한다.