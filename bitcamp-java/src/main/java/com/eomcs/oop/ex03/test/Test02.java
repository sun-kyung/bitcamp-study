package com.eomcs.oop.ex03.test;

public class Test02 {
  int x = 100;
  Test02(){
    x = 100;
    this.x = 200;
  }
  Test02(int a){
    x = 100;
    this.x = 200;
  }
  {
    this.x = 200;
  }

}
