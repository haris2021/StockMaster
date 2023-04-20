package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents Clientflexible class that provides various operations
 * that can be performed on flexible portfolio.
 */
public class Clientflexible implements Clientflexibleinterface {

  @Override
  public void addstocktoclientflexible(int quantity, String ssn, Stock newstock) {

    String portcount = readfile(ssn);

    try {

      File file1 = new File(System.getProperty("user.dir")
              + "/Textfile/" + ssn + "flexible" + "Portfolio"
              + portcount + ".txt");
      FileWriter fw = new FileWriter(file1, true);
      PrintWriter pw = new PrintWriter(fw);
      pw.println(newstock.getCompany());
      pw.println(quantity);
      pw.println(newstock.getPrice());
      pw.println(newstock.getDate());
      pw.close();
    } catch (IOException e) {
      System.out.println("exception caught");
    }

  }

  @Override
  public int getportfoliocountflexible(String ssnuser) {

    String content = readfile(ssnuser);
    int num = Integer.parseInt(content);
    return num;

  }

  @Override
  public void addportcountflexible(String ssnuser) {
    String content = readfile(ssnuser);
    int num = Integer.parseInt(content);
    num++;

    try {
      BufferedWriter writer = new BufferedWriter(
              new FileWriter(System.getProperty("user.dir")
                      + "/Textfile/" + ssnuser + "flexible" + "Portfolio" + ".txt"));
      writer.write(String.valueOf(num));
      writer.close();
    } catch (Exception e) {
      System.out.println("cannot write");

    }

  }

  @Override
  public void portfoliousingfileflexible(String ssn, String pathname) throws IOException {
    String portcount = readfile(ssn);

    File file2 = new File(System.getProperty("user.dir")
            + "/Textfile/" + ssn + "flexible"
            + "Portfolio" + portcount + ".txt");

    File file1 = new File(pathname);

    FileInputStream inputStream = new FileInputStream(file1);
    FileOutputStream outputStream = new FileOutputStream(file2);

    try {
      int i;
      while ((i = inputStream.read()) != -1) {
        outputStream.write(i);
      }
    } catch (Exception e) {
      System.out.println("Error Found: " + e.getMessage());
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
      if (outputStream != null) {
        outputStream.close();
      }
    }

  }

  @Override
  public boolean checkpnumflexible(int pnum, String ssn) {
    int portfolio_num = Integer.parseInt(readfile(ssn));
    return pnum >= 1 && pnum < portfolio_num;
  }

  @Override
  public Map<String, String[]> getportfolioinfoflexible(String ssnuser, int portfolionumber)
  {
    String pathname = System.getProperty("user.dir")
            + "/Textfile/" + ssnuser + "flexible" + "Portfolio"
            + portfolionumber + ".txt";

    Map<String, String[]> mp = new HashMap<>();

    String content = "";


    try {

      BufferedReader reader = new BufferedReader(new FileReader(pathname));
      StringBuilder stringBuilder = new StringBuilder();

      char[] buffer = new char[50];
      while (reader.read(buffer) != -1) {

        stringBuilder.append(new String(buffer));
        buffer = new char[50];

      }

      reader.close();
      content = stringBuilder.toString();
      content = content.trim();

    }
    catch (Exception e)
    {
      System.out.println("Exception caught");
    }

    String a = "";
    String[] arr = content.split("\\r?\\n|\\r");
    int k = 0;
    String finalupdate = "";

    int l = arr.length;


    for (int i = 0; i < l; ) {
      String[] s = new String[3];
      String dummy = arr[i];
      i++;

      for (int j = 0; j < 3; j++) {
        s[j] = arr[i];
        i++;
      }

      if (mp.containsKey(dummy))
      {

        // change is made here
        String getexistingdate = mp.get(dummy)[2];
        s[2] = getexistingdate;
    /*    System.out.println(s[2]);
        System.out.println(getexistingdate);*/

        String q = mp.get(dummy)[0];
        Double numq = Double.parseDouble(q);
        Double existingq = Double.parseDouble(s[0]);
        Double result = numq + existingq;
        String updateq = Double.toString(result);

        s[0] = updateq;
        s[0] = String.format("%.2f", Double.parseDouble(s[0]));

      }

      mp.put(dummy, s);

    }

    return mp;

  }

