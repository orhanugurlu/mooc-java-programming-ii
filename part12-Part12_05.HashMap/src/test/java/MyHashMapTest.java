import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {

    @Test
    public void addTests() {
        HashMap<String, String> map = new HashMap<>();
        Assert.assertEquals(0, map.size());
        Assert.assertNull(map.get("key"));
        
        map.add("key1", "value1");
        Assert.assertEquals(1, map.size());
        Assert.assertEquals("value1", map.get("key1"));
        
        map.add("key1", "value1_new");
        Assert.assertEquals(1, map.size());
        Assert.assertEquals("value1_new", map.get("key1"));
        
        map.add("key2", "value2");
        Assert.assertEquals(2, map.size());
        Assert.assertEquals("value2", map.get("key2"));
    }

    @Test
    public void growTest() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.add("key" + i, "value" + i);
        }
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals("Value is not as expected for key=key" + i,
                    "value" + i, map.get("key" + i));
        }        
    }
    
    @Test
    public void removeTest() {
        HashMap<String, String> map = new HashMap<>();
        map.add("key1", "value1");
        Assert.assertEquals(1, map.size());
        String removedItem = map.remove("key1");
        Assert.assertEquals(0, map.size());
        Assert.assertEquals("value1", removedItem);
        removedItem = map.remove("key1");
        Assert.assertEquals(0, map.size());
        Assert.assertNull(removedItem);        
    }
    
    @Test
    public void performanceTest() {
        List<String> myList = new List<>();
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < 1000000; i++) {
            myList.add("" + i);
            hashMap.add("" + i, "" + i);
        }

        List<String> elements = new List<>();
        Random randomizer = new Random();
        for (int i = 0; i < 1000; i++) {
            elements.add("" + randomizer.nextInt(2000000));
        }

        long listSearchStartTime = System.nanoTime();
        for (int i = 0; i < elements.size(); i++) {
            myList.contains(elements.value(i));
        }
        long listSearchEndTime = System.nanoTime();

        long hashMapSearchStartTime = System.nanoTime();
        for (int i = 0; i < elements.size(); i++) {
            hashMap.get(elements.value(i));
        }
        long hashMapSearchEndTime = System.nanoTime();

        long listSearch = listSearchEndTime - listSearchStartTime;
        System.out.println("List: the search took about " + listSearch / 1000000 + " milliseconds (" +
            listSearch + " nanoseconds.)");

        long hashMapSearch = hashMapSearchEndTime - hashMapSearchStartTime;
        System.out.println("Hash map: the search took about " + hashMapSearch / 1000000 +
            " milliseconds (" + hashMapSearch + " nanoseconds.)");  

        Assert.assertTrue(listSearch/hashMapSearch > 1000);
    }
    
}
