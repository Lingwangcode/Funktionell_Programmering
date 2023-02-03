package jdbc.prepared_statement;

import java.util.Scanner;

public class Run {
    Scanner scan = new Scanner(System.in);
    Uppkoppling u = new Uppkoppling();
    String name;
    public Run(){

        while (true) {
            System.out.println("Enter the childs name: ");
            name = scan.nextLine().trim();
            try {
                u.getChildByName(name).printOut();
            } catch (NullPointerException e) {
                System.out.println(name + " is not found in the database");
            }
        }

    }

    public static void main(String[] args) {
        Run r = new Run();
    }
}
