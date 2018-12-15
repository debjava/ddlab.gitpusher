package com.ddlab.tornado.dialog;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
@Deprecated
public class Temp1 extends Composite {
	private Text text;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Temp1(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Label lblAsdf = new Label(this, SWT.NONE);
		lblAsdf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAsdf.setText("asdf");
		
		text = new Text(this, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.heightHint = 37;
		text.setLayoutData(gd_text);
		
		Label lblAsdToDo = new Label(this, SWT.NONE);
		lblAsdToDo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAsdToDo.setText("ASD to do ");
		
		Combo combo = new Combo(this, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo.heightHint = 46;
		combo.setLayoutData(gd_combo);
		
		Label lblPikupiku = new Label(this, SWT.NONE);
		lblPikupiku.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblPikupiku.setText("PIKUPIKU");
		
		text_1 = new Text(this, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text_1.heightHint = 45;
		text_1.setLayoutData(gd_text_1);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
