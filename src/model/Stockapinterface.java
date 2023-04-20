package model;

/**
 * stockapiinterface has
 * methods which
 * are does
 * functionalities related to
 * api.
 */
public interface Stockapinterface {
  /**
   * returnstockdata is
   * used to return
   * the stock data
   * of one particular
   * stock
   * fetched from
   * the api.
   *
   * @param stockSymbol name of stock.
   * @return information of that stock.
   */
  String returnstockdata(String stockSymbol);

  /**
   * getstockprice
   * is used to fetch
   * price of particular
   * stock on a
   * particular date
   * from the api.
   *
   * @param stockdate   date for which price need
   *                    to be fetched.
   * @param stockSymbol name of the quantity
   *                    for which data should be
   *                    fetched from api.
   * @return stockprice of that particular stock.
   */
  String getstockprice(String stockdate, String stockSymbol);
}
