/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.dialog;

import static com.ddlab.tornado.common.CommonConstants.ACT_TYPE_LBL_TXT;
import static com.ddlab.tornado.common.CommonConstants.BOLD_FONT;
import static com.ddlab.tornado.common.CommonConstants.DLG_SHELL_TXT;
import static com.ddlab.tornado.common.CommonConstants.DLG_TITLE_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIST_BTN_TOOL_TIP_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIST_BTN_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIST_COMBO_DECORATOR_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIST_LBL_INFO_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIST_LBL_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIST_NOT_EMPTY_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIT_ACCOUNTS;
import static com.ddlab.tornado.common.CommonConstants.PLAIN_TXT_FONT;
import static com.ddlab.tornado.common.CommonConstants.PWD_DECORATOE_TXT;
import static com.ddlab.tornado.common.CommonConstants.PWD_LBL_TXT;
import static com.ddlab.tornado.common.CommonConstants.PWD_NOT_EMPTY_TXT;
import static com.ddlab.tornado.common.CommonConstants.SHELL_IMG_16;
import static com.ddlab.tornado.common.CommonConstants.SHELL_IMG_64;
import static com.ddlab.tornado.common.CommonConstants.UNAME_NOT_EMPTY_TXT;
import static com.ddlab.tornado.common.CommonConstants.USER_NAME_DECORATOR_TXT;
import static com.ddlab.tornado.common.CommonConstants.USER_NAME_TEXT;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ddlab.gitpusher.core.GitType;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.UserAccount;
import com.ddlab.gitpusher.exception.GenericGitPushException;
import com.ddlab.tornado.Activator;
import com.ddlab.tornado.common.CommonUtil;
import com.ddlab.tornado.common.ImageUtil;
import com.ddlab.tornado.threads.SnippetLoaderThread;

/**
 * The Class CreateGistSnippetDialog.
 *
 * @author Debadatta Mishra
 */
public class CreateGistSnippetDialog extends TitleAreaDialog {

  /** The git act combo. */
  private Combo gitActCombo = null;
  
  /** The user name text. */
  private Text userNameText = null;
  
  /** The password text. */
  private Text passwordText = null;
  
  /** The show gist btn. */
  private Button showGistBtn = null;
  
  /** The my gist combo. */
  private Combo myGistCombo = null;
  
  /** The gist desc txt. */
  private Text gistDescTxt = null;
  
  /** The selected file. */
  private File selectedFile;

