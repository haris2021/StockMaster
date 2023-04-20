package model;

import java.util.ArrayList;
import java.util.Map;

/**
 * interface that contains methods related to performing investment strategy 1 and 2.
 */

public interface Investmentplansinterface {
  /**
   * performs one time investment on a portfolio.
   *
   * @param ssn            ssn
   * @param displayport    portfolio number
   * @param investamount   investment amount
   * @param investmentdate investment date
   * @param sharepercent   percentage of each stock
   * @param portfolio      collection of all stocks in portfolio
   */

  public void investportfoliostrategy1(String ssn, int displayport, String investamount
          , String investmentdate, ArrayList<String> sharepercent,
                                       Map<String, String[]> portfolio);

  /**
   * performs start end investment on a portfolio.
   *
   * @param ssn             ssn
   * @param displayport     portfolio number
   * @param investamount    investment amount
   * @param investmentsdate investment start date
   * @param investmentedate investment end date
   * @param sharepercent    percentage of each stock
   * @param portfolio       collection of all stocks in portfolio
   * @param choice          portfolio choice
   */

  public void investportfoliostrategy2(String ssn, int displayport, String investamount
          , String investmentsdate, String investmentedate,
                                       ArrayList<String> sharepercent,
                                       Map<String, String[]> portfolio, String choice);

}
