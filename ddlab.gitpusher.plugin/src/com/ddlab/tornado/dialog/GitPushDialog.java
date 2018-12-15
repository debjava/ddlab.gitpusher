package com.ddlab.tornado.dialog;

// import static com.ddlab.tornado.common.CommonConstants.ACT_TYPE_DECORATOR_TXT;
// import static com.ddlab.tornado.common.CommonConstants.ACT_TYPE_LBL_TXT;
// import static com.ddlab.tornado.common.CommonConstants.BOLD_FONT;
// import static com.ddlab.tornado.common.CommonConstants.DLG_SHELL_TXT;
// import static com.ddlab.tornado.common.CommonConstants.DLG_TITLE_TXT;
// import static com.ddlab.tornado.common.CommonConstants.GIT_ACCOUNTS;
// import static com.ddlab.tornado.common.CommonConstants.PLAIN_TXT_FONT;
// import static com.ddlab.tornado.common.CommonConstants.PWD_DECORATOE_TXT;
// import static com.ddlab.tornado.common.CommonConstants.PWD_LBL_TXT;
// import static com.ddlab.tornado.common.CommonConstants.REPO_BTN_TOOL_TIP_TXT;
// import static com.ddlab.tornado.common.CommonConstants.REPO_COMBO_DECORATOR_TXT;
// import static com.ddlab.tornado.common.CommonConstants.REPO_BTN_TXT;
// import static com.ddlab.tornado.common.CommonConstants.SHELL_IMG_16;
// import static com.ddlab.tornado.common.CommonConstants.SHELL_IMG_64;
// import static com.ddlab.tornado.common.CommonConstants.USER_NAME_DECORATOR_TXT;
import static com.ddlab.tornado.common.CommonConstants.ACT_TYPE_DECORATOR_TXT;
import static com.ddlab.tornado.common.CommonConstants.ACT_TYPE_LBL_TXT;
import static com.ddlab.tornado.common.CommonConstants.BOLD_FONT;
import static com.ddlab.tornado.common.CommonConstants.DLG_SHELL_TXT;
import static com.ddlab.tornado.common.CommonConstants.DLG_TITLE_TXT;
import static com.ddlab.tornado.common.CommonConstants.GIT_ACCOUNTS;
import static com.ddlab.tornado.common.CommonConstants.PLAIN_TXT_FONT;
import static com.ddlab.tornado.common.CommonConstants.PWD_DECORATOE_TXT;
import static com.ddlab.tornado.common.CommonConstants.PWD_LBL_TXT;
import static com.ddlab.tornado.common.CommonConstants.PWD_NOT_EMPTY_TXT;
import static com.ddlab.tornado.common.CommonConstants.READ_ME_DECO_TXT;
import static com.ddlab.tornado.common.CommonConstants.READ_ME_INFO_TXT;
import static com.ddlab.tornado.common.CommonConstants.REPO_BTN_TOOL_TIP_TXT;
import static com.ddlab.tornado.common.CommonConstants.REPO_BTN_TXT;
import static com.ddlab.tornado.common.CommonConstants.REPO_COMBO_DECORATOR_TXT;
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
import com.ddlab.tornado.threads.ReposLoaderThread;

public class GitPushDialog extends TitleAreaDialog {

  private Combo gitActCombo = null;
  private Text userNameText = null;
  private Text passwordText = null;
  private Button showRepoBtn = null;
  private Combo myRepoCombo = null;
  private Text readMeTxt = null;
  private File selectedFile;

  public GitPushDialog(Shell parentShell, File selectedFile) {
    super(parentShell);
    this.selectedFile = selectedFile;
  }

  @Override
  public void create() {
    super.create();
    getShell().setText(DLG_SHELL_TXT);
    getShell().setImage(ImageUtil.getImage(SHELL_IMG_16));
    setTitle(DLG_TITLE_TXT);
    setTitleImage(ImageUtil.getImage(SHELL_IMG_64));
  }

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
    createShowRepo(container);
    createForReadMe(container);

