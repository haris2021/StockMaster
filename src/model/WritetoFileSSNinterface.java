package model;

import java.io.IOException;

/**
 * WritetoFileSSNinterface
 * has method ,
 * implementing storing
 * data into a file.
 */
public interface WritetoFileSSNinterface {

  /**
   * writetofilessn
   * class is used to
   * create a ssn.txt file
   * which intially contains
   * sample social
   * security numbers.
   */
  void intializessndata() throws IOException;
}