  @Override
  public Map<String, String[]> getportfolioinfoflexibledatefilter(
          String ssnuser, int portfolionumber, String displaydate) {
    LocalDate paramdate = LocalDate.parse(displaydate);
    String pathname = System.getProperty("user.dir")
            + "/Textfile/" + ssnuser + "flexible" + "Portfolio"
            + portfolionumber + ".txt";

    Map<String, String[]> mp = new HashMap<>();

    String content = "";

    try {

      BufferedReader reader = new BufferedReader(new FileReader(pathname));
      StringBuilder stringBuilder = new StringBuilder();

      char[] buffer = new char[50];
      while (reader.read(buffer) != -1) {

        stringBuilder.append(new String(buffer));
        buffer = new char[50];

      }

      reader.close();
      content = stringBuilder.toString();
      content = content.trim();

    } catch (Exception e) {
      System.out.println("Exception caught");
      System.out.println(e.getStackTrace());
    }

    String a = "";
    String[] arr = content.split("\\r?\\n|\\r");
    int k = 0;

    int l = arr.length;

    for (int i = 0; i < l; ) {
      String[] s = new String[3];
      String dummy = arr[i];
      i++;

      for (int j = 0; j < 3; j++) {
        s[j] = arr[i];
        i++;
      }

      LocalDate d = LocalDate.parse(s[2]);

      if (mp.containsKey(dummy) && (paramdate.isAfter(d) || paramdate.isEqual(d))) {

        // change is made here
        String getexistingdate = mp.get(dummy)[2];
        s[2] = getexistingdate;

        String q = mp.get(dummy)[0];
        Double numq = Double.parseDouble(q);
        Double existingq = Double.parseDouble(s[0]);
        Double result = numq + existingq;
        String updateq = Double.toString(result);
        s[0] = updateq;
        s[0] = String.format("%.2f", Double.parseDouble(s[0]));

      }

      if (paramdate.isAfter(d) || paramdate.isEqual(d)) {
        mp.put(dummy, s);
      }
    }
    return mp;

  }

  @Override
  public Map<String, String[]> getworthmapflexible(String ssn, int displayport, String worthdate) {
    LocalDate inputdate = LocalDate.parse(worthdate);
    String pathname = System.getProperty("user.dir")
            + "/Textfile/" + ssn + "flexible" + "Portfolio"
            + displayport + ".txt";

    Map<String, String[]> mp = new HashMap<>();

    String content = "";

    try {

      BufferedReader reader = new BufferedReader(new FileReader(pathname));
      StringBuilder stringBuilder = new StringBuilder();

      char[] buffer = new char[50];
      while (reader.read(buffer) != -1) {

        stringBuilder.append(new String(buffer));
        buffer = new char[50];

      }

      reader.close();
      content = stringBuilder.toString();
      content = content.trim();

    } catch (Exception e) {
      System.out.println("Exception caught");
    }

    String a = "";
    String[] arr = content.split("\\r?\\n|\\r");
    int k = 0;

    int l = arr.length;

    for (int i = 0; i < l; ) {
      String[] s = new String[3];
      String dummy = arr[i];
      i++;

      for (int j = 0; j < 3; j++) {
        s[j] = arr[i];
        i++;
      }

      String stringdate = s[2];
      LocalDate date = LocalDate.parse(stringdate);

      if (mp.containsKey(dummy)) {


        if (inputdate.isEqual(date) || inputdate.isAfter(date)) {
          String q = mp.get(dummy)[0];
          Double numq = Double.parseDouble(q);
          Double existingq = Double.parseDouble(s[0]);
          Double result = numq + existingq;
          String updateq = Double.toString(result);
          s[0] = updateq;
          mp.put(dummy, s);
        }


      } else {
        if (inputdate.isEqual(date) || inputdate.isAfter(date)) {
          mp.put(dummy, s);
        }
      }


    }
    return mp;
  }

