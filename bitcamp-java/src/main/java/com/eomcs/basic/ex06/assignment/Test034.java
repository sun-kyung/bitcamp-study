package com.eomcs.basic.ex06.assignment;

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
public class Test034{
  public static void main(String[] args){
    int width = Console.inputInt();

    if(width % 2 == 0)
      width--;

    int spaceSize = width >> 1;
    int line = 0;
    while(line++ < width) {
      if (line % 2 == 0) {
        continue;
      }
      Graphic.drawLine(spaceSize, ' ');
      spaceSize--;
      Graphic.drawLine(line, '*');
      System.out.println();
    }
  }
}
