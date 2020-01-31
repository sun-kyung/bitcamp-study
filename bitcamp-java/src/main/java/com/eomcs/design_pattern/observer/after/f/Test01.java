package com.eomcs.design_pattern.observer.after.f;


public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();
    car.addCarObserver(new SafeBeltCarObserver());
    car.addCarObserver(new EngineOilCarObserver());
    car.addCarObserver(new BreakOilCarObserver());
    car.addCarObserver(new LightOffCarObserver());
    car.addCarObserver(new SunRoofCloseCarObserver());
    car.start();

    car.run();

    car.stop();


    // 업그레이드를 수행한 다음 시간이 지난 후
    // 5) 시동 끌 때 썬루프를 자동으로 닫는 옵저버 (SunRoofCloseCarObserver()) 추가
  }

}


