/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ddlab.generator.IGitIgnoreGen;
import com.ddlab.generator.IReadMeGen;
import com.ddlab.generator.gitignore.GitIgnoreGenerator;
import com.ddlab.generator.readme.ReadMeGenerator;

/**
 * The Class CommonUtil.
 *
 * @author Debadatta Mishra
 */
public class CommonUtil {

  // public static final Font BOLD_FONT =
  // JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);

  /**
   * Sets the proposal decorator.
   *
   * @param control the control
   * @param message the message
   */
  public static void setProposalDecorator(Control control, String message) {
    ControlDecoration decorator = getDecorator(control, message);
    decorator.setImage(ImageUtil.PROPOSAL_IMAGE);
    decorator.show();
  }

  /**
   * Sets the info decorator.
   *
   * @param control the control
   * @param message the message
   */
  public static void setInfoDecorator(Control control, String message) {
    ControlDecoration decorator = getDecorator(control, message);
    decorator.setImage(ImageUtil.INFO_IMAGE);
    decorator.show();
  }

  /**
   * Sets the required decorator.
   *
   * @param control the control
   * @param message the message
   */
  public static void setRequiredDecorator(Control control, String message) {
    ControlDecoration decorator = getDecorator(control, message);
    //    decorator.setImage(ImageUtil.ERROR_IMAGE);
    decorator.setImage(ImageUtil.PROPOSAL_IMAGE);
    decorator.show();
  }

  /**
   * Gets the decorator.
   *
   * @param control the control
   * @param message the message
   * @return the decorator
   */
  public static ControlDecoration getDecorator(Control control, String message) {
    ControlDecoration decorator = new ControlDecoration(control, SWT.TOP);
    decorator.setDescriptionText(message);
    return decorator;
  }

  /**
   * Sets the layout data.
   *
   * @param control the new layout data
   */
  public static void setLayoutData(Control control) {
    GridData gData = new GridData();
    gData.heightHint = 29;
    gData.grabExcessHorizontalSpace = true;
    gData.horizontalAlignment = GridData.FILL;
    control.setLayoutData(gData);
  }

  /**
   * Sets the right side control decorator.
   *
   * @param control the control
   * @param message the message
   */
  public static void setRightSideControlDecorator(Control control, String message) {
    ControlDecoration decorator = new ControlDecoration(control, SWT.CENTER | SWT.RIGHT);
    decorator.setDescriptionText(message);
    decorator.setImage(ImageUtil.INFO_IMAGE);
    decorator.setMarginWidth(2);
    decorator.show();
  }

  /**
   * Show success.
   *
   * @param message the message
   */
  public static void showSuccess(String message) {
    Display.getDefault()
        .syncExec(
            () -> {
              MessageDialog.openInformation(new Shell(), "Success", message);
            });
  }

  /**
   * Show failure.
   *
   * @param errMsg the err msg
   */
  public static void showFailure(String errMsg) {
    Display.getDefault()
        .syncExec(
            () -> {
              MessageDialog.openError(new Shell(), "Error", errMsg);
            });
  }

  /**
   * Generate read me file.
   *
   * @param selectedFile the selected file
   * @param description the description
   */
  public static void generateReadMeFile(File selectedFile, String description) {
    IReadMeGen readMeGen = new ReadMeGenerator();
    String projectName = selectedFile.getName();
    description =
        (description == null || description.trim().isEmpty()) ? "To be updated later" : description;
    String readMeContents = readMeGen.generateReadMeMdContents(projectName, description, null);
    Path readMePath = Paths.get(selectedFile.getAbsolutePath() + File.separator + "README.md");
    try {
      if (Files.exists(readMePath)) return;
      Files.write(readMePath, readMeContents.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Generate git ignore file.
   *
   * @param selectedFile the selected file
   */
  public static void generateGitIgnoreFile(File selectedFile) {
    IGitIgnoreGen gitIgnoreGenerator = new GitIgnoreGenerator();
    String gitIgnoreContents = gitIgnoreGenerator.generateGitIgnoreContents();
    Path gitIgnorePath = Paths.get(selectedFile.getAbsolutePath() + File.separator + ".gitignore");
    try {
      if (Files.exists(gitIgnorePath)) return;
      Files.write(gitIgnorePath, gitIgnoreContents.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
