package com.eomcs.lms.mariadb;

import java.sql.Connection;
import java.sql.Statement;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoFileDaoImpl implements PhotoFileDao {


  Connection con;

  public PhotoFileDaoImpl(Connection con) {
    this.con = con;
  }


  @Override
  public int insert(PhotoFile photoFile) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try (Statement stmt = con.createStatement()) {

      // DBMS에게 데이터 입력하라는 명령을 보낸다
      // SQUL 문법 :
      // insert into 테이블명(컬럼명1, 컬럼명2, ...) values(값1, 값2, ...)
      // => executeUpdate()의 리턴 값은 서버에 입력된 데이터의 개수이다
      int result = stmt.executeUpdate("insert into lms_photo_file(photo_id,file_path) values("
          + photoFile.getBoardNo() + ",'" + photoFile.getFilepath() + "')");
      return result;
    }
  }

}