    return dialogComposite;
  }

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
    CommonUtil.setProposalDecorator(gitActCombo, ACT_TYPE_DECORATOR_TXT);
  }

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

  private void createShowRepo(Composite container) {
    showRepoBtn = new Button(container, SWT.PUSH);
    showRepoBtn.setText(REPO_BTN_TXT);
    showRepoBtn.setFont(BOLD_FONT);
    showRepoBtn.setLayoutData(new GridData(GridData.END, SWT.CENTER, false, false));
    showRepoBtn.setToolTipText(REPO_BTN_TOOL_TIP_TXT);

    myRepoCombo = new Combo(container, SWT.READ_ONLY);
    myRepoCombo.setFont(PLAIN_TXT_FONT);
    myRepoCombo.setToolTipText(REPO_COMBO_DECORATOR_TXT);
    CommonUtil.setLayoutData(myRepoCombo);
    addRepoBtnListener();
  }

  private void createForReadMe(Composite container) {
    Label readMeLbl = new Label(container, SWT.NONE);
    readMeLbl.setText(READ_ME_INFO_TXT);
    readMeLbl.setFont(BOLD_FONT);
    GridData userNamegData = new GridData();
    userNamegData.horizontalSpan = 2;
    readMeLbl.setLayoutData(userNamegData);

    readMeTxt = new Text(container, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
    readMeTxt.setFont(PLAIN_TXT_FONT);

    GridData gData = new GridData();
    gData.heightHint = 40;
    gData.horizontalAlignment = SWT.FILL; // GridData.FILL;
    gData.horizontalSpan = 2;
    readMeTxt.setLayoutData(gData);

    CommonUtil.setRightSideControlDecorator(readMeLbl, READ_ME_DECO_TXT);
  }

  private void addRepoBtnListener() {
    showRepoBtn.addSelectionListener(
        new SelectionAdapter() {
          @Override
          public void widgetSelected(SelectionEvent e) {
            populateRepoCombo();
          }
        });
  }

  private void addUserNameTextListener() {
    userNameText.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            setMessage("");
          }
        });
  }

  private void addPwdTextListener() {
    passwordText.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            setMessage("");
          }
        });
  }

  private void populateRepoCombo() {
    // get the list of repositories;
    if (!isAccountValid()) return;
    myRepoCombo.removeAll();
    String selectedGitType = GIT_ACCOUNTS[gitActCombo.getSelectionIndex()];
    UserAccount userAccount = new UserAccount(userNameText.getText(), passwordText.getText());
    IGitPusher gitPusher = GitType.fromString(selectedGitType).getGitPusher(userAccount);
    List<String> reposList = new ArrayList<>();

    IRunnableWithProgress op = new ReposLoaderThread(gitPusher, reposList);

    //    IRunnableWithProgress op =
    //        new RepoLoaderThread(userNameText.getText(), passwordText.getText(), myRepoCombo,
    // repoList);

    //    if (reposList.size() == 0)
    //      setMessage("There are no Snippet/s available, create one.",
    // IMessageProvider.INFORMATION);
    //    else setMessage("");
    try {
      new ProgressMonitorDialog(new Shell()).run(true, true, op);
      if (reposList.size() != 0) {
        setMessage("");
        String[] repos = reposList.toArray(new String[0]);
        myRepoCombo.setItems(repos);
        myRepoCombo.select(0);
      } else
        setMessage("There are no Snippet/s available, create one.", IMessageProvider.INFORMATION);

    } catch (InvocationTargetException | InterruptedException e) {
      e.printStackTrace();
      Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e);
      ErrorDialog.openError(new Shell(), "Error", e.getMessage(), status);
    }

    //
    //
    //    String[] repos;
    //    try {
    //      repos = GitHubUtil.getAllRepositories(userNameText.getText(), passwordText.getText());
    //      myRepoCombo.setItems(repos);
    //      // if items are not empty
    //      if (repos != null && repos.length != 0) myRepoCombo.select(0);
    //    } catch (Exception e) {
    //      Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(),
    // e);
    //
    //      //    	String PID = Activator.PLUGIN_ID;
    //      //    	MultiStatus status = new MultiStatus(PID, 1, "Error 1", null);
    //      //    	status.add(new Status(IStatus.ERROR, PID, 1, "Error 2", null));
    //      //    	status.add(new Status(IStatus.ERROR, PID, 1, "Error 3", null));
    //      //    	status.add(new Status(IStatus.ERROR, PID, 1, "Error 4", null));
    //
    //      ErrorDialog.openError(new Shell(), "Error", e.getMessage(), status);
    //      System.out.println("=========>" + e.getMessage());
    //      e.printStackTrace();
    //    }
    //
    //

  }

  @Override
  protected void okPressed() {
    if (isAccountValid()) {
      // Perform the operation
      //    	 WorkbenchPlugin.getDefault().getPreferenceStore().setValue("RUN_IN_BACKGROUND",
      // false);
      //    	runInBackgroundProgressService();

      //    	show13();

      //    	MessageDialog.openInformation(new Shell(), "Done", "All Done Paa");

      //      generateGitIgnoreFile();
      //      generateReadMeFile();
      //      close();

      String selectedGitType = GIT_ACCOUNTS[gitActCombo.getSelectionIndex()];
      UserAccount userAccount = new UserAccount(userNameText.getText(), passwordText.getText());
      IGitPusher gitPusher = GitType.fromString(selectedGitType).getGitPusher(userAccount);
      String readMeText = (readMeTxt.getText()) == null ? "" : readMeTxt.getText();

      executeInBackground(gitPusher, readMeText);
    }
    //    super.okPressed();
  }

  private void executeInBackground(IGitPusher gitPusher, String readMetxt) {
    String gitWebType = GIT_ACCOUNTS[gitActCombo.getSelectionIndex()];
    String actualGit = gitWebType.equalsIgnoreCase("gitHub") ? "GitHub" : "BitBucket";
    String message = "Creating a project in " + actualGit + " for ";
    Job job =
        new Job(message + selectedFile.getName()) {

          @Override
          protected IStatus run(IProgressMonitor monitor) {
            monitor.beginTask(
                "Repository creation in progress for project " + selectedFile.getName(), 7);
            monitor.worked(1);
            try {
              TimeUnit.SECONDS.sleep(2);
              monitor.subTask("Creating .gitignore file ...");
              CommonUtil.generateGitIgnoreFile(selectedFile);
              monitor.worked(1);
              TimeUnit.SECONDS.sleep(1);
              if (monitor.isCanceled()) return Status.CANCEL_STATUS;
              monitor.subTask("Creating README.md file ...");
              CommonUtil.generateReadMeFile(selectedFile, readMetxt);
              monitor.worked(1);
              TimeUnit.SECONDS.sleep(1);
              if (monitor.isCanceled()) return Status.CANCEL_STATUS;
              monitor.subTask("Connecting to  " + actualGit);
              //	              gitPusher.getExistingRepos();
              gitPusher.pushCodeDirectly(selectedFile);
              monitor.subTask("Pushing project details to  " + gitWebType);
              monitor.worked(1);
              TimeUnit.SECONDS.sleep(1);
              monitor.subTask("Verifying repository in  " + gitWebType);
              monitor.worked(1);
              TimeUnit.SECONDS.sleep(1);
              monitor.subTask("Completing all operations and finalizing.");
              TimeUnit.SECONDS.sleep(1);
              monitor.worked(1);
              monitor.worked(1);
              CommonUtil.showSuccess("Repository hosted successfully in " + actualGit);
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

  @Override
  protected void cancelPressed() {
    super.cancelPressed();
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

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

  @Override
  public boolean isHelpAvailable() {
    return false;
  }
}
