package com.eomcs.lms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// 서브 클래스에게 공통 필드나 메서드를 상속해주는 역할 (abstract)
// 서브클래스에게 상속해주는 메서드 중 indexOf() 처럼 구현되지 않은 메서드가 있기 때문
public abstract class AbstractObjectFileDao<T> {

  protected String filename;
  protected List<T> list;

  public AbstractObjectFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();
  }

  @SuppressWarnings("unchecked")
  protected void loadData() {
    File file = new File(filename);

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      list = (List<T>) in.readObject();

      System.out.printf("총 %d개의 객체를 로딩했습니다\n", list.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }


  protected void saveData() {
    File file = new File(filename);

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.reset(); // 기존에 직렬화 수행 중에 캐시된(임시보관된) 데이터를 초기화시킨다
      out.writeObject(list);

      System.out.printf("총 %d개의 객체를 저장했습니다\n", list.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  // 서브 클래스들의 공통 메서드이기때문에 수퍼 클래스에 정의한다
  // 서브 클래스에서 접근할 수 있어야하기 때문에 protected로 선언
  // 서브 클래스마다 구현 방법이 다르기 때문에 구현해서는 안 됨 (abstract)
  protected abstract <K> int indexOf(K key);

}
