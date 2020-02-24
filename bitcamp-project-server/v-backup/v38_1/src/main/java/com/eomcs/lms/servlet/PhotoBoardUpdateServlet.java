package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardUpdateServlet implements Servlet {
  // DAO 클래스를 구체적으로 지정하기보다는
  // 인터페이스를 지정함으로써 향후 다른 구현체로 교체하기 쉽도록 한다
  PhotoBoardDao photoBoardDao;

  public PhotoBoardUpdateServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    PhotoBoard old = photoBoardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 사진 게시글이 없습니다");
      return;
    }
    out.printf("제목(%s)? \n", old.getTitle());
    out.println("!{}!");
    out.flush();

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(in.nextLine());
    photoBoard.setNo(no);

    if (photoBoardDao.update(photoBoard) > 0) { // 변경했다면
      out.println("사진 게시글을 변경했습니다");
    } else {
      out.println("사진 게시글 변경에 실패했습니다");
    }
  }

}
