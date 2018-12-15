package com.ddlab.gitpusher.exception;

public class GenericGitPushException extends Exception {

  private static final long serialVersionUID = 9102128217654596979L;

  public GenericGitPushException(String errMessage) {
    super(errMessage);
  }

  public GenericGitPushException(String message, Throwable cause) {
    super(message, cause);
  }

  public GenericGitPushException(Exception ex) {
    super(ex);
  }
}
