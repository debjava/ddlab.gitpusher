//package com.ddlab.tornado.dialog;
//
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//
//public class Test1 {
//
//  public static void main(String[] args) {
//    Display display = new Display();
//    Shell shell = new Shell(display);
//    
//    GitPushDialog gd = new GitPushDialog(shell);
//    gd.create();
//    gd.open();
//    
//    
//    
//    
//    while(! shell.isDisposed()) {
//        if(! display.readAndDispatch()) {// If no more entries in event queue
//          display.sleep();
//        }
//      }
//      
//      display.dispose();
//    
//    
//  }
//}
