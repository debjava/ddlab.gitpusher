package com.ddlab.generator.readme;

import com.ddlab.generator.IReadMeGen;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;

import static com.ddlab.generator.GeneratorConstants.README_MD_TEMPLATE;

public class ReadMeGenerator implements IReadMeGen {
  @Override
  public String generateReadMeMdContents(
      String projectName, String description, String contributorName) {
    String readMeContents = "";
    InputStream inputStream = getClass().getResourceAsStream(README_MD_TEMPLATE);
    try {
      String username = System.getProperty("user.name");
      contributorName = contributorName == null ? username : contributorName;
      readMeContents = IOUtils.toString(inputStream, Charset.defaultCharset());
      MessageFormat formatter = new MessageFormat(readMeContents);
      readMeContents =
          formatter.format(new String[] {projectName, description, contributorName, username});
    } catch (IOException e) {
      // Handle it
      e.printStackTrace();
    }
    return readMeContents;
  }
}
