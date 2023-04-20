package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import features.Features;
import model.Mainmodelinterface;
import model.Stock;
import view.GUIviewInterface;

/**
 * MaincontrollerGUI
 * is the controller
 * which handles
 * GUI related functionalties
 * by interacting with the
 * GUI and model.
 */
public class MaincontrollerGUI implements Features {

  private Mainmodelinterface m1;
  private GUIviewInterface v1;
  private Set<String> stockset;
  private String ssn;
  private int increment;

  private Map<String, String[]> portfolio;

  private ArrayList<String> sharepercent;

  private Double totalsharepercent;

  private int totalcount;

  private double tsharepercent;
  private int check1;
  private int check2;

  /**
   * Maincontroller
   * is the constructor
   * which initalizes
   * model object
   * to the private
   * data member
   * of type
   * MainmodelInterface.
   *
   * @param model Object of type MainmodelInterface.
   */
  public MaincontrollerGUI(Mainmodelinterface model) {
    sharepercent = new ArrayList<>();
    totalsharepercent = 0.0;
    increment = 1;
    portfolio = new HashMap<>();
    m1 = model;
    totalcount = 0;
    tsharepercent = 0.0;
    check1 = 0;
    check2 = 0;


    try {
      stockset = m1.initializeset();

    } catch (Exception e) {
      System.out.println("File not found");
    }

  }

  public void setView(GUIviewInterface view) {
    v1 = view;
    v1.addFeatures(this);
  }

  @Override
  public void getssn() {
    v1.getssn();
  }

  @Override
  public void checkssn(String ssnuser) {

    if (ssnuser.length() == 0 || ssnuser.contains("-")) {
      v1.displayinvalidmsg("Invalid information entered");
    } else {
      ssn = ssnuser;
      try {
        boolean check = m1.checkuserpresent(ssn);
        if (check) {
          v1.displaymenu();
        } else {
          v1.registeruser();
        }
      } catch (Exception e) {
        System.out.println("File does not exist");
      }
    }

  }

  @Override
  public void registeruser(String name, String ssn) {
    if (name.length() == 0 || ssn.length() == 0) {
      v1.displayinvalidmsg("please enter all details");
    } else {
      try {
        m1.createuser(name, ssn);
        v1.displaysuccessmessage("Successfully registered");
      } catch (Exception e) {
        System.out.println("file does not exist");
      }
    }
  }

  @Override
  public void displaymenu() {

    v1.displaymenu();
  }


  @Override
  public void choice() {

    v1.displaychoice();

  }

  @Override
  public void getstockmanually() {
    v1.manualmenu();
  }

  @Override
  public void getstockinfo(String stockname, String quantity, String date) {

    boolean checkstockname = stockset.contains(stockname.toUpperCase());
    boolean checkquantity = m1.validatequantity(quantity);
    int checkdate = m1.checkdatevalidity(date);

    if (checkstockname && checkquantity && checkdate == 0) {
      System.out.println("All true it comes here ");
      String price = m1.getstockprice(date, stockname);
      Stock news = new Stock(stockname, price, date, "0");
      m1.addstockflexible(Integer.parseInt(quantity), ssn, news);
      v1.stockaddedafterstep();
    } else {
      if (!checkstockname) {
        v1.wrongstockinfoentered("Wrong stock Name entered");
      } else if (!checkquantity) {
        v1.wrongstockinfoentered("Invalid Quantity");
      } else if (checkdate == 1) {
        v1.wrongstockinfoentered("Invalid date, Weekend");
      } else if (checkdate == 2) {
        v1.wrongstockinfoentered("Invalid date, Future date");

      } else if (checkdate == 4 || checkdate == 3) {
        v1.wrongstockinfoentered("Invalid date Format");

      } else {
        v1.wrongstockinfoentered("Invalid information");
      }
    }

  }

  @Override
  public void addstock() {

    v1.manualmenu();
  }

