package com.eomcs.basic.ex07.assignment;

public class Test031 {
  public static void main(String[] args) {

    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    //배열에 들어있는 값을 거꾸로 바꿔라
    //출력결과 => -22, 0, 45, 22, 12, 78, -3, 4, 34}
    reverse(values);

  }
  static void reverse(int[] values) {
    int count = values.length >> 1;
    int temp = 0;
    int endPos = values.length - 1;
    for (int i = 0; i < count; i++) {
      temp = values[i];
      values[i] = values[endPos - i];
      values[endPos - i] = temp;
    }
    System.out.println();
  }
  static void printValues(int[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.printf("%3d", values[i]);
    }
    System.out.println();
  }
}
