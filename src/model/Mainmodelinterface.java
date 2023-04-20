package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * mainmodelinterface
 * has all methods
 * defined in them,
 * which are to be done
 * by the model.
 */
public interface Mainmodelinterface {

  /**
   * Check is
   * client is
   * registered
   * client or not.
   *
   * @param ssn social security number of client.
   * @return true if user is present and false otherwise.
   * @throws IOException if file not found.
   */

  boolean checkuserpresent(String ssn) throws IOException;

  /**
   * create a new
   * client and store the
   * information into file.
   *
   * @param name name of the client.
   * @param ssn  social security number of the client.
   * @throws IOException if file not found.
   */
  void createuser(String name, String ssn) throws IOException;


  /**
   * addstock is used to add
   * a stock to client
   * portfolio.
   *
   * @param quantity number of shares.
   * @param ssn      social security number of client.
   * @param newstock stock data which client bought.
   */
  void addstock(int quantity, String ssn, Stock newstock);

  /**
   * adds stock into a flexible portfolio.
   *
   * @param quantity quantity
   * @param ssn      ssn
   * @param newstock stock details
   */

  void addstockflexible(int quantity, String ssn, Stock newstock);

  /**
   * addportfoliocount is used
   * to increase the count
   * of portfolio of
   * one particular client.
   *
   * @param ssn social security number of client.
   */
  void addportfoliocount(String ssn);

  /**
   * increments flexible portfolio count when new portfolio created.
   *
   * @param ssn ssn
   */

  void addportfoliocountflexible(String ssn);

  /**
   * displayportfolionumbers is used
   * to return the total count
   * of portfolios a client has.
   *
   * @param ssn social security number of client
   * @return total number of portfolios.
   */
  int displayportfolionumbers(String ssn);

  /**
   * displays the portfolio count for the ssn user.
   * @param ssn ssn
   * @return count of portfolios
   */

  int displayportfolionumbersflexible(String ssn);


  /**
   * displayportfoliodetails is
   * used to fetch
   * details of all
   * stocks of a particular
   * portfolio a particular
   * client has.
   *
   * @param ssn             social security number of client.
   * @param portfolionumber portfolio number
   *                        for which
   *                        data must be displayed.
   * @return hashmap has portfolio information.
   */

  Map<String, String[]> displayportfoliodetails(String ssn, int portfolionumber);

  /**
   * fetches the stock details of the chosen portfolio.
   *
   * @param ssn             ssn
   * @param portfolionumber portfolio number
   * @return collection of stocks
   */

  Map<String, String[]> displayportfoliodetailsflexible(String ssn, int portfolionumber);

  /**
   * filters out the stocks within the date entered.
   *
   * @param ssn             ssn
   * @param portfolionumber portfolio number
   * @param displaydate     date entered
   * @return collection of stocks
   */

  Map<String, String[]> displayportfoliodetailsflexibledatefilter(
          String ssn, int portfolionumber, String displaydate);

  /**
   * validatequantity
   * is used to
   * check if the
   * quantity entered
   * by the user is valid or
   * not.
   *
   * @param quantitiy number of stocks.
   * @return true if valid and false otherwise.
   */
  boolean validatequantity(String quantitiy);

  /**
   * checkportnum is sued
   * to check
   * if a particular
   * portfolio
   * exists or not.
   *
   * @param portnum number of the portfolio.
   * @param ssn     social security number of client.
   * @return true if exists and false otherwise.
   */

  boolean checkportnum(int portnum, String ssn);

  /**
   * validates the portfolio number of the user.
   *
   * @param portnum portfolio number
   * @param ssn     ssn
   * @return true if present, else false
   */

  boolean checkportnumflexible(int portnum, String ssn);


  /**
   * createportfoliousingfile is used
   * to create portfolio
   * by accepting a
   * file path from user
   * and store the portfolio
   * into a file.
   *
   * @param ssn      social security number of client.
   * @param pathname file path from where
   *                 file should be read.
   * @throws IOException if file to be read is not found.
   */
  void createportfoliousingfile(String ssn, String pathname) throws IOException;

