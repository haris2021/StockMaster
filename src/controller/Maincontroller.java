package controller;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import model.Mainmodelinterface;
import model.Stock;
import model.Stockapi;
import model.Stockapinterface;
import view.Mainviewinterface;


/**
 * This is an implementation of the Maincontrollerinterface which provides various methods that
 * communicates with model and view.
 */

public class Maincontroller implements Maincontrollerinterface {
  private Mainmodelinterface m1;
  private Reader input;
  private Mainviewinterface v1;

  /**
   * represents a constructor for Maincontroller class.
   *
   * @param m1 maininterface object
   * @param v1 Mainviewinterface object
   * @param in Reader object
   */

  public Maincontroller(Mainmodelinterface m1, Mainviewinterface v1, Reader in) {
    this.m1 = m1;
    this.v1 = v1;
    this.input = in;

  }

  @Override
  public void mainfun() throws IOException {

    Set<String> stockset = m1.initializeset();

    v1.getclientinfo();
    Scanner sc = new Scanner(input);
    String ssn = sc.nextLine();

    boolean run1 = true;
    boolean run2 = true;
    boolean t;

    do {

      boolean check = m1.checkuserpresent(ssn);

      if (check) {

        do {

          v1.displaymenu();
          v1.displayuserchoicemessage();
          String strch = sc.nextLine();
          int choice = Integer.parseInt(strch);

          switch (choice) {
            case 1:
              createportfolio(ssn, stockset);
              break;
            case 2:
              viewportfolio(ssn);
              break;
            case 3:
              calculateworth(ssn);
              break;
            case 4:
              buystocks(ssn, stockset);
              break;
            case 5:
              sellstocks(ssn, stockset);
              break;
            case 6:
              costbasis(ssn);
              break;
            case 7:
              performance(ssn);
              break;
            case 8:
              investment1(ssn);
              break;
            case 9:
              investment2(ssn, false);
              break;
            case 10:
              run1 = false;
              System.exit(0);
              break;
            default:
              run2 = false;
              v1.displayinvalidmessage();
              break;
          }

        }
        while (run2);
      } else {
        v1.getusername();
        String name = sc.nextLine();
        v1.getuserssn();
        String ssn_new = sc.nextLine();
        m1.createuser(name, ssn_new);
        v1.succfun();

      }


    }
    while (run1);

  }

  private boolean createportfoliousingsetinflexible(String ssn, Set<String> stockset) {

    String get;
    boolean t;
    int quantity = 0;
    String stockname = "";
    boolean isstock;
    boolean result;
    String udate = "";
    String quantitystr = "";
    Scanner sc = new Scanner(System.in);

    v1.getstockfromuser();
    do {
      stockname = sc.nextLine();
      stockname = stockname.toUpperCase();
      isstock = stockset.contains(stockname);
      if (!isstock) {
        v1.displayinvalidstock();
      }
    }
    while (!isstock);

    v1.getstockquantity();
    do {
      quantitystr = sc.nextLine();
      result = m1.validatequantity(quantitystr);
      if (!result) {
        v1.displayquantitymessage();
      }

    }
    while (!result);
    quantity = Integer.parseInt(quantitystr);
    int checkdate;
    do {
      v1.getdatefromuser();
      udate = sc.nextLine();
      checkdate = isDateValid2(udate);

      if (checkdate == 1) {
        v1.displayinvaliddateweekend();
      } else if (checkdate == 2) {
        v1.displayinvaliddatefuture();

      } else if (checkdate == 3) {
        v1.displayinvailiddate();
      } else if (checkdate == 4) {
        v1.displayinvailiddate();
      }
    }
    while (checkdate != 0);

    String price = m1.getstockprice(udate, stockname);

    Stock news = new Stock(stockname, price, udate, "0");

    m1.addstock(quantity, ssn, news);

    v1.successaddedstock();

    get = sc.nextLine().toLowerCase();
    t = get.equals("yes");
    return t;
  }

