// 스프링 IoC 컨테이너 사용
package com.eomcs.spring.ioc.ex01.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.ex01.Car;

public class Exam01 {

  public static void main(String[] args) {
    // 스프링 IoC 컨테이너는 ApplicationContext를 구현한다.
    ApplicationContext iocContainer = null;

    iocContainer =
        new ClassPathXmlApplicationContext("bitcamp/java106/step01/application-context.xml");

    // IoC 컨테이너에 보관된 객체를 꺼내기
    Car car = (Car) iocContainer.getBean("c1");
    System.out.println(car);

    // 존재하지 않는 자바 객체를 꺼내려 한다면?
    // => 예외 발생!
    car = (Car) iocContainer.getBean("c2");

  }

}