  @Override
  public void noaddstock() {
    m1.addportfoliocountflexible(ssn);
    v1.displaymenu();
  }

  @Override
  public void fileinput() {
    v1.displayfileinput();
  }

  @Override
  public void filepath(String filepath) {

    File tmpDir = new File(filepath);
    boolean exists = tmpDir.exists();

    if (exists) {

      if (tmpDir.length() == 0) {
        v1.wrongfileinfoentered("No content in the file");
        System.out.println(tmpDir.length());
      } else {
        boolean checkvalidstocks = m1.checkvalidstockname(filepath, stockset);
        System.out.println(checkvalidstocks);

        if (checkvalidstocks) {
          try {
            v1.displaysuccessmessage("Portfolio is created successfully");
            m1.createportfoliousingfileflexible(ssn, filepath);
            m1.addportfoliocountflexible(ssn);
          } catch (Exception e) {
            System.out.println("File not found");
          }

        } else {
          v1.wronginfoentered("Incorrect file information ");
        }
      }

    } else {
      v1.wronginfoentered("No such file exists in the path");
    }
  }

  @Override
  public void getstockinvestment1() {
    v1.getstockusinginvestment1();
  }

  @Override
  public void createstockusinginvestment1(String date, String amount) {

    String datecheck;
    boolean amtcheck;

    datecheck = m1.isDateValid4(date);
    amtcheck = m1.validateinvestmentamount(amount);


    if (date.length() == 0 || amount.length() == 0) {
      v1.displayinvalidinvestmentinfo("Invalid Information");

    } else {
      if (datecheck.equals("6")) {
        v1.displayinvalidinvestmentinfo("Future date Entered, Invalid date");
      } else if (datecheck.equals("1")) {
        v1.displayinvalidinvestmentinfo("Invalid date");
      } else if (datecheck.length() == 10 && amtcheck) {
        v1.getstocksforinvestment1(datecheck, amount);
      } else {
        v1.displayinvalidmsg("Add valid details");
      }

    }

  }

  @Override
  public void addstocksviainvestment1(
          String stockname, String percentage, String date, String investamount) {

    boolean checkstockname = stockset.contains(stockname.toUpperCase());
    boolean checkpercentage = percentage.contains("-");

    if (stockname.length() == 0 && percentage.length() == 0) {
      v1.displayinvalidmsgshares("Invalid inforamtion", date, investamount);
    } else {
      if (!checkpercentage && checkstockname) {
        String price = m1.getstockprice(date, stockname);
        String[] allcontent = m1.createstockforivestmentst1(date, price);
        portfolio.put(stockname, allcontent);
        sharepercent.add(percentage);
        totalsharepercent = totalsharepercent + Double.parseDouble(percentage);

        if (totalsharepercent == 100) {
          // all good
          int displayport = m1.displayportfolionumbersflexible(ssn);
          m1.investmentstrategy1(ssn, displayport, investamount, date, sharepercent, portfolio);
          m1.addportfoliocountflexible(ssn);
          v1.displaysuccessmessage("Investment made sucessfully");
          totalsharepercent = 0.0;
          portfolio = new HashMap<>();
          sharepercent = new ArrayList<>();

        } else {
          if (totalsharepercent > 100) {
            totalsharepercent = 0.0;
            v1.displaysuccessstockaddedinvestment1viacreation(
                    date, investamount, "Exceed 100%, Enter again");
          } else {
            v1.displaysuccessstockaddedinvestment1viacreation(date, investamount, "Added");
          }
        }
      } else if (checkpercentage) {
        v1.displayinvalidmsgshares("Invalid percantage", date, investamount);
      } else if (!checkstockname) {
        v1.displayinvalidmsgshares("Invalid Stockname", date, investamount);
      } else {
        v1.displayinvalidmsgshares("Wrong Information", date, investamount);
      }

    }

  }

  @Override
  public void getstockinvestment2() {
    v1.getstockusinginvestment2();
  }

