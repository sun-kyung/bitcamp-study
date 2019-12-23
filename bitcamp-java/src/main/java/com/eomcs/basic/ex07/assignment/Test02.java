package com.eomcs.basic.ex07.assignment;

public class Test02 {
  public static void main(String[] args) throws Exception{
    //배열에 들어있는 값을 오름차순으로 정렬하라
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    sort(values);
    System.out.println("------------------------------");
    printValues(values);

    for(int value : values) {
      System.out.print(value + " ,");
    }
    System.out.println();
  }
  static void sort(int[] values) throws Exception{
    //크기 비교를 위해 현재 이치의 값과 앞쪽의 값을 비교해야 한다
    //따라서 배열 개수만큼 반복하지 말고 한 번 적게 반복해야 한다
    //다음 반복문을 한 번 돌면 가장 큰 수가 맨 오른쪽에 놓인다
    //이 반복문을 여러 번 반복하면 된다
    for (int x = (values.length - 1); x > 0; x--) {
      int temp = 0;
      for (int i = 0; i < x; i++) {
        Thread.currentThread().sleep(1000);
        printValues(values, i);
        
        if (values[i] > values[i + 1]) {
          temp = values[i];
          values[i] = values[i + 1];
          values[i + 1] = temp;
          
          Thread.currentThread().sleep(1000);
          printValues(values, i);
        }
        }
      }
    }
  static void printValues(int[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.printf("%3d", values[i]);
    }
    System.out.println();
  }

  static void printValues(int[] values, int currPos) {
    for (int i = 0; i < values.length; i++) {
      if (i == currPos) {
        System.out.printf("%3d<-", values[i]);
      } else {
        System.out.printf("%3d  ", values[i]);
      }
    }
    System.out.println();
  }
}
