package BasicStrömmar._Sorting_Joining;


import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class LogicBook {

    Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling",
            "blå","fantasy", 2, "Ling", false );
    Book book2 = new Book("To Kill a Mockingbird", "Harper Lee",
            "blå","roman", 2, "Bea", false );
    Book book3 = new Book("Pride and Prejudice", "Jane Austen",
            "vit","roman", 5, "Ceasar", false );
    Book book4 = new Book("Öride and Prejudice", "Jane Austen",
            "vit","roman", 8, "Ceasar", false );
    Book book5 = new Book("emma", "Jane Austen",
            "vit","roman", 10, "Ling", false );

    public List<Book> getBookList(){

        return Arrays.asList(book1, book2, book3, book4, book5);

    }

    public void sortedBookInSv(){
        Collator c = Collator.getInstance(new Locale("sv", "SE"));
        getBookList().stream().map(Book::getTitel).sorted(c).forEach(b-> System.out.println(b));
    }

    public void sortedBookInSv2(){
        getBookList().stream().sorted(Comparator.comparing(Book::getTitel)).forEach(b-> System.out.println(b.getTitel()));
    }

    public void sortBookInRating(){
        getBookList().stream().map(Book::getBetyg).sorted().forEach(b -> System.out.println(b));
    }

    public void sortBookInRating2(){
        getBookList().stream().sorted((b1, b2) -> ((Integer)b1.getBetyg()).compareTo(b2.getBetyg()))
                .forEach(b -> System.out.println(b.getTitel()));
    }

    public long findMyBooks(){
       return getBookList().stream().filter(b -> b.getÄgare().equals("Ceasar") && b.getGenre().equals("vit")).count();
    }

    public boolean hasJanesBook(){
       return getBookList().stream().anyMatch(b -> b.författare.equals("Jane"));
    }
    public String printOutAllTitel(){

        return getBookList().stream().map(Book::getTitel).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        LogicBook l = new LogicBook();
       // System.out.println(l.findMyBooks());
        //System.out.println(l.hasJanesBook());
        l.sortBookInRating();
        System.out.println();
        l.sortBookInRating2();
        System.out.println();
        l.sortedBookInSv();
        System.out.println();
        l.sortedBookInSv2();
        System.out.println();
        System.out.println(l.printOutAllTitel());
    }
}
