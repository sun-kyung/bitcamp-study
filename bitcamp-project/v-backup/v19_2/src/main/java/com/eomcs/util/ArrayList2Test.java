package com.eomcs.util;

public class ArrayList2Test {
  public static void main(String[] args) {
    ArrayList2<String> a2 = new ArrayList2<>();
    
    a2.add("111");
    a2.add("222");
    a2.add("333");
    a2.add("444");
    a2.add("555");
    a2.add("666");
    a2.add("777");
    a2.add("888");
    
    System.out.println(a2.get(0));
    a2.remove(0);
    System.out.println(a2.get(0));
    a2.remove(0);
    System.out.println(a2.get(0));

  }
}
