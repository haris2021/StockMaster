package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

/**
 * represents Investmentplans class which provides 2 investment strategy methods
 * by implementing the InvestmentplansInterface.
 */

public class Investmentplans extends Stockapi implements Investmentplansinterface {

  @Override
  public void investportfoliostrategy1(String ssn, int displayport, String investamount,
                                       String investmentdate, ArrayList<String> sharepercent,
                                       Map<String, String[]> portfolio) {

    ArrayList<String> amounttoinvest = new ArrayList<>();
    int i = 0;

    for (String a : sharepercent) {
      Double prices = (Double.parseDouble(investamount) * Integer.parseInt(a)) / 100;
      amounttoinvest.add(Double.toString(prices));
    }

    i = 0;
    for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {
      String p = getstockprice(investmentdate, entry.getKey());
      float price = Float.parseFloat(p);
      Double qauntity = Double.parseDouble(amounttoinvest.get(i)) / price;
      try {
        File file1 = new File(System.getProperty("user.dir")
                + "/Textfile/" + ssn + "flexible" + "Portfolio"
                + displayport + ".txt");

        FileWriter fw = new FileWriter(file1, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(entry.getKey());
        pw.println(Double.toString(qauntity));
        pw.println(price);
        pw.println(investmentdate);
        pw.close();

      } catch (Exception e) {
        System.out.println("File not found");
      }

      i++;

    }


  }

  @Override
  public void investportfoliostrategy2(String ssn, int displayport, String investamount,
                                       String investmentsdate, String investmentedate,
                                       ArrayList<String> sharepercent,
                                       Map<String, String[]> portfolio, String choice) {


    LocalDate sdate = LocalDate.parse(investmentsdate);
    LocalDate edate = LocalDate.parse(investmentedate);

    if (choice.equals("1")) {

      do {


        do {
          if (getstockprice(sdate.toString(), "AMZN").equals("")) {
            sdate = sdate.plusDays(1);
          }
        }
        while (getstockprice(sdate.toString(), "AMZN").equals(""));

        String stdate = sdate.toString();

        investportfoliostrategy1(ssn, displayport, investamount, stdate, sharepercent, portfolio);
        System.out.println(sdate);

        sdate = sdate.plusDays(1);


      }
      while (sdate.isBefore(edate) || sdate.isEqual(edate));

    } else if (choice.equals("2")) {

      do {

        do {
          if (getstockprice(sdate.toString(), "AMZN").equals("")) {
            sdate = sdate.plusDays(1);
          }
        }
        while (getstockprice(sdate.toString(), "AMZN").equals(""));

        String stdate = sdate.toString();

        investportfoliostrategy1(ssn, displayport, investamount, stdate, sharepercent, portfolio);
        sdate = sdate.plusDays(7);

      }
      while (sdate.isBefore(edate) || sdate.isEqual(edate));


    } else if (choice.equals("3")) {


      do {

        do {
          if (getstockprice(sdate.toString(), "AMZN").equals("")) {
            sdate = sdate.plusDays(1);
          }
        }
        while (getstockprice(sdate.toString(), "AMZN").equals(""));

        String stdate = sdate.toString();

        investportfoliostrategy1(ssn, displayport, investamount, stdate, sharepercent, portfolio);
        sdate = sdate.plusMonths(1);
      }
      while (sdate.isBefore(edate) || sdate.isEqual(edate));


    } else if (choice.equals("4")) {

      do {

        do {
          if (getstockprice(sdate.toString(), "AMZN").equals("")) {
            sdate = sdate.plusDays(1);
          }
        }
        while (getstockprice(sdate.toString(), "AMZN").equals(""));

        String stdate = sdate.toString();

        investportfoliostrategy1(ssn, displayport, investamount, stdate, sharepercent, portfolio);
        sdate = sdate.plusYears(1);

      }
      while (sdate.isBefore(edate) || sdate.isEqual(edate));


    }


  }


}
