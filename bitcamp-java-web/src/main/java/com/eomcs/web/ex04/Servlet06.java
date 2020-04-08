// 클라이언트가 보낸 데이터 읽기 - 여러 개의 데이터를 같은 이름으로 보낸 경우
package com.eomcs.web.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s6")
public class Servlet06 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");

    // POST 요청
    // - 웹 페이지의 폼(method='POST' 일 때)에서 전송 버튼을 클릭하면 POST 요청을 보낸다.
    //
    // 테스트
    // - http://localhost:8080/java-web/ex04/test06.html 실행
    //

    // 같은 이름으로 여러 개의 데이터를 보낼 수 있다.
    // => 예) name=aaa&name=bbb&name=ccc
    String[] genre1 = req.getParameterValues("genre1");
    String[] genre2 = req.getParameterValues("genre2");
    String[] genre3 = req.getParameterValues("genre3");
    String[] genre4 = req.getParameterValues("genre4");
    String[] genre5 = req.getParameterValues("genre5");
    String[] genre6 = req.getParameterValues("genre6");

    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("선택한 장르");
    if (genre1 != null) {
      out.println("로맨틱");
    }
    for (String name : names) {
      out.printf("이름=%s\n", name);
    }
  }
}


