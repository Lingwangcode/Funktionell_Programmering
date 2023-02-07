package BasicStrömmar.flatmap;

import java.util.List;

public class myBook {

    List<String> book = List.of("Book1", "Book2", "Book3");
    List<String > book2 = List.of("new book 1", "new book 2", "new book 3");
    List<List<String>> allbooks = List.of(book, book2);

    public List<String> getAllbooks(){
        return allbooks.stream().flatMap(b->b.stream()).toList();
    }

    public myBook(){
        //getAllbooks().forEach(b -> System.out.println(b));
        System.out.println(getAllbooks());
    }

    public static void main(String[] args) {
        myBook mb = new myBook();

    }
}
