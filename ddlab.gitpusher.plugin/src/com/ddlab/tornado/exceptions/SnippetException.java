package com.ddlab.tornado.exceptions;

public class SnippetException extends Exception {

  private static final long serialVersionUID = -1722640780407606671L;

  public SnippetException(String errorMessage) {
    super(errorMessage);
  }

  public SnippetException(Exception ex) {
    super(ex);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
