/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.common;

import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.graphics.Image;

import com.ddlab.tornado.Activator;

/**
 * The Class ImageUtil.
 *
 * @author Debadatta Mishra
 */
public class ImageUtil {
  
  /** The Constant PROPOSAL_IMAGE. */
  public static final Image PROPOSAL_IMAGE =
      FieldDecorationRegistry.getDefault()
          .getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL)
          .getImage();

  /** The Constant ERROR_IMAGE. */
  public static final Image ERROR_IMAGE =
      FieldDecorationRegistry.getDefault()
          .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
          .getImage();
  
  /** The Constant INFO_IMAGE. */
  public static final Image INFO_IMAGE =
	      FieldDecorationRegistry.getDefault()
	          .getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION)
	          .getImage();

  /** The Constant REQUIRED_IMAGE. */
  public static final Image REQUIRED_IMAGE =
      FieldDecorationRegistry.getDefault()
          .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR_QUICKFIX)
          .getImage();
  //          .getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED)
  //          .getImage();

  /**
   * Gets the image.
   *
   * @param fileName the file name
   * @return the image
   */
  public static Image getImage(String fileName) {
    return Activator.getImageDescriptor("/icons/" + fileName).createImage();
  }
}
