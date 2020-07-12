import java.util.HashMap;

public class Abbreviations {

    private HashMap<String, String> map;

    public Abbreviations() {
        map = new HashMap<>();
    }
    
    private String sanitizedString(String str) {
        if (str == null) {
            return "";
        } else {
            return str.trim().toLowerCase();
        }
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        map.put(sanitizedString(abbreviation), explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return map.containsKey(sanitizedString(abbreviation));
    }
    
    public String findExplanationFor(String abbreviation) {
        return map.get(sanitizedString(abbreviation));
    }
    
}
