package com.ddlab.tornado.threads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.exception.GenericGitPushException;

public class ReposLoaderThread implements IRunnableWithProgress {

  private IGitPusher gitPusher;
  private List<String> reposList = null;

  public ReposLoaderThread(IGitPusher gitPusher, List<String> reposList) {
    super();
    this.gitPusher = gitPusher;
    this.reposList = reposList;
  }

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

  private int getInterval(int initialValue) {
    int interval = (initialValue == 0) ? 100 : (100 / initialValue);
    return interval;
  }
}
