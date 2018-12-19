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
 * The Class SnippetLoaderThread.
 *
 * @author Debadatta Mishra
 */
public class SnippetLoaderThread implements IRunnableWithProgress {

  /** The git pusher. */
  private IGitPusher gitPusher;
  
  /** The gist list. */
  private List<String> gistList = null;

  /**
   * Instantiates a new snippet loader thread.
   *
   * @param gitPusher the git pusher
   * @param gistList the gist list
   */
  public SnippetLoaderThread(IGitPusher gitPusher, List<String> gistList) {
    super();
    this.gitPusher = gitPusher;
    this.gistList = gistList;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
    monitor.beginTask("Please wait, fetching your available gists", 100);
    String[] snippets = null;
    try {
      snippets = gitPusher.getExistingSnippets();
      System.out.println("Now Snippets : "+snippets);
      int interval = getInterval(snippets.length);
      for (int i = 0; i < snippets.length; i++) {
        gistList.add(snippets[i]);

        monitor.subTask("Loading snippets " + (i + 1) + " of " + snippets.length + "...");
        monitor.worked(interval);
        TimeUnit.MILLISECONDS.sleep(100);
        if (monitor.isCanceled()) {
          monitor.done();
          return;
        }
      }
      monitor.done();
      System.out.println("Now gistList : "+gistList);
    } catch (GenericGitPushException e) {
    	System.out.println("Error Message in thread : "+e.getMessage() ); 
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
