package com.iitm.raj.hello.views;



import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;



public class HelloIIT extends ViewPart {

	public HelloIIT() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createPartControl(Composite parent) {
		Button button = new Button(parent, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		button.setText("All the Suggestion for string tokens");
		
		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(parent.getShell(), "IDSug", "This is my first plugin");
			}
		});
		

	}
	
	

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