  /**
   * performs creation of flexible portfolio using file.
   *
   * @param ssn      ssn
   * @param pathname pathname of the file
   * @throws IOException when invalid pathname given
   */

  void createportfoliousingfileflexible(String ssn, String pathname) throws IOException;

  /**
   * checkvalidstockname is used
   * to check if the
   * file containing
   * the portfolio
   * entered by the user
   * contains valid stock
   * name.
   *
   * @param filepath file path where
   *                 file is present.
   * @param stocks   contains all valid stock
   *                 names.
   * @return true all stocks provided by user valid,false otherwise.
   */
  boolean checkvalidstockname(String filepath, Set<String> stocks);


  /**
   * fetchdatafromapi is used
   * to fetch the data
   * of certain stocks
   * from the api.
   */
  void fetchdatafromapi();

  /**
   * checks if the entered date to display value of portfolio is valid.
   *
   * @param date      the entered date.
   * @param portfolio portfolio to compute the value of.
   * @return message code number
   */

  int checkfordate(String date, Map<String, String[]> portfolio);

  /**
   * getstockprice is
   * a method which is
   * used to fetch the price
   * of a particular stock
   * on a particular date.
   *
   * @param udate     date for which price is needed.
   * @param stockname name of the stock.
   * @return
   */
  String getstockprice(String udate, String stockname);

  /**
   * initializeset used to get
   * the data from file into
   * set.
   *
   * @return Set consisting of stock symbols
   * @throws IOException when file read is unsuccessful
   */
  Set<String> initializeset() throws IOException;

  /**
   * checkdatevalidity
   * used to validate
   * the date entered by
   * user.
   *
   * @param udate date entered by user.
   * @return
   */
  int checkdatevalidity(String udate);

  /**
   * addstockstoportfolio
   * allows client to
   * add stock to flexible
   * portfolio's.
   *
   * @param ssn       social security number
   * @param stockname name of stock
   * @param quantity  shares of stock
   * @param date      date on which stock is bought
   * @param price     price of the stock
   */
  void addstockstoportfolioflexible(String ssn, String stockname,
                                    int quantity, String date, String price, int displayport);

  // repeating fucntion why?

  /**
   * getstockprice is
   * a method which is
   * used to fetch the price
   * of a particular stock
   * on a particular date.
   *
   * @param date      date for which price is needed.
   * @param stockname name of the stock.
   * @return
   */
  String getpricecertaindate(String date, String stockname);

  /**
   * sellstocks helps
   * the user to
   * sell a particular stock.
   *
   * @param ssn             social security number
   * @param stockname       name of stock
   * @param qantity         shares of stock
   * @param portfolionumber portfolio number in which stock is sold
   * @param selldate        date on which stock sold
   * @param sellprice       price for which stock sold
   */
  void sellstocksflexible(String ssn, String stockname, String qantity,
                          int portfolionumber, String selldate, String sellprice);

  /**
   * checkselldate checks
   * if a client can sell
   * a particular stock
   * and returns true if he can
   * otherwise false.
   *
   * @param stockname name of stock
   * @param date      selling date of stock
   * @param portfolio portfolio information stored in map
   * @return true if valid ,false otherwise
   */
  boolean checkselldate(String stockname, String date, Map<String, String[]> portfolio,String quantity);

  /**
   * calculateflexiableportfolio
   * returns the worth
   * of the user portfolio
   * on a given
   * date specified from
   * the user.
   *
   * @param date      date for which worth
   *                  of the portfolio need
   *                  to be computed.
   * @param portfolio Hashmap
   *                  Conatains all
   *                  the stocks which
   *                  the user has in his
   *                  portfolio.
   * @return value of the portfolio.
   */
  float calculateflexiableportfolio(Map<String, String[]> portfolio, String date);

