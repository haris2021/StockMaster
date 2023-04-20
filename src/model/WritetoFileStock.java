package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * writetofilestock
 * implements
 * WritetoFileStockinterface
 * which has
 * methods to fetch data
 * from api
 * and store it in
 * file.
 */
public class WritetoFileStock implements WritetoFileStockinterface {

  @Override
  public void fetchdatafromapi() {

    try {
      Stockapi st = new Stockapi();
      FileWriter fw1 = new FileWriter(System.getProperty(
              "user.dir") + "/Textfile/stocks.txt", false);
      PrintWriter pw1 = new PrintWriter(fw1, false);
      pw1.flush();
      pw1.close();
      fw1.close();


      File file = new File(System.getProperty("user.dir") + "/Textfile/stocks.txt");
      FileWriter fw = new FileWriter(file, true);
      PrintWriter pw = new PrintWriter(fw);

      String[] stocks = {"GOOG", "AAPL", "AMZN"};
      int counter = 1;

      for (int i = 0; i < stocks.length; i++) {
        counter++;
        String data = st.returnstockdata(stocks[i]);
        pw.println(stocks[i] + "," + data);
      }

      pw.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
