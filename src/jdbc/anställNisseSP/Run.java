package jdbc.anställNisseSP;

import java.util.Scanner;

public class Run {
    Scanner scan = new Scanner(System.in);
    Uppkoppling u = new Uppkoppling();
    String name;
    String newName;
    public Run(){

        while (true) {
            System.out.println("Enter the elfs name: ");
            name = scan.nextLine().trim();

            try {
                u.addNisseByName(name);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Run r = new Run();
    }
}