  private boolean createportfoliousingsetflexible(String ssn, Set<String> stockset) {

    String get;
    boolean t;
    int quantity = 0;
    String stockname = "";
    boolean isstock;
    boolean result;
    String udate = "";
    String quantitystr = "";

    Scanner sc = new Scanner(input);

    v1.getstockfromuser();


    do {
      stockname = sc.nextLine();
      stockname = stockname.toUpperCase();
      isstock = stockset.contains(stockname);
      if (!isstock) {
        v1.displayinvalidstock();
      }
    }
    while (!isstock);


    v1.getstockquantity();
    do {
      quantitystr = sc.nextLine();
      result = m1.validatequantity(quantitystr);
      if (!result) {
        v1.displayquantitymessage();
      }

    }
    while (!result);
    quantity = Integer.parseInt(quantitystr);
    int checkdate;
    do {
      v1.getdatefromuser();
      udate = sc.nextLine();
      checkdate = isDateValid2(udate);

      if (checkdate == 1) {
        v1.displayinvaliddateweekend();
      } else if (checkdate == 2) {
        v1.displayinvaliddatefuture();

      } else if (checkdate == 3) {
        v1.displayinvailiddate();
      } else if (checkdate == 4) {
        v1.displayinvailiddate();
      }
    }
    while (checkdate != 0);

    String price = m1.getstockprice(udate, stockname);

    Stock news = new Stock(stockname, price, udate, "0");

    m1.addstockflexible(quantity, ssn, news);

    v1.successaddedstock();

    get = sc.nextLine().toLowerCase();
    t = get.equals("yes");
    return t;
  }

  public int isDateValid2(String udate) {
    return m1.checkdatevalidity(udate);

  }

  private int flexinflexmenu() {

    v1.displayflexinflexmenu();

    Scanner sc = new Scanner(input);

    String str = sc.nextLine();
    if (str.length() > 1) {
      str = "3";
    }
    char ch = str.charAt(0);
    return Character.getNumericValue(ch);

  }

  private void createportfolio(String ssn, Set<String> stockset) {

    int choice = flexinflexmenu();

    switch (choice) {
      case 1:
        portfoliocreationflexible(ssn, stockset);
        break;

      case 2:
        portfoliocreationinflexible(ssn, stockset);
        break;

      default:

    }


  }


  ///need to add addportcount for create using file? check it

  private void portfoliocreationinflexible(String ssn, Set<String> stockset) {
    Scanner sc = new Scanner(System.in);

    v1.displayportfoliochoice();
    int portfoliochoice = sc.nextInt();
    boolean t;
    sc.nextLine();

    if (portfoliochoice == 2) {
      do {
        t = createportfoliousingsetinflexible(ssn, stockset);
      }
      while (t);
      v1.displaysuccportmessage();
      m1.addportfoliocount(ssn);

    } else if (portfoliochoice == 1) {
      try {
        storedatausingfile2(ssn, stockset);
      } catch (Exception e) {
        v1.displayfilenotexist();
      }

    }

  }
  ///need to add addportcount for create using file? check it

  private void portfoliocreationflexible(String ssn, Set<String> stockset) {

    Scanner sc = new Scanner(input);

    v1.displayportfoliochoicecreation();
    int portfoliochoice = sc.nextInt();
    boolean t;
    sc.nextLine();

    if (portfoliochoice == 2) {
      do {
        t = createportfoliousingsetflexible(ssn, stockset);
      }
      while (t);
      v1.displaysuccportmessage();
      m1.addportfoliocountflexible(ssn);

    } else if (portfoliochoice == 1) {
      try {
        storedatausingfile2flexible(ssn, stockset);
      } catch (Exception e) {
        v1.displayfilenotexist();
      }

    } else if (portfoliochoice == 3) {

      createportfolioinvestment(ssn);
    } else if (portfoliochoice == 4) {

      investment2(ssn, true);
    }

  }


