package dictionary;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SaveableDictionary {
    
    private String file;
    private HashMap<String,String> entries1;
    private HashMap<String,String> entries2;

    public SaveableDictionary() {
        entries1 = new HashMap<>();
        entries2 = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }    

    public boolean load() {
        boolean result = true;
        try {
            Files.lines(Paths.get(file)).forEach(row -> 
                    this.add(row.split(":")[0], row.split(":")[1]));
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    public boolean save() {
        boolean result = true;
        try {
            PrintWriter writer = new PrintWriter(file);
            for (Map.Entry<String, String> entry : entries1.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            writer.close(); 
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    public void add(String word, String translation) {
        if (!entries1.containsKey(word) && !entries2.containsKey(translation)) {
            entries1.put(word, translation);
            entries2.put(translation, word);
        }
    }
    
    public String translate(String word) {
        String translation = entries1.get(word);
        if (translation == null) {
            translation = entries2.get(word);
        }
        return translation;
    }
    
    public void delete(String word) {
        if (entries1.containsKey(word)) {
            String translation = entries1.get(word);
            entries1.remove(word);
            entries2.remove(translation);
        } else if (entries2.containsKey(word)) {
            String translation = entries2.get(word);
            entries2.remove(word);
            entries1.remove(translation);
        }
    }
}
