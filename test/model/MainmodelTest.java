package model;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a test class for performing unit tests on Mainmodel class.
 */

public class MainmodelTest {


  @Test
  public void testcheckvaliduser() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      assertTrue(m1.checkuserpresent("8"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  @Test
  public void testcheckinvaliduser() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      assertFalse(m1.checkuserpresent("001"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testcreateuser() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      m1.createuser("Dhoni", "007");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    File tmpDir = new File("/Users/harisgunasekaran/"
            + "Desktop/Java_Projects/Stock/src/Text file/007.txt");
    assertTrue(tmpDir.exists());

  }


  @Test
  public void testaddstock() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      m1.createuser("Dhoni", "007");
      Stock s = new Stock("GOOG", "150.10", "2022-09-10", "1234567");
      m1.addstock(3, "007", s);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    StringBuilder stringBuilder = new StringBuilder();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(
              "/Users/harisgunasekaran/Desktop"
                      + "/Java_Projects/Stock/src/Text file/"
                      + "007Portfolio1.txt"));
      char[] buffer = new char[10];
      while (reader.read(buffer) != -1) {
        stringBuilder.append(new String(buffer));
        buffer = new char[10];
      }
      reader.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    String content = stringBuilder.toString().trim();
    String expected = "GOOG\n"
            + "3\n"
            + "150.10\n"
            + "2022-09-10";
    assertEquals(expected, content);

  }


  @Test
  public void testaddportfoliocount() {
    Mainmodelinterface m1 = new Mainmodel();
    int count = 0;
    try {
      m1.createuser("sachin", "010");
      Stock s = new Stock("GOOG", "150.10", "2022-09-10", "1234567");
      m1.addstock(3, "007", s);
      count = m1.displayportfolionumbers("010");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    assertEquals(1, count);

  }

  @Test
  public void testdisplayportfoliodetails() {

    Mainmodelinterface m1 = new Mainmodel();
    try {

      Map<String, String[]> details = m1.displayportfoliodetails("007", 1);

      for (Map.Entry<String, String[]> entry : details.entrySet()) {
        assertEquals(entry.getKey(), "AAPL");
        assertEquals(entry.getValue()[0], "3");
        assertEquals(entry.getValue()[1], "150.10");
        assertEquals(entry.getValue()[2], "2022-09-10");
      }


    } catch (Exception e) {
      System.out.println(e.getMessage());
    }


  }

  @Test
  public void testvalidatequantity() {
    Mainmodelinterface m1 = new Mainmodel();
    assertFalse(m1.validatequantity("-1"));
  }

  @Test
  public void testvalidatequantity1() {
    Mainmodelinterface m1 = new Mainmodel();
    assertTrue(m1.validatequantity("1"));
  }

  @Test
  public void testcheckportnum() {
    Mainmodelinterface m1 = new Mainmodel();
    assertFalse(m1.checkportnum(7, "3"));
  }

  @Test
  public void testcheckportnum1() {
    Mainmodelinterface m1 = new Mainmodel();
    assertTrue(m1.checkportnum(1, "3"));
  }

  @Test
  public void testcreateportfoliousingfile() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      m1.addportfoliocount("6");
      m1.createportfoliousingfile("6", "/Users/harisgunasekaran/"
              + "Desktop/sampledata.txt");
      File tmpDir = new File(
              "/Users/harisgunasekaran/Desktop/Java_Projects/"
                      + "Stock/src/Text file/6Portfolio3.txt");
      assertTrue(tmpDir.exists());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }


  @Test
  public void testfetchdatafromapi() {
    Mainmodelinterface m1 = new Mainmodel();

    try {
      m1.fetchdatafromapi();
      File tmpDir = new File(System.getProperty("user.dir") + "/src/Text file/stocks.txt");
      assertTrue(tmpDir.exists());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }


  @Test
  public void testcheckfordatenegativedate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      Map<String, String[]> details = m1.displayportfoliodetails("567", 1);
      assertEquals(5, m1.checkfordate("-2020-10-10", details));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  @Test
  public void testcheckfordatefuturedate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      Map<String, String[]> details = m1.displayportfoliodetails("567", 1);
      assertEquals(2, m1.checkfordate("2023-10-10", details));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testcheckfordatebeforepurchasedate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      Map<String, String[]> details = m1.displayportfoliodetails("567", 1);
      assertEquals(3, m1.checkfordate("2022-10-10", details));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }


  @Test
  public void testcheckforcorrectdate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      Map<String, String[]> details = m1.displayportfoliodetails("567", 1);
      assertEquals(4, m1.checkfordate("2022-11-01", details));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testcheckforweekenddate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      Map<String, String[]> details = m1.displayportfoliodetails("567", 1);
      assertEquals(1, m1.checkfordate("2022-10-30", details));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }


