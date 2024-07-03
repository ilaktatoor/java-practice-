import java.util.ArrayList;
import java.util.Scanner;

public class Main{
  private static ArrayList<Itool> itoolist = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n1. Add Itool\n2. Show Itools\n3. Calculate \n4. Exit");
      int choise = scanner.nextInt();
      scanner.nextLine();

      switch (choise) {
        case 1:
          addItool();        
          break;
        case 2:
          showItools();
          break;
        case 3:
          Calculate();
          break;
        case 4:
          System.out.println("Exiting...");
          scanner.close();
          return;

        default:
          System.out.println("[!] Invalid choise, please try again.");
      }
      
    }
  }

  //functions
  private void addItool(){
    System.out.println("Enter Itool name: ");
    String itoolname = scanner.nextLine();
    System.out.println("Enter Itool porcentage amount:% ");
    double amount = scanner.nextDouble();

    Itool itool = new Itool(name, amount);
    itoolist.add(itool);
  }

  private void showItools(){
    if (!itoolist.isEmpty()) {
      for (Itool itool : itoolist) {
        System.out.println(itool);
      }
      return;
    }
    System.out.println("[!] No Itools to show!");
  }

  
}
