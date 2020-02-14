package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.json.BoardJsonFileDao;
import com.eomcs.lms.dao.json.LessonJsonFileDao;
import com.eomcs.lms.dao.json.MemberJsonFileDao;

// 애플리케이션이 시작되거나 종료될 때 데이터를 로딩하고 저장하는 일을 한다
public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다");

    // 이 메서드를 호출한 쪽(App)에서 DAO객체를 사용할 수 있도록 Map객체에 담아둔다
    context.put("boardDao", new BoardJsonFileDao("./board.json"));
    context.put("lessonDao", new LessonJsonFileDao("./lesson.json"));
    context.put("memberDao", new MemberJsonFileDao("./member.json"));
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다");

    // 애플리케이션이 종료되면 이 메서드가 호출될 것이고
    // 이 메서드에서는 애플리케이션이 작업한 데이터를 저장하는 일을 한다
  }

}


