package com.eomcs.lms.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

  @Override
  public List<PhotoFile> findAll(int boardNo) throws Exception {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( //
            "select photo_file_id, photo_id, file_path" //
                + " from lms_photo_file" //
                + " where photo_id=" + boardNo //
                + " order by photo_file_id asc")) {

      ArrayList<PhotoFile> list = new ArrayList<>();

      while (rs.next()) {

        // 1) 생성자를 통해 인스턴스 필드의 값을 설정하기
        // list.add(new PhotoFile(
        // rs.getInt("photo_file_id"),
        // rs.getString("file_path"),
        // rs.getInt("photo_id")));

        // 2) 셋터를 통해 체인방식으로 인스턴스 필드의 값을 설정하기
        list.add(new PhotoFile()//
            .setNo(rs.getInt("photo_file_id"))//
            .setFilepath(rs.getString("file_path"))//
            .setBoardNo(rs.getInt("photo_id")));//
      }
      return list;
    }
  }

  @Override
  public int deleteAll(int boardNo) throws Exception {
    try (Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate("delete from lms_photo_file" //
          + " where photo_id=" + boardNo);
      return result;

    }
  }
}
