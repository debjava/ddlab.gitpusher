package com.ddlab.generator;

import com.ddlab.generator.gitignore.GitIgnoreGenerator;

public class TestGitIgnore1 {
  public static void main(String[] args) {
    IGitIgnoreGen gitIgnore = new GitIgnoreGenerator();
    String contents = gitIgnore.generateGitIgnoreContents();
    System.out.println(contents);
  }
}
