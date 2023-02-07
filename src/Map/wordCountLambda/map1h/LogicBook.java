package Map.wordCountLambda.map1h;


import BasicStrömmar._Sorting_Joining.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class LogicBook {

    Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling",
            "blå","fantasy", 2, "Ling", true );
    Book book2 = new Book("To Kill a Mockingbird", "Harper Lee",
            "grå","roman", 2, "Bea", false );
    Book book3 = new Book("Pride and Prejudice", "Jane Austen",
            "vit","roman", 1, "Ceasar", true );
    Book book4 = new Book("Pride and Prejudice", "Jane",
            "svart","roman", 1, "Ceasar", false );
    Book book5 = new Book("Emma", "Jane Aus",
            "röd","roman", 1, "Ling", false );

    public List<Book> getBookList(){

        return Arrays.asList(book1, book2, book3, book4, book5);

    }
    public Map<String, Book> colorBook(){
        return getBookList().stream().collect(Collectors.toMap((b -> b.getGenre()), b -> b));
    }

    public Map<Boolean, List<Book>> fBookMap(){

        return getBookList().stream().collect(partitioningBy(b -> b.isFakta()));
    }

    public Map<String, Book> getBooksByAuthor(){

        return getBookList().stream().collect(Collectors.toMap(b -> b.getFörfattare(),b -> b));

    }

    public long findMyBooks(){
       return getBookList().stream().filter(b -> b.getÄgare().equals("Ceasar") && b.getGenre().equals("vit")).count();
    }

    public boolean hasJanesBook(){
       return getBookList().stream().anyMatch(b -> b.getFörfattare().equals("Jane"));
    }

    public static void main(String[] args) {
        LogicBook l = new LogicBook();
        //System.out.println(l.findMyBooks());
        //System.out.println(l.hasJanesBook());
        l.fBookMap().forEach((k,v)->System.out.println(k + " " + v.get(0).getTitel()));
        l.getBooksByAuthor().forEach((k,v)->System.out.println(k + " " + v.getTitel()));
        System.out.println();
        l.colorBook().forEach((k, v) -> System.out.println(k + " " + v.getTitel()));
    }
}
