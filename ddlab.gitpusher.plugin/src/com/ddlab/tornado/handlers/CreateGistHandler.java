/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ddlab.tornado.dialog.CreateGistSnippetDialog;

/**
 * The Class CreateGistHandler.
 *
 * @author Debadatta Mishra
 */
public class CreateGistHandler extends AbstractHandler {

  /* (non-Javadoc)
   * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    Shell shell = window.getShell();

    ISelectionService service = window.getSelectionService();
    IStructuredSelection structuredSelection = (IStructuredSelection) service.getSelection();
    Object selctionElement = structuredSelection.getFirstElement();
    if (selctionElement instanceof IAdaptable) {
      //      IFile resource = (IFile) ((IAdaptable) selctionElement).getAdapter(IFile.class);
      IResource resource = (IFile) ((IAdaptable) selctionElement).getAdapter(IResource.class);
      File selectedFile = resource.getLocation().toFile();

      CreateGistSnippetDialog gistDialog = new CreateGistSnippetDialog(shell, selectedFile);
      gistDialog.create();
      gistDialog.open();
    }
    return null;
  }
}
