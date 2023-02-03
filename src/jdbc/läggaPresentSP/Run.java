package jdbc.läggaPresentSP;

import java.util.Scanner;

public class Run {
    Scanner scan = new Scanner(System.in);
    Uppkoppling u = new Uppkoppling();
    String name;
    String newName;
    public Run(){

        while (true) {
            System.out.println("Enter the gift name: ");
            name = scan.nextLine().trim();

            try {
                u.addPresentByName(name);
            } catch (NullPointerException e) {
                System.out.println("Något gick fel");
            }
        }

    }

    public static void main(String[] args) {
        Run r = new Run();
    }
}
