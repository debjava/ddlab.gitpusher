package com.ddlab.generator;

import com.ddlab.generator.readme.ReadMeGenerator;

public class TestReadMe1 {
  public static void main(String[] args) {
    IReadMeGen readMeGen = new ReadMeGenerator();
    String contents = readMeGen.generateReadMeMdContents("My Project", "A short description",null);
    System.out.println("--------------------------");
    System.out.println(contents);



  }
}
