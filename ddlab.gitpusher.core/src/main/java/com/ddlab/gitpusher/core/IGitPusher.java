package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.exception.GenericGitPushException;

import java.io.File;

public interface IGitPusher {
  void pushCodeDirectly(File projectDir) throws GenericGitPushException;

  void pushSnippetDirectly(File file, String description) throws GenericGitPushException;

  String[] getExistingRepos() throws GenericGitPushException;

  String[] getExistingSnippets() throws GenericGitPushException;
}
