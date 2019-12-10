package com.eomcs.basic.ex03;

//문자 리터럴(literal) - 문자코드를 이용하여 문자 출력

public class Exam42 {
  public static void main(String[] args) {

    //코드 값을 안다면 직접 코드 값을 사용하여 문자를 지정할 수 있음
    System.out.println(0x0041); //앞의 00 생략가능
    System.out.println(0xac00); 
    
    // => 그냥 출력하면 정수를 표현한 것으로 오해한다
    // => 숫자 앞에 문자 코드임을 알리는 표시를 한다
    System.out.println((char)0x0041); 
    System.out.println((char)0xac00); 

    for (int i = 0; i < 11172; i++) {
      if (i % 80 == 0)
        System.out.println();
      System.out.print((char)(0xac00 + i));
    }
    
  
  


  }
}