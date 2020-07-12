
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static List<Book> readBooks(String file) {
        List<Book> books = new ArrayList<>();

        try {
            Files.lines(Paths.get(file))
                .map(line -> line.split(","))
                .map(p -> new Book(p[0], Integer.valueOf(p[1]), Integer.valueOf(p[2]), p[3]))
                .forEach(b -> books.add(b));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return books;
    }    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

}