  @Test
  public void testnegativequantity() {

    Mainmodelinterface m1 = new Mainmodel();
    try {
      assertFalse(m1.validatequantity("-5"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  @Test
  public void testpostivivequantity() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      assertTrue(m1.validatequantity("5"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testcreateflexibleportfoiliousingfile() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      m1.createportfoliousingfileflexible(
              "676", "/Users/harisgunasekaran/Desktop/validate.txt");
      assertTrue(m1.checkportnum(6, "676"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testcreateflexibleportfolio() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      Stock news = new Stock("goog", "96.7300", "2022-11-11", "0");
      m1.addstockflexible(2, "767", news);

      StringBuilder stringBuilder = new StringBuilder();

      try {
        BufferedReader reader = new BufferedReader(new FileReader(
                "/Users/harisgunasekaran/Desktop"
                        + "/Java_Projects/StockP2/Textfile/"
                        + "767flexiblePortfolio5.txt"));
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
          stringBuilder.append(new String(buffer));
          buffer = new char[10];
        }
        reader.close();
      } catch (Exception e) {
        System.out.println("hello");
      }

      String content = stringBuilder.toString().trim();
      String expected = "GOOG\n"
              + "2\n"
              + "96.7300\n"
              + "2022-11-11";

      assertEquals(expected, content);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testviewflexibleportfolio() {

    Mainmodelinterface m1 = new Mainmodel();
    try {

      String actual = "";
      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "767", 2, "2022-11-02");
      for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
        actual = actual + entry.getKey() +
                entry.getValue()[0] + entry.getValue()[1] + entry.getValue()[2];
      }
      String expected = "GOOG" + "10" + "90.5000" + "2022-11-01";
      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testaddstocktoflexibleportfolio() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      String actual = "";

      m1.addstockstoportfolioflexible("500", "meta", Integer.parseInt("4"),
              "2022-11-05", "65.4", 2);
      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "767", 2, "2022-11-02");
      for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
        actual = actual + entry.getKey() + entry.getValue()[0]
                +
                entry.getValue()[1] + entry.getValue()[2];
      }

      String expected = "TSLA" + "2" + "975.9300" + "2022 - 04 - 11" + "AMZN"
              +
              "1" + "3022.4400" + "2022 - 04 - 11" + "meta" + "4" + "65.4" + "2022-11-05";

      assertEquals(expected, actual);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }


  }

  @Test
  public void testsellstockfromportfolio() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      String actual = "";

      m1.sellstocksflexible("13", "GOOG", "1",
              7, "2022-11-11", "98.45");
      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "13", 7, "2022-11-11");
      for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
        actual = actual + entry.getKey()
                +
                entry.getValue()[0] + entry.getValue()[1] + entry.getValue()[2];
      }
      String expected = "META" + "1" + "334.3700" + "2022-01-11"
              +
              "GOOG" + "1" + "2800.3500" + "2022-11-11";
      assertEquals(expected, actual);

    } catch (Exception e) {
      System.out.println("file does not exist");
    }

  }

  @Test
  public void testcomputecostbasis() {

    Mainmodelinterface m1 = new Mainmodel();
    try {
      Double ans = m1.calculatecostbasisflexible(
              "13", 7, "2022-11-11", 5);
      assertEquals(5950.07, ans, 0.1);
    } catch (Exception e) {
      System.out.println("file is not found");
    }

  }

  @Test
  public void invalidinvestmentamount() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      boolean checkamount = m1.validateinvestmentamount("-200");
      assertFalse(checkamount);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void validinvestmentamount() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      boolean checkamount = m1.validateinvestmentamount("200");
      assertTrue(checkamount);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void validinvestmentamountdecimal() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      boolean checkamount = m1.validateinvestmentamount("200.10");
      assertTrue(checkamount);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void checkinvestmentstrategydate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      String checkinvestmentdate = m1.isDateValid4("-2022");
      assertEquals("1", checkinvestmentdate);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void checkinvestmentstrategydate2() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      String checkinvestmentdate = m1.isDateValid4("2024-04-11");
      assertEquals("6", checkinvestmentdate);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void checkinvestmentstrategydate3() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      String checkinvestmentdate = m1.isDateValid4("2022-11-27");
      assertEquals("2022-11-28", checkinvestmentdate);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void checkinvestmentstrategydate4() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      String checkinvestmentdate = m1.isDateValid4("2022-11-0");
      assertEquals("1", checkinvestmentdate);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void checkinvestmentstrategydate5() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      String checkinvestmentdate = m1.isDateValid4("2022-11-29");
      assertEquals("2022-11-29", checkinvestmentdate);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void checkinvalidpercentage() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      boolean checkinvestmentdate = m1.validpercentage("-20");
      assertFalse(checkinvestmentdate);

    } catch (Exception e) {
      System.out.println("File not found");
    }

  }

  @Test
  public void checkvalidpercentage() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      boolean checkinvestmentdate = m1.validpercentage("20");
      assertTrue(checkinvestmentdate);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void chekcvaliddecimalpercentage() {
    Mainmodelinterface m1 = new Mainmodel();
    try {

      boolean checkinvestmentdate = m1.validpercentage("20.20");
      assertTrue(checkinvestmentdate);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }


  @Test
  public void checktotalsharepercentage() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.50");
      sharepercent.add("49.5");
      boolean checktotalpercent = m1.checktotalpercentage(sharepercent);
      assertTrue(checktotalpercent);
    } catch (Exception e) {
      System.out.println("File not found");
    }

  }

  @Test
  public void checktotalsharepercentage2() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.50");
      sharepercent.add("49.1");
      boolean checktotalpercent = m1.checktotalpercentage(sharepercent);
      assertFalse(checktotalpercent);
    } catch (Exception e) {
      System.out.println("File not found");
    }

  }

  @Test
  public void checktotalsharepercentage1() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.50");
      sharepercent.add("52.5");
      boolean checktotalpercent = m1.checktotalpercentage(sharepercent);
      assertFalse(checktotalpercent);
    } catch (Exception e) {
      System.out.println("File not found");
    }

  }


  @Test
  public void checkonetimeinvestment() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.00");
      sharepercent.add("50.00");

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "1000", 34, "2019-06-11");
      m1.investmentstrategy1("1000", 35, "1000",
              "2019-06-11", sharepercent, portfolio);
      assertEquals(1299.10, m1.calculateflexiableportfolio(portfolio,
              "2022-11-21"), 0.2);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void checkdollarcostaveraginginvestment2() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.00");
      sharepercent.add("50.00");

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "1000", 35, "2015-04-11");

      m1.investmentstrategy2("1000", 35, "1000",
              "2020-04-11",
              "2022-04-11", sharepercent, portfolio, "4");

      assertEquals(1499.10, m1.calculateflexiableportfolio(portfolio,
              "2022-11-21"), 0.2);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void enddatebeforestartdate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      boolean check = m1.checkstartenddate("2022-04-11", "2010-04-11");
      assertFalse(check);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void enddateafterstartdate() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      boolean check = m1.checkstartenddate("2022-04-11", "2024-04-11");
      assertTrue(check);

    } catch (Exception e) {
      System.out.println("File not found");
    }
  }

  @Test
  public void buyfromportfoliocreatedinvesment() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.00");
      sharepercent.add("50.00");

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "1000", 35, "2015-04-11");

      m1.investmentstrategy2("1000", 35, "1000",
              "2020-04-11",
              "2022-04-11", sharepercent, portfolio, "4");
      Stock s = new Stock("GOOG", "150.11", "2022-11-10", "1234567");
      m1.addstockflexible(4, "1000", s);
      assertEquals(18979.10, m1.calculateflexiableportfolio(portfolio,
              "2022-11-21"), 0.2);

    } catch (Exception e) {
      System.out.println("File not found ");
    }

  }

  @Test
  public void sellfromportfolioinvesment() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.00");
      sharepercent.add("50.00");

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "1000", 35, "2015-04-11");

      m1.investmentstrategy2("1000", 35, "1000",
              "2020-04-11",
              "2022-04-11", sharepercent, portfolio, "4");
      Stock s = new Stock("GOOG", "150.11", "2022-11-10", "1234567");
      m1.sellstocksflexible("1000", "GOOG", "2", 35,
              "2022-11-24", "110.11");
      assertEquals(16579.10, m1.calculateflexiableportfolio(portfolio,
              "2022-11-21"), 0.2);
    } catch (Exception e) {
      System.out.println("File not found ");
    }


  }

  @Test
  public void costbasisinvestmentstrategywtcm() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.00");
      sharepercent.add("50.00");

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "1000", 35, "2015-04-11");

      m1.investmentstrategy2("1000", 35, "1000",
              "2020-04-11",
              "2022-04-11", sharepercent, portfolio, "4");
      Stock s = new Stock("GOOG", "150.11", "2022-11-10",
              "1234567");
      m1.calculatecostbasisflexible("1000", 1000,
              "2022-11-19", 0);
      assertEquals(1561.11, m1.calculateflexiableportfolio(portfolio,
              "2022-11-21"), 0.2);
    } catch (Exception e) {
      System.out.println("File not found ");
    }


  }

  @Test
  public void costbasisinvestmentwcb() {
    Mainmodelinterface m1 = new Mainmodel();
    try {
      ArrayList<String> sharepercent = new ArrayList<>();
      sharepercent.add("50.00");
      sharepercent.add("50.00");

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
              "1000", 35, "2015-04-11");

      m1.investmentstrategy2("1000", 35, "1000",
              "2020-04-11",
              "2022-04-11", sharepercent, portfolio, "4");
      Stock s = new Stock("GOOG", "150.11", "2022-11-10",
              "1234567");
      m1.calculatecostbasisflexible("1000", 1000,
              "2022-11-19", 5);
      assertEquals(17811.11, m1.calculateflexiableportfolio(portfolio,
              "2022-11-21"), 0.2);
    } catch (Exception e) {
      System.out.println("File not found ");
    }

  }

}