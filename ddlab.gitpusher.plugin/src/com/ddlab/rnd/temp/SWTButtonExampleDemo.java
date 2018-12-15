//package com.ddlab.rnd.temp;
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.events.SelectionListener;
//import org.eclipse.swt.layout.RowLayout;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.swt.widgets.Text;
//
//import com.ddlab.tornado.dialog.GitPushDialog;
//
///**
// * @author Steven Holzner
// * 
// */
//public class SWTButtonExampleDemo {
//
//  public static void main(String[] args) {
//    Display display = new Display();
//    Shell shell = new Shell(display);
//    shell.setSize(300, 200);
//    shell.setText("Button Example");
//    shell.setLayout(new RowLayout());
//    
//    
//    GitPushDialog gd = new GitPushDialog(shell);
//    gd.create();
//    gd.open();
//    
//
////    final Button button = new Button(shell, SWT.PUSH);
////    button.setText("Click Me");
////
////    final Text text = new Text(shell, SWT.SHADOW_IN);
////
////    button.addSelectionListener(new SelectionListener() {
////
////      public void widgetSelected(SelectionEvent event) {
////        text.setText("No worries!");
////      }
////
////      public void widgetDefaultSelected(SelectionEvent event) {
////        text.setText("No worries!");
////      }
////    });
////    shell.open();
//    
//    
//    
//    
//    
//    while (!shell.isDisposed()) {
//      if (!display.readAndDispatch())
//        display.sleep();
//    }
//    display.dispose();
//  }
//}