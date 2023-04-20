package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * writetofilessn
 * implements
 * WritetoFileSSNinterface
 * and has method
 * implemented
 * to write dummy data
 * into file.
 */
public class WritetoFileSSN implements WritetoFileSSNinterface {

  @Override
  public void intializessndata() throws IOException {
    File file =
            new File(System.getProperty("user.dir")
                    + "/Textfile/ssn.txt");
    FileWriter fw = new FileWriter(file, true);
    PrintWriter pw = new PrintWriter(fw);

    pw.println("123");
    pw.println("456");
    pw.println("789");

    pw.close();

  }
}
