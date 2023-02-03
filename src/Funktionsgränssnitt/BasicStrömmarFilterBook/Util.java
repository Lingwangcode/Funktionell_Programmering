package Funktionsgränssnitt.BasicStrömmarFilterBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

   // List<Book> bookList = new ArrayList<>();
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

            /*bookList.add(book1);
            bookList.add(book2);
            bookList.add(book3);
            bookList.add(book4);
            bookList.add(book5);
            return bookList;

             */
            return Arrays.asList(book1, book2, book3, book4, book5);

        }

        public List<Book> getBooksWithSameAuthor(String name){
            return getBookList().stream().filter(b-> b.getFörfattare().equalsIgnoreCase(name.trim())).toList();
        }

        public List<Book> getBooksWithSameColor(String color){
            return getBookList().stream().filter(b-> b.getFärg().equalsIgnoreCase(color.trim())).toList();
        }
        public long countBooksByAuthor(String name){
            return getBookList().stream().filter(b -> b.getFörfattare().equalsIgnoreCase(name.trim())).count();
        }
        public int countBooksByOwner(String name){
            return getBookList().stream().filter(b -> b.getÄgare().equalsIgnoreCase(name.trim())).toList().size();
        }

        public Util(){
            getBooksWithSameAuthor("Jane austen").forEach(b -> System.out.println(b.getTitel()));
            System.out.println();
            getBooksWithSameColor("blå").forEach(b-> System.out.println(b.getTitel()));
            System.out.println(countBooksByAuthor("Jane austen"));
            System.out.println(countBooksByOwner("ceasar"));

            getBooksTitel().forEach(b -> System.out.println(b));
            System.out.println();
            getBooksFörfattare().forEach(b -> System.out.println(b));
            System.out.println();
            getMybooks().forEach(b-> System.out.println(b));
        }

        public List<String> getBooksTitel(){

            return getBookList().stream().map(b -> b.getTitel()).toList();
        }

        public List<String> getBooksFörfattare(){

            return getBookList().stream().map(b -> b.getFörfattare()).distinct().toList();
        }

        public List<String> getMybooks(){

            return getBookList().stream().filter(b -> b.getÄgare().equals("Ling")).map(Book::getTitel).toList();
        }

        public static void main(String[] args) {
            Util u = new Util();
        }


}
