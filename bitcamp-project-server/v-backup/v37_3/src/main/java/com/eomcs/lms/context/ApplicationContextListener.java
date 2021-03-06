package com.eomcs.lms.context;

import java.util.Map;

// 애플리케이션의 상태가 변경되었을 때 호출할 메서드 규칙을 정의한다
// 즉 애플리케이션 상태 변경에 대해 보고를 받을 "Observer"규칙을 정의한다
// 보통 옵저버를 "리스너(listener)"라 부른다

public interface ApplicationContextListener {

  // 애플리케이션이 시작될 때 호출된다
  // - 호출자가 옵저버의 결과를 받을 수 있도록 파라미터로 맵 객체를 전달할 것이다
  // - 리턴 값으로 결과를 전달받지 않고 파라미터로 넘어온 저장소에 보관하는 방법을 사용한다
  // - 왜 이런 방식을 사용하는가?
  // - 파라미터 방식은 메서드에게 작업에 필요한 정보를 전달할 수 있기 때문
  // - Map을 사용하여 파라미터로 전달하는 방식은 데이터의 In/Out이 가능하다
  void contextInitialized(Map<String, Object> context);

  void contextDestroyed(Map<String, Object> context);
}
