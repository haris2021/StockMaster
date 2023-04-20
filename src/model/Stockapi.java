package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * stockapi
 * implements stockapiinterface
 * having all methods
 * related
 * to fetching data
 * from api.
 */
public class Stockapi implements Stockapinterface {

  @Override
  public String returnstockdata(String stockSymbol) {
    String apiKey = "XVLMEBWYJ9X5CYWJ";
    URL url = null;
    try {

      url = new URL("https://www.alphavantage"
              + ".co/query?function=TIME_SERIES_DAILY"
              + "&outputsize=full"
              + "&symbol"
              + "=" + stockSymbol + "&apikey=" + apiKey + "&datatype=csv");
    } catch (MalformedURLException e) {
      throw new RuntimeException("the alphavantage API has either changed or "
              + "no longer works");
    }

    InputStream in = null;
    StringBuilder output = new StringBuilder();

    try {

      in = url.openStream();
      int b;
      int count = 0;

      while ((b = in.read()) != -1) {
        if ((char) b != '\n') {
          if (count == 0) {
            continue;
          } else {
            output.append((char) b);
          }

        }

        if ((char) b == '\n') {
          count++;
          if (count == 2) {
            break;
          }
        }
      }
    } catch (IOException e) {
      throw new IllegalArgumentException("No price data found for " + stockSymbol);
    }

    return output.toString();

  }

  @Override
  public String getstockprice(String stockdate, String stockSymbol) {


    String apiKey = "XVLMEBWYJ9X5CYWJ";
    URL url = null;
    try {

      url = new URL("https://www.alphavantage"
              + ".co/query?function=TIME_SERIES_DAILY"
              + "&outputsize=full"
              + "&symbol"
              + "=" + stockSymbol + "&apikey=" + apiKey + "&datatype=csv");
    } catch (MalformedURLException e) {
      throw new RuntimeException("the alphavantage API has either changed or "
              + "no longer works");
    }

    InputStream in = null;
    String output = "";

    try {

      in = url.openStream();
      int b;
      int count = 0;

      while ((b = in.read()) != -1) {

        if ((char) b != '\n') {
          if (count == 0) {
            continue;
          } else {
            output += ((char) b);

          }

        }

        if ((char) b == '\n') {

          if (count == 0) {
            count++;
          } else {
            String[] ress = output.split(",");
            if (ress[0].equals(stockdate)) {
              return ress[4];
            }
          }

          output = "";
        }

      }
    } catch (IOException e) {
      return "";
      //throw new IllegalArgumentException("No price data found for " + stockSymbol);
    }

    return output;

  }

}

