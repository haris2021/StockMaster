package features;

import java.util.ArrayList;
import java.util.Map;

/**
 * Has all
 * methods
 * which GUI needs
 * to perform by interacting
 * with controller.
 */
public interface Features {


  /**
   * Calls the view
   * to get ssn from
   * the user.
   */
  void getssn();

  /**
   * Calls the model
   * to get check
   * if the ssn
   * entered by the
   * user is
   * existing
   * or new ssn.
   *
   * @param ssn SSN of the user.
   **/
  void checkssn(String ssn);


  /**
   * registeruser
   * calls the
   * model to
   * register the user
   * with the given
   * information passsed
   * as arguments.
   *
   * @param name Name of the user.
   * @param ssn  Ssn of the user.
   */
  void registeruser(String name, String ssn);

  /**
   * Calls the view
   * method which
   * is responsible
   * for displaying
   * menu to the user.
   */
  void displaymenu();

  /**
   * Calls the view
   * method which
   * is responsible
   * for showing
   * user the
   * various option
   * of creating
   * a new portfolio.
   */
  void choice();

  /**
   * Calls the method
   * in view , which
   * creates a portfolio
   * by accepting
   * file location
   * from the user.
   */
  void fileinput();

  /**
   * responsible for
   * creating a portfolio
   * using file path
   * by calling
   * the model with
   * the file path sent by the user.
   *
   * @param str Filepath given by user.
   */
  void filepath(String str);

  /**
   * Calls the view
   * method
   * which takes
   * all stock information
   * from user
   * to add it to
   * the user portfolio.
   */
  void getstockmanually();

  /**
   * perform one day investment on portfolio.
   */

  void getstockinvestment1();

  /**
   * create portfolio using one day investment.
   *
   * @param date   investment date
   * @param amount investment amount
   */

  void createstockusinginvestment1(String date, String amount);

  /**
   * performs one day investment by collecting stock data.
   *
   * @param stockname    stockname
   * @param percent      percentage of stock
   * @param date         date of investment
   * @param investamount investment amount.
   */

  void addstocksviainvestment1(String stockname, String percent, String date, String investamount);

  /**
   * requests user to enter start date and amount for dollar cost averaging.
   */

  void getstockinvestment2();

  /**
   * asks user to enter percentage for each stock on portfolio for start end investment.
   *
   * @param sdate            start date
   * @param investmentamount investment amount
   */

  void createstockusinginvestment2(String sdate, String investmentamount);

  /**
   * performs start end investment on stocks from the portfolio.
   *
   * @param stockname    stockname
   * @param percentage   percentage for the stock
   * @param date         starting date
   * @param investamount investment amount
   */

  void addstocksviainvestment2(String stockname, String percentage,
                               String date, String investamount);

  /**
   * asks the user for end date to perform start end investment and transfers to
   * start end investment operation.
   *
   * @param portfolio       collection of stocks in portfolio
   * @param sharepercent    percentages for each stock
   * @param date            end date
   * @param investamount    investment amount
   * @param portfolionumber portfolio number
   */

  void provideenddatefromuser(Map<String, String[]> portfolio, ArrayList<String> sharepercent,
                              String date, String investamount, String portfolionumber);

  /**
   * asks the user to enter the interval choice for start end investment on portfolio.
   *
   * @param portfolio       collection of stocks
   * @param sharepercent    percentages for each stock
   * @param date            start date
   * @param investamount    investment amount
   * @param edate           end date
   * @param portfolionumber portfolio number
   */

  void getintervalchoice(Map<String, String[]> portfolio, ArrayList<String> sharepercent,
                         String date, String investamount, String edate, String portfolionumber);

  /**
   * computes the start end investment.
   *
   * @param portfolio      collection of stocks
   * @param sharepercent   percentages for each stock
   * @param date           start date
   * @param investamount   investment amount
   * @param edate          end date
   * @param choice         portfolio choice
   * @param portfoliocount portfolio count
   */

  void calculateinvestment2(Map<String, String[]> portfolio, ArrayList<String> sharepercent,
                            String date, String investamount, String edate,
                            String choice, String portfoliocount);

  /**
   * performs investment when no end date is provided by the user.
   *
   * @param portfolio       collection of stocks
   * @param sharepercent    percentage for each stock
   * @param date            end date taken as current date
   * @param investamount    investment amount
   * @param portfolionumber portfolio number
   */

  public void noenddatefromuser(Map<String, String[]> portfolio, ArrayList<String> sharepercent,
                                String date, String investamount, String portfolionumber);

  /**
   * displays menu of various operations.
   */

  public void noaddstock();

  /**
   * Creates a portfolio by
   * using the accpeted parameters
   * which is sent in by the
   * view method.
   *
   * @param stockname name of stock.
   * @param quantity  number of stock.
   * @param date      date of buying the stock.
   */

  void getstockinfo(String stockname, String quantity, String date);

  /**
   * Calling the
   * view method
   * which is responsible
   * for navigating the
   * user to
   * the appropriate
   * window depending
   * upon the user choice.
   */
  void addstock();

