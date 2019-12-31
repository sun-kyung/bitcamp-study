//#캡슐화 문법 사용 후 - 캡슐화와 게터/세터
package com.eomcs.oop.ex07.a;

class Score4 {
  //실무에서는 보통 필드의 직접 접근을 막는다
  //- 가능한 세터를 통해 값을 설정,
  //- 게터를 통해 값을 조회하도록 유도
  //그래서 name 필드처럼 굳이 세터나 게터가 필요없는 경우에도 세터/게터를 만든다
  //- 즉 필드는 캡슐화문법을 통해 외부의 접근을 제한하고 세터/게터메서드를 통해 값을 설정/조회하게 만든다
  
  //name, kor, eng, math필드같은 경우 값을 설정하고 조회도 해야하기 때문에 게터/세터가 모두 있다
  //sum, aver필드같은경우 값을 조회만 해야하기 때문에 게터만 있다
  
  //이렇게 필드에 대해서 항상 게터/세터를 모두 만드는 것이 아니다
  
  //용어
  // -name, kor, eng, math, sum, aver 는 "필드(field)"라 부른다
  // -getXxx()/setXxx()는 "프로퍼티(property)"라 부른다
  //필드는 프로퍼티라 부르는 것이 아니다 게터/세터를 프로퍼티라 부르는 것이다
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }

  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }
  public int getKor() {
    return this.kor;
  }
  
  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }
  public int getEng() {
    return this.eng;
  }
  
  public void setMath(int math) {
    this.math = math;
    this.compute();
  }
  public int getMath() {
    return this.math;
  }

  
  public int getSum() {
    return this.sum;
  }
  
  public float getAver() {
    return this.aver;
  }
  
  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
public class Exam0311 {
  public static void main(String[] args) {
    Score4 s1 = new Score4();
    s1.setName("홍길동");
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);
    
    // 세터를 통해서  국영수 값을 설정할 때마다 합계평균을 자동으로 계산하기때문에 compute()를 호출할 필요가 없다
    //s1.compute();
    
    // 다음과 같이 어제든지 국영수 점수를 변경하더라도 합계와 평균이 자동계산될 것이다
    s1.setEng(100);
    s1.setMath(100);

    // 이제 kor, eng, math도 비공개모드이기 때문에 값을조회하려면 게터를 사용해야한다
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
        s1.getName(), s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAver());
    
  }

}
