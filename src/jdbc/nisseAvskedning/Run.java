package jdbc.nisseAvskedning;

import java.util.Scanner;

public class Run {
    Scanner scan = new Scanner(System.in);
    Uppkoppling u = new Uppkoppling();
    String name;
    String newName;
    public Run(){

        while (true) {
            System.out.println("Enter the name of the elf you want to tack away: ");
            name = scan.nextLine().trim();

            try {
                u.deleteNisseByName(name);
            } catch (NullPointerException e) {
                System.out.println("Det gick inte att ändra namn på nisse");
            }
        }

    }

    public static void main(String[] args) {
        Run r = new Run();
    }
}
