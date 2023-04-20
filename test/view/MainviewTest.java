package view;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;

import model.Mainmodel;
import model.Mainmodelinterface;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for performing unit tests on Mainview class.
 */

public class MainviewTest {

  private PrintStream out;
  OutputStream outstream = new ByteArrayOutputStream();


  @Test
  public void test1() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.getclientinfo();
    assertEquals("Please enter your ssn:\n", outstream.toString());

  }

  @Test
  public void test2() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displaymenu();
    assertEquals("1.Create new Portfolio\n"
                    + "2.View Portfolio\n"
                    + "3.View current value of Portfolio\n"
                    + "4.Exit\n",
            outstream.toString());
  }

  @Test
  public void test3() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.getusername();
    assertEquals("Please register!\n"
                    + "Please enter your name:\n",
            outstream.toString());
  }


  @Test
  public void test4() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.getuserssn();
    assertEquals("Please enter your ssn:\n", outstream.toString());
  }

  @Test
  public void test5() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.succfun();
    assertEquals("Sucessfully created!\n", outstream.toString());
  }


  @Test
  public void test8() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.getstockfromuser();
    assertEquals("Please enter the stockname you want to buy:\n", outstream.toString());
  }

  @Test
  public void test9() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.getstockquantity();
    assertEquals("Please enter number of stocks you want to buy:\n", outstream.toString());
  }

  @Test
  public void test10() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayportfoliomenu(5);
    assertEquals("Please enter number of stocks you want to buy:\n", outstream.toString());
  }

  @Test
  public void test11() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayportfolioheader();
    assertEquals("\nName" + " "
            + "Quantity" + " "
            + "Price Purchased" + " "
            + "Date\n", outstream.toString());
  }

  @Test
  public void test14() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.successaddedstock();
    assertEquals("Successfuly added the stock!\n"
                    + "Do u want to add more stocks"
                    + " to your portfolio!(Yes/No)\n",
            outstream.toString());

  }

  @Test
  public void test15() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displaysuccportmessage();
    assertEquals("portfolio sucessfully created\n", outstream.toString());

  }

  @Test
  public void test16() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayinvalidmessage();
    assertEquals("invalid number\n", outstream.toString());

  }

  @Test
  public void test17() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayquantitymessage();
    assertEquals("Please enter valid quantity: \n", outstream.toString());

  }

  @Test
  public void test18() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayinvalidstock();
    assertEquals("Please enter valid stock name:\n", outstream.toString());

  }

  @Test
  public void test19() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.noportfoliomessage();
    assertEquals("no portfolios to show. please create one.\n", outstream.toString());


  }

  @Test
  public void test20() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayportfoliochoice();
    assertEquals("1.Enter stock using file+\n"
                    + "2.Enter stock data otherwise\n",
            outstream.toString());
  }

  @Test
  public void test21() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayinvalidportfolionumbermessage();
    assertEquals("Enter valid portfolio number\n", outstream.toString());

  }

  @Test
  public void test22() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.getfilepathfromuser();
    assertEquals("Please enter the file path:\n", outstream.toString());

  }

  @Test
  public void test23() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayvalidfilemessage();
    assertEquals("Please enter the file path:\n", outstream.toString());

  }

  @Test
  public void test24() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayfileloaddeduscc();
    assertEquals("File loaded successfully!\n", outstream.toString());

  }

  @Test
  public void getdatefromusertest() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.getdatefromuser();
    assertEquals(" Enter the date (YYYY-MM-DD):", outstream.toString());
  }

  @Test
  public void sellstockmessagetest() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.sellstockmessage();
    assertEquals("Flexible Portfolios are\n" +
            "The portfolio where you want to sell stocks from are::\n", outstream.toString());
  }

  @Test
  public void invalidnamesellingtest() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.invalidnameselling();
    assertEquals("Please enter stockname present in the portfolio\n", outstream.toString());
  }

  @Test
  public void testdisplayportfoliomenuforperformance() {
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    obj.displayportfoliomenuforperformance(2);
    assertEquals("Portfolio 1\n" +
            "Please enter the portfolio number to calculate performance:\n", outstream.toString());

  }

  @Test
  public void displayperformancetest() {
    Mainmodelinterface m1 = new Mainmodel();
    Mainviewinterface obj = new Mainview(new PrintStream(outstream));
    Map<String, String> mp = m1.calculateperformanceflexible("2020-05-05", "2020-10-10", "767", 5);
    Double minprice = m1.getminval(mp);
    obj.displayperformance(mp, minprice, "2020-05-05", "2020-10-10");
    assertEquals("Performance of portfolio from 2020-05-05 to 2020-10-10\n" +
            "MAY2020: *\n" +
            "JUN2020: **\n" +
            "JUL2020: ****\n" +
            "AUG2020: *****\n" +
            "SEP2020: ******\n" +
            "OCT2020: ********\n" +
            "Scale: *= $2702.22\n", outstream.toString());

  }

}