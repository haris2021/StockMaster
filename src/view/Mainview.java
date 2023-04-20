package view;

import java.io.PrintStream;
import java.util.Map;


/**
 * Mainview implements
 * mainviewinterface
 * which has methods
 * responsible for
 * displaying messages
 * to user.
 */
public class Mainview implements Mainviewinterface {

  private PrintStream out;

  /**
   * constructs a mainview object.
   *
   * @param o inputstream
   */

  public Mainview(PrintStream o) {
    this.out = o;
  }

  @Override
  public void getclientinfo() {
    out.println("Please enter your ssn:");
  }

  @Override
  public void displaymenu() {
    out.println("1.Create new Portfolio");
    out.println("2.View Portfolio");
    out.println("3.Get value of a Portfolio");
    out.println("4.Add Stocks to Flexible Portfolio");
    out.println("5.Sell Stocks from Flexible Portfolio");
    out.println("6.Compute Cost Basis");
    out.println("7.display performance");
    out.println("8.One time Investment in portfolio");
    out.println("9.Dollar cost Averaging in portfolio");
    out.println("10.Exit");
  }

  @Override
  public void getusername() {
    out.println("Please register!");
    out.println("Please enter your name:");
  }


  @Override
  public void getuserssn() {
    out.println("Please enter your ssn:");
  }

  @Override
  public void succfun() {
    out.println("Sucessfully created!");
  }

  @Override
  public void getstockfromuser() {
    out.println("Please enter the stockname you want to buy:");
  }

  @Override
  public void getstockquantity() {
    out.println("Please enter number of stocks you want to buy:");
  }

  @Override
  public void displayportfoliomenu(int count) {
    for (int i = 1; i < count; i++) {
      out.println("Portfolio" + " " + i);
    }
    System.out.println("Please enter the portfolio number to view:");

  }

  @Override
  public void displayportfolioheader() {
    out.println("");
    out.println("Name" + " "
            + "Quantity" + " "
            + "PurchasedDate");
  }


  @Override
  public void displayportfolio2(Map<String, String[]> portfolio) {
    int count = 0;
    for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {

      out.println(entry.getKey() + "   "
              +
              entry.getValue()[0]
              + "      " + entry.getValue()[2]);
      count++;
    }

    out.println("");
  }

  @Override
  public void printcurrentvalue(Double price) {

    out.println("Porfolio worth on entered date :$ " + price);
    out.println("");
  }

  @Override
  public void successaddedstock() {
    out.println("Successfuly added the stock!");
    out.println("Do u want to add more stocks to your portfolio!(Yes/No)");
  }

  @Override
  public void displaysuccportmessage() {
    out.println("portfolio sucessfully created");
  }

  @Override
  public void displayinvalidmessage() {
    out.println("invalid number");
  }

  @Override
  public void displayquantitymessage() {
    out.println("Please enter valid quantity: ");
  }

  @Override
  public void displayinvalidstock() {
    out.println("Please enter valid stock name:");
  }

  @Override
  public void noportfoliomessage() {
    out.println("no portfolios to show. please create one.");
  }

  @Override
  public void displayportfoliochoice() {
    out.println("1.Enter stock using file ");
    out.println("2.Enter stock data otherwise");
  }

  @Override
  public void displayportfoliochoicecreation() {
    out.println("1.Enter stock using file ");
    out.println("2.Enter stock data otherwise");
    out.println("3.Create portfolio using investment Strategy");
  }

  @Override
  public void displayinvalidportfolionumbermessage() {
    out.println("Enter valid portfolio number::");
  }

  @Override
  public void getfilepathfromuser() {
    out.println("Please enter the file path:");
  }

  @Override
  public void displayvalidfilemessage() {
    out.println("Fils is empty , enter valid file!");
    out.println(" ");
  }

  @Override
  public void displayfileloaddeduscc() {
    out.println("File loaded successfully!");
  }

  @Override
  public void displayfilenotexist() {
    out.println("File does not exist in the given location:");
    out.println("");
  }

  @Override
  public void getdatefromuser() {
    out.println("Enter the date (YYYY-MM-DD): ");
  }

  @Override
  public void displayinvalidstockname() {
    out.println("Invalid stock names");
  }

  @Override
  public void displayinvaliddateweekend() {
    out.println("No stock data on weekend");
  }

  @Override
  public void displayinvaliddatefuture() {
    out.println("cannot check for future date.");
  }


  @Override
  public void displayinvailiddate() {
    out.println("invalid date");
  }

  @Override
  public void displayuserchoicemessage() {
    out.println("Please enter your choice:");
  }

  @Override
  public void addstockmessage() {
    out.println("Please enter stock name you want to add stocks too: ");

  }