  @Override
  public void createstockusinginvestment2(String sdate, String investmentamount) {

    boolean amtcheck = m1.validateinvestmentamount(investmentamount);
    String datecheck = m1.isDateValid4(sdate);

    if (sdate.length() == 0 || investmentamount.length() == 0) {
      v1.invaliddateamtinvestment2viacreation("Invalid Information");
    } else {
      if (amtcheck && datecheck.length() == 10) {
        // need to get the portfolio number.
        v1.getstocksforinvestment2(datecheck, investmentamount);
      } else if (amtcheck) {
        v1.invaliddateamtinvestment2viacreation("Invalid Amount");
      } else if (datecheck.equals("6")) {
        check1++;
        v1.getstocksforinvestment2(datecheck, investmentamount);
        // future date
      } else if (datecheck.equals("1")) {
        v1.invaliddateamtinvestment2viacreation("Invalid Date");

      }

    }

  }

  @Override
  public void addstocksviainvestment2(
          String stockname, String percentage, String date, String investamount) {

    stockname = stockname.toUpperCase();
    boolean checkstockname = stockset.contains(stockname);
    boolean checkpercentage = true;

    if (percentage.contains("-") || percentage.equals("0")) {
      checkpercentage = false;
    }

    if (stockname.length() == 0 || percentage.length() == 0) {
      v1.invalidstockpercentinvestment2viacreating(date, investamount, "Invalid Information");
    } else {

      if (checkstockname && checkpercentage) {
        String price = m1.getstockprice(date, stockname);
        String[] allcontent = m1.createstockforivestmentst1(date, price);
        portfolio.put(stockname, allcontent);
        sharepercent.add(percentage);
        totalsharepercent = totalsharepercent + Double.parseDouble(percentage);

        if (totalsharepercent == 100) {
          v1.enddatefunctions(portfolio, sharepercent, date, investamount, "0");
          totalsharepercent = 0.0;
          portfolio = new HashMap<>();
          sharepercent = new ArrayList<>();
        } else {

          if (totalsharepercent > 100) {
            totalsharepercent = 0.0;
            v1.displaysuccessstockaddedviainvestment2(
                    date, investamount, "Percentage cannot exceed 100");
          } else {
            v1.displaysuccessstockaddedviainvestment2(date, investamount, "Added");
          }
        }
      } else if (!checkstockname) {
        v1.invalidstockpercentinvestment2viacreating(date, investamount, "Invalid Stockname");

      } else if (!checkpercentage) {
        v1.invalidstockpercentinvestment2viacreating(date, investamount, "Invalid Percentage");

      }

    }

  }

  @Override
  public void provideenddatefromuser(
          Map<String, String[]> portfolio, ArrayList<String> sharepercent,
          String date, String investamount, String portfolionumber) {
    v1.getenddatefromuser(portfolio, sharepercent, date, investamount, portfolionumber);
  }

  @Override
  public void getintervalchoice(
          Map<String, String[]> portfolio, ArrayList<String> sharepercent,
          String date, String investamount, String edate, String portfolionumber) {

    System.out.println("end date" + edate);
    System.out.println("came");

    String edatecheck = m1.isDateValid4(edate);

    System.out.println(edatecheck);

    String edatee = "";

    if (!m1.checkstartenddate(date, edate)) {
      /// check in this function if enddate< startdate if yes ask user again to enter.
      v1.enddatebeforestartdateinvestment2(
              portfolio, sharepercent, date, investamount, portfolionumber);
    } else {
      if (edate.length() == 0) {
        v1.invalidenddateinvestment2(
                portfolio, sharepercent, date, investamount,
                portfolionumber, "Invalid information");
      } else
      {
        if (edatecheck.equals("6"))
        {
          check2++;
          if (check1 == 0)
          {
            edatecheck = m1.getbeforecurr();
            edatee = m1.isDateValid4(edatecheck);

          }

          System.out.println("entrred correct block1");

          v1.getintervalfromuser(portfolio, sharepercent, date,
                  investamount, edatee, portfolionumber);


        } else if (edatecheck.equals("1")) {
          v1.invalidenddateinvestment2(portfolio, sharepercent, date,
                  investamount, portfolionumber, "Invalid Date");

        }

        if (edatecheck.length() == 10) {
          System.out.println("entrred correct block2");
          v1.getintervalfromuser(portfolio, sharepercent, date,
                  investamount, edatecheck, portfolionumber);
        }

      }
    }
  }

