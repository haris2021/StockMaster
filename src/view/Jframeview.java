package view;

import java.awt.GridBagConstraints;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.Map;


import javax.swing.Box;

import java.awt.GridBagLayout;

import java.awt.GridLayout;
import java.awt.FlowLayout;


import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.BorderFactory;


import features.Features;

/**
 * JFrameview has defination
 * of all event
 * listeners that GUI
 * needs to handle
 * and this class
 * extends JFrame built
 * in class
 * in Java Swing and Implements
 * GUIviewinterface which consists
 * of all event listening methods.
 */
public class Jframeview extends JFrame implements GUIviewInterface {

  private JLabel display;
  private JLabel display1;
  private JLabel display2;
  private JLabel display3;

  //private JButton viewbutton;


  private JButton gobackbtn;

  private JButton submitbtn;
  private JButton nextbtn;

  private JButton exitbtn;
  private JButton okaybtn;

  private JTextField input;
  private JTextField input2;
  private JTextField input3;

  private Features fobject;

  /**
   * Jframeview is
   * a default constructor
   * which creates
   * the first frame
   * the program will
   * generate when
   * executed, also
   * it accepts caption
   * as parameter
   * which gives heading
   * to the frame.
   *
   * @param caption heading to frame.
   */
  public Jframeview(String caption) {

    super(caption);

    this.setSize(400, 200);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());

    JButton viewbutton = new JButton("Welcome");
    viewbutton.setActionCommand("Welcome");


    viewbutton.addActionListener(evt -> {
      fobject.getssn();
      this.dispose();
    });

    this.add(viewbutton, new GridBagConstraints());

