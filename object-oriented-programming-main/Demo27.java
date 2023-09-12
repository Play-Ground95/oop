import java.util.Scanner;

public class Demo27 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Item Service");
        System.out.println("2. Cart Service");
        System.out.println("3. Report Service");

        do {
            System.out.println("Enter your service type");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice > 0 && choice < 4)
                break;
        } while (true);

        // if(choice==1) serviceType=ServiceType.ITEM;
        // else if (choice==2) serviceType=ServiceType.CART;
        // else serviceType= ServiceType.REPORT;

        // int choice;

        // do {
        //     System.out.println("Enter your service type");
        //     choice = scanner.nextInt();
        //     scanner.nextLine();
        // } while (choice < 1 || choice > 3);

        // ServiceType serviceType = (choice == 1) ? ServiceType.ITEM :
        //                         (choice == 2) ? ServiceType.CART :
        //                         ServiceType.REPORT;
    }
}

enum ServiceType {
    ITEM, CART, REPORT; // instance ekak hadenawa

    private int index;
}