  @Override
  public void calculateinvestment2(Map<String, String[]> portfolio,
                                   ArrayList<String> sharepercent, String date,
                                   String investamount, String edate,
                                   String choice, String portfoliocount) {
    int pcount;

    if (portfoliocount.equals("0")) {
      pcount = m1.displayportfolionumbersflexible(ssn);
    } else {
      pcount = Integer.parseInt(portfoliocount);
    }

    if (check1 != 0 && check2 != 0) {
      v1.displaysuccessmessage("Investment to be made in future, come back later");
    } else if (check1 == 0 && check2 != 0) {
      System.out.println("datee :" + date + "edate " + edate);
      m1.investmentstrategy2(ssn, pcount, investamount, date,
              edate, sharepercent, portfolio, choice);

      if (portfoliocount.equals("0")) {
        m1.addportfoliocountflexible(ssn);
      }
      v1.displaysuccessmessage("Done investment but for future investment come back later");

    } else {

      m1.investmentstrategy2(ssn, pcount, investamount, date,
              edate, sharepercent, portfolio, choice);

      if (portfoliocount.equals("0")) {
        m1.addportfoliocountflexible(ssn);
      }
      check1 = 0;
      check2 = 0;

      v1.displaysuccessmessage("Done investment");

    }

  }

  @Override
  public void noenddatefromuser(Map<String, String[]> portfolio,
                                ArrayList<String> sharepercent,
                                String date, String investamount, String portfolionumber) {

    String enddate = m1.getbeforecurr();

    String checkdate = m1.isDateValid4(enddate);
    v1.getintervalfromuser(portfolio, sharepercent, date, investamount, checkdate, portfolionumber);
    check2++;

  }


