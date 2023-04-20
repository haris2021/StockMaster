package view;

import java.util.ArrayList;
import java.util.Map;

import features.Features;

/**
 * Has all
 * features
 * which GUI needs
 * to perform
 * by creating
 * frames in the user
 * window.
 */
public interface GUIviewInterface {


  /**
   * Intializes features.
   *
   * @param f Object of type features.
   */
  void addFeatures(Features f);


  /**
   * getssn gets
   * the ssn from the
   * user.
   */
  void getssn();


  /**
   * registeruser
   * asks the user
   * to register
   * if not registered
   * by asking the
   * required information.
   */
  void registeruser();


  /**
   * Responsible
   * for displaying
   * menu to the user.
   */
  void displaymenu();

  /**
   * Responsible
   * for showing
   * user the
   * various option
   * of creating
   * a new portfolio.
   */
  void displaychoice();

  /**
   * creates a portfolio
   * by accepting
   * file location
   * from the user.
   */
  void displayfileinput();

  /**
   * displays message when wrong file info entered.
   *
   * @param message message regarding the file.
   */

  void wrongfileinfoentered(String message);

  /**
   * Takes
   * all stock information
   * from user
   * to add it to
   * the user portfolio.
   */
  void manualmenu();

  /**
   * displays message when incorrect stock info entered.
   *
   * @param message appropriate message
   */

  void wrongstockinfoentered(String message);

  /**
   * displays error message when wrong information is entered.
   *
   * @param message message to be displayed.
   */

  void wronginfoentered(String message);

  /**
   * Navigating the
   * user to
   * the appropriate
   * window depending
   * upon the user choice
   * after creating the
   * portfolio.
   */
  void stockaddedafterstep();

  /**
   * creates portfolio using one time investment.
   */

  void getstockusinginvestment1();

  /**
   * directs to the window to get stocks for the one time investment.
   *
   * @param date             date to perform investment
   * @param investmentamount amount to be invested
   */

  void getstocksforinvestment1(String date, String investmentamount);

  /**
   * creates portfolio using start end investment.
   */

  void getstockusinginvestment2();

  /**
   * directs to the window to get stocks for start end investment.
   *
   * @param sdate            starting date
   * @param investmentamount investment amount
   */

  void getstocksforinvestment2(String sdate, String investmentamount);

  /**
   * displays message when stocks are added.
   *
   * @param message appropriate message
   */

  void displaysuccessstockadded(String message);

  /**
   * responsible for asking user end date for start end investment and
   * perform investment based on the end date provided.
   *
   * @param portfolio       collection of stocks on portfolio
   * @param sharepercent    percentages of each stock
   * @param date            end date
   * @param investamount    amount to be invested
   * @param portfolionumber portfolio number
   */

  void enddatefunctions(Map<String, String[]> portfolio, ArrayList<String> sharepercent,
                        String date, String investamount, String portfolionumber);

  /**
   * responsible for getting the end date for investment from the gui.
   *
   * @param portfolio       the collection of stocks on the portfolio.
   * @param sharepercent    percentages of each stock
   * @param date            end date
   * @param investamount    amount to be invested
   * @param portfolionumber portfolio number
   */

  void getenddatefromuser(Map<String, String[]> portfolio, ArrayList<String> sharepercent,
                          String date, String investamount, String portfolionumber);

  /**
   * responsible for asking user to enter the interval range such as days, weeks, months.
   *
   * @param portfolio       collection of stocks on portfolio
   * @param sharepercent    percentages of each stock
   * @param date            starting date
   * @param investamount    investment amount
   * @param edate           end date
   * @param portfolionumber portfolio number
   */

  void getintervalfromuser(Map<String, String[]> portfolio, ArrayList<String> sharepercent,
                           String date, String investamount, String edate, String portfolionumber);


  /**
   * Gets information
   * from the user
   * to display
   * a particular portfolio.
   */
  void view(int portfoliocount);

  /**
   * displays the stocks in a portfolio.
   *
   * @param portfolio collection of stocks in the portfolio.
   */

