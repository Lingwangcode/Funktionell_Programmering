package BasicStrömmar.primitivaVariablerAnymatch;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class LogicBook {

    Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling",
            "blå","fantasy", 2, "Ling", false );
    Book book2 = new Book("To Kill a Mockingbird", "Harper Lee",
            "blå","roman", 2, "Bea", false );
    Book book3 = new Book("Pride and Prejudice", "Jane Austen",
            "vit","roman", 1, "Ceasar", false );
    Book book4 = new Book("Pride and Prejudice", "Jane Austen",
            "vit","roman", 1, "Ceasar", false );
    Book book5 = new Book("Emma", "Jane Austen",
            "vit","roman", 1, "Ling", false );

    public List<Book> getBookList(){

        return Arrays.asList(book1, book2, book3, book4, book5);

    }

    public long findMyBooks(){
       return getBookList().stream().filter(b -> b.getÄgare().equals("Ceasar") && b.getGenre().equals("vit")).count();
    }

    public boolean hasJanesBook(){
       return getBookList().stream().anyMatch(b -> b.författare.equals("Jane"));
    }

    public static void main(String[] args) {
        LogicBook l = new LogicBook();
        System.out.println(l.findMyBooks());
        System.out.println(l.hasJanesBook());
    }
}
