//package com.ddlab.tornado.github;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.IStatus;
//import org.eclipse.core.runtime.Status;
//import org.eclipse.jface.dialogs.ErrorDialog;
//import org.eclipse.jface.operation.IRunnableWithProgress;
//import org.eclipse.swt.widgets.Combo;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//
//import com.ddlab.tornado.Activator;
//
//@Deprecated
//public class RepoLoaderThread implements IRunnableWithProgress {
//
//  private String userName = null;
//  private String password = null;
//  private Combo myRepoCombo = null;
//  private List<String> repoList = null;
//
//  public RepoLoaderThread(String userName, String password, Combo myRepoCombo, List<String> repoList) {
//    super();
//    this.userName = userName;
//    this.password = password;
//    this.myRepoCombo = myRepoCombo;
//    this.repoList = repoList;
//  }
//
//  @Override
//  public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
//    monitor.beginTask("Please wait, fetching your repositories", 100);
//    String[] repos = null;
//    try {
//      repos = GitHubUtil.getAllRepositories(userName, password);
//      int interval = getInterval(repos.length);
////      int pval = interval;
////      System.out.println("1-pval : "+pval);
//      monitor.worked(interval);
//      for (int i = 0; i < repos.length; i++) {
//    	  repoList.add( repos[i]);
//        monitor.subTask("Loading repos " + (i + 1) + " of " + repos.length + "...");
////        pval = pval+interval;
////        System.out.println("2-pval : "+pval);
//        monitor.worked(interval);
//        TimeUnit.MILLISECONDS.sleep(100);
//        if (monitor.isCanceled()) {
//          monitor.done();
//          return;
//        }
//      }
//      
//    } catch (Exception e) {
//      throw new InterruptedException(e.getMessage());
//    }
//    
////    repoList.add("abcd-1");
////    repoList.add("abcd-2");
////    repoList.add("abcd-3");
////    repoList.add("abcd-4");
////    repoList = Arrays.asList(repos);
//    monitor.done();
//    System.out.println("Now all reposList :::"+repoList);
//  }
//  
//  private int getInterval(int initialValue) {
//	  int interval = (initialValue == 0) ? 100: (100/initialValue);
//	  return interval;
//  }
//
//  @Deprecated
//  public void run11(IProgressMonitor monitor)
//      throws InvocationTargetException, InterruptedException {
//    //    final String[] repos;
//
//    monitor.beginTask("Please wait, fetching your repositories", 10);
//    Display.getDefault()
//        .syncExec(
//            new Runnable() {
//              public void run() {
//
//                try {
//                  String[] repos = GitHubUtil.getAllRepositories(userName, password);
//
//                  for (int i = 0; i < repos.length; i++) {
//                    monitor.subTask("Loading repos " + (i + 1) + " of " + repos.length + "...");
//                    TimeUnit.MILLISECONDS.sleep(100);
//                    if (monitor.isCanceled()) {
//                      monitor.done();
//                      return;
//                    }
//                  }
//                  myRepoCombo.setItems(repos);
//                  // if items are not empty
//                  if (repos != null && repos.length != 0) myRepoCombo.select(0);
//                } catch (Exception e) {
//                  Status status =
//                      new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e);
//
//                  ErrorDialog.openError(new Shell(), "Error", e.getMessage(), status);
//                  System.out.println("=========>" + e.getMessage());
//                  e.printStackTrace();
//                }
//              }
//            });
//
//    monitor.done();
//
//    //    monitor.beginTask("Please wait, fetching your repositories", 10);
//    //    try {
//    //      repos = GitHubUtil.getAllRepositories(userName, password);
//    //
//    //      for (int i = 0; i < repos.length; i++) {
//    //        monitor.subTask("Loading repos " + (i + 1) + " of " + repos.length + "...");
//    //        TimeUnit.MILLISECONDS.sleep(100);
//    //        if (monitor.isCanceled()) {
//    //          monitor.done();
//    //          return;
//    //        }
//    //      }
//    //      myRepoCombo.setItems(repos);
//    //      // if items are not empty
//    //      if (repos != null && repos.length != 0) myRepoCombo.select(0);
//    //    } catch (Exception e) {
//    //      Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(),
//    // e);
//    //
//    //      ErrorDialog.openError(new Shell(), "Error", e.getMessage(), status);
//    //      System.out.println("=========>" + e.getMessage());
//    //      e.printStackTrace();
//    //    }
//    //    monitor.done();
//  }
//}
