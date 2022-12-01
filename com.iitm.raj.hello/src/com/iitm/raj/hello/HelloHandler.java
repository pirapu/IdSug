package com.iitm.raj.hello;

import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class HelloHandler extends AbstractHandler {

	@SuppressWarnings("static-access")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//reading active file name
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		IEditorInput input = editor.getEditorInput();
		String fileName = input.getName();
		IPath path = ((FileEditorInput)input).getPath();
		String url = path.toString();
		
		
		
		//Splitting the string token
		String message1 = "";
		String message2 = "";
		CamelExplicitSplitter ces = new CamelExplicitSplitter();
		ces.idfyIdentifiers(url);
		Set<String> str1 = ces.splitNames;
		Set<String> str2 = ces.unSplitNames;
		for(String eachId2:str2){
			 message2 += eachId2 + "    ";
		}
		
		for(String eachId3 : str1){
			 message2 += eachId3 + "    ";
		}
		
		//Checking whether the string token is dictionary word or not
		DictWordChecker dictCheck = new DictWordChecker();
		for(String eachId1:str1){
			if(dictCheck.check_for_word(eachId1) == true) {
			 message1 += eachId1 + "    ";
			}
		}
		
		//for displaying the identifiers
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageDialog.openInformation(shell, fileName , message2);
		return null;
	}

}
