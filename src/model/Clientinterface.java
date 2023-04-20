package model;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Clientinterface has
 * all methods
 * which are required
 * to be performed
 * by the client.
 */
public interface Clientinterface {

  /**
   * obtains the price of the stock on entered date.
   *
   * @param date      entered date
   * @param stockname stock name
   * @return price of the stock
   */

  String getprice(String date, String stockname);

  /**
   * This method accept ssn
   * which is String
   * as input and
   * check if that user is
   * existing user or not
   * by reading ssn.txt
   * which is a file
   * that contains
   * ssn of all
   * registered customers.
   *
   * @param ssn represent Social security number.
   * @return boolean.
   * @throws IOException thrown when ssn.txt file is not found.
   */
  boolean checkuser(String ssn) throws IOException;

  /**
   * Createnewclient , accepts
   * two parameters
   * which are name of the
   * client and ssn of client
   * and creates clien tfile
   * for this client
   * with name and ssn ,
   * also updates
   * ssn.txt file which
   * contains all
   * existing client's ssn to
   * validate exisitng clients.
   *
   * @param name name of client.
   * @param ssn  ssn of client.
   * @throws IOException if ssn.txt file not found.
   */
  void createnewclient(String name, String ssn) throws IOException;

  /**
   * addstocktoclient accepts
   * three parameters and
   * write the stock which
   * the client has bought
   * into the client portfolio
   * file.
   *
   * @param quantity Number of shares client bought.
   * @param ssn      Social security number of the client.
   * @param newstock contains the stock details that
   *                 client has bought.
   */
  void addstocktoclient(int quantity, String ssn, Stock newstock);

  /**
   * addportcount, is used
   * to update the number of
   * portfolio a client has
   * created,
   * so that each time
   * a client wants to
   * use a different
   * portfolio
   * count can be retrived
   * from this file.
   *
   * @param ssnuser social security number of client.
   */
  void addportcount(String ssnuser);

  /**
   * getportfoliocount
   * is used
   * to get the current
   * number of portfolio
   * a user has ,
   * using ssn which is
   * accepted as parameter.
   *
   * @param ssnuser social security number of client.
   * @return number of portfolio user has.
   */
  int getportfoliocount(String ssnuser);

  /**
   * getportfolioinfo is used
   * to fetch all the stocks
   * a client has in a particular
   * portfolio and put it into
   * hashmap and retur it
   * so that the
   * portfolio information
   * can be displayed to the
   * user by running
   * through the hasmap.
   *
   * @param ssnuser         social security number of client.
   * @param portfolionumber The portfolio number
   *                        the client wants to view the details of.
   * @return hashmap containing the portfolio information.
   */
  Map<String, String[]> getportfolioinfo(String ssnuser, int portfolionumber);

  /**
   * validateq is used to
   * validate the quantity
   * entered by the client
   * and aks them to renter
   * the quantity if
   * negative quantity
   * is give.
   *
   * @param quantity number of stocks user
   *                 wants to buy.
   * @return true if valid quantity and false otherwise.
   */
  boolean validateq(String quantity);

  /**
   * validateq is used to
   * validate the quantity
   * entered by the client
   * and aks them to renter
   * the quantity if
   * negative quantity
   * is give.
   *
   * @param pnum portfolio number
   * @return true portfolio given exists , false otherwise.
   */
  boolean checkpnum(int pnum, String ssn);

  /**
   * portfoliousingfile is used
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
  void portfoliousingfile(String ssn, String pathname) throws IOException;

  /**
   * checkvalidstocks is used
   * to check if the
   * file containing
   * the portfolio
   * entered by the user
   * contains valid stock
   * name.
   *
   * @param filename   file path where
   *                   file is present.
   * @param stocknames contains all valid stock
   *                   names.
   * @return true if stocks in file valid,false otherwise.
   */
  boolean checkvalidstocks(String filename, Set<String> stocknames);

  /**
   * getworthstocks
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
  float getworthstocks(String date, Map<String, String[]> portfolio);


  /**
   * checkvalidselldate checks
   * if a client can sell
   * a particular stock
   * and returns true if he can
   * otherwise false.
   *
   * @param stockname name of stock
   * @param date      selling date of stock
   * @param portfolio portfolio information stored in map
   * @return true if valid else false
   */
  boolean checkvalidselldate(String stockname, String date, Map<String, String[]> portfolio, String quantity);

  /**
   * getworthmap used to
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
  Map<String, String[]> getworthmap(String ssn, int displayport, String worthdate);

  /**
   * find stock with minimum value.
   *
   * @param mp map of stock data
   * @return minimum value.
   */

  Double findmin(Map<String, String> mp);
}
