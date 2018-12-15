package com.ddlab.rnd.temp;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet56 {

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		final ProgressBar bar = new ProgressBar(shell, SWT.SMOOTH);
		Rectangle clientArea = shell.getClientArea ();
		bar.setBounds (clientArea.x, clientArea.y, 200, 32);
		shell.open();
		final int maximum = bar.getMaximum();
		new Thread() {
			@Override
			public void run() {
				for (final int[] i = new int[1]; i[0] <= maximum; i[0]++) {
				try {Thread.sleep (100);} catch (Throwable th) {}
					if (display.isDisposed()) return;
					display.asyncExec(() -> {
					if (bar.isDisposed ()) return;
						bar.setSelection(i[0]);
					});
				}
			}
		}.start();
		while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose();
	}
}
