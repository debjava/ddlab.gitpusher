package com.ddlab.tornado.common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class CommonConstants {

  public static final Display DISPLAY = Display.getDefault();
  public static final FontData PLAIN_FONT_DATA =
      new FontData("Times New Roman", 12, SWT.NORMAL); // Courier New
  public static final FontData BOLD_FONT_DATA = new FontData("Times New Roman", 10, SWT.BOLD);

  public static final Font PLAIN_TXT_FONT = new Font(DISPLAY, PLAIN_FONT_DATA);
  public static final Font BOLD_FONT = new Font(DISPLAY, BOLD_FONT_DATA);

  public static final String[] GIT_ACCOUNTS = new String[] {"GitHub", "Bitbucket"};

  public static final String DLG_SHELL_TXT = "Git account information";
  public static final String DLG_TITLE_TXT = "Git account information";

  public static final String SHELL_IMG_16 = "github16.png";
  public static final String SHELL_IMG_64 = "github64.png";

  public static final String ACT_TYPE_LBL_TXT = "Select Git account type";
  public static final String ACT_TYPE_DECORATOR_TXT = "Select account type, default is GitHub";

  public static final String USER_NAME_TEXT = "User name";
  public static final String USER_NAME_DECORATOR_TXT = "User name cannot be blank or empty";

  public static final String PWD_LBL_TXT = "Password";
  public static final String PWD_DECORATOE_TXT = "Password cannot be blank or empty";

  public static final String REPO_BTN_TOOL_TIP_TXT = "Click to see the list of repositories";

  public static final String REPO_COMBO_DECORATOR_TXT = "Displays the list of repositories";

  public static final String GIST_COMBO_DECORATOR_TXT = "Displays the list of gist";

  public static final String REPO_BTN_TXT = "Test and show my repositories";

  public static final String GIST_BTN_TXT = "Test and show my gists";
  
  public static final String GIST_LBL_TXT = "Provide brief description of the code snippet";

  public static final String GIST_LBL_INFO_TXT =
      "The below description has been made mandatory to help \nthe developer/s "
          + "know the significance of your code snippet."
          + "\nThis desciption will be indexed by "
          + "all the search engines \n to find the code quickly";
  
  public static final String UNAME_NOT_EMPTY_TXT = "User name cannot be empty";
  
  public static final String PWD_NOT_EMPTY_TXT = "Password cannot be empty";
  
  public static final String GIST_NOT_EMPTY_TXT = "Gist description cannot be empty";
  
  public static final String READ_ME_INFO_TXT = "Provide description which will be visible in  README.md";
  
  public static final String READ_ME_DECO_TXT = "This description helps the developer/s to know about your project.";
  
}
