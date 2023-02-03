package Inlämning1_webbshop;

import java.util.Scanner;

public class WebshopMain {

    Scanner scan = new Scanner(System.in);
    Repository repository = new Repository();
    String customerName;
    String passWord;
    String searchNr;
    String customerInput;
    Customer customer;
    public WebshopMain(){

        System.out.println("Please enter your first name:");
        customerName = scan.nextLine().trim();
        System.out.println("Please enter your password:");
        passWord = scan.nextLine().trim();

        try {
            repository.getCustomer(customerName, passWord).printOut();
        }catch (NullPointerException e){
            System.out.println("Invalid name or password.");
            System.exit(0);
        }
        while(scan.hasNextLine()) {
            searchNr = scan.nextLine().trim();
            if (searchNr.equals("1") || searchNr.equals("2") || searchNr.equals("3")) {
                repository.printOutAllColorOrBrandOrSize(searchNr);
                break;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
        while (scan.hasNextLine()) {
            customerInput = scan.nextLine().trim();
            if (repository.getAllProductToList().stream().filter(p->p.getColor().equalsIgnoreCase(customerInput)).count() > 0 ||
                    repository.getAllProductToList().stream().filter(p->p.getBrand().equalsIgnoreCase(customerInput)).count() > 0 ||
                    repository.getAllProductToList().stream().filter(p -> p.getSize().equalsIgnoreCase(customerInput)).count()> 0) {

                repository.printOutProduktByInput(searchNr, customerInput);
                break;
            }
            else {
                System.out.println("No product found. Please try again");
                repository.printOutAllColorOrBrandOrSize(searchNr);
            }
        }
        System.out.println("Choose the product by enter the number of the product");

        customerInput = scan.nextLine().trim();
        repository.addToCart(customerName, passWord, customerInput);

    }

    public static void main(String[] args) {
        WebshopMain w = new WebshopMain();
    }
}