  @Override
  public void editportfolio(String ssn, String stockname,
                            int quantity, String date, String price, int displayport) {


    try {
      String filename = System.getProperty("user.dir")
              + "/Textfile/" + ssn + "flexible" + "Portfolio" + displayport + ".txt";

      FileWriter fw = new FileWriter(filename, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      pw.println(stockname);
      pw.println(quantity);
      pw.println(price);
      pw.println(date);

      pw.close();
      fw.close();
      bw.close();
    } catch (IOException ioe) {
      System.out.println("File not found!");
    }


  }

  @Override
  public void sellstocksfromportfolio(String ssn, String stockname, String quantity,
                                      int portfolionumber, String selldate, String sellprice) {

    try {
      String filename = System.getProperty("user.dir")
              + "/Textfile/" + ssn + "flexible" + "Portfolio" + portfolionumber + ".txt";

      FileWriter fw = new FileWriter(filename, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      quantity = "-" + quantity;

      pw.println(stockname);
      pw.println(quantity);
      pw.println(sellprice);
      pw.println(selldate);

      pw.close();
      fw.close();
      bw.close();
    } catch (IOException ioe) {
      System.out.println("File not found!");
    }

    BufferedReader reader;


  }

  @Override
  public Double computecostbasis(String ssn, int displayport, String date, int comissionrate) {
    String filename = System.getProperty("user.dir")
            + "/Textfile/" + ssn + "flexible" + "Portfolio" + displayport + ".txt";
    LocalDate paramd = LocalDate.parse(date);
    Double costbasis = 0.0;


    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(filename));
      String line = reader.readLine();
      String[] str = new String[4];
      int i = 0;


      while (line != null) {
        str[i] = line;
        i++;
        if (i == 4) {
          LocalDate d = LocalDate.parse(str[3]);
          if (paramd.isAfter(d) || paramd.isEqual(d)) {

            if (Double.parseDouble(str[1]) > 0) {


              costbasis += (Double.parseDouble(str[1]) *
                      Double.parseDouble(str[2])) + comissionrate;
            }

            if (Double.parseDouble(str[1]) < 0) {
              costbasis = costbasis + comissionrate;
            }

          }
          i = 0;
        }
        line = reader.readLine();
      }

      reader.close();
    } catch (Exception e) {
      System.out.println("File does not exist!");

      e.printStackTrace();
    }

    return costbasis;

  }

