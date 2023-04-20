package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * mainmodel class
 * implements
 * mainmodelinterface
 * and contains all
 * methods definations
 * which model should have.
 */
public class Mainmodel implements Mainmodelinterface {
  Clientinterface s = new Client();
  Clientflexibleinterface sf = new Clientflexible();
  Stockinterface st = new Stock("0", "0", "0", "0");

  Investmentplansinterface ip = new Investmentplans();

  Stockapinterface sapi = new Stockapi();


  @Override
  public String isDateValid4(String date) {
    return sf.date4help(date);
  }


  @Override
  public boolean checkuserpresent(String ssn) throws IOException {
    boolean check = s.checkuser(ssn);
    return check;

  }

  @Override
  public void createuser(String name, String ssn) throws IOException {
    s.createnewclient(name, ssn);
  }

  @Override
  public void addstock(int quantity, String ssn, Stock newstock) {
    s.addstocktoclient(quantity, ssn, newstock);

  }

  @Override
  public void addstockflexible(int quantity, String ssn, Stock newstock) {

    sf.addstocktoclientflexible(quantity, ssn, newstock);
  }

  @Override
  public void addportfoliocount(String ssn) {
    s.addportcount(ssn);
  }

  @Override
  public void addportfoliocountflexible(String ssn) {
    sf.addportcountflexible(ssn);
  }


  @Override
  public int displayportfolionumbers(String ssn) {
    return s.getportfoliocount(ssn);
  }

  @Override
  public int displayportfolionumbersflexible(String ssn) {
    return sf.getportfoliocountflexible(ssn);
  }

  @Override
  public Map<String, String[]> displayportfoliodetails(String ssn, int portfolionumber) {
    return s.getportfolioinfo(ssn, portfolionumber);
  }

  @Override
  public Map<String, String[]> displayportfoliodetailsflexible(String ssn, int portfolionumber) {
    return sf.getportfolioinfoflexible(ssn, portfolionumber);
  }

  @Override
  public Map<String, String[]> displayportfoliodetailsflexibledatefilter(
          String ssn, int portfolionumber, String displaydate) {
    return sf.getportfolioinfoflexibledatefilter(ssn, portfolionumber, displaydate);
  }

  @Override
  public boolean validatequantity(String quantitiy) {
    return s.validateq(quantitiy);
  }

  @Override
  public boolean checkportnum(int portnum, String ssn) {
    return s.checkpnum(portnum, ssn);

  }

  @Override
  public boolean checkportnumflexible(int portnum, String ssn) {
    return sf.checkpnumflexible(portnum, ssn);

  }

  @Override
  public void createportfoliousingfile(String ssn, String pathname) throws IOException {
    s.portfoliousingfile(ssn, pathname);
  }

  @Override
  public void createportfoliousingfileflexible(String ssn, String pathname) throws IOException {
    sf.portfoliousingfileflexible(ssn, pathname);
  }

  @Override
  public boolean checkvalidstockname(String filepath, Set<String> stocks) {
    return s.checkvalidstocks(filepath, stocks);
  }

  @Override
  public void fetchdatafromapi() {
    WritetoFileStock obj = new WritetoFileStock();
    try {
      obj.fetchdatafromapi();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  @Override
  public int checkfordate(String date, Map<String, String[]> portfolio) {
    return st.checkvaliddate(date, portfolio);
  }

  public Set<String> initializeset() throws IOException {
    return st.putdataintoset();
  }

  public String getstockprice(String udate, String stockname) {
    return s.getprice(udate, stockname);
  }

  public int checkdatevalidity(String d) {
    return st.checkvaliddate2(d);
  }

  public void addstockstoportfolioflexible(String ssn, String stockname, int quantity,
                                           String date, String price, int displayport) {
    sf.editportfolio(ssn, stockname, quantity, date, price, displayport);
  }

  public String getpricecertaindate(String date, String stockname) {
    return sapi.getstockprice(date, stockname);
  }

  public void sellstocksflexible(String ssn, String stockname, String quantity,
                                 int portfolionumber, String selldate, String sellprice) {
    sf.sellstocksfromportfolio(ssn, stockname, quantity, portfolionumber, selldate, sellprice);

  }

  public Double calculatecostbasisflexible(String ssn, int displayport,
                                           String date, int comissionrate) {
    return sf.computecostbasis(ssn, displayport, date, comissionrate);
  }

  public boolean checkselldate(String stockname, String date, Map<String, String[]> portfolio,String quantity) {
    return s.checkvalidselldate(stockname, date, portfolio,quantity);

  }

  public float calculateflexiableportfolio(Map<String, String[]> portfolio, String date) {
    return s.getworthstocks(date, portfolio);
  }

  public Map<String, String[]> getconsolidatedmap(String ssn, int displayport, String worthdate) {
    return s.getworthmap(ssn, displayport, worthdate);
  }

  public Map<String, String[]> getconsolidatedmapflexible(String ssn,
                                                          int displayport, String worthdate) {
    return sf.getworthmapflexible(ssn, displayport, worthdate);
  }


  public Map<String, String> calculateperformanceflexible(String bdate, String endate,
                                                          String ssn, int portfolionumber) {
    return sf.displayperformancebar(bdate, endate, ssn, portfolionumber);
  }

  public Double getminval(Map<String, String> m) {
    return s.findmin(m);

  }

  @Override
  public void investmentstrategy1(String ssn, int displayport, String investamount,
                                  String investmentdate, ArrayList<String> sharepercent,
                                  Map<String, String[]> portfolio) {

    ip.investportfoliostrategy1(ssn, displayport, investamount,
            investmentdate, sharepercent, portfolio);
  }


  @Override
  public void investmentstrategy2(String ssn, int displayport, String investamount,
                                  String investmentsdate, String investmentedate,
                                  ArrayList<String> sharepercent, Map<String, String[]> portfolio,
                                  String choice) {

    ip.investportfoliostrategy2(ssn, displayport, investamount,
            investmentsdate, investmentedate,
            sharepercent, portfolio, choice);
  }

  @Override
  public String[] createstockforivestmentst1(String date, String price) {
    return sf.createstockforinvestment(date, price);
  }

  @Override
  public boolean validateinvestmentamount(String amt) {
    return sf.validateamt(amt);
  }

  @Override
  public int checksellqty(String qu, Map<String, String[]> portfolio, String stockname) {

    return sf.validateqty(qu, portfolio, stockname);
  }

  @Override
  public boolean checkstartenddate(String sdate, String edate) {
    return sf.comparedate(sdate, edate);

  }

  @Override
  public String getbeforecurr() {
    return sf.getbeforecurr();
  }

  @Override
  public boolean validpercentage(String p) {
    return sf.valperc(p);
  }

  @Override
  public boolean checktotalpercentage(ArrayList<String> totalsharepercentage) {
    Double total = 0.0;
    for (int i = 0; i < totalsharepercentage.size(); i++) {
      total = total + Double.parseDouble(totalsharepercentage.get(i));
    }

    return total == 100.00;
  }


}