  /**
   * Instantiates a new creates the gist snippet dialog.
   *
   * @param parentShell the parent shell
   * @param selectedFile the selected file
   */
  public CreateGistSnippetDialog(Shell parentShell, File selectedFile) {
    super(parentShell);
    this.selectedFile = selectedFile;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.Dialog#create()
   */
  @Override
  public void create() {
    super.create();
    getShell().setText(DLG_SHELL_TXT);
    getShell().setImage(ImageUtil.getImage(SHELL_IMG_16));
    setTitle(DLG_TITLE_TXT);
    setTitleImage(ImageUtil.getImage(SHELL_IMG_64));
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite dialogComposite = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(dialogComposite, SWT.NONE);
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    GridLayout layout = new GridLayout(2, false);
    container.setLayout(layout);

    createGitAccountCombo(container);
    createUserName(container);
    createPassword(container);
    createShowGist(container);
    createGistDescription(container);

    return dialogComposite;
  }

  /**
   * Creates the git account combo.
   *
   * @param container the container
   */
  private void createGitAccountCombo(Composite container) {
    Label gitActLabel = new Label(container, SWT.NONE);
    gitActLabel.setText(ACT_TYPE_LBL_TXT);
    gitActLabel.setFont(BOLD_FONT);
    gitActLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

    gitActCombo = new Combo(container, SWT.READ_ONLY);
    gitActCombo.setItems(GIT_ACCOUNTS);
    gitActCombo.select(0);
    gitActCombo.setFont(PLAIN_TXT_FONT);
    CommonUtil.setLayoutData(gitActCombo);
  }

  /**
   * Creates the user name.
   *
   * @param container the container
   */
  private void createUserName(Composite container) {
    Label userNameLabel = new Label(container, SWT.NONE);
    userNameLabel.setText(USER_NAME_TEXT);
    userNameLabel.setFont(BOLD_FONT);
    userNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    CommonUtil.setRequiredDecorator(userNameLabel, USER_NAME_DECORATOR_TXT);

    userNameText = new Text(container, SWT.BORDER);
    userNameText.setFont(PLAIN_TXT_FONT);
    userNameText.setFocus();
    addUserNameTextListener();
    CommonUtil.setLayoutData(userNameText);
  }

  /**
   * Creates the password.
   *
   * @param container the container
   */
  private void createPassword(Composite container) {
    Label passwordLabel = new Label(container, SWT.NONE);
    passwordLabel.setText(PWD_LBL_TXT);
    passwordLabel.setFont(BOLD_FONT);
    passwordLabel.setLayoutData(new GridData(GridData.END, SWT.CENTER, false, false));
    CommonUtil.setRequiredDecorator(passwordLabel, PWD_DECORATOE_TXT);

    passwordText = new Text(container, SWT.PASSWORD | SWT.BORDER);
    addPwdTextListener();
    CommonUtil.setLayoutData(passwordText);
  }

  /**
   * Creates the show gist.
   *
   * @param container the container
   */
  private void createShowGist(Composite container) {
    showGistBtn = new Button(container, SWT.PUSH);
    showGistBtn.setText(GIST_BTN_TXT);
    showGistBtn.setFont(BOLD_FONT);
    showGistBtn.setLayoutData(new GridData(GridData.END, SWT.CENTER, false, false));
    showGistBtn.setToolTipText(GIST_BTN_TOOL_TIP_TXT);

    myGistCombo = new Combo(container, SWT.READ_ONLY);
    myGistCombo.setFont(PLAIN_TXT_FONT);
    myGistCombo.setToolTipText(GIST_COMBO_DECORATOR_TXT);
    CommonUtil.setLayoutData(myGistCombo);
    addRepoBtnListener();
  }

  /**
   * Creates the gist description.
   *
   * @param container the container
   */
  private void createGistDescription(Composite container) {
    Label gistDescLbl = new Label(container, SWT.NONE);
    gistDescLbl.setText(GIST_LBL_TXT);
    gistDescLbl.setFont(BOLD_FONT);
    GridData userNamegData = new GridData();
    userNamegData.horizontalSpan = 2;
    gistDescLbl.setLayoutData(userNamegData);

    gistDescTxt = new Text(container, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
    gistDescTxt.setFont(PLAIN_TXT_FONT);
    addGistTextListener();

    GridData gData = new GridData();
    gData.heightHint = 40;
    gData.horizontalAlignment = SWT.FILL; // GridData.FILL;
    gData.horizontalSpan = 2;
    gistDescTxt.setLayoutData(gData);

    CommonUtil.setRightSideControlDecorator(gistDescLbl, GIST_LBL_INFO_TXT);
  }

  /**
   * Adds the gist text listener.
   */
  private void addGistTextListener() {
    gistDescTxt.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            setMessage("");
          }
        });
  }

  /**
   * Adds the repo btn listener.
   */
  private void addRepoBtnListener() {
    showGistBtn.addSelectionListener(
        new SelectionAdapter() {
          @Override
          public void widgetSelected(SelectionEvent e) {
            populateRepoCombo();
          }
        });
  }

  /**
   * Adds the user name text listener.
   */
  private void addUserNameTextListener() {
    userNameText.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            setMessage("");
          }
        });
  }

  /**
   * Adds the pwd text listener.
   */
  private void addPwdTextListener() {
    passwordText.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            setMessage("");
          }
        });
  }

  /**
   * Populate repo combo.
   */
  private void populateRepoCombo() {
    if (!isAccountValid()) return;
    myGistCombo.removeAll();
    String selectedGitType = GIT_ACCOUNTS[gitActCombo.getSelectionIndex()];
    UserAccount userAccount = new UserAccount(userNameText.getText(), passwordText.getText());
    IGitPusher gitPusher = GitType.fromString(selectedGitType).getGitPusher(userAccount);
    List<String> gistList = new ArrayList<>();
    IRunnableWithProgress op = new SnippetLoaderThread(gitPusher, gistList);

    try {
      new ProgressMonitorDialog(new Shell()).run(true, true, op);
      if (gistList.size() != 0) {
        setMessage("");
        String[] repos = gistList.toArray(new String[0]);
        myGistCombo.setItems(repos);
        myGistCombo.select(0);
      } else
        setMessage("There are no Snippet/s available, create one.", IMessageProvider.INFORMATION);

    } catch (InvocationTargetException | InterruptedException e) {
      e.printStackTrace();
      String reason = e.toString();
      String errMsg = e.getMessage();
      //      Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, reason, e);
      //      Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, reason);
      Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, reason, e);
      System.out.println("Actual Error Message : [" + e.getMessage() + "]");
      ErrorDialog.openError(new Shell(), "Error", errMsg, status);
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.Dialog#okPressed()
   */
  @Override
  protected void okPressed() {
    if (isAccountValid() && isDescValid()) {
      // Perform the operation
      String selectedGitType = GIT_ACCOUNTS[gitActCombo.getSelectionIndex()];
      UserAccount userAccount = new UserAccount(userNameText.getText(), passwordText.getText());
      IGitPusher gitPusher = GitType.fromString(selectedGitType).getGitPusher(userAccount);
      String snippetDesc = gistDescTxt.getText();
      executeInBackground(gitPusher, snippetDesc);

      close();
    }
  }

  /**
   * Execute in background.
   *
   * @param gitPusher the git pusher
   * @param snippetDesc the snippet desc
   */
  private void executeInBackground(IGitPusher gitPusher, String snippetDesc) {
    String gitWebType = GIT_ACCOUNTS[gitActCombo.getSelectionIndex()];
    String actualGit = gitWebType.equalsIgnoreCase("gitHub") ? "GitHub" : "BitBucket";
    String gistOrSnippet = gitWebType.equalsIgnoreCase("gitHub") ? "Gist" : "Snippet";
    String message = "Creating a " + gistOrSnippet + " in " + actualGit + " for ";
    Job job =
        new Job(message + selectedFile.getName()) {

          @Override
          protected IStatus run(IProgressMonitor monitor) {
            monitor.beginTask("Snippet Creation in Progress for file " + selectedFile.getName(), 4);
            monitor.worked(1);
            try {
              TimeUnit.SECONDS.sleep(2);
              monitor.subTask("Connecting to  " + actualGit);
              if (monitor.isCanceled()) return Status.CANCEL_STATUS;
              //              gitPusher.getExistingSnippets();
              gitPusher.pushSnippetDirectly(selectedFile, snippetDesc);
              monitor.subTask("Pushing code fragments to  " + gitWebType);
              monitor.worked(1);
              TimeUnit.SECONDS.sleep(1);
              monitor.subTask("Verifying code in  " + gitWebType);
              monitor.worked(1);
              TimeUnit.SECONDS.sleep(1);
              monitor.subTask("Completing all operations and finalizing.");
              TimeUnit.SECONDS.sleep(1);
              monitor.worked(1);
              monitor.worked(1);
              CommonUtil.showSuccess("Created successfully in " + actualGit);
            } catch (GenericGitPushException e1) {
              CommonUtil.showFailure(e1.getMessage());
            } catch (InterruptedException ie) {
              CommonUtil.showFailure(ie.getMessage());
            }
            if (monitor.isCanceled()) return Status.CANCEL_STATUS;

            monitor.done();
            return Status.OK_STATUS;
          }
        };
    job.setUser(true);
    job.schedule();
    PlatformUI.getWorkbench().getProgressService().showInDialog(getShell(), job);
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
   */
  @Override
  protected void cancelPressed() {
    super.cancelPressed();
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.Dialog#isResizable()
   */
  @Override
  protected boolean isResizable() {
    return true;
  }

  /**
   * Checks if is account valid.
   *
   * @return true, if is account valid
   */
  private boolean isAccountValid() {
    boolean isValidFlag = false;
    if (userNameText.getText().isEmpty()) setMessage(UNAME_NOT_EMPTY_TXT, IMessageProvider.ERROR);
    else if (passwordText.getText().isEmpty())
      setMessage(PWD_NOT_EMPTY_TXT, IMessageProvider.ERROR);
    else {
      isValidFlag = true;
      setMessage("");
    }
    return isValidFlag;
  }

  /**
   * Checks if is desc valid.
   *
   * @return true, if is desc valid
   */
  private boolean isDescValid() {
    boolean isValidFlag = false;
    if (gistDescTxt.getText().trim().isEmpty())
      setMessage(GIST_NOT_EMPTY_TXT, IMessageProvider.ERROR);
    else if (gistDescTxt.getText().length() > 200
        && GIT_ACCOUNTS[gitActCombo.getSelectionIndex()].equalsIgnoreCase("bitbucket"))
      setMessage("In Bitbucket more 200 characters are not allowed.", IMessageProvider.ERROR);
    else {
      isValidFlag = true;
      setMessage("");
    }
    return isValidFlag;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.TrayDialog#isHelpAvailable()
   */
  @Override
  public boolean isHelpAvailable() {
    return false;
  }
}
