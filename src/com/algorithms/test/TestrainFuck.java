package com.algorithms.test;

import com.practice.algorithms.BrainFuckCompiler;

public class TestrainFuck {
  public static void main(String args[]) {
    //String str = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
    String str1 = "++++++++.[>.++++[>.++>.+++>.+++>.+<.<.<.<.-]>.+>.+>.->.>.+[<.]<.-].";
    BrainFuckCompiler bfc = new BrainFuckCompiler(str1);
    bfc.compile();
  }
}
