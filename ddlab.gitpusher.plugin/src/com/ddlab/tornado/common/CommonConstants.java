/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

/**
 * The Class CommonConstants.
 *
 * @author Debadatta Mishra
 */
public class CommonConstants {

  /** The Constant DISPLAY. */
  public static final Display DISPLAY = Display.getDefault();
  
  /** The Constant PLAIN_FONT_DATA. */
  public static final FontData PLAIN_FONT_DATA =
      new FontData("Times New Roman", 12, SWT.NORMAL); // Courier New
  
  /** The Constant BOLD_FONT_DATA. */
  public static final FontData BOLD_FONT_DATA = new FontData("Times New Roman", 10, SWT.BOLD);

  /** The Constant PLAIN_TXT_FONT. */
  public static final Font PLAIN_TXT_FONT = new Font(DISPLAY, PLAIN_FONT_DATA);
  
  /** The Constant BOLD_FONT. */
  public static final Font BOLD_FONT = new Font(DISPLAY, BOLD_FONT_DATA);

  /** The Constant GIT_ACCOUNTS. */
  public static final String[] GIT_ACCOUNTS = new String[] {"GitHub", "Bitbucket"};

  /** The Constant DLG_SHELL_TXT. */
  public static final String DLG_SHELL_TXT = "Git account information";
  
  /** The Constant DLG_TITLE_TXT. */
  public static final String DLG_TITLE_TXT = "Git account information";

  /** The Constant SHELL_IMG_16. */
  public static final String SHELL_IMG_16 = "github16.png";
  
  /** The Constant SHELL_IMG_64. */
  public static final String SHELL_IMG_64 = "github64.png";

  /** The Constant ACT_TYPE_LBL_TXT. */
  public static final String ACT_TYPE_LBL_TXT = "Select Git account type";
  
  /** The Constant ACT_TYPE_DECORATOR_TXT. */
  public static final String ACT_TYPE_DECORATOR_TXT = "Select account type, default is GitHub";

  /** The Constant USER_NAME_TEXT. */
  public static final String USER_NAME_TEXT = "User name";
  
  /** The Constant USER_NAME_DECORATOR_TXT. */
  public static final String USER_NAME_DECORATOR_TXT = "User name cannot be blank or empty";

  /** The Constant PWD_LBL_TXT. */
  public static final String PWD_LBL_TXT = "Password";
  
  /** The Constant PWD_DECORATOE_TXT. */
  public static final String PWD_DECORATOE_TXT = "Password cannot be blank or empty";

  /** The Constant REPO_BTN_TOOL_TIP_TXT. */
  public static final String REPO_BTN_TOOL_TIP_TXT = "Click to see the list of repositories";
  
  public static final String GIST_BTN_TOOL_TIP_TXT = "Click to see the list of code snippets";

  /** The Constant REPO_COMBO_DECORATOR_TXT. */
  public static final String REPO_COMBO_DECORATOR_TXT = "Displays the list of repositories";

  /** The Constant GIST_COMBO_DECORATOR_TXT. */
  public static final String GIST_COMBO_DECORATOR_TXT = "Displays the list of gist";

  /** The Constant REPO_BTN_TXT. */
  public static final String REPO_BTN_TXT = "Test and show my repositories";

  /** The Constant GIST_BTN_TXT. */
  public static final String GIST_BTN_TXT = "Test and show my gists";
  
  /** The Constant GIST_LBL_TXT. */
  public static final String GIST_LBL_TXT = "Provide brief description of the code snippet";

  /** The Constant GIST_LBL_INFO_TXT. */
  public static final String GIST_LBL_INFO_TXT =
      "The below description has been made mandatory to help \nthe developer/s "
          + "know the significance of your code snippet."
          + "\nThis desciption will be indexed by "
          + "all the search engines \n to find the code quickly";
  
  /** The Constant UNAME_NOT_EMPTY_TXT. */
  public static final String UNAME_NOT_EMPTY_TXT = "User name cannot be empty";
  
  /** The Constant PWD_NOT_EMPTY_TXT. */
  public static final String PWD_NOT_EMPTY_TXT = "Password cannot be empty";
  
  /** The Constant GIST_NOT_EMPTY_TXT. */
  public static final String GIST_NOT_EMPTY_TXT = "Gist description cannot be empty";
  
  /** The Constant READ_ME_INFO_TXT. */
  public static final String READ_ME_INFO_TXT = "Provide description which will be visible in  README.md";
  
  /** The Constant READ_ME_DECO_TXT. */
  public static final String READ_ME_DECO_TXT = "This description helps the developer/s to know about your project.";
  
}
