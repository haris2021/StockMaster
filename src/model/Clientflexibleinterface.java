package model;

import java.io.IOException;
import java.util.Map;

/**
 * Represents  Clientflexibleinterface that provides various methods
 * that can be applied on flexible portfolios.
 */

public interface Clientflexibleinterface {


  /**
   * adds stock data to flexible portfolio of the user.
   *
   * @param quantity quantity of stock
   * @param ssn      ssn
   * @param newstock stock object
   */
  void addstocktoclientflexible(int quantity, String ssn, Stock newstock);

  /**
   * returns count of flexible portfolios.
   *
   * @param ssnuser ssn
   * @return no of flexible portfolios.
   */

  int getportfoliocountflexible(String ssnuser);

  /**
   * adds 1 to no of flexible portfolios.
   *
   * @param ssnuser ssn
   */

  void addportcountflexible(String ssnuser);

  /**
   * gets flexible portfolio items through loading file.
   *
   * @param ssn      ssn
   * @param pathname path of the portfolio file
   * @throws IOException if failiure in reading file
   */

  void portfoliousingfileflexible(String ssn, String pathname) throws IOException;

  /**
   * checks whether the portfolio number of the flexible portfolio is valid one.
   *
   * @param pnum portfolio number
   * @param ssn  ssn
   * @return true if number is valid, else false
   */

  boolean checkpnumflexible(int pnum, String ssn);

  /**
   * returns the stocks data present in the flexible portfolio.
   *
   * @param ssnuser         ssn
   * @param portfolionumber portfolio number
   * @return map of stock data belonging to the portfolio
   */

  Map<String, String[]> getportfolioinfoflexible(String ssnuser, int portfolionumber);

  /**
   * returns the stock data of a flexible portfolio based on input date.
   *
   * @param ssnuser         ssn
   * @param portfolionumber portfolio number
   * @param displaydate     date given by the user
   * @return stock data on or before displaydate
   */

  Map<String, String[]> getportfolioinfoflexibledatefilter(
          String ssnuser, int portfolionumber, String displaydate);

  /**
   * returns value of the flexible portfolio based on input date.
   *
   * @param ssn         ssn
   * @param displayport portfolio number
   * @param worthdate   date given by the user
   * @return value of the portfolio
   */

  Map<String, String[]> getworthmapflexible(String ssn, int displayport, String worthdate);

  /**
   * function to edit the flexible portfolio.
   *
   * @param ssn       ssn
   * @param stockname stock symbol
   * @param quantity  quantity
   * @param date      date
   * @param price     price of stock symbol
   */

  void editportfolio(String ssn, String stockname,
                     int quantity, String date, String price, int displayport);

  /**
   * performs selling of stocks of a flexible portfolio.
   *
   * @param ssn             ssn
   * @param stockname       stock symbol
   * @param quantity        quantity of stock
   * @param portfolionumber portfolio number
   * @param selldate        selling date
   * @param sellprice       selling price
   */

  void sellstocksfromportfolio(String ssn, String stockname, String quantity,
                               int portfolionumber, String selldate, String sellprice);

  /**
   * performs cost basis of a flexible portfolio.
   *
   * @param ssn           ssn
   * @param displayport   portfolio number
   * @param date          date to perform cost basis
   * @param comissionrate commission rate for the transaction
   * @return the cost basis value
   */

  Double computecostbasis(String ssn, int displayport, String date, int comissionrate);

  /**
   * returns performance data of the flexible portfolio to display performance chart.
   *
   * @param bdate           beginning date
   * @param edate           end date
   * @param ssn             ssn
   * @param portfolionumber portfolio number
   * @return map of data based on interval given
   */

  Map<String, String> displayperformancebar(String bdate, String edate,
                                            String ssn, int portfolionumber);


  /**
   * creates stock for investment.
   *
   * @param date  date for investment
   * @param price investment price
   * @return array of created stocks
   */

  String[] createstockforinvestment(String date, String price);

  /**
   * validates the entered date.
   *
   * @param dat date
   * @return status of type string
   */

  String date4help(String dat);

  /**
   * validates the entered amount for investment.
   *
   * @param amt amount
   * @return true if valid, else false.
   */

  boolean validateamt(String amt);

  /**
   * validates the quantity for the stock.
   *
   * @param q         quantity
   * @param portfolio collection of stocks in the portfolio
   * @param qs        stockname
   * @return result of int type that denotes the status
   */

  int validateqty(String q, Map<String, String[]> portfolio, String qs);

  /**
   * compares start date and end date.
   *
   * @param sdate start date
   * @param edate end date
   * @return true if start date is before end date, else false.
   */

  boolean comparedate(String sdate, String edate);

  /**
   * returns the date before the current date.
   *
   * @return date
   */

  String getbeforecurr();

  /**
   * validates percentage for the stock.
   *
   * @param p percentage
   * @return true if valid, else false
   */

  boolean valperc(String p);

}
