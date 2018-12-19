/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.threads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.exception.GenericGitPushException;

/**
 * The Class ReposLoaderThread.
 *
 * @author Debadatta Mishra
 */
public class ReposLoaderThread implements IRunnableWithProgress {

  /** The git pusher. */
  private IGitPusher gitPusher;
  
  /** The repos list. */
  private List<String> reposList = null;

  /**
   * Instantiates a new repos loader thread.
   *
   * @param gitPusher the git pusher
   * @param reposList the repos list
   */
  public ReposLoaderThread(IGitPusher gitPusher, List<String> reposList) {
    super();
    this.gitPusher = gitPusher;
    this.reposList = reposList;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
    monitor.beginTask("Please wait, fetching your available repositories", 100);
    String[] repos = null;
    try {
      repos = gitPusher.getExistingRepos();
      int interval = getInterval(repos.length);
      for (int i = 0; i < repos.length; i++) {
        reposList.add(repos[i]);

        monitor.subTask("Loading repositories " + (i + 1) + " of " + repos.length + "...");
        monitor.worked(interval);
        TimeUnit.MILLISECONDS.sleep(100);
        if (monitor.isCanceled()) {
          monitor.done();
          return;
        }
      }
      monitor.done();
    } catch (GenericGitPushException e) {
      throw new InterruptedException(e.getMessage());
    }
  }

  /**
   * Gets the interval.
   *
   * @param initialValue the initial value
   * @return the interval
   */
  private int getInterval(int initialValue) {
    int interval = (initialValue == 0) ? 100 : (100 / initialValue);
    return interval;
  }
}