  @Override
  public Map<String, String> displayperformancebar(String bdate, String edate,
                                                   String ssn, int portfolionumber) {

    Map<String, String[]> portfolio = getportfolioinfoflexible(ssn, portfolionumber);


    Map<String, String[]> sdata;
    LocalDate bd = LocalDate.parse(bdate);
    LocalDate ed = LocalDate.parse(edate);
    Period diff = Period.between(bd, ed);


    int years = diff.getYears();
    int months = diff.getMonths();
    int days = diff.getDays();

    LocalDate yearlater = bd;
    LocalDate nextmonth = bd;
    LocalDate nextyear = bd;
    LocalDate nextday = bd;


    Map<String, String> mp = new LinkedHashMap<>();

    int totalmonths = months + (years * 12);

    if (totalmonths == 0) {
      String price = "";
      String displayname = "";

      for (int i = 1; i <= days + 1; i++) {

        do {

          if (datevalidate(nextday.toString()) != 0) {
            LocalDate prev1 = nextday.plusDays(1);
            nextday = prev1;
            i++;
          }

        }
        while (datevalidate(nextday.toString()) != 0);

        Double t = 0.0;


        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
          do {
            price = getprice(nextday.toString(), entry.getKey());
            if (Objects.equals(price, "")) {
              nextday = nextday.plusDays(1);
              i++;
            }
          }
          while (Objects.equals(price, ""));

          if (Double.parseDouble(entry.getValue()[0]) > 0) {
            t += Double.parseDouble(price) * Double.parseDouble(entry.getValue()[0]);
          }
        }

        String mname = nextday.getMonth().toString().substring(0, 3);
        String dayname = String.valueOf(nextday.getDayOfMonth());

        displayname = mname + dayname;

        mp.put(displayname, t.toString());

        nextday = nextday.plusDays(1);

      }


    } else if (totalmonths >= 1 && totalmonths <= 29) {
      String price = "";
      String laststock = "";
      String lastquantity = "";
      String displayname = "";
      Double t = 0.0;

      for (int i = 1; i <= totalmonths + 2; i++) {

        do {

          if (datevalidate(nextmonth.toString()) != 0) {
            LocalDate prev1 = nextmonth.minusDays(1);
            nextmonth = prev1;
          }

        }
        while (datevalidate(nextmonth.toString()) != 0);

        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {

          do {
            price = getprice(nextmonth.toString(), entry.getKey());
            laststock = entry.getKey();
            if (Objects.equals(price, "")) {
              nextmonth = nextmonth.minusDays(1);
            }
          }
          while (Objects.equals(price, ""));

          if (Double.parseDouble(entry.getValue()[0]) > 0) {
            t += Double.parseDouble(price) * Double.parseDouble(entry.getValue()[0]);
          }

        }
        String yrr = String.valueOf(nextmonth.getYear());
        String mname = nextmonth.getMonth().toString().substring(0, 3);
        displayname = mname + yrr;

        mp.put(displayname, t.toString());

        nextmonth = nextmonth.plusMonths(1);

      }

      if (days != 0) {
        nextmonth = ed;

        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
          do {
            price = getprice(nextmonth.toString(), entry.getKey());
            if (Objects.equals(price, "")) {
              nextmonth = nextmonth.minusDays(1);
            }
          }
          while (Objects.equals(price, ""));

          if (Double.parseDouble(entry.getValue()[0]) > 0) {
            t += Double.parseDouble(price) * Double.parseDouble(entry.getValue()[0]);
          }

        }

        mp.put(displayname, t.toString());
      }


    } else if (totalmonths >= 30 && totalmonths <= 58) {

      String price = "";
      String displayname = "";
      Double t = 0.0;

      for (int i = 1; i <= totalmonths + 2; i = i + 2) {


        String monthname = nextmonth.getMonth().toString().substring(0, 3);
        String yearname = String.valueOf(nextmonth.getYear());

        do {

          if (datevalidate(nextmonth.toString()) != 0) {

            LocalDate prev1 = nextmonth.minusDays(1);
            nextmonth = prev1;

          }

        }
        while (datevalidate(nextmonth.toString()) != 0);


        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
          do {
            price = getprice(nextmonth.toString(), entry.getKey());
            if (Objects.equals(price, "")) {
              nextmonth = nextmonth.minusDays(1);
            }
          }
          while (Objects.equals(price, ""));

          if (Double.parseDouble(entry.getValue()[0]) > 0) {
            t += Double.parseDouble(price) * Double.parseDouble(entry.getValue()[0]);
          }
        }

        displayname = monthname + yearname;
        mp.put(displayname, t.toString());
        nextmonth = nextmonth.plusMonths(2);

      }


      if (days != 0) {
        nextmonth = ed;

        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
          do {
            price = getprice(nextmonth.toString(), entry.getKey());
            if (Objects.equals(price, "")) {
              nextmonth = nextmonth.minusDays(1);
            }
          }
          while (Objects.equals(price, ""));

          if (Double.parseDouble(entry.getValue()[0]) > 0) {
            t += Double.parseDouble(price) * Double.parseDouble(entry.getValue()[0]);
          }

        }

        mp.put(displayname, t.toString());
      }

    } else {
      Double t = 0.0;
      String price = "";
      String displayname = "";

      for (int i = 1; i <= years + 1; i++) {

        String yearname = String.valueOf(nextyear.getYear());

        do {

          if (datevalidate(nextyear.toString()) != 0) {
            LocalDate prev1 = nextyear.minusDays(1);
            nextyear = prev1;
          }

        }
        while (datevalidate(nextyear.toString()) != 0);


        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
          do {
            price = getprice(nextyear.toString(), entry.getKey());
            if (Objects.equals(price, "")) {
              nextyear = nextyear.minusDays(1);
            }
          }
          while (Objects.equals(price, ""));

          if (Double.parseDouble(entry.getValue()[0]) > 0) {
            t += Double.parseDouble(price) * Double.parseDouble(entry.getValue()[0]);
          }
        }

        displayname = yearname;

        mp.put(displayname, t.toString());
        nextyear = nextyear.plusYears(1);

      }


      if (months != 0 || days != 0) {
        nextyear = ed;

        for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
          do {
            price = getprice(nextyear.toString(), entry.getKey());
            if (Objects.equals(price, "")) {
              nextyear = nextyear.minusDays(1);
            }
          }
          while (Objects.equals(price, ""));

          if (Double.parseDouble(entry.getValue()[0]) > 0) {
            t += Double.parseDouble(price) * Double.parseDouble(entry.getValue()[0]);
          }

        }

        mp.put(displayname, t.toString());
      }

    }

    return mp;

  }


  private int datevalidate(String date) {
    final String dateformat = "yyyy-MM-dd";

    try {

      DateFormat df = new SimpleDateFormat(dateformat);
      df.setLenient(false);
      df.parse(date);
      Date enteredDate = df.parse(date);

      Calendar cal = Calendar.getInstance();
      cal.setTime(enteredDate);

      int day = cal.get(Calendar.DAY_OF_WEEK);

      if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
        return 1;
      }


      if (enteredDate.after(new Date())) {
        return 2;
      }

    } catch (ParseException e) {
      return 3;
    }
    return 0;
  }

  private String getprice(String date, String stockname) {
    Stockapi apiobj = new Stockapi();
    String price = apiobj.getstockprice(date, stockname);
    return price;


  }

  private String readfile(String ssnuser) {

    String content = "";

    try {
      BufferedReader reader = new BufferedReader(
              new FileReader(System.getProperty("user.dir")
                      + "/Textfile/" + ssnuser + "flexible" + "Portfolio" + ".txt"));

      StringBuilder stringBuilder = new StringBuilder();

      char[] buffer = new char[10];

      while (reader.read(buffer) != -1) {
        stringBuilder.append(new String(buffer));
        buffer = new char[10];
      }

      reader.close();

      content = stringBuilder.toString();
      content = content.trim();

    } catch (Exception e) {
      System.out.println("invalid file");
    }
    return content;


  }

  @Override
  public String[] createstockforinvestment(String date, String price) {
    String[] allcontent = new String[3];
    allcontent[0] = "0";
    allcontent[1] = price;
    allcontent[2] = date;

    return allcontent;

  }

  @Override
  public String date4help(String date) {

    System.out.println("in client flexible ");


    final String dateformat = "yyyy-MM-dd";

    Stockapinterface sp = new Stockapi();

    String finaldate = date;

    do {

      try {

        System.out.println("Entered try" + finaldate);


        DateFormat df = new SimpleDateFormat(dateformat);
        df.setLenient(false);
        df.parse(finaldate);
        Date enteredDate = df.parse(finaldate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(enteredDate);

        int day = cal.get(Calendar.DAY_OF_WEEK);

        System.out.println("before if"+finaldate);

        if (enteredDate.after(new Date())) {
          return "6";
        } else if (day == Calendar.SATURDAY) {

          finaldate = LocalDate.parse(date).plusDays(2).toString();
          System.out.println("in sat added" + finaldate);

        }
        else if (day == Calendar.SUNDAY)
        {
          finaldate = LocalDate.parse(date).plusDays(1).toString();
          System.out.println("sunday"+ finaldate);

        } else if (sp.getstockprice(finaldate, "AMZN").equals("")) {

          finaldate = LocalDate.parse(finaldate).plusDays(1).toString();
          System.out.println("Entered into next year"+ finaldate);
          // need to ask someone about this.
          Date futuredate = df.parse(finaldate);
          if (futuredate.after(new Date())) {
            return "6";
          }

        } else if (finaldate.length() != 10) {
          return "1";
        }


      } catch (ParseException e) {
        return "1";
      }
    }
    while (sp.getstockprice(finaldate, "AMZN").equals(""));

    System.out.println("before returning"+ finaldate);
    return finaldate;
  }

  @Override
  public boolean validateamt(String amt) {
    return !amt.contains("-") && !amt.equals("0");

  }

  @Override
  public int validateqty(String q, Map<String, String[]> portfolio, String stockname) {
    if (q.contains(".")) {
      //v1.displayquantitymessage();

      return 1;
    }
     else if (Integer.parseInt(q) <= 0) {
      // v1.displayquantitymessage();
      return 3;
    }
    return 4;
  }

  @Override
  public boolean comparedate(String sdate, String edate) {
    LocalDate start = LocalDate.parse(sdate);
    LocalDate end = LocalDate.parse(edate);
    return end.isAfter(start);
  }

  @Override
  public String getbeforecurr() {
    return LocalDate.now().minusDays(1).toString();
  }

  @Override
  public boolean valperc(String p) {
    return !p.contains("-") && !p.equals("0");
  }


}
