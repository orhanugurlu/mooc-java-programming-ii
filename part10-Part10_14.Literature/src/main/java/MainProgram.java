
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("Input the age recommendation: ");
            int age = Integer.valueOf(scanner.nextLine());
            books.add(new Book(name, age));
        }
        
        System.out.println(books.size() + " books in total.");
        Collections.sort(books, Comparator.comparing(Book::getAge)
              .thenComparing(Book::getName));
        System.out.println("Books:");
        books.stream().forEach(b -> System.out.println(b.getName() 
                + " (recommended for " + b.getAge()
                + " year-olds or older"));
    }

}
