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
          addItool(scanner);        
          break;
        case 2:
          showItools();
          break;
        case 3:
          Calculate(scanner);
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
  private static void addItool(Scanner scanner){
    System.out.println("Enter Itool name: ");
    String itoolname = scanner.nextLine();
    System.out.println("Enter Itool porcentage amount:% ");
    double amount = scanner.nextDouble();

    Itool itool = new Itool(itoolname, amount);
    itoolist.add(itool);
  }

  private static void showItools(){
    if (!itoolist.isEmpty()) {
      for (Itool itool : itoolist) {
        System.out.println(itool);
      }
      return;
    }
    System.out.println("[!] No Itools to show!");
  }

  public static void Calculate(Scanner scanner){
    System.out.println("Amount to invest:$ ");
    double uamaunt = scanner.nextDouble();

    double rtotal=0;
    for (Itool itool : itoolist) {
       double rperitool=0;
       rperitool= uamaunt*itool.getPorcentaje()/100;
       rtotal= rtotal+rperitool;
       System.out.println("Para "+itool.getNombre()+" con porcentaje de: "+itool.getPorcentaje()+"% se tiene que invertir: $"+rperitool);

    }
    if((uamaunt - rtotal) !=0){
      System.out.println("Sobran para invertir: $"+(uamaunt - rtotal));
    }
  }

  
}