  @Override
  public void invalidstockname() {
    out.println("Stock you entered is not valid! Please renter!");

  }

  @Override
  public void getmoresharemessage() {
    out.println("Please choose how much more shares you want to add : ");

  }

  @Override
  public void getaddeddate() {
    out.println("enter the date for the stock to add(YYYY-MM-DD)");
  }

  @Override
  public void sellstockmessage() {
    out.println("Flexible Portfolios are");
    out.println("The portfolio where you want to sell stocks from are::");
  }

  @Override
  public void sellstock() {
    out.println("Please enter the stock name you want to sell::");

  }

  @Override
  public void invalidnameselling() {
    out.println("Please enter stockname present in the portfolio");

  }

  @Override
  public void sellshares() {
    out.println("Please enter number of stocks you want to sell::");

  }

  @Override
  public void errorsellshares() {
    out.println("quantity cannot exceed available quantity.");

  }

  @Override
  public void selldate() {
    out.println("Enter the date for which you want to sell the stock(YYYY-MM-DD):");

  }

  @Override
  public void invaliddateselling() {
    out.println("Please enter valid Date :");

  }

  @Override
  public void getcommission() {
    out.println("Enter the commission amount per transaction: ");

  }


  @Override
  public void performancemenu() {
    out.println("Performance Index");
    out.println("Enter Beginning date::");
  }

  @Override
  public void getstartdate() {
    System.out.println("Please enter the Start date to invest::");

  }

  @Override
  public void endingdateget() {
    out.println("Enter ending date::");

  }


  @Override
  public void displayportfoliomenuforperformance(int count) {
    for (int i = 1; i < count; i++) {
      out.println("Portfolio" + " " + i);
    }
    out.println("Please enter the portfolio number :");

  }

  @Override
  public void displayperformance(Map<String, String> mp,
                                 Double minprice, String bdate, String edate) {
    String rep = "";
    out.println("Performance of portfolio from " + bdate + " " + "to" + " " + "" + edate);

    for (Map.Entry<String, String> entry : mp.entrySet()) {
      int len = (int) (Double.parseDouble(entry.getValue()) / minprice);
      if (len > 50) {
        len = 50;
        rep = "*".repeat(len);
        rep += "  truncated to max 50";
      } else {
        rep = "*".repeat(len);
      }
      out.println(entry.getKey() + ": " + rep);

    }

    out.println("Scale: *= $" + minprice);

  }

  @Override
  public void nostockboughtmessage() {
    out.println("No stocks are bought before this date");
  }

  @Override
  public void noflexportfolio() {
    out.println("You do not have any Flexible portfolio , please add some!!");

  }

  @Override
  public void displayflexinflexmenu() {
    out.println("1.Flexible Portfolio::");
    out.println("2.InFlexible Portfolio::");
    out.println("Enter your choice::");
  }

  @Override
  public void displaysellstockmessage() {
    out.println("Flexible Portfolios are");
    out.println("The portfolio where you want to sell stocks from are::");

  }

  @Override
  public void successsoldstock() {
    out.println("Sold successfully!");
  }

  @Override
  public void printcostbasis(Double cbf) {

    Double l = Double.valueOf(Math.round(cbf * 100) / 100);

    out.println("Cost basis calculated is :$ " + cbf);
  }

  @Override
  public void displaysuccessbuy() {
    out.println("Successfully Bought the stock");
  }

  @Override
  public void stockquantityzero() {
    out.println("Number of shares for this stock is zero! Please enter some other stock!");
  }

  @Override
  public void displaycommissionerrormessage() {
    out.println("Please enter valid commission amount:");
  }

  @Override
  public void displaywaitmessage() {
    out.println("Please wait!! Data is being generated!");
  }

  @Override
  public void getinvestamount() {
    out.println("enter the investment amount.");

  }

  @Override
  public void succinvest() {
    out.println("investment made successfully.");
  }

  @Override
  public void holidayandfuture() {
    out.println("Day entered is holiday and next working day is Future day, " +
            "So please enter some other day ");
  }

  @Override
  public void getpercentage(String stockname) {
    out.println("enter percentage for " + stockname);
  }

  @Override
  public void invalidpercentage() {
    out.println("please enter valid percentage.");
  }

  @Override
  public void getenddate() {
    out.println("Do you want to give end date(Yes/No)");
  }

  @Override
  public void investfuture() {
    out.println("Investment to be made in the future.");
  }

  @Override
  public void timerangemenu() {
    out.println("Time ranges ");
    out.println("1.Days");
    out.println("2.Weeks");
    out.println("3.Months");
    out.println("4.years");
    out.println("Please enter the choice::");
  }

  @Override
  public void noportfoliorange() {
    out.println("no stock available in the portfolio within the range.");
  }
}