  private void createportfolioinvestment(String ssn) {

    Scanner sc = new Scanner(System.in);
    String investamount = "";
    String investmentdate = "";
    String stockname = " ";
    String investmentamount = " ";


    ArrayList<String> sharepercent = new ArrayList<>();

    Map<String, String[]> portfolio = new HashMap<>();

    v1.getdatefromuser();
    do {
      investmentdate = sc.nextLine();
      investmentdate = m1.isDateValid4(investmentdate);
      if (investmentdate.equals("1")) {
        v1.displayinvailiddate();
      }
    }
    while (investmentdate.equals("1"));

    v1.getinvestamount();
    boolean checkamt;
    do {
      investamount = sc.nextLine();
      checkamt = m1.validateinvestmentamount(investamount);
      if (!checkamt) {
        v1.displayquantitymessage();
      }

    }
    while (!checkamt);
    String check;
    do {
      String[] allcontent = new String[3];
      v1.getstockfromuser();
      stockname = sc.nextLine();
      String price = m1.getstockprice(investmentdate, stockname);

      // Stock news = new Stock(stockname, price, investmentdate, "0");
      //m1.addstockflexible(0, ssn, news);

      allcontent[0] = "0";
      allcontent[1] = price;
      allcontent[2] = investmentdate;

      portfolio.put(stockname, allcontent);

      v1.successaddedstock();

      check = sc.nextLine();
      check = check.toLowerCase();

    }
    while (check.equals("yes"));


    int displayport = m1.displayportfolionumbersflexible(ssn);

    sharepercent = validatesharepercentage(portfolio, sharepercent);

    m1.investmentstrategy1(ssn, displayport, investamount, investmentdate, sharepercent, portfolio);
    m1.addportfoliocountflexible(ssn);

    v1.displaysuccportmessage();

  }


  private void viewportfolio(String ssn) {

    int choice = flexinflexmenu();

    switch (choice) {
      case 1:
        displayportfolioflexible(ssn);
        break;

      case 2:
        displayportfolio(ssn);
        break;

      default:

    }

  }

  private void displayportfolio(String ssn) {

    int pcount = m1.displayportfolionumbers(ssn);
    if (pcount == 1) {
      v1.noportfoliomessage();

    } else {
      viewportfolio2(ssn);
    }

  }

  private void displayportfolioflexible(String ssn) {

    int pcount = m1.displayportfolionumbersflexible(ssn);

    if (pcount == 1) {
      v1.noportfoliomessage();

    } else {
      viewportfolio2flexible(ssn);
    }

  }


  private void viewportfolio2(String ssn) {
    Scanner sc = new Scanner(System.in);
    boolean checkportoliopresent;
    int displayport = 0;

    int portfoliocount = m1.displayportfolionumbers(ssn);

    v1.displayportfoliomenu(portfoliocount);

    do {
      displayport = sc.nextInt();
      checkportoliopresent = m1.checkportnum(displayport, ssn);
      if (!checkportoliopresent) {
        v1.displayinvalidportfolionumbermessage();
      }
    }
    while (!checkportoliopresent);

    v1.displayportfolioheader();

    Map<String, String[]> portfolio = m1.displayportfoliodetails(ssn, displayport);

    v1.displayportfolio2(portfolio);

  }

