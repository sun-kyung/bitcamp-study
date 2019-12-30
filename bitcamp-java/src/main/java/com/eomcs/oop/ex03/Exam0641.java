// 초기화 블록 - 클래스 블록 = 스태틱 블록
package com.eomcs.oop.ex03;

public class Exam0641 {
    
    public static class A {
        static int a;
        static void m() {}
        
        // 스태틱 블록은 클래스가 로딩된 후에 자동으로 순서대로 실행된다.
        static {
            System.out.println("Static{} 11111");
        }
        
        static {
            System.out.println("Static{} 22222");
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 클래스가 로딩되는 경우
        
        // => 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다.
        A obj1;
        A obj2;
        System.out.println("종료");
    }
}