  /**
   * Calls the method
   * in view which
   * gets information
   * from the user
   * to display
   * a particular portfolio.
   */
  void view();

  /**
   * calls the
   * model to
   * retrive
   * information
   * about a particular portfolio
   * which the user
   * wants to view.
   *
   * @param portfolionumber Portfolio number.
   * @param date            Date accepted from user.
   */
  void viewportfolio(String portfolionumber, String date);

  /**
   * Calls the
   * view method
   * responsible
   * for getting information
   * for calculating
   * the cost basis.
   */
  void costbasis();

  /**
   * Calls the model
   * to calculate cost basis
   * depending upon
   * the information
   * procided by the user.
   *
   * @param portfolionumber Portfolio number.
   * @param date            Date accepted from user.
   */
  void calcualtecostbasis(String portfolionumber, String date, String comissionrate);

  /**
   * Calls the
   * view method
   * responsible
   * for getting information
   * for calculating
   * worth of
   * portfolio.
   */
  void worth();

  /**
   * Calls the model
   * to calculate
   * worth of
   * portfolio
   * depending upon
   * the information
   * procided by the user.
   *
   * @param portfolionumber Portfolio number.
   * @param date            Date accepted from user.
   */
  void calcualteworth(String portfolionumber, String date);

  /**
   * asks user to enter no of shares to buy.
   */

  void buyshares();

  /**
   * collects the buy information of shares to execute buy function.
   *
   * @param stockname      stockname
   * @param quantity       quantity of stocks
   * @param date           date of buy
   * @param portfoliocount portfolio count
   */

  void buysharesinfo(String stockname, String quantity, String date, String portfoliocount);

  /**
   * asks user for quantity of stocks to sell.
   */

  void sellshares();

  /**
   * stores stocks of the entered portfolio number and displays the details.
   *
   * @param portfolionumber portfolio number
   */

  void sellsharesfun2(String portfolionumber);

  /**
   * collects the selling stock details from user and calls the sell function.
   *
   * @param stockname       stock name
   * @param quantity        quantity of stock
   * @param date            sell date
   * @param portfolionumber portfolio number
   */

  void sellsharesinfo(String stockname, String quantity, String date, String portfolionumber);

  /**
   * Calls the view
   * method which
   * gets information
   * regarding
   * one time investment.
   */
  void investment1();

  /**
   * colelcts the portfolio number, date and amount for one time investment from user.
   *
   * @param pnum portfolio number
   * @param date investment date
   * @param amt  investment amount
   */


  void investment1strategyf1(String pnum, String date, String amt);

  /**
   * collects the percentages of each stock in the portfolio.
   *
   * @param perc percentage of investment
   * @param p    collection of stocks
   * @param pnum portfolio number
   * @param date investment date
   * @param amt  investment amount
   */

  void investment1strategyf2(ArrayList<String> perc, Map<String, String[]> p,
                             int pnum, String date, String amt);

  /**
   * collects the stock details for start end investment and validates the total percentage
   * of the stock investment using model.
   *
   * @param percentage percentage of stocks
   * @param p          collection of stocks
   * @param pnum       portfolio number
   * @param date       investment date
   * @param amt        investment amount
   */

  void storepercinvestment2(String percentage, Map<String, String[]> p,
                            String pnum, String date, String amt);

  /**
   * collects stock  info for one time investment and validates the percentage of each stock.
   *
   * @param perc percentages of each stock
   * @param p    collection of stocks
   * @param pnum portfolio number
   * @param date investment date
   * @param amt  investment amount
   */

  void storeperc(String perc, Map<String, String[]> p, String pnum, String date, String amt);


  /**
   * Calls the view
   * method which
   * gets information
   * regarding
   * dollar cost
   * investment.
   */
  void investment2();

  /**
   * colleccts stock details within the entered date and calls view to to collect percentage
   * info for each stock.
   *
   * @param amount          investment amount
   * @param date            investment date
   * @param portfolionumber portfolio number
   */

  void investment2getedate(String amount, String date, String portfolionumber);

  /**
   * exits the gui.
   */


  void exitoption();

  /**
   * performs cost basis without commission fee.
   *
   * @param portfolionumber portfolio number
   * @param date            cost basis date
   * @param count           portfolio number
   */

  void nocommissionfee(String portfolionumber, String date, int count);

  /**
   * performs cost basis with commission fee.
   *
   * @param portfolionumber portfolio number
   * @param date            cost basis date.
   * @param count           portfolio number
   */

  void yescommissionfee(String portfolionumber, String date, int count);

  /**
   * collects commission fee from user and validates it.
   *
   * @param comission       commission rate
   * @param portfolionumber portfolio number
   * @param date            cost basis date
   */

  void checkcommissionfee(String comission, String portfolionumber, String date);

  /**
   * calls the view which collects stock information for performing selling of shares.
   *
   * @param portfolionumber portfolio number
   */
  void doafterdisplayingstock(String portfolionumber);


}
