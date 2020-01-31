package com.eomcs.design_pattern.observer.after.h;

// 이전 버전에서는 인터페이스를 직접 구현했지만
// (그래서 관심도 없는 carStopped() 메서드까지 정의했다)
// 이번 버전에서는 추상 클래스를 상속받아 간접적으로 구현한다
public class BreakOilCarObserver extends AbstractCarObserver {

  @Override
  public void carStarted() {
    System.out.println("브레이크 오일 유무 검사");
  }
}
// carStopped() - 수퍼클래스에서 구현
