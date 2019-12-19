package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

/* # 과제 III
사용자로부터 정삼각형 밑변의 길이를 숫자를 입력 받아 '*' 문자로 그려라.

## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
```
밑변 길이? 5
  *
 ***
*****
``` 
 */
public class Test033{
  public static void main(String[] args){
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int width = keyScan.nextInt();
    
    if(width % 2 == 0)
      width--;

    int spaceSize = width >> 1;
    int line = 0;
    while(line++ < width) {
      if (line % 2 == 0) {
        continue;
      }
      int count = 0;
      while(count++ < spaceSize) {
        System.out.print(" ");
      }
      spaceSize--;
      int x = 0;
      while(x++ < line) {
        System.out.print("*");
      }
      System.out.println();
    }
      keyScan.close();
    }
  }
