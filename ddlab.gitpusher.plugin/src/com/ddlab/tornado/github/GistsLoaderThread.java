package com.ddlab.tornado.github;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

@Deprecated
public class GistsLoaderThread implements IRunnableWithProgress {

  private String userName = null;
  private String password = null;
  private List<String> gistList = null;

  public GistsLoaderThread(String userName, String password, List<String> gistList) {
    super();
    this.userName = userName;
    this.password = password;
    this.gistList = gistList;
  }

  @Override
  public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
    monitor.beginTask("Please wait, fetching your available gists", 100);
    String[] repos = null;
    try {
      repos = GitHubUtil.getAllGists(userName, password);
      int interval = getInterval(repos.length);
      monitor.worked(interval);
      for (int i = 0; i < repos.length; i++) {
        gistList.add(repos[i]);
        monitor.subTask("Loading repos " + (i + 1) + " of " + repos.length + "...");
        monitor.worked(interval);
        TimeUnit.MILLISECONDS.sleep(100);
        if (monitor.isCanceled()) {
          monitor.done();
          return;
        }
      }

    } catch (Exception e) {
      throw new InterruptedException(e.getMessage());
    }
    monitor.done();
    System.out.println("Now all reposList :::" + gistList);
  }

  private int getInterval(int initialValue) {
    int interval = (initialValue == 0) ? 100 : (100 / initialValue);
    return interval;
  }
}
