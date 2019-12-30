// 초기화 블록 - 생성자와 인스턴스 블록
package com.eomcs.oop.ex03;

public class Exam0612 {
    static class A {
        int a;
        int b;
        int c;
        
        //인스턴스 초기화 블록 후
        {
          a = 100;
          System.out.println("Hello!");
          
        }
        A() {
            b = 200;
            c = 300;
        }
        A(int b) {
          a = 100;
            System.out.println("Hello!");
            this.b = b;
            this.c = c;
        }
        A(int b, int c) {
          a = 100;
            System.out.println("Hello!");
            this.b = b;
            this.c = c;
        }

    }
    public static void main(String[] args) {
        A obj1 = new A();
        System.out.printf("a=%d, b=%d, c=%d\n", obj1.a, obj1.b, obj1.c);
    }
}