  /**
   * getconsolidatedmap used to
   * help the client to
   * calculate the worth of
   * the portfolio on
   * a certain date.
   *
   * @param ssn         social security number
   * @param displayport Portfolio whose worth to calculate
   * @param worthdate   Date for which worth is calculated
   * @return map containing stocks
   */
  Map<String, String[]> getconsolidatedmap(String ssn, int displayport, String worthdate);

  /**
   * returns collection of stocks in a portfolio created on or before the entered date.
   *
   * @param ssn         ssn
   * @param displayport portfolio number
   * @param worthdate   entered date
   * @return collection of stocks
   */

  Map<String, String[]> getconsolidatedmapflexible(String ssn, int displayport, String worthdate);


  /**
   * calculatecostbasis , allows the
   * client to calculate
   * cost basis of a particular
   * portfolio on a certain date.
   *
   * @param ssn           social security number
   * @param displayport   Portfolio whose cost basis to calculate
   * @param date          Date for which cost basis is calculated
   * @param comissionrate commission rate
   * @return cost basis
   */
  Double calculatecostbasisflexible(String ssn, int displayport, String date, int comissionrate);

  /**
   * generates performance data of stocks of portfolio.
   *
   * @param bdate           beginning date
   * @param endate          end date
   * @param ssn             ssn
   * @param portfolionumber portfolio number
   * @return the performance data within the given interval
   */

  Map<String, String> calculateperformanceflexible(String bdate, String endate,
                                                   String ssn, int portfolionumber);

  /**
   * returns the minimum value of stock performance data.
   *
   * @param m map of stock data
   * @return minimum stock data value
   */

  Double getminval(Map<String, String> m);

  /**
   * performs one time investment on  a portfolio.
   *
   * @param ssn            ssn
   * @param displayport    portfolio number
   * @param investamount   investment amount
   * @param investmentdate investment date
   * @param sharepercent   percentages of each stock
   * @param portfolio      collection of stocks
   */

  void investmentstrategy1(String ssn, int displayport, String investamount,
                           String investmentdate, ArrayList<String> sharepercent,
                           Map<String, String[]> portfolio);

  /**
   * performs start end investment on a portfolio.
   *
   * @param ssn             ssn
   * @param displayport     portfolio number
   * @param investamount    investment amount
   * @param investmentsdate investment start date
   * @param investmentedate investment end date
   * @param sharepercent    percentages of stock
   * @param portfolio       collection of stocks on portfolio
   * @param choice          investment choice
   */


  void investmentstrategy2(String ssn, int displayport, String investamount,
                           String investmentsdate, String investmentedate,
                           ArrayList<String> sharepercent,
                           Map<String, String[]> portfolio, String choice);

  /**
   * creates portfolio using one time investment.
   *
   * @param date  investment date
   * @param price investment amount
   * @return collection of created stocks
   */

  String[] createstockforivestmentst1(String date, String price);

  /**
   * validates date for investment strategies.
   *
   * @param date entered date
   * @return status of the entered date.
   */


  String isDateValid4(String date);

  /**
   * validates the investment amount entered by the user.
   *
   * @param amt amount entered
   * @return true if valid, else false.
   */

  boolean validateinvestmentamount(String amt);

  /**
   * validates the selling quantity of the stock.
   *
   * @param qu        entered quantity
   * @param portfolio collection of stocks in portfolio
   * @param qq        stockname
   * @return status of the sell qty evaluation
   */

  int checksellqty(String qu, Map<String, String[]> portfolio, String qq);

  /**
   * checks if start and end date are in proper order.
   *
   * @param sdate start date
   * @param edate end date
   * @return true if correct order, else false.
   */

  boolean checkstartenddate(String sdate, String edate);

  /**
   * returns the date before the current date.
   *
   * @return previous date
   */

  String getbeforecurr();

  /**
   * validates the percentage entered.
   *
   * @param p percentage
   * @return true if valid, else false.
   */

  boolean validpercentage(String p);

  /**
   * validates the total percentage for the entered stocks.
   *
   * @param totalsharepercentage total percentage list
   * @return true if valid, else false
   */

  boolean checktotalpercentage(ArrayList<String> totalsharepercentage);

}
