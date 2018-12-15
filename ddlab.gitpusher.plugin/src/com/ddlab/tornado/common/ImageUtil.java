package com.ddlab.tornado.common;

import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.graphics.Image;

import com.ddlab.tornado.Activator;

public class ImageUtil {
  public static final Image PROPOSAL_IMAGE =
      FieldDecorationRegistry.getDefault()
          .getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL)
          .getImage();

  public static final Image ERROR_IMAGE =
      FieldDecorationRegistry.getDefault()
          .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
          .getImage();
  
  public static final Image INFO_IMAGE =
	      FieldDecorationRegistry.getDefault()
	          .getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION)
	          .getImage();

  public static final Image REQUIRED_IMAGE =
      FieldDecorationRegistry.getDefault()
          .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR_QUICKFIX)
          .getImage();
  //          .getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED)
  //          .getImage();

  public static Image getImage(String fileName) {
    return Activator.getImageDescriptor("/icons/" + fileName).createImage();
  }
}