  private void viewportfolio2flexible(String ssn) {

    Scanner sc = new Scanner(System.in);

    boolean checkportoliopresent;
    int displayport = 0;
    String displaydate = "";

    int portfoliocount = m1.displayportfolionumbersflexible(ssn);

    v1.displayportfoliomenu(portfoliocount);

    do {
      displayport = sc.nextInt();
      checkportoliopresent = m1.checkportnumflexible(displayport, ssn);
      if (!checkportoliopresent) {
        v1.displayinvalidportfolionumbermessage();
      }
    }
    while (!checkportoliopresent);

    sc.nextLine();
    int checkd;
    do {
      v1.getdatefromuser();
      displaydate = sc.nextLine();
      checkd = isDateValid2(displaydate);
      if (checkd == 1) {
        checkd = 0;
      }

    }
    while (checkd != 0);

    v1.displayportfolioheader();

    Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
            ssn, displayport, displaydate);
    if (portfolio.size() == 0) {
      v1.noportfoliomessage();
    } else {
      v1.displayportfolio2(portfolio);
    }

  }


  private void calculateworth(String ssn) {
    int choice = flexinflexmenu();
    switch (choice) {
      case 1:
        worthofportfolioflexible(ssn);
        break;

      case 2:
        worthofportfolio(ssn);
        break;

      default:
        v1.displayinvalidmessage();
        break;
    }

  }

  private void worthofportfolio(String ssn) {

    Scanner sc = new Scanner(System.in);
    String date;
    int checkdate;

    int pcount = m1.displayportfolionumbers(ssn);
    if (pcount == 1) {
      v1.noportfoliomessage();
    } else {
      boolean checkportoliopresent;
      int displayport = 0;

      int portfoliocount = m1.displayportfolionumbers(ssn);

      v1.displayportfoliomenu(portfoliocount);

      do {
        displayport = sc.nextInt();
        sc.nextLine();
        checkportoliopresent = m1.checkportnum(displayport, ssn);
        if (!checkportoliopresent) {
          v1.displayinvalidportfolionumbermessage();
        }
      }
      while (!checkportoliopresent);

      do {
        v1.getdatefromuser();
        date = sc.nextLine();
        checkdate = isDateValid2(date);

        if (checkdate == 1) {
          v1.displayinvaliddateweekend();
        } else if (checkdate == 2) {
          v1.displayinvaliddatefuture();

        } else if (checkdate == 3) {
          v1.displayinvailiddate();
        } else if (checkdate == 4) {
          v1.displayinvailiddate();
        }
      }
      while (checkdate != 0);


      Map<String, String[]> portfolio = m1.getconsolidatedmap(ssn, displayport, date);


      double amount = m1.calculateflexiableportfolio(portfolio, date);
      if (amount > 0.0) {
        v1.displayportfolioheader();
        v1.displayportfolio2(portfolio);
        amount = Double.valueOf(Math.round(amount * 100) / 100);
        v1.printcurrentvalue(amount);
      } else {
        v1.nostockboughtmessage();
      }

    }

  }


  private void worthofportfolioflexible(String ssn) {

    Scanner sc = new Scanner(System.in);
    String date;
    int checkdate;

    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.noportfoliomessage();
    } else {
      boolean checkportoliopresent;
      int displayport = 0;

      int portfoliocount = m1.displayportfolionumbersflexible(ssn);

      v1.displayportfoliomenu(portfoliocount);

      do {
        displayport = sc.nextInt();
        sc.nextLine();
        checkportoliopresent = m1.checkportnumflexible(displayport, ssn);
        if (!checkportoliopresent) {
          v1.displayinvalidportfolionumbermessage();
        }
      }
      while (!checkportoliopresent);

      do {
        v1.getdatefromuser();
        date = sc.nextLine();
        checkdate = isDateValid2(date);

        if (checkdate == 1) {
          v1.displayinvaliddateweekend();
        } else if (checkdate == 2) {
          v1.displayinvaliddatefuture();

        } else if (checkdate == 3) {
          v1.displayinvailiddate();
        } else if (checkdate == 4) {
          v1.displayinvailiddate();
        }
      }
      while (checkdate != 0);


      Map<String, String[]> portfolio = m1.getconsolidatedmapflexible(ssn, displayport, date);


      double amount = m1.calculateflexiableportfolio(portfolio, date);
      if (amount > 0.0) {
        amount = Double.valueOf(Math.round(amount * 100) / 100);
        v1.displayportfolioheader();
        v1.displayportfolio2(portfolio);
        v1.printcurrentvalue(amount);
      } else {
        v1.nostockboughtmessage();
        v1.printcurrentvalue(amount);
      }

    }

  }

  private void buystocks(String ssn, Set<String> stocks) {

    int portfoliocount = m1.displayportfolionumbersflexible(ssn);

    boolean checkportoliopresent;
    int displayport = 0;
    Scanner sc = new Scanner(System.in);
    String stockname;
    String stockquantity;
    String stockdate;
    boolean isquantity;
    boolean isdate;
    boolean ispresent;
    String stockprice;


    if (portfoliocount == 1) {
      v1.noflexportfolio();
      return;
    } else {
      v1.displayportfoliomenu(portfoliocount);

      do {
        displayport = sc.nextInt();
        checkportoliopresent = m1.checkportnumflexible(displayport, ssn);
        if (!checkportoliopresent) {
          v1.displayinvalidportfolionumbermessage();
        }
      }
      while (!checkportoliopresent);

    }
    sc.nextLine();

    Map<String, String[]> portfolio = m1.displayportfoliodetailsflexible(ssn, displayport);
    v1.displayportfolioheader();
    v1.displayportfolio2(portfolio);

    do {

      v1.addstockmessage();
      stockname = sc.nextLine();
      stockname = stockname.toUpperCase();
      ispresent = stocks.contains(stockname);

      if (!ispresent) {
        v1.invalidstockname();
      }

    }
    while (!ispresent);

    boolean qtpresent = true;

    do {

      v1.getmoresharemessage();
      stockquantity = sc.nextLine();

      if (stockquantity.contains(".")) {
        v1.displayquantitymessage();
      } else if (Integer.parseInt(stockquantity) <= 0) {
        v1.displayquantitymessage();
      } else {
        qtpresent = false;
      }

    }
    while (qtpresent);

    int checkdate;

    do {

      v1.getaddeddate();
      stockdate = sc.nextLine();
      checkdate = isDateValid2(stockdate);

      if (checkdate == 1) {
        v1.displayinvaliddateweekend();
      } else if (checkdate == 2) {
        v1.displayinvaliddatefuture();

      } else if (checkdate == 3) {
        v1.displayinvailiddate();
      }
    }
    while (checkdate != 0);

    stockname = stockname.toUpperCase();

    stockprice = m1.getpricecertaindate(stockdate, stockname);

    m1.addstockstoportfolioflexible(ssn, stockname, Integer.parseInt(stockquantity),
            stockdate, stockprice, displayport);

    v1.displaysuccessbuy();


  }


  private void sellstocks(String ssn, Set<String> stocks)
  {
    int displayport = 0;
    boolean checkportoliopresent;
    String sellquantity = "";
    String stockname;
    String saledate;
    boolean checkdate;


    Scanner sc = new Scanner(System.in);


    int portfoliocount = m1.displayportfolionumbersflexible(ssn);

    if (portfoliocount == 1) {
      v1.noflexportfolio();
      return;
    } else {

      v1.displayportfoliomenu(portfoliocount);

      do {
        displayport = sc.nextInt();
        checkportoliopresent = m1.checkportnumflexible(displayport, ssn);
        if (!checkportoliopresent) {
          v1.displayinvalidportfolionumbermessage();
        }
      }
      while (!checkportoliopresent);

    }

    sc.nextLine();

    v1.displaysellstockmessage();

    Map<String, String[]> portfolio = m1.displayportfoliodetailsflexible(ssn, displayport);
    //Map<String, String[]> portfolio1 = m1.displayportfoliodetailsflexibledatefilter(ssn,displayport,saledate);


    v1.displayportfolio2(portfolio);


    boolean stpresent = true;
    boolean qtpresent = true;
    do {

      v1.sellstock();
      stockname = sc.nextLine().toUpperCase();

      if (!portfolio.containsKey(stockname)) {
        v1.invalidnameselling();
      } else {
        if (Double.parseDouble(portfolio.get(stockname)[0]) == 0) {
          v1.stockquantityzero();
        } else {
          stpresent = false;
        }
      }

    }
    while (stpresent);


    do {
      v1.sellshares();
      sellquantity = sc.nextLine();
      if (sellquantity.contains(".")) {
        v1.displayquantitymessage();
      }
      else if (Double.parseDouble(sellquantity) > Double.parseDouble(portfolio.get(stockname)[0]))
      {
        v1.errorsellshares();
      }
      else if (Integer.parseInt(sellquantity) <= 0)
      {
        v1.displayquantitymessage();
      } else {
        qtpresent = false;
      }

    }
    while (qtpresent);

    v1.selldate();
    do {
      saledate = sc.nextLine();
      Map<String, String[]> portfolio1 = m1.displayportfoliodetailsflexibledatefilter(ssn,displayport,saledate);
      for (Map.Entry<String, String[]> entry : portfolio1.entrySet()) {

        System.out.println(entry.getKey() + "   "
                +
                entry.getValue()[0]
                + "      " + entry.getValue()[1]  + "      " + entry.getValue()[2]);

      }
      checkdate = m1.checkselldate(stockname, saledate, portfolio1, sellquantity);

      if (!checkdate) {
        v1.invaliddateselling();
      }
    }
    while (!checkdate);


    String sellprice = m1.getpricecertaindate(saledate, stockname);

    m1.sellstocksflexible(ssn, stockname, sellquantity, displayport, saledate, sellprice);

    v1.successsoldstock();

  }


  private void costbasis(String ssn) {

    calculatecostbasisflexible(ssn);

  }

  private void calculatecostbasisflexible(String ssn) {
    String date;
    int comissionrate;

    Scanner sc = new Scanner(System.in);

    int pcount = m1.displayportfolionumbersflexible(ssn);
    if (pcount == 1) {
      v1.noportfoliomessage();
    } else {
      boolean checkportoliopresent;
      int displayport = 0;

      int portfoliocount = m1.displayportfolionumbersflexible(ssn);

      v1.displayportfoliomenu(portfoliocount);

      do {
        displayport = sc.nextInt();
        sc.nextLine();
        checkportoliopresent = m1.checkportnumflexible(displayport, ssn);
        if (!checkportoliopresent) {
          v1.displayinvalidportfolionumbermessage();
        }
      }
      while (!checkportoliopresent);

      v1.displayportfolioheader();

      Map<String, String[]> portfolio = m1.displayportfoliodetailsflexible(ssn, displayport);

      v1.displayportfolio2(portfolio);

      v1.getcommission();

      do {
        comissionrate = sc.nextInt();
        if (comissionrate <= 0) {
          v1.displaycommissionerrormessage();
        }
      }
      while (comissionrate < 0);
      sc.nextLine();

      int checkdate;

      do {
        v1.getdatefromuser();
        date = sc.nextLine();
        checkdate = isDateValid2(date);
        if (checkdate == 1) {
          checkdate = 0;
        }
        if (checkdate == 2) {
          v1.displayinvaliddatefuture();
        } else if (checkdate == 3) {
          v1.displayinvailiddate();
        } else if (checkdate == 4) {
          v1.displayinvailiddate();
        }
      }
      while (checkdate != 0);

      Double cbf = m1.calculatecostbasisflexible(ssn, displayport, date, comissionrate);

      v1.printcostbasis(cbf);

    }
  }

  private void storedatausingfile2(String ssn, Set<String> stocks) throws IOException {
    Scanner sc = new Scanner(System.in);
    String filepath = "";
    v1.getfilepathfromuser();
    filepath = sc.nextLine();

    File tmpDir = new File(filepath);
    boolean exists = tmpDir.exists();

    if (exists) {

      if (tmpDir.length() == 0) {
        v1.displayvalidfilemessage();

      } else {
        boolean checkvalidstocks = m1.checkvalidstockname(filepath, stocks);

        if (checkvalidstocks) {
          m1.createportfoliousingfile(ssn, filepath);
          m1.addportfoliocount(ssn);
          v1.displayfileloaddeduscc();
        } else {
          v1.displayinvalidstockname();
        }
      }

    } else {
      v1.displayfilenotexist();
    }

  }

  private void storedatausingfile2flexible(String ssn, Set<String> stocks) throws IOException {
    Scanner sc = new Scanner(System.in);
    String filepath = "";
    v1.getfilepathfromuser();
    filepath = sc.nextLine();

    File tmpDir = new File(filepath);
    boolean exists = tmpDir.exists();

    if (exists) {

      if (tmpDir.length() == 0) {
        v1.displayvalidfilemessage();

      } else {
        boolean checkvalidstocks = m1.checkvalidstockname(filepath, stocks);

        if (checkvalidstocks) {
          m1.createportfoliousingfileflexible(ssn, filepath);
          m1.addportfoliocountflexible(ssn);
          v1.displayfileloaddeduscc();
        } else {
          v1.displayinvalidstockname();
        }
      }

    } else {
      v1.displayfilenotexist();
    }

  }


  private void performance(String ssn) {
    Scanner sc = new Scanner(System.in);
    String bdate;
    String edate;

    int displayport = getportfolionumber(ssn);

    if (displayport < 0) {
      return;
    } else {

      v1.performancemenu();
      bdate = sc.nextLine();

      v1.endingdateget();
      edate = sc.nextLine();

      v1.displaywaitmessage();

      Map<String, String> mp = m1.calculateperformanceflexible(bdate, edate, ssn, displayport);
      Double minprice = m1.getminval(mp);
      v1.displayperformance(mp, minprice, bdate, edate);
    }

  }

  private String isDateValid3(String date) {

    if(date.length() != 10){
      return "1";
    }

    final String dateformat = "yyyy-MM-dd";

    Stockapinterface sp = new Stockapi();

    String finaldate = date;

    do {

      try {

        DateFormat df = new SimpleDateFormat(dateformat);
        df.setLenient(false);
        df.parse(finaldate);
        Date enteredDate = df.parse(finaldate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(enteredDate);

        int day = cal.get(Calendar.DAY_OF_WEEK);

        if (day == Calendar.SATURDAY) {
          finaldate = LocalDate.parse(date).plusDays(2).toString();
        } else if (day == Calendar.SUNDAY) {
          finaldate = LocalDate.parse(date).plusDays(1).toString();

        } else if (sp.getstockprice(finaldate, "AMZN").equals("")) {

          finaldate = LocalDate.parse(date).plusDays(1).toString();

          Date futuredate = df.parse(finaldate);
          if (futuredate.after(new Date())) {
            return "2";
          }

        } else if (finaldate.length() != 10) {
          return "1";
        } else if (enteredDate.after(new Date())) {
          return "1";
        }

      } catch (ParseException e) {
        return "1";
      }
    }
    while (sp.getstockprice(finaldate, "AMZN").equals(""));

    return finaldate;

  }


  private void investment1(String ssn) {
    Scanner sc = new Scanner(System.in);

    String investamount = "";
    String investmentdate = "";

    ArrayList<String> sharepercent = new ArrayList<>();

    int displayport = getportfolionumber(ssn);

    v1.getinvestamount();

    boolean checkamt;
    do {
      investamount = sc.nextLine();
      checkamt = m1.validateinvestmentamount(investamount);
      if (!checkamt) {
        v1.displayquantitymessage();
      }

    }
    while (!checkamt);

    investmentdate = helperinvestmentdate(investmentdate);
    v1.displayportfolioheader();
    Map<String, String[]> portfolio = m1.displayportfoliodetailsflexibledatefilter(
            ssn, displayport, investmentdate);
    v1.displayportfolio2(portfolio);

    sharepercent = validatesharepercentage(portfolio, sharepercent);

    m1.investmentstrategy1(ssn, displayport, investamount, investmentdate, sharepercent, portfolio);

    v1.succinvest();


  }

  private int getportfolionumber(String ssn) {
    Scanner sc = new Scanner(System.in);

    int displayport = 0;
    boolean checkportoliopresent;

    int pcount = m1.displayportfolionumbersflexible(ssn);

    if (pcount == 1) {
      v1.noportfoliomessage();
      return -1;
    }

    v1.displayportfoliomenuforperformance(pcount);

    do {
      displayport = sc.nextInt();
      checkportoliopresent = m1.checkportnumflexible(displayport, ssn);
      if (!checkportoliopresent) {
        v1.displayinvalidportfolionumbermessage();
      }
    }
    while (!checkportoliopresent);

    sc.nextLine();
    return displayport;

  }


  private String helperinvestmentdate(String investmentdate) {

    boolean checkdate;
    Scanner sc = new Scanner(System.in);


    do {
      v1.getdatefromuser();
      investmentdate = sc.nextLine();
      investmentdate = isDateValid3(investmentdate);

      if (investmentdate.equals("1")) {
        v1.invaliddateselling();
        checkdate = false;
      } else if (investmentdate.equals("2")) {
        v1.holidayandfuture();
        checkdate = false;
      } else {
        checkdate = true;
      }


    }
    while (!checkdate);

    return investmentdate;
  }


  private ArrayList<String> validatesharepercentage(Map<String, String[]> portfolio,
                                                    ArrayList<String> sharepercent) {
    int iteration = 0;
    int sum = 0;

    boolean checkpercent = true;
    Scanner sc = new Scanner(System.in);

    for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {

      iteration++;

      String percent;

      do {

        v1.getpercentage(entry.getKey());
        percent = sc.nextLine();

        if (iteration == portfolio.size()) {
          if (Integer.parseInt(percent) + sum != 100) {
            v1.invalidpercentage();
            checkpercent = false;
          } else {
            checkpercent = true;
          }
        } else if (Integer.parseInt(percent) > 100 || Integer.parseInt(percent) <= 0
                || Integer.parseInt(percent) + sum > 100) {
          v1.invalidpercentage();
          checkpercent = false;
        } else {
          sum += Integer.parseInt(percent);
          checkpercent = true;
        }

      }
      while (!checkpercent);


      sharepercent.add(percent);

    }

    return sharepercent;

  }

  private void investment2(String ssn, boolean f) {
    Map<String, String[]> portfolio = new HashMap<>();
    Stockapinterface sp = new Stockapi();
    Scanner sc = new Scanner(System.in);
    int check1 = 0;
    int check2 = 0;

    String investamount = " ";
    String investmentsdate = " ";
    String investmentedate = " ";
    String choice = " ";

    ArrayList<String> sharepercent = new ArrayList<>();
    int displayport;
    v1.getinvestamount();

    //investamount = validateinvestmentamount(investamount);
    boolean checkamt;
    do {
      investamount = sc.nextLine();
      checkamt = m1.validateinvestmentamount(investamount);
      if (!checkamt) {
        v1.displayquantitymessage();
      }

    }
    while (!checkamt);

    do {
      v1.getstartdate();
      investmentsdate = sc.nextLine();
      investmentsdate = m1.isDateValid4(investmentsdate);
      if (investmentsdate.equals("1")) {
        v1.displayinvailiddate();
      }
    }
    while (investmentsdate.equals("1"));
    if (investmentsdate.equals("6")) {
      check1++;
    }


    String stockname;
    if (f) {
      displayport = m1.displayportfolionumbersflexible(ssn);

      String check;
      do {

        String[] allcontent = new String[3];
        v1.getstockfromuser();
        stockname = sc.nextLine();
        String price = m1.getstockprice(investmentsdate, stockname);
        // Stock news = new Stock(stockname, price, investmentdate, "0");
        //m1.addstockflexible(0, ssn, news);
        allcontent[0] = "0";
        allcontent[1] = price;
        allcontent[2] = investmentsdate;
        portfolio.put(stockname, allcontent);

        v1.successaddedstock();
        check = sc.nextLine();
        check = check.toLowerCase();

      }
      while (check.equals("yes"));


    } else {
      displayport = getportfolionumber(ssn);
      portfolio = m1.displayportfoliodetailsflexibledatefilter(
              ssn, displayport, investmentsdate);
    }


    v1.getenddate();
    String s = sc.nextLine();
    s = s.toLowerCase();
    if (s.equals("yes")) {
      v1.endingdateget();
      do {
        investmentedate = sc.nextLine();

        investmentedate = m1.isDateValid4(investmentedate);
        if (investmentedate.equals("1")) {
          v1.invaliddateselling();
        }
      }
      while (investmentedate.equals("1"));

      if (investmentedate.equals("6")) {
        check2++;
        investmentedate = LocalDate.now().toString(); // assign it to current date
        System.out.println(investmentedate);
        do {
          //investmentedate = m1.isDateValid4(investmentedate);//
          investmentedate = LocalDate.parse(investmentedate).minusDays(1).toString();

        }
        while (sp.getstockprice(investmentedate, "AMZN").equals(""));// need to validate this date.

        System.out.println(investmentedate);

      }

    } else {

      investmentedate = LocalDate.now().toString(); // assign it to current date
      //
      do {
        //investmentedate = m1.isDateValid4(investmentedate);//
        investmentedate = LocalDate.parse(investmentedate).minusDays(1).toString();

      }
      while (sp.getstockprice(investmentedate, "AMZN").equals(""));
    }

    if (check1 == 1 && check2 == 1) {
      v1.investfuture();

    } else {

      v1.timerangemenu();
      choice = sc.nextLine();
      // validate choice
      v1.displayportfolioheader();
      if (portfolio.size() == 0) {
        v1.noportfoliorange();
        return;
      }
      v1.displayportfolio2(portfolio);

      sharepercent = validatesharepercentage(portfolio, sharepercent);

      m1.investmentstrategy2(ssn, displayport, investamount, investmentsdate,
              investmentedate, sharepercent, portfolio, choice);

      if (f) {
        m1.addportfoliocountflexible(ssn);
      }


      if (check2 == 1) {
        v1.investfuture();
      } else {
        v1.succinvest();
      }

    }

  }

}

