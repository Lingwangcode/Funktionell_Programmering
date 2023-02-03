package jdbc.namnbytesprogram;

import java.util.Scanner;

public class Run {
    Scanner scan = new Scanner(System.in);
    Uppkoppling u = new Uppkoppling();
    String name;
    String newName;
    public Run(){

        while (true) {
            System.out.println("Enter the Elfs name you want to change: ");
            name = scan.nextLine().trim();
            System.out.println("Enter a new name");
            newName = scan.nextLine().trim();
            try {
                u.changeNissesName(name, newName);
            } catch (NullPointerException e) {
                System.out.println("Det gick inte att ändra namn på nisse");
            }
        }

    }

    public static void main(String[] args) {
        Run r = new Run();
    }
}