  @Override
  public void view() {
    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.wronginfoentered("No Portfolio , Please create one");
    } else {
      v1.view(pcount);
    }

  }

  @Override
  public void viewportfolio(String portfolionumber, String date) {

    int pcount = m1.displayportfolionumbersflexible(ssn);
    int checkdate = m1.checkdatevalidity(date);

    Map<String, String[]> portfolio;

    if (portfolionumber.length() == 0 || date.length() == 0) {
      v1.wrongviewinfoentered("Wrong stock information entered", pcount);

    } else {
      if (checkdate == 0) {
        portfolio = m1.displayportfoliodetailsflexibledatefilter(
                ssn, Integer.parseInt(portfolionumber), date);

        if (portfolio.size() == 0) {
          v1.wrongviewinfoentered("No Portfolio , Please create one", pcount);
        } else {
          v1.displayportfolio(portfolio);
        }
      } else {
        v1.wrongviewinfoentered("Invalid date entered", pcount);
      }
    }

  }

  @Override
  public void costbasis() {
    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.wronginfoentered("No Portfolio , Please create one");
    } else {
      v1.costbasis(pcount);
    }

  }

  @Override
  public void yescommissionfee(String portfolionumber, String date, int pcount) {

    System.out.println("entered into checking commission fee");

    int checkdate = m1.checkdatevalidity(date);

    if (checkdate == 1) {
      checkdate = 0;
    } else if (checkdate == 2) {
      v1.displayinvaliddatecostbasis(pcount);

      //v1.displayinvaliddatefuture();
    } else if (checkdate == 3) {
      v1.displayinvaliddatecostbasis(pcount);

      //v1.displayinvailiddate();
    } else if (checkdate == 4) {
      v1.displayinvaliddatecostbasis(pcount);

      //v1.displayinvailiddate();
    }


    // valid date
    if (checkdate == 0) {
      v1.askcommissionfee(portfolionumber, date);
    } else {
      v1.displayinvaliddatecostbasis(pcount);
    }

  }

  @Override
  public void nocommissionfee(String portfolionumber, String date, int pcount) {

    // need to validate date
    int checkdate = m1.checkdatevalidity(date);
    if (checkdate == 1) {
      checkdate = 0;
    } else if (checkdate == 2) {
      v1.displayinvaliddatecostbasis(pcount);

    } else if (checkdate == 3) {
      v1.displayinvaliddatecostbasis(pcount);

    } else if (checkdate == 4) {
      v1.displayinvaliddatecostbasis(pcount);
    }


    if (checkdate == 0) {
      // valid date
      calcualtecostbasis(portfolionumber, date, "0");
    } else {
      v1.displayinvaliddatecostbasis(pcount);

    }


  }

  @Override
  public void checkcommissionfee(String commissionfee, String portfolionumber, String date) {
    if (commissionfee.contains("-")) {
      v1.displayinvalidcommissionfeemessage(portfolionumber, date);
    } else {
      calcualtecostbasis(portfolionumber, date, commissionfee);
    }
  }


  @Override
  public void calcualtecostbasis(String portfolionumber, String date, String comissionrate) {

    if (portfolionumber.length() == 0 || date.length() == 0 || comissionrate.length() == 0) {
      v1.wronginfoentered("Empty inputs");
    } else {
      if (comissionrate.contains("-")) {
        v1.wronginfoentered("Invalid information entered");
      } else {
        Double cbf = m1.calculatecostbasisflexible(ssn,
                Integer.parseInt(portfolionumber), date,
                Integer.parseInt(comissionrate));
        v1.displayvalue(cbf);
      }
    }
  }

  @Override
  public void worth() {
    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.wronginfoentered("No Portfolio , Please create one");
    } else {
      v1.worth(pcount);
    }

  }

  @Override
  public void calcualteworth(String portfolionumber, String date) {

    int checkdate = m1.checkdatevalidity(date);

    if (checkdate == 1) {
      v1.invaliddateworth("Invalid date, weekend");
      //v1.displayinvaliddateweekend();
    } else if (checkdate == 2) {
      v1.invaliddateworth("Invalid date, Future date");
      //v1.displayinvaliddatefuture();

    } else if (checkdate == 3) {
      v1.invaliddateworth("Invalid date");

      //v1.displayinvailiddate();
    } else if (checkdate == 4) {
      v1.invaliddateworth("Invalid date");

      //v1.displayinvailiddate();
    } else {

      double amount = 0.0;
      Map<String, String[]> portfolio = m1.getconsolidatedmapflexible(
              ssn, Integer.parseInt(portfolionumber), date);
      amount = m1.calculateflexiableportfolio(portfolio, date);
      if (amount > 0.0) {
        v1.displayvalue(amount);
      } else {
        v1.wronginfoentered("No stocks bought for this date, Worth is 0");
      }

    }
  }

  @Override
  public void buyshares() {
    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.wronginfoentered("No Portfolio , Please create one");
    } else {
      v1.buyshares(pcount);
    }

  }

  @Override
  public void buysharesinfo(String stockname, String quantity, String date, String portfoliocount) {

    String stockprice;

    stockname = stockname.toUpperCase();
    boolean checkstockname = stockset.contains(stockname);
    boolean checkquantity = m1.validatequantity(quantity);
    int checkdate = m1.checkdatevalidity(date);

    if (checkstockname && checkquantity && checkdate == 0) {
      stockprice = m1.getpricecertaindate(date, stockname);
      m1.addstockstoportfolioflexible(ssn, stockname, Integer.parseInt(quantity),
              date, stockprice, Integer.parseInt(portfoliocount));

      v1.displaysuccessmessage("Bought Sucessfully");

    } else if (!checkstockname) {
      v1.wrongstockinfobuy("Invalid stock name");

    } else if (!checkquantity) {
      v1.wrongstockinfobuy("Invalid Quantity");
    } else if (checkdate != 0) {
      v1.wrongstockinfobuy("Invalid date");
    } else {
      v1.wrongstockinfobuy("Invalid information");
    }

  }


  @Override
  public void sellshares() {
    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.wronginfoentered("No Portfolio , Please create one");
    } else {
      v1.sellshares(pcount);
    }

  }

  @Override
  public void sellsharesfun2(String portfolionumber) {
    Map<String, String[]> portfolio = m1.displayportfoliodetailsflexible(
            ssn, Integer.parseInt(portfolionumber));
    v1.displaysellsharestock(portfolio, portfolionumber);
  }

  @Override
  public void doafterdisplayingstock(String portfolionumber) {
    v1.sellsharesfun2(portfolionumber);
  }

  @Override
  public void sellsharesinfo(String stockname, String quantity,
                             String date, String portfolionumber) {

    // Map<String, String[]> portfolio = m1.displayportfoliodetailsflexible(
           // ssn, Integer.parseInt(portfolionumber));


    stockname = stockname.toUpperCase();

    boolean checkdate;

    boolean checkstockname = stockset.contains(stockname);
    int checkquantity = m1.checksellqty(quantity, portfolio, stockname);

    int checkdate1 = m1.checkdatevalidity(date);


    if (stockname.length() == 0 || quantity.length() == 0 || date.length() == 0) {
      v1.invalidinfosel("Invalid information", portfolionumber);

    } else if (!checkstockname) {
      v1.invalidinfosel("Invalid Stock name", portfolionumber);

    } else if (checkquantity != 4) {
      v1.invalidinfosel("Invalid Stock quantity", portfolionumber);

    } else if (checkdate1 != 0) {
      System.out.println("invalid1");
      v1.invalidinfosel("Invalid Stock date", portfolionumber);

    } else {

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(ssn,Integer.parseInt(portfolionumber),date);

      for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {

        System.out.println(entry.getKey() + "   "
                +
                entry.getValue()[0]
                + "      " + entry.getValue()[1]  + "      " + entry.getValue()[2]);

      }

      checkdate = m1.checkselldate(stockname, date, portfolio,quantity);


      if (checkdate) {

        String sellprice = m1.getpricecertaindate(date, stockname);
        m1.sellstocksflexible(ssn, stockname, quantity,
                Integer.parseInt(portfolionumber), date, sellprice);

        v1.displaysuccessmessage("Sold Sucessfully");
      } else
      {
        v1.invalidinfosel("Invalid date provided", portfolionumber);
      }

    }


  }

  @Override
  public void investment1() {
    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.wronginfoentered("No Portfolio , Please create one");
    } else {
      v1.investment1strategy(pcount);
    }

  }


  @Override
  public void investment1strategyf1(String pnum, String date, String amt) {

    if (pnum.length() == 0 || date.length() == 0 || amt.length() == 0) {
      v1.displayerrorinvestment("Invalid Information");
    } else {
      boolean checkamt = true;
      String checkdate = m1.isDateValid4(date);

      if (amt.contains("-") || amt.equals("0")) {
        checkamt = false;
      }

      if (checkamt && checkdate.length() == 10) {
        Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
                ssn, Integer.parseInt(pnum), date);

        if (portfolio.size() == 0) {
          v1.nostocksforinvestment1();
        } else {
          v1.displaystock(Integer.toString(increment), portfolio, pnum, date, amt);
        }
      } else if (!checkamt) {
        v1.displayerrorinvestment("Invalid amount");
      } else if (checkdate.length() != 10) {
        v1.displayerrorinvestment("Invalid date");
      }

    }

  }

  @Override
  public void storeperc(String perc, Map<String, String[]> p,
                        String pnum, String date, String amt) {

    if (Double.parseDouble(perc) <= 0) {
      v1.displaypercentageerrormessage(pnum, date, amt);
    } else {
      if (totalcount == p.size()) {
        m1.investmentstrategy1(ssn, Integer.parseInt(pnum), amt, date, sharepercent, p);
        totalcount = 0;
        increment = 1;
        tsharepercent = 0.0;
        sharepercent = new ArrayList<>();
        v1.displaysuccessmessage("Done");
      } else {
        sharepercent.add(perc);
        tsharepercent = tsharepercent + Double.parseDouble(perc);
        totalcount++;
        increment++;
        if (totalcount < p.size()) {
          v1.displaysuccessstockaddedinvestment1(pnum, date, amt);
        } else {
          System.out.println(tsharepercent);
          if (tsharepercent != 100.0) {
            v1.displaytotalpercentageerror(pnum, date, amt);
            totalcount = 0;
            increment = 1;
            tsharepercent = 0.0;
            sharepercent = new ArrayList<>();
          } else {
            storeperc(perc, p, pnum, date, amt);
          }
        }

      }
    }

  }


  @Override
  public void investment1strategyf2(ArrayList<String> perc, Map<String, String[]> portfolio,
                                    int pnum, String date, String amt) {
    System.out.println("perc" + perc);
  }


  @Override
  public void investment2() {

    int portfoliocount = m1.displayportfolionumbersflexible(ssn);
    v1.investment2strategy(portfoliocount);
  }

  @Override
  public void investment2getedate(String amount, String date, String portfolionumber) {

    if (amount.length() == 0 || date.length() == 0) {
      v1.invaliddateamtinvestment2("Invalid information entered");
    } else {
      boolean amtcheck = m1.validateinvestmentamount(amount);
      String datecheck = m1.isDateValid4(date);

      if (datecheck.equals("6")) {
        // given by user is future date
        check1++;
        System.out.println(check1);
        Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
                ssn, Integer.parseInt(portfolionumber), date);

        v1.displaystockinvestment2(Integer.toString(increment),
                portfolio, portfolionumber, date, amount);

      } else if (datecheck.equals("1")) {
        v1.invaliddateamtinvestment2("Invalid date");
        //invalid format
      } else if (datecheck.length() == 10 && amtcheck) {

        Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
                ssn, Integer.parseInt(portfolionumber), date);

        v1.displaystockinvestment2(Integer.toString(increment), portfolio,
                portfolionumber, date, amount);

      } else {
        v1.invaliddateamtinvestment2("Invalid amount entered");

      }
    }

  }

  @Override
  public void storepercinvestment2(String percentage, Map<String,
          String[]> p, String pnum, String date, String amt) {

    if (percentage.length() == 0 || percentage.contains("-")) {

      v1.invalidpercentageinvestment2(amt, date, pnum);
      // even one wrong ask from first.
      increment = 1;

    } else {

      if (totalcount == p.size()) {
        v1.getenddatefromuserinvestment2(sharepercent, p, pnum, date, amt);
        totalcount = 0;
        increment = 1;
        tsharepercent = 0.0;
        sharepercent = new ArrayList<>();

      } else {
        sharepercent.add(percentage);
        tsharepercent = tsharepercent + Double.parseDouble(percentage);
        totalcount++;
        increment++;

        if (totalcount < p.size()) {
          v1.displaystockinvestment2(Integer.toString(increment), p, pnum, date, amt);
        } else {

          System.out.println(tsharepercent);

          if (tsharepercent != 100.0) {
            v1.displaytotalpercentageerrorinvestment2(amt, date, pnum);
            totalcount = 0;
            increment = 1;
            tsharepercent = 0.0;
            sharepercent = new ArrayList<>();
          } else {
            storepercinvestment2(percentage, p, pnum, date, amt);

          }

        }

      }
    }

  }

  @Override
  public void exitoption() {
    v1.exitbutton();
  }
}

