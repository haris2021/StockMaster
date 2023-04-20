package model;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * stock class
 * implements
 * stockinterface
 * and implements all
 * functionalies
 * related to stock data.
 */
public class Stock implements Stockinterface {

  private String company;
  private String price;
  private String date;
  private String volume;

  /**
   * Constructs a Stock object with the following parameters.
   *
   * @param company company name
   * @param price   price of the stock
   * @param date    purchased date
   * @param volume  volume of the stock
   */

  public Stock(String company, String price, String date, String volume) {
    this.company = company;
    this.price = price;
    this.date = date;
    this.volume = volume;

  }

  public String getCompany() {
    return company;
  }

  public String getPrice() {
    return price;
  }

  public String getDate() {
    return date;
  }

  public String getVolume() {
    return volume;
  }


  @Override
  public int checkvaliddate(String date, Map<String, String[]> portfolio) {

    final String dateformat = "yyyy-MM-dd";

    try {

      DateFormat df = new SimpleDateFormat(dateformat);
      df.setLenient(false);
      df.parse(date);
      Date enteredDate = df.parse(date);

      Calendar cal = Calendar.getInstance();
      cal.setTime(enteredDate);

      int day = cal.get(Calendar.DAY_OF_WEEK);

      if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
        return 1;
      }


      if (enteredDate.after(new Date())) {
        return 2;
      } else {
        DateFormat dd = new SimpleDateFormat(dateformat);

        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
          Date portdate = dd.parse(entry.getValue()[2]);
          if (enteredDate.before(portdate)) {
            return 3;
          }
        }

      }
      return 4;

    } catch (ParseException e) {
      return 5;
    }

  }

  @Override
  public int checkvaliddate2(String date) {

    final String dateformat = "yyyy-MM-dd";
    Stockapinterface sp = new Stockapi();

    try {

      DateFormat df = new SimpleDateFormat(dateformat);
      df.setLenient(false);
      df.parse(date);
      Date enteredDate = df.parse(date);

      Calendar cal = Calendar.getInstance();
      cal.setTime(enteredDate);

      int day = cal.get(Calendar.DAY_OF_WEEK);

      if (date.length() != 10) {
        return 4;
      }

      if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
        return 1;
      }


      if (enteredDate.after(new Date())) {
        return 2;
      }

      if (sp.getstockprice(date, "AMZN").length() == 0) {
        return 1;
      }

    } catch (ParseException e) {
      return 3;
    }
    return 0;
  }

  @Override
  public Set<String> putdataintoset() throws IOException {
    Set<String> stocks = new HashSet<>();
    FileReader fr = new FileReader(System.getProperty("user.dir") + "/Textfile/Tickers.txt");
    int i;
    String company = "";
    boolean check = false;

    while ((i = fr.read()) != -1) {
      if (((char) i) != '\n') {
        if (((char) i) == '\r') {
          continue;
        }

        company = company + ((char) i);

      } else {
        stocks.add(company);
        company = "";
      }
    }

    return stocks;


  }


}