    setVisible(true);

  }

  @Override
  public void addFeatures(Features f) {

    fobject = f;
  }


  /**
   * resetFocus is the
   * method present in
   * built class JFrame
   * which set the focusable
   * to true.
   */
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public void getssn() {

    JFrame f = new JFrame();

    f.setSize(400, 200);
    f.setLocation(200, 200);
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setLayout(new GridBagLayout());

    display1 = new JLabel("Enter SSN");
    f.add(display1);
    input = new JTextField(10);
    f.add(input);


    submitbtn = new JButton("Submit");
    submitbtn.setActionCommand("Submit");
    f.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.checkssn(input.getText());
      f.dispose();
    });

    f.add(submitbtn, new GridBagConstraints());

    f.setVisible(true);
  }

  @Override
  public void registeruser() {
    JFrame f = new JFrame();

    f.setSize(500, 200);
    f.setLocation(200, 200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new FlowLayout());

    display1 = new JLabel("Enter Name");
    f.add(display1);
    input = new JTextField(10);
    f.add(input);

    display2 = new JLabel("Enter SSN");
    f.add(display2);
    input2 = new JTextField(10);
    f.add(input2);

    submitbtn = new JButton("Submit");
    submitbtn.setActionCommand("Submit");
    f.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.registeruser(input.getText(), input2.getText());
      f.dispose();
    });

    f.setVisible(true);
  }

  @Override
  public void displaymenu() {

    JFrame f = new JFrame("Menu Page");

    f.setSize(400, 440);
    f.setLocation(200, 200);
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    Box cpBox = Box.createHorizontalBox();
    cpBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton createp = new JButton("Create Portfolio");
    createp.setSize(new Dimension(40, 100));
    createp.addActionListener(evt -> {
      fobject.choice();
      f.dispose();
    });
    createp.setActionCommand("Create Portfolio");
    cpBox.add(createp);

    JButton viewpbtn = new JButton("View portfolio");
    viewpbtn.setSize(new Dimension(40, 100));
    viewpbtn.addActionListener(evt -> {
      fobject.view();
      f.dispose();
    });
    viewpbtn.setActionCommand("View Portfolio");
    cpBox.add(viewpbtn);

    Box bsBox = Box.createHorizontalBox();
    bsBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton buysharebtn = new JButton("Buy Stocks");
    buysharebtn.setSize(new Dimension(40, 40));
    buysharebtn.addActionListener(evt -> {
      fobject.buyshares();
      f.dispose();
    });
    buysharebtn.setActionCommand("Buy Stocks");
    bsBox.add(buysharebtn);


    JButton sellsharebtn = new JButton("Sell Stocks");
    sellsharebtn.setSize(new Dimension(400, 700));
    sellsharebtn.addActionListener(evt -> {
      fobject.sellshares();
      f.dispose();
    });
    sellsharebtn.setActionCommand("Sell Stocks");
    bsBox.add(sellsharebtn);


    Box cbpBox = Box.createHorizontalBox();
    cbpBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton costbasisbtn = new JButton("Calculate Cost basis");
    costbasisbtn.setSize(new Dimension(40, 40));
    costbasisbtn.addActionListener(evt -> {
      fobject.costbasis();
      f.dispose();
    });
    costbasisbtn.setActionCommand("Cost basis");
    cbpBox.add(costbasisbtn);


    JButton valuebtn = new JButton("Calculate Worth");
    valuebtn.setSize(new Dimension(40, 40));
    valuebtn.addActionListener(evt -> {
      fobject.worth();
      f.dispose();
    });
    valuebtn.setActionCommand("Worth");
    cbpBox.add(valuebtn);


    Box iv1Box = Box.createHorizontalBox();
    iv1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton investment1btn = new JButton("One time investment");
    investment1btn.setSize(new Dimension(40, 40));
    investment1btn.addActionListener(evt -> {
      fobject.investment1();
      f.dispose();
    });
    investment1btn.setActionCommand("One time investment");
    iv1Box.add(investment1btn);


    JButton investment2btn = new JButton("Dollar cost Averaging ");
    investment2btn.setSize(new Dimension(40, 40));
    investment2btn.addActionListener(evt -> {
      fobject.investment2();
      f.dispose();
    });
    investment2btn.setActionCommand("Dollar cost Averaging");
    iv1Box.add(investment2btn);


    Box eBox = Box.createHorizontalBox();
    eBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    exitbtn = new JButton("Exit");
    exitbtn.setSize(new Dimension(40, 40));
    exitbtn.addActionListener(evt -> fobject.exitoption());
    exitbtn.setActionCommand("Exit");
    eBox.add(exitbtn);

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(cpBox);
    createfBox.add(bsBox);
    createfBox.add(cbpBox);
    createfBox.add(iv1Box);
    createfBox.add(eBox);


    f.add(createfBox);
    f.setVisible(true);

  }

  @Override
  public void displaychoice() {

    JFrame f1 = new JFrame();

    f1.setSize(620, 260);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    Box cfBox = Box.createHorizontalBox();
    cfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton createpfile = new JButton("Create using file");
    createpfile.addActionListener(evt -> {
      fobject.fileinput();
      f1.dispose();
    });
    createpfile.setActionCommand("Create using file");
    cfBox.add(createpfile);

    JButton createpstock = new JButton("Create manually");
    createpstock.setActionCommand("Create manually");
    createpstock.addActionListener(evt -> {
      fobject.getstockmanually();
      f1.dispose();
    });
    cfBox.add(createpstock);


    Box ivBox = Box.createHorizontalBox();
    ivBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton createinvestment1stock = new JButton("Create Using one time investment");
    createinvestment1stock.setActionCommand("Create Using one time investment");
    createinvestment1stock.addActionListener(evt -> {
      fobject.getstockinvestment1();
      f1.dispose();
    });
    ivBox.add(createinvestment1stock);

    JButton createinvestment2stock = new JButton("Create Using Dollar cost averaging");
    createinvestment2stock.setActionCommand("Create Using Dollar cost averaging");
    createinvestment2stock.addActionListener(evt -> {
      fobject.getstockinvestment2();
      f1.dispose();
    });
    ivBox.add(createinvestment2stock);


    Box eBox = Box.createHorizontalBox();
    eBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton backbtn = new JButton("Back to Menu");
    backbtn.setPreferredSize(new Dimension(40, 40));
    backbtn.addActionListener(evt -> {
      fobject.displaymenu();
      f1.dispose();
    });
    exitbtn.setActionCommand("Back to Menu");
    eBox.add(backbtn);

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(cfBox);
    createfBox.add(ivBox);
    createfBox.add(eBox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void displayfileinput() {
    JFrame f1 = new JFrame();

    f1.setSize(500, 300);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setLayout(new FlowLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Enter file path");
    displayBox.add(display);

    Box inputBox = Box.createHorizontalBox();
    inputBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    input = new JTextField(10);
    inputBox.add(input);

    Box submitBox = Box.createHorizontalBox();
    submitBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton getfilebtn = new JButton("Add");
    getfilebtn.setActionCommand("Add");
    submitBox.add(getfilebtn);

    getfilebtn.addActionListener(evt -> {
      fobject.filepath(input.getText());
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(inputBox);
    createfBox.add(submitBox);

    f1.add(createfBox);

    f1.setVisible(true);


  }

  @Override
  public void wrongfileinfoentered(String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    f1.setLayout(new GridLayout(2, 0));

    display = new JLabel(message);
    f1.add(display);

    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    f1.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.fileinput();
      f1.dispose();
    });
    f1.setVisible(true);
  }


  @Override
  public void manualmenu() {
    JFrame f2 = new JFrame("Add stock information");

    f2.setSize(500, 500);
    f2.setLocation(200, 200);
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f2.setLayout(new GridBagLayout());

    Box stockinfoBox = Box.createHorizontalBox();
    stockinfoBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Enter Stock Information here");
    stockinfoBox.add(display);

    Box stocknameBox = Box.createHorizontalBox();
    stocknameBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Enter Stock Name");
    input = new JTextField(1);
    input.setSize(new Dimension(10, 10));
    stocknameBox.add(display1);
    stocknameBox.add(input);

    Box stockquanteBox = Box.createHorizontalBox();
    stockquanteBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display2 = new JLabel("Enter Number of stocks");
    input2 = new JTextField(10);
    stockquanteBox.add(display2);
    stocknameBox.add(input2);
    stockquanteBox.add(display2);
    stockquanteBox.add(input2);


    Box stockdateBox = Box.createHorizontalBox();
    stockdateBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display3 = new JLabel("Enter date");
    stockdateBox.add(display3);
    input3 = new JTextField(1);
    stockdateBox.add(input3);

    Box submitBox = Box.createHorizontalBox();
    submitBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("Submit");
    submitbtn.setActionCommand("Submit");
    submitBox.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.getstockinfo(input.getText(), input2.getText(), input3.getText());
      f2.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(stockinfoBox);
    createfBox.add(stocknameBox);
    createfBox.add(stockquanteBox);
    createfBox.add(stockdateBox);
    createfBox.add(submitBox);


    f2.add(createfBox);
    f2.setVisible(true);

  }

  @Override
  public void wrongstockinfoentered(String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.getstockmanually();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  // waste
  @Override
  public void wronginfoentered(String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    f1.setLayout(new GridLayout(4, 0));
    display = new JLabel(message);
    f1.add(display);

    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    f1.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.displaymenu();
      f1.dispose();
    });
    f1.setVisible(true);

  }


  @Override
  public void stockaddedafterstep() {
    JFrame f1 = new JFrame("SOLD");

    f1.setSize(500, 250);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box displaybox = Box.createHorizontalBox();
    displaybox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Stock addedd successfully");
    displaybox.add(display);

    Box display1box = Box.createHorizontalBox();
    display1box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Add more stocks");
    display1box.add(display1);

    JButton againaddstockbtn = new JButton("yes");
    againaddstockbtn.setActionCommand("yes");
    display1box.add(againaddstockbtn);
    againaddstockbtn.addActionListener(evt -> {
      fobject.addstock();
      f1.dispose();
    });


    againaddstockbtn = new JButton("No");
    againaddstockbtn.setActionCommand("No");
    display1box.add(againaddstockbtn);
    againaddstockbtn.addActionListener(evt -> {
      fobject.noaddstock();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displaybox);
    createfBox.add(display1box);


    f1.add(createfBox);

    f1.setVisible(true);
  }

  @Override
  public void getstockusinginvestment1() {
    JFrame f1 = new JFrame();

    f1.setSize(500, 300);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    f1.setLayout(new GridBagLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Date Of Investment");
    displayBox.add(display1);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    displayBox.add(input2);

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display2 = new JLabel("Amount");
    display1Box.add(display2);
    input3 = new JTextField();
    input3.setPreferredSize(new Dimension(100, 30));
    display1Box.add(input3);


    Box display3Box = Box.createHorizontalBox();
    display3Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    display3Box.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.createstockusinginvestment1(input2.getText(), input3.getText());
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(display1Box);
    createfBox.add(display3Box);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void getstocksforinvestment1(String date, String investmentamount) {

    JFrame f1 = new JFrame("Stocks Information");

    Box pfNameBox = Box.createHorizontalBox();
    pfNameBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Stock name");
    input = new JTextField(20);
    pfNameBox.add(display);
    pfNameBox.add(input);

    Box amtBox = Box.createHorizontalBox();
    amtBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("percentage to invest");
    input2 = new JTextField(20);
    amtBox.add(display1);
    amtBox.add(input2);

    Box btnBox = Box.createHorizontalBox();
    btnBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.addActionListener(evt -> {
      fobject.addstocksviainvestment1(input.getText(), input2.getText(), date, investmentamount);
      f1.dispose();
    });
    submitbtn.setActionCommand("submit");
    btnBox.add(submitbtn);


    Box createDCABox = Box.createVerticalBox();
    createDCABox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createDCABox.add(pfNameBox);
    createDCABox.add(amtBox);
    createDCABox.add(btnBox);


    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.add(createDCABox);


    f1.pack();
    f1.setVisible(true);


  }

  @Override
  public void getstocksforinvestment2(String date, String investmentamount) {

    JFrame f1 = new JFrame("Stocks Information");

    Box pfNameBox = Box.createHorizontalBox();
    pfNameBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Stock name");
    input = new JTextField(20);
    pfNameBox.add(display);
    pfNameBox.add(input);

    Box amtBox = Box.createHorizontalBox();
    amtBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("percentage to invest");
    input2 = new JTextField(20);
    amtBox.add(display1);
    amtBox.add(input2);

    Box btnBox = Box.createHorizontalBox();
    btnBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.addActionListener(evt -> {
      fobject.addstocksviainvestment2(input.getText(), input2.getText(), date, investmentamount);
      f1.dispose();
    });
    submitbtn.setActionCommand("submit");
    btnBox.add(submitbtn);


    Box createDCABox = Box.createVerticalBox();
    createDCABox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createDCABox.add(pfNameBox);
    createDCABox.add(amtBox);
    createDCABox.add(btnBox);


    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.add(createDCABox);


    f1.pack();
    f1.setVisible(true);

  }

  @Override
  public void getstockusinginvestment2() {

    JFrame f1 = new JFrame();

    f1.setSize(450, 300);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    f1.setLayout(new GridBagLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Start date");
    displayBox.add(display1);
    input = new JTextField();
    input.setPreferredSize(new Dimension(100, 30));
    displayBox.add(input);

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display2 = new JLabel("Amount");
    display1Box.add(display2);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    display1Box.add(input2);

    Box display2Box = Box.createHorizontalBox();
    display2Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    display2Box.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.createstockusinginvestment2(input.getText(), input2.getText());
      f1.dispose();
    });


    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(display1Box);
    createfBox.add(display2Box);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void enddatefunctions(Map<String, String[]> portfolio,
                               ArrayList<String> sharepercent, String date,
                               String investamount, String portfoionumber) {

    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    Box sendbtnBox = Box.createHorizontalBox();
    sendbtnBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton penddatebtn = new JButton("Provide endDate");
    penddatebtn.setActionCommand("Provide endDate");
    sendbtnBox.add(penddatebtn);
    penddatebtn.addActionListener(evt -> {
      fobject.provideenddatefromuser(portfolio, sharepercent, date, investamount, portfoionumber);
      f1.dispose();
    });

    Box nendbtnBox = Box.createHorizontalBox();
    nendbtnBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JButton enddatebtn = new JButton("No endDate");
    enddatebtn.setActionCommand("No endDate");
    nendbtnBox.add(enddatebtn);
    enddatebtn.addActionListener(evt -> {
      fobject.noenddatefromuser(portfolio, sharepercent, date, investamount, portfoionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(sendbtnBox);
    createfBox.add(nendbtnBox);

    f1.add(createfBox);
    f1.setVisible(true);


  }

  @Override
  public void getenddatefromuser(Map<String, String[]> portfolio,
                                 ArrayList<String> sharepercent, String date,
                                 String investamount, String portfolionumber) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("End date");
    displayBox.add(display1);
    input = new JTextField();
    input.setPreferredSize(new Dimension(100, 30));
    displayBox.add(input);

    Box submitBox = Box.createHorizontalBox();
    submitBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    submitBox.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.getintervalchoice(portfolio, sharepercent, date,
              investamount, input.getText(), portfolionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(submitBox);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void getintervalfromuser(Map<String, String[]> portfolio,
                                  ArrayList<String> sharepercent, String date,
                                  String investamount, String edate, String portfolionumber) {

    JFrame f1 = new JFrame();

    f1.setSize(500, 450);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JLabel display4;
    JLabel display5;


    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Please choose Frequency");
    displayBox.add(display1);
    String[] portfoliocount = new String[5];
    for (int i = 1; i <= 4; i++) {
      portfoliocount[i] = Integer.toString(i);
    }
    JComboBox c1 = new JComboBox(portfoliocount);
    displayBox.add(c1);

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display2 = new JLabel("1->Days");
    display1Box.add(display2);

    Box display2Box = Box.createHorizontalBox();
    display2Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display3 = new JLabel("2->Weeks");
    display2Box.add(display3);

    Box display3Box = Box.createHorizontalBox();
    display3Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display4 = new JLabel("3->Months");
    display3Box.add(display4);

    Box display4Box = Box.createHorizontalBox();
    display4Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display5 = new JLabel("4->Years");
    display4Box.add(display5);



    Box submitBox = Box.createHorizontalBox();
    submitBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    submitBox.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.calculateinvestment2(portfolio, sharepercent, date, investamount,
              edate, c1.getSelectedItem().toString(), portfolionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(display1Box);
    createfBox.add(display2Box);
    createfBox.add(display3Box);
    createfBox.add(display4Box);

    createfBox.add(displayBox);
    createfBox.add(submitBox);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  //useless
  @Override
  public void displaysuccessstockadded(String message) {

    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridLayout(4, 0));

    display = new JLabel(message);
    f1.add(display);

    okaybtn = new JButton("Okay");
    okaybtn.setActionCommand("Okay");
    f1.add(okaybtn);
    okaybtn.addActionListener(evt -> {
      f1.dispose();
      input.setText("");
      input2.setText("");

    });

    f1.setVisible(true);


  }

  @Override
  public void displayinvalidmsg(String message) {
    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    displayBox.add(display);

    Box pfNameBox = Box.createHorizontalBox();
    pfNameBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    okaybtn = new JButton("Next");
    okaybtn.setActionCommand("Next");
    okaybtn.setPreferredSize(new Dimension(40, 40));
    pfNameBox.add(okaybtn);


    Box createBox = Box.createVerticalBox();
    createBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createBox.add(displayBox);
    createBox.add(pfNameBox);

    JFrame f1 = new JFrame("Error page");
    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.add(createBox);

    okaybtn.addActionListener(evt -> {

      f1.dispose();
      if (input != null) {
        input.setText("");
      }
      if (input2 != null) {
        input2.setText("");
      }
      if (input3 != null) {
        input3.setText("");
      }


    });


    f1.setVisible(true);


  }


  @Override
  public void view(int count) {
    JFrame f1 = new JFrame();

    f1.setSize(450, 250);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    f1.setLayout(new GridBagLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("View portfolio");
    displayBox.add(display);

    String[] portfoliocount = new String[count];
    for (int i = 1; i < count; i++) {
      portfoliocount[i] = Integer.toString(i);
    }

    JComboBox c1 = new JComboBox(portfoliocount);
    displayBox.add(c1);

    Box display2Box = Box.createHorizontalBox();
    display2Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Enter date");
    display2Box.add(display1);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    display2Box.add(input2);

    Box display3Box = Box.createHorizontalBox();
    display3Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    display3Box.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.viewportfolio(c1.getSelectedItem().toString(), input2.getText());
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(display2Box);
    createfBox.add(display3Box);
    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void displayportfolio(Map<String, String[]> portfolio) {

    JFrame f1 = new JFrame("Display Portfolio");

    f1.setSize(800, 300);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    f1.setLayout(new GridLayout(8, 0));

    for (Map.Entry<String, String[]> entry : portfolio.entrySet()) {

      display1 = new JLabel(entry.getKey());
      f1.add(display1);

      display2 = new JLabel(entry.getValue()[0]);
      f1.add(display2);

      display3 = new JLabel(entry.getValue()[2]);
      f1.add(display3);


    }

    gobackbtn = new JButton("Back to Menu");
    gobackbtn.setActionCommand("Back to Menu");
    f1.add(gobackbtn);
    gobackbtn.addActionListener(evt -> {
      fobject.displaymenu();
      f1.dispose();
    });


    f1.pack();
    f1.setVisible(true);


  }


  @Override
  public void costbasis(int count) {
    JFrame f1 = new JFrame("Cost basis");

    f1.setSize(500, 400);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridBagLayout());

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Select portfolio");
    display1Box.add(display);

    String[] portfoliocount = new String[count + 1];

    for (int i = 1; i < count; i++) {
      portfoliocount[i] = Integer.toString(i);
    }
    JComboBox c1 = new JComboBox(portfoliocount);
    display1Box.add(c1);

    Box display2Box = Box.createHorizontalBox();
    display2Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Enter date");
    display2Box.add(display1);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    display2Box.add(input2);


    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display2 = new JLabel("Enter commission fee");
    displayBox.add(display2);

    JButton yesbtn = new JButton("Yes");
    yesbtn.setActionCommand("Yes");
    displayBox.add(yesbtn);
    yesbtn.addActionListener(evt -> {
      fobject.yescommissionfee(c1.getSelectedItem().toString(), input2.getText(), count);
      f1.dispose();
    });

    JButton nobtn = new JButton("No");
    nobtn.setActionCommand("No");
    displayBox.add(nobtn);
    nobtn.addActionListener(evt -> {
      fobject.nocommissionfee(c1.getSelectedItem().toString(), input2.getText(), count);
      f1.dispose();
    });


    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(display1Box);
    createfBox.add(display2Box);
    createfBox.add(displayBox);


    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void displayinvaliddatecostbasis(int count) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridLayout(4, 0));

    display = new JLabel("Invalid date");
    f1.add(display);

    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    f1.add(nextbtn);
    nextbtn.addActionListener(evt -> {
      costbasis(count);
      f1.dispose();
    });

    f1.setVisible(true);
  }

  @Override
  public void askcommissionfee(String portfolionumber, String date) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridLayout(4, 0));

    display = new JLabel("Enter Comission fee");
    input = new JTextField();
    input.setPreferredSize(new Dimension(100, 30));
    f1.add(input);
    f1.add(display);

    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    f1.add(nextbtn);
    nextbtn.addActionListener(evt -> {
      fobject.checkcommissionfee(input.getText(), portfolionumber, date);
      f1.dispose();
    });

    f1.setVisible(true);

  }

  @Override
  public void displayinvalidcommissionfeemessage(String portfolionumber, String date) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Invalid Comission fee");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      askcommissionfee(portfolionumber, date);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void displayvalue(Double cbf) {

    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box displaybox = Box.createHorizontalBox();
    displaybox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    display = new JLabel("Amount calculated is $" + cbf);
    displaybox.add(display);

    Box gobackbtnbox = Box.createHorizontalBox();
    gobackbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    gobackbtn = new JButton("Back to Menu");
    gobackbtn.setActionCommand("Back to Menu");
    gobackbtnbox.add(gobackbtn);
    gobackbtn.addActionListener(evt -> {
      fobject.displaymenu();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displaybox);
    createfBox.add(gobackbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);


  }

  @Override
  public void worth(int count) {
    JFrame f1 = new JFrame("Worth of Portfolio");

    f1.setSize(500, 280);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridBagLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Select portfolio");
    displayBox.add(display);

    String[] portfoliocount = new String[count + 1];

    for (int i = 1; i < count; i++) {
      portfoliocount[i] = Integer.toString(i);
    }
    JComboBox c1 = new JComboBox(portfoliocount);
    displayBox.add(c1);

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Enter date");
    display1Box.add(display1);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    display1Box.add(input2);

    Box display2Box = Box.createHorizontalBox();
    display2Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    display2Box.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.calcualteworth(c1.getSelectedItem().toString(), input2.getText());
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(display1Box);
    createfBox.add(display2Box);

    f1.add(createfBox);
    f1.setVisible(true);
  }


  @Override
  public void buyshares(int count) {

    JFrame f1 = new JFrame("Buy Shares ");

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridLayout(6, 0));

    display = new JLabel("Choose Portfolio");
    f1.add(display);

    // create drop down and get the portfolio number.
    String[] portfoliocount = new String[count + 1];

    for (int i = 1; i < count; i++) {
      portfoliocount[i] = Integer.toString(i);
    }


    JComboBox c1 = new JComboBox(portfoliocount);

    f1.add(c1);


    display1 = new JLabel("Enter stockname");
    f1.add(display1);
    input = new JTextField();
    input.setPreferredSize(new Dimension(100, 30));
    f1.add(input);

    display2 = new JLabel("Enter Number of shares");
    f1.add(display2);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    f1.add(input2);

    display3 = new JLabel("Enter Date");
    f1.add(display3);
    input3 = new JTextField();
    input3.setPreferredSize(new Dimension(100, 30));
    f1.add(input3);


    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    f1.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.buysharesinfo(input.getText(), input2.getText(),
              input3.getText(), c1.getSelectedItem().toString());
      f1.dispose();
    });


    f1.setVisible(true);
  }

  @Override
  public void sellshares(int count) {

    JFrame f1 = new JFrame("Sell shares");

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Choose Portfolio");
    displayBox.add(display);


    String[] portfoliocount = new String[count + 1];
    for (int i = 1; i < count; i++) {
      portfoliocount[i] = Integer.toString(i);
    }
    JComboBox c1 = new JComboBox(portfoliocount);
    displayBox.add(c1);

    Box submitBox = Box.createHorizontalBox();
    submitBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    submitBox.add(submitbtn);
    // changing here
    submitbtn.addActionListener(evt -> {
      fobject.sellsharesfun2(c1.getSelectedItem().toString());
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(submitBox);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void sellsharesfun2(String portfolionumber) {
    JFrame f1 = new JFrame("Sell Shares ");

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridLayout(4, 0));


    display1 = new JLabel("Enter stockname");
    f1.add(display1);
    input = new JTextField();
    input.setPreferredSize(new Dimension(100, 30));
    f1.add(input);

    display2 = new JLabel("Enter Number of shares");
    f1.add(display2);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    f1.add(input2);

    display3 = new JLabel("Enter Date");
    f1.add(display3);
    input3 = new JTextField();
    input3.setPreferredSize(new Dimension(100, 30));
    f1.add(input3);


    submitbtn = new JButton("submit");
    submitbtn.setActionCommand("submit");
    f1.add(submitbtn);
    submitbtn.addActionListener(evt -> {
      fobject.sellsharesinfo(input.getText(), input2.getText(),
              input3.getText(), portfolionumber);
      f1.dispose();
    });

    f1.setVisible(true);

  }

  @Override
  public void investment1strategy(int pcount) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 300);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridBagLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Choose portfolio");
    displayBox.add(display1);
    String[] portfoliocount = new String[pcount + 1];

    for (int i = 1; i < pcount; i++) {
      portfoliocount[i] = Integer.toString(i);
    }
    JComboBox c1 = new JComboBox(portfoliocount);
    displayBox.add(c1);

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Enter the total amount to be invested");
    display1Box.add(display1);
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    display1Box.add(input2);

    Box display2Box = Box.createHorizontalBox();
    display2Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display2 = new JLabel("Enter the Date");
    display2Box.add(display2);
    input3 = new JTextField();
    input3.setPreferredSize(new Dimension(100, 30));
    display2Box.add(input3);


    submitbtn = new JButton("Next");
    submitbtn.addActionListener(evt -> {
      fobject.investment1strategyf1(c1.getSelectedItem().toString(),
              input3.getText(), input2.getText());
      f1.dispose();
    });
    display2Box.add(submitbtn);

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(display1Box);
    createfBox.add(display2Box);


    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void displaytotalpercentageerror(String pnum, String date, String amt) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Sum does not add upto 100%, Please enter again");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment1strategyf1(pnum, date, amt);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void displaypercentageerrormessage(String portfoionumber, String date, String amount) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Invalid percentage Please enter again");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment1strategyf1(portfoionumber, date, amount);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void nostocksforinvestment1() {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Portfolio has no stocks for investing in the duration");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment1();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }


  @Override
  public void investment2strategy(int pcount) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 400);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridBagLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("Enter amount to invest");
    displayBox.add(display1);

    Box display11Box = Box.createHorizontalBox();
    display11Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    input = new JTextField();
    input.setPreferredSize(new Dimension(100, 30));
    display11Box.add(input);

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display2 = new JLabel("Enter the Start Date");
    display1Box.add(display2);

    Box display12Box = Box.createHorizontalBox();
    display12Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    input2 = new JTextField();
    input2.setPreferredSize(new Dimension(100, 30));
    display12Box.add(input2);

    Box display2Box = Box.createHorizontalBox();
    display2Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display1 = new JLabel("choose portfolio");
    display2Box.add(display1);
    String[] portfoliocount = new String[pcount + 1];

    for (int i = 1; i < pcount; i++) {
      portfoliocount[i] = Integer.toString(i);
    }
    JComboBox c1 = new JComboBox(portfoliocount);

    display2Box.add(c1);

    Box display3Box = Box.createHorizontalBox();
    display3Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("Submit");
    submitbtn.addActionListener(evt -> {
      fobject.investment2getedate(input.getText(), input2.getText(),
              c1.getSelectedItem().toString());
      f1.dispose();
    });
    display3Box.add(submitbtn);


    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(display11Box);
    createfBox.add(display1Box);
    createfBox.add(display12Box);
    createfBox.add(display2Box);
    createfBox.add(display3Box);

    f1.add(createfBox);
    f1.setVisible(true);


  }


  @Override
  public void displaysuccessmessage(String message) {
    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    displayBox.add(display);

    Box pfNameBox = Box.createHorizontalBox();
    pfNameBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    okaybtn = new JButton("Menu");
    okaybtn.setActionCommand("Menu");
    okaybtn.setPreferredSize(new Dimension(40, 40));
    pfNameBox.add(okaybtn);


    Box createBox = Box.createVerticalBox();
    createBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createBox.add(displayBox);
    createBox.add(pfNameBox);


    JFrame f1 = new JFrame("Success Page");
    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.add(createBox);

    okaybtn.addActionListener(evt -> {
      fobject.displaymenu();
      f1.dispose();
    });

    f1.setVisible(true);

  }

  @Override
  public void displaystock(String stockname, Map<String, String[]> p,
                           String pnum, String date, String amt) {

    JFrame f1 = new JFrame();
    f1.setSize(500, 230);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    f1.setLayout(new GridBagLayout());

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Number of stock in this portfolio is " + p.size());
    displayBox.add(display);

    Box stockBox = Box.createHorizontalBox();
    stockBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("enter stock percentage for " + stockname);
    stockBox.add(display);
    input = new JTextField();
    input.setPreferredSize(new Dimension(50, 50));
    stockBox.add(input);

    Box btnBox = Box.createHorizontalBox();
    btnBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("next");
    submitbtn.addActionListener(evt -> {
      fobject.storeperc(input.getText(), p, pnum, date, amt);
      f1.dispose();
    });

    btnBox.add(submitbtn);

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(displayBox);
    createfBox.add(stockBox);
    createfBox.add(btnBox);

    f1.add(createfBox);
    f1.setVisible(true);


  }

  @Override
  public void displaystockinvestment2(String sname, Map<String, String[]> p,
                                      String pnum, String date, String amt) {

    JFrame f1 = new JFrame();
    f1.setSize(450, 300);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridBagLayout());

    Box display1Box = Box.createHorizontalBox();
    display1Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Number of stocks in Portfolio " + p.size());
    display1Box.add(display);

    Box displayBox = Box.createHorizontalBox();
    displayBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));
    display = new JLabel("enter stock percentage for " + sname);
    displayBox.add(display);

    Box display11Box = Box.createHorizontalBox();
    display11Box.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));
    input = new JTextField();
    display11Box.add(input);

    Box sbtnBox = Box.createHorizontalBox();
    sbtnBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    submitbtn = new JButton("invest");
    submitbtn.addActionListener(evt -> {
      fobject.storepercinvestment2(input.getText(), p, pnum, date, amt);
      f1.dispose();
    });
    sbtnBox.add(submitbtn);

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(display1Box);
    createfBox.add(displayBox);
    createfBox.add(display11Box);
    createfBox.add(sbtnBox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void getenddatefromuserinvestment2(ArrayList<String> sharepercent, Map<String,
          String[]> p, String pnum, String date, String amt) {
    enddatefunctions(p, sharepercent, date, amt, pnum);
  }

  @Override
  public void exitbutton() {
    System.exit(0);
  }

  @Override
  public void displayinvalidinvestmentinfo(String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.getstockinvestment1();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }


  @Override
  public void displayinvalidmsgshares(String message, String date, String investmentamount) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      getstocksforinvestment1(date, investmentamount);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void wrongviewinfoentered(String message, int portfiocount) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      view(portfiocount);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void invaliddateworth(String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.worth();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void wrongstockinfobuy(String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.buyshares();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void displaysellsharestock(Map<String, String[]> p, String portfolionumber) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f1.setLayout(new GridLayout(8, 0));

    display = new JLabel("Portfolio is");
    f1.add(display);

    for (Map.Entry<String, String[]> entry : p.entrySet()) {

      display1 = new JLabel(entry.getKey());
      f1.add(display1);

      display2 = new JLabel(entry.getValue()[0]);
      f1.add(display2);

      display3 = new JLabel(entry.getValue()[2]);
      f1.add(display3);


    }

    gobackbtn = new JButton("Next");
    gobackbtn.setActionCommand("Next");
    f1.add(gobackbtn);
    gobackbtn.addActionListener(evt -> {
      fobject.doafterdisplayingstock(portfolionumber);
      f1.dispose();
    });


    f1.pack();
    f1.setVisible(true);
  }

  @Override
  public void invalidinfosel(String message, String portfolionumber) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.sellsharesfun2(portfolionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);

  }

  @Override
  public void displaysuccessstockaddedinvestment1(String pnum, String date, String amt) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Sucessfully added");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment1strategyf1(pnum, date, amt);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void displayerrorinvestment(String message) {

    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment1();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void displaytotalpercentageerrorinvestment2(String amount,
                                                     String date, String portfolionumber) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Sum does not add upto 100%, Please enter again");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment2getedate(amount, date, portfolionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void invaliddateamtinvestment2(String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment2();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void invalidenddateinvestment2(
          Map<String, String[]> portfolio,
          ArrayList<String> sharepercent, String date,
          String investamount, String portfolionumber, String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.provideenddatefromuser(portfolio, sharepercent, date,
              investamount, portfolionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void invalidpercentageinvestment2(String amount, String date,
                                           String portfolionumber) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("Invalid percentage entered!Enter from first");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.investment2getedate(amount, date, portfolionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void enddatebeforestartdateinvestment2(
          Map<String, String[]> portfolio,
          ArrayList<String> sharepercent,
          String date, String investamount, String portfolionumber) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel("End date , before start date! Invalid date");
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.provideenddatefromuser(portfolio, sharepercent, date,
              investamount, portfolionumber);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void invaliddateamtinvestment2viacreation(String messagae) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(messagae);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.getstockinvestment2();
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void invalidstockpercentinvestment2viacreating(String date,
                                                        String investamount, String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.createstockusinginvestment2(date, investamount);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void displaysuccessstockaddedinvestment1viacreation(String date,
                                                             String amount, String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.createstockusinginvestment1(date, amount);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

  @Override
  public void displaysuccessstockaddedviainvestment2(String date,
                                                     String amount, String message) {
    JFrame f1 = new JFrame();

    f1.setSize(500, 200);
    f1.setLocation(200, 200);
    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    Box messagebox = Box.createHorizontalBox();
    messagebox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    display = new JLabel(message);
    messagebox.add(display);

    Box nextbtnbox = Box.createHorizontalBox();
    nextbtnbox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    nextbtn = new JButton("Next");
    nextbtn.setActionCommand("Next");
    nextbtn.setPreferredSize(new Dimension(40, 40));
    nextbtnbox.add(nextbtn);

    nextbtn.addActionListener(evt -> {
      fobject.createstockusinginvestment2(date, amount);
      f1.dispose();
    });

    Box createfBox = Box.createVerticalBox();
    createfBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    createfBox.add(messagebox);
    createfBox.add(nextbtnbox);

    f1.add(createfBox);
    f1.setVisible(true);
  }

}
