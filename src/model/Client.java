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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Client class will implement
 * clientinterface and have
 * method definations of
 * all functionalities related
 * to client.
 */
public class Client implements Clientinterface {

  @Override
  public boolean checkuser(String ssn) throws IOException {

    FileReader fr = new FileReader(System.getProperty("user.dir") + "/Textfile/ssn.txt");
    int i;
    String ssncheck = "";
    boolean check = false;

    while ((i = fr.read()) != -1) {
      if (((char) i) != '\n') {
        if (((char) i) == '\r') {
          continue;
        }

        ssncheck = ssncheck + ((char) i);

      } else {
        check = ssncheck.equals(ssn);
        if (check) {
          return check;

        }
        ssncheck = "";
      }
    }
    return check;

  }

  @Override
  public void createnewclient(String name, String ssn) throws IOException {


    try {
      File file3 = new File(System.getProperty("user.dir")
              + "/Textfile/" + ssn + "Flexible" + "Portfolio" + ".txt");
      FileWriter fw3 = new FileWriter(file3, true);
      PrintWriter pw3 = new PrintWriter(fw3);
      pw3.println("1");
      pw3.close();

      File file4 = new File(System.getProperty("user.dir")
              + "/Textfile/" + ssn + "Inflexible" + "Portfolio" + ".txt");
      FileWriter fw4 = new FileWriter(file4, true);
      PrintWriter pw4 = new PrintWriter(fw4);
      pw4.println("1");
      pw4.close();
    } catch (IOException e) {
      System.out.println("exception caught");
    }

    File file = new File(System.getProperty("user.dir") + "/Textfile" + "/ssn.txt");
    File file1 = new File(System.getProperty("user.dir") + "/Textfile/" + ssn + ".txt");
    FileInputStream fis = new FileInputStream(file);
    FileWriter fw = new FileWriter(file, true);
    FileWriter fw1 = new FileWriter(file1, true);
    PrintWriter pw = new PrintWriter(fw);
    PrintWriter pw1 = new PrintWriter(fw1);

    pw.println(ssn);
    pw1.println(name);
    pw1.println(ssn);
    pw.close();
    pw1.close();

  }

  @Override
  public void addstocktoclient(int quantity, String ssn, Stock newstock) {

    String portcount = readfile(ssn);
    try {

      File file1 = new File(System.getProperty("user.dir")
              + "/Textfile/" + ssn + "inflexible" + "Portfolio"
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
  public void addportcount(String ssnuser) {
    String content = readfile(ssnuser);
    int num = Integer.parseInt(content);
    num++;

    try {
      BufferedWriter writer = new BufferedWriter(
              new FileWriter(System.getProperty("user.dir")
                      + "/Textfile/" + ssnuser + "inflexible" + "Portfolio" + ".txt"));
      writer.write(String.valueOf(num));
      writer.close();
    } catch (Exception e) {
      System.out.println("cannot write");

    }

  }

  @Override
  public int getportfoliocount(String ssnuser) {

    String content = readfile(ssnuser);
    int num = Integer.parseInt(content);
    return num;

  }


  @Override
  public Map<String, String[]> getportfolioinfo(String ssnuser, int portfolionumber) {
    String pathname = System.getProperty("user.dir")
            + "/Textfile/" + ssnuser + "inflexible" + "Portfolio"
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

      if (mp.containsKey(dummy)) {
        String q = mp.get(dummy)[0];
        int numq = Integer.parseInt(q);
        int existingq = Integer.parseInt(s[0]);
        int result = numq + existingq;
        String updateq = Integer.toString(result);
        s[0] = updateq;
      }

      mp.put(dummy, s);
    }
    return mp;

  }

  /**
   * readfile is a helper method
   * which is used to read
   * content from file and
   * return that content.
   *
   * @param ssnuser social security number of the client.
   * @return content of the file which is read.
   */
  public String readfile(String ssnuser) {

    String content = "";

    try {
      BufferedReader reader = new BufferedReader(
              new FileReader(System.getProperty("user.dir")
                      + "/Textfile/" + ssnuser + "inflexible" + "Portfolio" + ".txt"));

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
  public boolean validateq(String quantity) {
    int num = 0;
    try {
      num = Integer.parseInt(quantity);
    } catch (Exception e) {
      return false;
    }

    return num >= 1;

  }

  @Override
  public boolean checkpnum(int pnum, String ssn) {
    int portfolio_num = Integer.parseInt(readfile(ssn));
    return pnum >= 1 && pnum < portfolio_num;
  }

  @Override
  public void portfoliousingfile(String ssn, String pathname) throws IOException {
    String portcount = readfile(ssn);

    File file2 = new File(System.getProperty("user.dir")
            + "/Textfile/" + ssn + "inflexible"
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
  public boolean checkvalidstocks(String filename, Set<String> stocks) {

    Map<String, String[]> mp;
    mp = readfileputinttomap(filename);

    for (Map.Entry<String, String[]> entry : mp.entrySet()) {
      String userenteredstock = entry.getKey();
      if (!stocks.contains(userenteredstock)) {
        return false;
      }

    }
    return true;

  }

  @Override
  public float getworthstocks(String date, Map<String, String[]> portfolio) {
    LocalDate param_date = LocalDate.parse(date);
    Stockapi apiobj = new Stockapi();
    float totalval = 0.0f;

    for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {


      Double q = Double.parseDouble(entry.getValue()[0]);
      q = Double.valueOf(String.format("%.2f", q));

      String p = apiobj.getstockprice(date, entry.getKey());
      float price = Float.parseFloat(p);

      totalval += q * price;
      totalval = Float.parseFloat(String.format("%.2f", totalval));


    }
    return totalval;

  }

  @Override
  public String getprice(String date, String stockname) {
    Stockapi apiobj = new Stockapi();
    String price = apiobj.getstockprice(date, stockname);
    return price;


  }

  private Map<String, String[]> readfileputinttomap(String pathname) {
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
      mp.put(dummy, s);
    }
    return mp;

  }


  @Override
  public boolean checkvalidselldate(String stockname, String date,
                                    Map<String, String[]> portfolio, String quantity ) {
    System.out.println("sname " + stockname);
    System.out.println("date " + date);
    System.out.println("portfolio " + portfolio);
    System.out.println("quantity " + quantity);

    LocalDate argdate = LocalDate.parse(date);
    for (Map.Entry<String, String[]> entry : portfolio.entrySet())
    {
      if (entry.getKey().equals(stockname))
      {
        LocalDate curr = LocalDate.parse(entry.getValue()[2]);

        if ( (argdate.isAfter(curr) || argdate.isEqual(curr) ) && (Double.parseDouble(quantity) < Double.parseDouble(entry.getValue()[0])))
        {
          return true;
        }

      }
    }
    return false;
  }

  @Override
  public Map<String, String[]> getworthmap(String ssn, int displayport, String worthdate) {
    LocalDate inputdate = LocalDate.parse(worthdate);
    String pathname = System.getProperty("user.dir")
            + "/Textfile/" + ssn + "inflexible" + "Portfolio"
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


      mp.put(dummy, s);
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

  @Override
  public Double findmin(Map<String, String> mp) {

    double res = Double.MAX_VALUE;

    for (Map.Entry<String, String> entry : mp.entrySet()) {
      res = Math.min(res, Double.parseDouble(entry.getValue()));
    }

    return res;
  }


}
