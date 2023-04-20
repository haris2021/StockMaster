package model;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * stockinterface contains
 * all methods which
 * is related to handling
 * stock data.
 */
public interface Stockinterface {


  /**
   * checks if the entered date to check value is valid by comparing with portfolio data.
   *
   * @param date      date to compute the value of portfolio.
   * @param portfolio the portfolio to compute value.
   * @return the message code number.
   */

  int checkvaliddate(String date, Map<String, String[]> portfolio);

  /**
   * checks if the entered date is valid.
   *
   * @param date date to be checked.
   * @return integer values each denoting different information about the date.
   */

  int checkvaliddate2(String date);

  /**
   * stores stock symbols into set and returns it.
   *
   * @return set containing stock symbols.
   * @throws IOException when error during file read
   */

  Set<String> putdataintoset() throws IOException;


}
