package controller;

/*
 * This is a test class for performing unit tests on Maincontroller class.
 */

/*
public class MaincontrollerTest {


  @Test
  public void test1() {
    StringBuilder log = new StringBuilder();
    Reader in = new StringReader("767\n8\n");


    Mainmodelinterface m1 = new Loggingmodel(log);
    Mainviewinterface v1 = new Mainview(System.out);

    Maincontrollerinterface c = new Maincontroller(m1, v1, in);

    try {
      c.mainfun();
    } catch (Exception e) {
      System.out.println("file not found!");
    }

    assertEquals("767", log.toString());

  }

  @Test
  public void test2() {

    StringBuilder log = new StringBuilder();
    Reader in = new StringReader("767\n1\n1\n2\ngoog\n2\n2022-11-11\nno\n8\n");


    Mainmodelinterface m1 = new Loggingmodel1(log);
    Mainviewinterface v1 = new Mainview(System.out);

    Maincontrollerinterface c = new Maincontroller(m1, v1, in);

    try {
      c.mainfun();
    } catch (Exception e) {
      System.out.println("file not found!");
    }

    assertEquals("goog2022-07-11", log.toString());

  }


  class Loggingmodel implements Mainmodelinterface {

    private final StringBuilder log;

    public Loggingmodel(StringBuilder log) {
      this.log = log;
    }

    @Override
    public boolean checkuserpresent(String ssn) throws IOException {

      log.append(ssn);
      return false;

    }

    @Override
    public void createuser(String name, String ssn) throws IOException {
      //creating user.
    }

    @Override
    public void addstock(int quantity, String ssn, Stock newstock) {
      //adding stock to user.
    }

    @Override
    public void addstockflexible(int quantity, String ssn, Stock newstock) {
      //adding stock to flexible.
    }

    @Override
    public void addportfoliocount(String ssn) {
      //adding portfolio count.
    }

    @Override
    public void addportfoliocountflexible(String ssn) {
      //adding flexible portfolio count.
    }


    @Override
    public int displayportfolionumbers(String ssn) {
      return 0;
    }

    @Override
    public int displayportfolionumbersflexible(String ssn) {
      return 0;
    }


    @Override
    public Map<String, String[]> displayportfoliodetails(
            String ssn, int portfolionumber) {
      return null;
    }

    @Override
    public Map<String, String[]> displayportfoliodetailsflexible(
            String ssn, int portfolionumber) {
      return null;
    }

    @Override
    public Map<String, String[]> displayportfoliodetailsflexibledatefilter(

            String ssn, int portfolionumber, String displaydate) {
      return null;
    }

    @Override
    public boolean validatequantity(String quantitiy) {
      return false;
    }

    @Override
    public boolean checkportnum(int portnum, String ssn) {
      return false;
    }

    @Override
    public boolean checkportnumflexible(int portnum, String ssn) {
      return false;
    }

    @Override
    public void createportfoliousingfile(
            String ssn, String pathname) throws IOException {
      // create inflexible portfolio using file.
    }

    @Override
    public void createportfoliousingfileflexible(
            String ssn, String pathname) throws IOException {
      // create flexible portfolio using file.
    }

    @Override
    public boolean checkvalidstockname(
            String filepath, Set<String> stocks) {
      return false;
    }

    @Override
    public void fetchdatafromapi() {
      // fetch data from api.
    }

    @Override
    public int checkfordate(String date, Map<String, String[]> portfolio) {
      return 0;
    }

    @Override
    public String getstockprice(String udate, String stockname) {

      return null;
    }

    @Override
    public Set<String> initializeset() throws IOException {
      return null;
    }

    @Override
    public int checkdatevalidity(String udate) {
      return 0;
    }

    @Override
    public void addstockstoportfolioflexible(
            String ssn, String stockname,
            int quantity, String date, String price, int displayport) {
      // add stock to portfolio

    }

    @Override
    public String getpricecertaindate(String date, String stockname) {
      return null;
    }


    @Override
    public void sellstocksflexible(
            String ssn, String stockname, String qantity,
            int portfolionumber, String selldate, String sellprice) {

      //sell stocks from flexible portfolio.
    }

    @Override
    public boolean checkselldate(

            String stockname, String date, Map<String, String[]> portfolio) {
      return false;
    }

    @Override
    public float calculateflexiableportfolio(
            Map<String, String[]> portfolio, String date) {
      return 0;
    }

    @Override
    public Map<String, String[]> getconsolidatedmap(
            String ssn, int displayport, String worthdate) {
      return null;
    }

    @Override
    public Map<String, String[]> getconsolidatedmapflexible(
            String ssn, int displayport, String worthdate) {
      return null;
    }

    @Override
    public Double calculatecostbasisflexible(
            String ssn, int displayport, String date, int comissionrate) {
      return null;
    }

    @Override
    public Map<String, String> calculateperformanceflexible(
            String bdate, String endate,
            String ssn, int portfolionumber) {
      return null;
    }

    @Override
    public Double getminval(Map<String, String> m) {
      return null;
    }

  }

  class Loggingmodel1 implements Mainmodelinterface {

    private final StringBuilder log;

    Loggingmodel1(StringBuilder log) {
      this.log = log;
    }

    @Override
    public boolean checkuserpresent(String ssn) throws IOException {
      return false;
    }

    @Override
    public void createuser(String name, String ssn) throws IOException {
      // create user.
    }

    @Override
    public void addstock(int quantity, String ssn, Stock newstock) {
      // adding stock.
    }

    @Override
    public void addstockflexible(int quantity, String ssn, Stock newstock) {
      // adding stock to flexible portfolio.
    }

    @Override
    public void addportfoliocount(String ssn) {
      //adding inflexible portfolio count.
    }

    @Override
    public void addportfoliocountflexible(String ssn) {
      // adding flexible portfolio count.
    }

    @Override
    public int displayportfolionumbers(String ssn) {
      return 0;
    }

    @Override
    public int displayportfolionumbersflexible(String ssn) {
      return 0;
    }

    @Override
    public Map<String, String[]> displayportfoliodetails(
            String ssn, int portfolionumber) {
      return null;
    }

    @Override
    public Map<String, String[]> displayportfoliodetailsflexible(
            String ssn, int portfolionumber) {
      return null;
    }

    @Override
    public Map<String, String[]> displayportfoliodetailsflexibledatefilter(
            String ssn, int portfolionumber, String displaydate) {
      return null;
    }

    @Override
    public boolean validatequantity(String quantitiy) {
      return false;
    }


    @Override
    public boolean checkportnum(int portnum, String ssn) {
      return false;
    }

    @Override
    public boolean checkportnumflexible(int portnum, String ssn) {
      return false;
    }

    @Override
    public void createportfoliousingfile(String ssn, String pathname) throws IOException {
      //create inflexible portfolio using file.
    }

    @Override
    public void createportfoliousingfileflexible(
            String ssn, String pathname) throws IOException {
      // create flexible portfolio using file.
    }

    @Override
    public boolean checkvalidstockname(
            String filepath, Set<String> stocks) {
      return false;
    }

    @Override
    public void fetchdatafromapi() {
      // fetch data from api.
    }

    @Override
    public int checkfordate(
            String date, Map<String, String[]> portfolio) {
      return 0;
    }

    @Override
    public String getstockprice(String udate, String stockname) {
      log.append(udate).append(stockname);
      return null;
    }

    @Override
    public Set<String> initializeset() throws IOException {
      return null;
    }

    @Override
    public int checkdatevalidity(String udate) {
      return 0;
    }

    @Override
    public void addstockstoportfolioflexible(
            String ssn, String stockname, int quantity,
            String date, String price, int displayport) {
      // adding stock to flexible portfolio.
    }

    @Override
    public String getpricecertaindate(
            String date, String stockname) {
      return null;
    }

    @Override
    public void sellstocksflexible(
            String ssn, String stockname, String qantity,

            int portfolionumber, String selldate, String sellprice) {
      // selling stock from flexible portfolio.
    }

    @Override
    public boolean checkselldate(
            String stockname, String date, Map<String, String[]> portfolio) {
      return false;
    }

    @Override
    public float calculateflexiableportfolio(
            Map<String, String[]> portfolio, String date) {
      return 0;
    }

    @Override
    public Map<String, String[]> getconsolidatedmap(
            String ssn, int displayport, String worthdate) {
      return null;
    }

    @Override
    public Map<String, String[]> getconsolidatedmapflexible(
            String ssn, int displayport, String worthdate) {
      return null;
    }


    @Override
    public Double calculatecostbasisflexible(
            String ssn, int displayport, String date, int comissionrate) {
      return null;
    }

    @Override
    public Map<String, String> calculateperformanceflexible(
            String bdate, String endate, String ssn, int portfolionumber) {
      return null;
    }

    @Override
    public Double getminval(Map<String, String> m) {
      return null;
    }
  }

}
*/
