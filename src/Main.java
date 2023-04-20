import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.Maincontroller;
import controller.MaincontrollerGUI;
import controller.Maincontrollerinterface;
import model.Mainmodel;
import model.Mainmodelinterface;
import view.GUIviewInterface;
import view.Jframeview;
import view.Mainview;
import view.Mainviewinterface;


/**
 * Main is the main
 * part of the program
 * where the flow of control
 * begins.
 */
public class Main {

  /**
   * main method that initialises the main controller and begins execution of the program.
   *
   * @param args command line argument.
   * @throws IOException when file related operation results in failiure.
   */
  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    System.out.println("\nUser Choice");
    System.out.println("1.Use console as the Interface");
    System.out.println("2.Use GUI as the Interface");
    System.out.println("Please enter your choice::");
    int choice = sc.nextInt();
    if (choice == 1) {

      Mainmodelinterface m1 = new Mainmodel();
      Mainviewinterface v1 = new Mainview(System.out);

      Maincontrollerinterface c = new Maincontroller(m1, v1, new InputStreamReader(System.in));

      c.mainfun();
    } else if (choice == 2) {
      Mainmodelinterface m1 = new Mainmodel();
      MaincontrollerGUI c = new MaincontrollerGUI(m1);

      GUIviewInterface view = new Jframeview("Stock Master");
      c.setView(view);

    } else {
      System.out.println("Invalid choice");
    }
  }

}