  void displayportfolio(Map<String, String[]> portfolio);

  /**
   * Responsible
   * for getting information
   * for calculating
   * the cost basis
   * from user.
   */
  void costbasis(int count);

  /**
   * displays the calculated cost basis to the user.
   *
   * @param cbf cost basis value
   */

  void displayvalue(Double cbf);

  /**
   * Responsible
   * for getting information
   * for calculating
   * the worth
   * of portfolio
   * from user.
   */
  void worth(int numberofportfolio);

  /**
   * gets the no of shares to be bought from the user.
   *
   * @param count count of shares
   */

  void buyshares(int count);

  /**
   * gets the no of shares to be sold from the user.
   *
   * @param count count of shares
   */

  void sellshares(int count);

  /**
   * performs the selling of shares from a portfolio.
   *
   * @param portfolionumber portfolio number
   */

  void sellsharesfun2(String portfolionumber);

  /**
   * displays the success message of an performed operation.
   *
   * @param message the appropriate message
   */
  void displaysuccessmessage(String message);


  /**
   * Responsible
   * for getting information
   * regarding one
   * time investment
   * in a particular
   * portfolio
   * from user.
   */
  void investment1strategy(int pcount);


  /**
   * Responsible
   * for getting information
   * regarding dollar
   * cost investment
   * in a particular
   * portfolio
   * from user.
   */
  void investment2strategy(int pcount);

  /**
   * performs the start end investment of a portfolio.
   *
   * @param sname stock name
   * @param p     collection of stocks
   * @param pnum  portfolio number
   * @param date  starting date
   * @param amt   amount to be invested
   */

  void displaystockinvestment2(String sname, Map<String, String[]> p,
                               String pnum, String date, String amt);

  /**
   * performs start end investment when end date is given by the user else current date taken.
   *
   * @param sharepercent percentages of stocks
   * @param p            collection of stocks of portfolio.
   * @param pnum         portfolio number
   * @param date         end date
   * @param amt          investment amount
   */

  void getenddatefromuserinvestment2(ArrayList<String> sharepercent,
                                     Map<String, String[]> p,
                                     String pnum, String date, String amt);

  /**
   * exits the gui.
   */
  void exitbutton();

  /**
   * asks the user for percentage for each stock in a portfolio and passes to perform
   * one time investment .
   *
   * @param stockname stockname
   * @param p         collection of stocks in portfolio
   * @param pnum      portfolio number
   * @param date      date for investment
   * @param amt       investment amount
   */

  void displaystock(String stockname, Map<String, String[]> p,
                    String pnum, String date, String amt);

  /**
   * displays message when invalid data entered.
   *
   * @param message approptiate message
   */

  void displayinvalidmsg(String message);

  /**
   * displays message when user enters invalid investment details.
   *
   * @param message appropriate message
   */


  void displayinvalidinvestmentinfo(String message);

  /**
   * displays message when user enters invalid share info for investment.
   *
   * @param message          appropriate message
   * @param date             investment date
   * @param investmentamount investment amount
   */

  void displayinvalidmsgshares(String message, String date, String investmentamount);

  /**
   * displays message when user enters wrong portfolio count.
   *
   * @param message      appropriate messsage
   * @param portfiocount portfolio count
   */

  void wrongviewinfoentered(String message, int portfiocount);

  /**
   * asks user to enter the commision fee for cost basis.
   *
   * @param portfolionumber portfolio number
   * @param date            cost basis date
   */

  void askcommissionfee(String portfolionumber, String date);

  /**
   * displays message when user inters invalid commission fee.
   *
   * @param portfolionumber portfolio number
   * @param date            cost basis date
   */

  void displayinvalidcommissionfeemessage(String portfolionumber, String date);

  /**
   * displays message when user enters invalid date for cost basis calculation.
   *
   * @param pcount portfolio count
   */

  void displayinvaliddatecostbasis(int pcount);

  /**
   * displays message when user enters invalid date for getting worth of portfolio.
   *
   * @param message appropriate message
   */

  void invaliddateworth(String message);

