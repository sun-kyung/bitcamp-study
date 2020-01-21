package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class ComputeCommand implements Command {

  public Prompt prompt;

  public ComputeCommand(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    int a = prompt.inputInt("수1? ");
    int b = prompt.inputInt("수2? ");
    int compute = a + b;
    System.out.printf("계산결과는 %d입니다\n", compute);

  }
}
