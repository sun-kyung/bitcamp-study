package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

/* # 과제 II
사용자로부터 마름모의 가로 길이를 숫자를 입력 받아 '*' 문자로 그려라. 단 마름모의 절반만 그린다.
 

## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
```
밑변 길이? 5
*
**
***
****
*****
****
***
**
*
``` 
*/
public class Test02{
  public static void main(String[] args){
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int base = keyScan.nextInt();
    int count = 1;
    while (count <= base) {
      int star = 1;
      while (star <= count) {
        System.out.print("*");
        star++;
      }
      System.out.println();
      count++;
    }
    count = base -1;
    while (count >= 1) {
      int star = 1;
      while (star <= count) {
        System.out.print("*");
        star++;
      }
      System.out.println();
      count--;
    }
    keyScan.close();
  }
}