  /**
   * displays message when user enters wrong stock for buying.
   *
   * @param message appropriate message
   */

  void wrongstockinfobuy(String message);

  /**
   * displays the stock details for selling purpose.
   *
   * @param p               collection of stocks
   * @param portfolionumber portfolio number
   */

  void displaysellsharestock(Map<String, String[]> p, String portfolionumber);


  /**
   * displays message when user gives incorrect information during selling.
   *
   * @param message         appropriate message
   * @param portfolionumber portfolio number
   */
  void invalidinfosel(String message, String portfolionumber);

  /**
   * displays message when total percentage doesnt add up to 100.
   *
   * @param portfoionumber portfolio number
   * @param date           date
   * @param amount         amount
   */

  void displaytotalpercentageerror(String portfoionumber, String date, String amount);

  /**
   * displays message when percentage value is incorrect.
   *
   * @param portfoionumber portfolio number
   * @param date           date
   * @param amount         amount
   */

  void displaypercentageerrormessage(String portfoionumber, String date, String amount);

  /**
   * displays message when no stocks available for one time investment .
   */

  void nostocksforinvestment1();

  /**
   * displays message when one time investment was successfully made.
   *
   * @param pnum portfolio number
   * @param date investment date
   * @param amt  investment amount
   */

  void displaysuccessstockaddedinvestment1(String pnum, String date, String amt);

  /**
   * displays message when there is a error in the investment.
   *
   * @param message appropriate message
   */

  void displayerrorinvestment(String message);

  /**
   * displays error message for incorrect percentage in start end investment.
   *
   * @param amount          investment amount
   * @param date            investment date
   * @param portfolionumber portfolio number
   */

  void displaytotalpercentageerrorinvestment2(String amount,
                                              String date, String portfolionumber);

  /**
   * displays message when entered invalid start date for start end investment.
   *
   * @param message appropriate message
   */

  void invaliddateamtinvestment2(String message);

  /**
   * displays message when enteredd invalid end date in start end investment.
   *
   * @param portfolio       portfolio
   * @param sharepercent    percentages of stocks
   * @param date            end date
   * @param investamount    investment amount
   * @param portfolionumber portfolio number
   * @param message         appropriate message
   */

  void invalidenddateinvestment2(Map<String, String[]> portfolio,
                                 ArrayList<String> sharepercent,
                                 String date, String investamount,
                                 String portfolionumber, String message);

  /**
   * displays message when invalid percentage entered for start end investment
   * and goes to new window asking percentages again.
   *
   * @param amount          amount
   * @param date            investment date
   * @param portfolionumber portfolio number
   */

  void invalidpercentageinvestment2(String amount, String date, String portfolionumber);

  /**
   * displays message when end date is before start date for investment.
   *
   * @param portfolio       portfolio
   * @param sharepercent    percentages of stocks
   * @param date            investment date
   * @param investamount    investment amount
   * @param portfolionumber portfolio number
   */

  void enddatebeforestartdateinvestment2(Map<String, String[]> portfolio,
                                         ArrayList<String> sharepercent,
                                         String date, String investamount, String portfolionumber);

  /**
   * displays message when invalid date entered during portfolio creation.
   * using start end investment.
   *
   * @param message appropriate message
   */


  void invaliddateamtinvestment2viacreation(String message);

  /**
   * displays message when invalid stock percent entered during portfolio.
   * creation using start end investment.
   *
   * @param date         investment date
   * @param investamount investment amount
   * @param message      appropriate message
   */

  void invalidstockpercentinvestment2viacreating(String date, String investamount, String message);

  /**
   * displays message when portfolio created using one time investment.
   *
   * @param date    investment date
   * @param amount  investment amount
   * @param message success message
   */

  void displaysuccessstockaddedinvestment1viacreation(String date, String amount, String message);

  /**
   * displays message when  portfolio created using start end investment.
   *
   * @param date    investment date
   * @param amount  investment amount
   * @param message appropriate message
   */

  void displaysuccessstockaddedviainvestment2(String date, String amount, String message);


}
