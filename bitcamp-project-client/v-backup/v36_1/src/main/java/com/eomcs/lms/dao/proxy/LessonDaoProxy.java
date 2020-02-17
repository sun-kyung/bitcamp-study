package com.eomcs.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

// 프록시 객체는 항상 작업 객체와 동일한 인터페이스를 구현해야 한다
// => 마치 자신이 작업 객체인 양 보이기 위함이다
// => LessonDao 작업객체를 대행할 프록시를 정의한다

public class LessonDaoProxy implements LessonDao {

  DaoProxyHelper daoProxyHelper;

  public LessonDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }


  @Override
  public int insert(Lesson lesson) throws Exception {
    class InsertWorker implements Worker {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {

        out.writeUTF("/lesson/add");
        out.writeObject(lesson);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1;
      }
    }
    InsertWorker worker = new InsertWorker();

    int resultState = (int) daoProxyHelper.request(worker);
    return resultState;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Lesson> findAll() throws Exception {
    Worker worker = new Worker() {
      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {

        out.writeUTF("/lesson/list");
        out.flush();
        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    };
    Object result = daoProxyHelper.request(worker);
    return (List<Lesson>) result;
  }

  @Override
  public Lesson findByNo(int no) throws Exception {
    Object result = daoProxyHelper.request(new Worker() {
      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {

        out.writeUTF("/lesson/detail");
        out.writeInt(no);
        out.flush();

        String response = in.readUTF();

        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    });
    return (Lesson) result;
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    return (int) daoProxyHelper.request(new Worker() {
      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {

        out.writeUTF("/lesson/update");
        out.writeObject(lesson);
        out.flush();
        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1;
      }
    });
  }

  @Override
  public int delete(int no) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/lesson/delete");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }

}
