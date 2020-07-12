
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                .map(line -> line.split(","))
                .sorted((p1, p2) -> Float.valueOf(p1[5]).compareTo(Float.valueOf(p2[5])))
                .map(p -> p[3] + " (" + p[4] + ")," + p[2].replace(" (%)", "") + ", " + p[5])
                .forEach(i -> System.out.println(i));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
