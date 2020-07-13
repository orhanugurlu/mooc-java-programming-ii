public class Program {

    public static void main(String[] args) {
        System.out.println("Test grow");
        List<String> myList = new List<>();
        for (int i = 0; i < 11; i++) {
            myList.add("hello");
        }

        System.out.println("Test contains");
        myList = new List<>();
        System.out.println(myList.contains("hello"));
        myList.add("hello");
        System.out.println(myList.contains("hello"));
        
        System.out.println("Test remove");
        myList = new List<>();
        System.out.println(myList.contains("hello"));
        myList.add("hello");
        System.out.println(myList.contains("hello"));
        myList.remove("hello");
        System.out.println(myList.contains("hello"));
        
        System.out.println("Test value and indexOfValue");
        myList = new List<>();
        System.out.println(myList.contains("hello"));
        myList.add("hello");
        System.out.println(myList.contains("hello"));
        int index = myList.indexOfValue("hello");
        System.out.println(index);
        System.out.println(myList.value(index));
        myList.remove("hello");
        System.out.println(myList.contains("hello"));
        
        System.out.println("Test size");
        myList = new List<>();
        myList.add("hello");
        myList.add("world");

        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.value(i));
        }        
    }
    
}
