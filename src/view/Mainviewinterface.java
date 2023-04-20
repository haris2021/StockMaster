package view;

import java.util.Map;


/**
 * represents interface of the view.
 * provides methods to display content to the user.
 */

public interface Mainviewinterface {
  /**
   * asks the
   * user to enter ssn.
   */
  void getclientinfo();

  /**
   * displays the
   * text menu to
   * the user with
   * various options
   * that can be
   * performed on stocks.
   */
  void displaymenu();

  /**
   * asks the
   * user to enter
   * name.
   */
  void getusername();

  /**
   * asks the
   * user to
   * enter ssn.
   */
  void getuserssn();

  /**
   * displays success
   * message when user
   * created.
   */
  void succfun();

  /**
   * asks the user
   * to enter the
   * stock name to buy.
   */
  void getstockfromuser();

  /**
   * asks the user
   * to enter stock
   * quantity.
   */
  void getstockquantity();

  /**
   * displays the list
   * of all portfolios
   * created by the user.
   *
   * @param count the number of portfolios of the user.
   */
  void displayportfoliomenu(int count);

  /**
   * displays the
   * portfolio header
   * containing the
   * details of the
   * portfolio.
   */
  void displayportfolioheader();

  /**
   * displays the list of portfolio.
   *
   * @param portfolio collection of portfolio
   */

  void displayportfolio2(Map<String, String[]> portfolio);

  /**
   * displays the value
   * of the portfolio
   * on the entered date.
   *
   * @param price price of portfolio.
   */
  void printcurrentvalue(Double price);

  /**
   * displays success
   * message when stock
   * added to portfolio.
   */
  void successaddedstock();

  /**
   * displays success
   * message when
   * portfolio is created.
   */
  void displaysuccportmessage();

  /**
   * displays error
   * message when date
   * entered is invalid.
   */
  void displayinvalidmessage();

  /**
   * displays error
   * message when quantity
   * entered is invalid.
   */
  void displayquantitymessage();

  /**
   * displays error
   * message when stockname
   * entered is invalid.
   */
  void displayinvalidstock();

  /**
   * displays error message
   * when user tries
   * to view portfolio
   * if there isnt any.
   */
  void noportfoliomessage();

  /**
   * displays error message
   * when date entered
   * is weekend.
   */
  void displayinvaliddateweekend();

  /**
   * displays error message
   * when date entered
   * is in future.
   */

  void displayinvaliddatefuture();

  /**
   * Displayes Message
   * to get choice from
   * user.
   */
  void displayuserchoicemessage();

  /**
   * Displays
   * Message to get
   * which portfolio
   * number to get
   * details of.
   */
  void displayportfoliochoice();

  /**
   * Displays
   * message when
   * user try to enter
   * invalid
   * stock
   * data.
   */
  void displayinvalidstockname();

  /**
   * Displays invalid
   * message when portfolio
   * number for which the
   * user wants to
   * get details does
   * not exist.
   */
  void displayinvalidportfolionumbermessage();

  /**
   * Gets date
   * from user.
   */
  void getdatefromuser();

  /**
   * Display invalid
   * date message
   * when the
   * date entered
   * by the use is
   * not valid.
   */
  void displayinvailiddate();

  /**
   * Displays message
   * to get the
   * file path from
   * where the program
   * need to load the file
   * into the program.
   */
  void getfilepathfromuser();

  /**
   * Displays
   * invalid message
   * when the file user
   * trying to upload
   * is empty.
   */
  void displayvalidfilemessage();

  /**
   * Displays
   * success message
   * when user is able
   * to load the file
   * sucessfully into
   * the program.
   */
  void displayfileloaddeduscc();

  /**
   * Displays
   * invalid message
   * when the file user
   * trying to upload
   * does not exist.
   */
  void displayfilenotexist();

  /**
   * displays message when stocks added to portfolio.
   */

  void addstockmessage();

  /**
   * displays error message when stockname is invalid.
   */

  void invalidstockname();

  /**
   * asks user if more shares are to be added.
   */

  void getmoresharemessage();

  /**
   * asks user the date on which to add stocks.
   */

  void getaddeddate();

  /**
   * displays message if stocks are sold successfully.
   */

  void sellstockmessage();

  /**
   * asks user the stock name to sell.
   */

  void sellstock();

  /**
   * displays error message when user tries to sell invalid stock name.
   */

  void invalidnameselling();

  /**
   * asks user for no of shares to sell.
   */

  void sellshares();

  /**
   * displays error message when selling quantity exceeds available quantity.
   */

  void errorsellshares();

  /**
   * asks the user for selling date.
   */

  void selldate();

  /**
   * asks user to enter valid selling date.
   */

  void invaliddateselling();

  /**
   * asks the user to enter commission value.
   */

  void getcommission();

  /**
   * asks user to enter beginning date for performance chart.
   */

  void performancemenu();

  /**
   * asks user to enter ending date for performance chart.
   */

  void endingdateget();

  /**
   * lists the portfolios and asks user to enter number to calculate portfolio performance.
   *
   * @param count count of portfolio.
   */

  void displayportfoliomenuforperformance(int count);

  /**
   * displays the performance chart.
   *
   * @param mp       stock data of portfolio
   * @param minprice minimum stock data value
   * @param a        beginning date
   * @param b        end date
   */

  void displayperformance(Map<String, String> mp, Double minprice, String a, String b);

  /**
   * displays message if date entered is before the stock creation date.
   */

  void nostockboughtmessage();

  /**
   * displays error message when user tries to do flexible portfolio operations but not has any .
   */

  void noflexportfolio();

  /**
   * asks user to choose flexible or inflexible portfolio.
   */

  void displayflexinflexmenu();

  /**
   * displays the selling flexible portfolio contents .
   */

  void displaysellstockmessage();

  /**
   * displays messsage when stocks are sold successfully.
   */

  void successsoldstock();

  /**
   * displays the computed cost basis.
   *
   * @param cbf costbasis
   */

  void printcostbasis(Double cbf);

  /**
   * displays message when stocks are successfully bought.
   */

  void displaysuccessbuy();

  /**
   * displays error message when no of stocks is zero.
   */

  void stockquantityzero();

  /**
   * displays error message when commission fee is invalid.
   */

  void displaycommissionerrormessage();

  /**
   * asks the user to wait during performance chart creation.
   */

  void displaywaitmessage();

  /**
   * asks the user to enter the choice of creating portfolio.
   */

  void displayportfoliochoicecreation();

  /**
   * asks the user to enter investment amount.
   */

  void getinvestamount();

  /**
   * displays message when investment made successfully.
   */

  void succinvest();

  /**
   * displays user that the date entered is present and is a holiday.
   */

  void holidayandfuture();

  /**
   * asks the user to enter percentage of investment for the stockname.
   *
   * @param stockname the stock symbol
   */

  void getpercentage(String stockname);

  /**
   * displays message that the entered percentage is invalid.
   */

  void invalidpercentage();

  /**
   * asks the user to enter start date for investment.
   */

  void getstartdate();

  /**
   * asks the user to enter end date for investment.
   */

  void getenddate();

  /**
   * displays message that the investment is to be made in future.
   */

  void investfuture();

  /**
   * displays menu option of different time ranges to invest.
   */

  void timerangemenu();

  /**
   * displays message when no stocks available within the investment range.
   */

  void noportfoliorange();


}
