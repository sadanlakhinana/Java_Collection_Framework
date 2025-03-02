import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapPOC {

	 public static void main(String[] args) {
	        // HashMap: Unordered, Fastest retrieval
	        System.out.println("<----------------------------------------------------------------->");

	        Map<Integer, String> hashMap = new HashMap<>();
	        System.out.println("==== HashMap (Unordered) ====");
	        performOperations(hashMap);

	        // LinkedHashMap: Maintains Insertion Order
	        System.out.println("<----------------------------------------------------------------->");

	        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
	        System.out.println("\n==== LinkedHashMap (Insertion Order) ====");
	        performOperations(linkedHashMap);

	        // TreeMap: Sorted by Key (Ascending Order)
	        System.out.println("<----------------------------------------------------------------->");

	        Map<Integer, String> treeMap = new TreeMap<>();
	        System.out.println("\n==== TreeMap (Sorted Order by Key) ====");
	        performOperations(treeMap);
	    }

	    private static void performOperations(Map<Integer, String> map) {
	        // Adding key-value pairs
	        map.put(3, "Banana");
	        map.put(1, "Apple");
	        map.put(2, "Orange");
	        map.put(4, "Mango");

	        // Display map contents
	        System.out.println("Initial Map: " + map);

	        // Retrieving values
	        System.out.println("Value for key 2: " + map.get(2));

	        // Updating a value
	        map.put(2, "Pineapple");
	        System.out.println("Updated Map after modifying key 2: " + map);

	        // Checking if a key exists
	        System.out.println("Contains key 3? " + map.containsKey(3));

	        // Checking if a value exists
	        System.out.println("Contains value 'Apple'? " + map.containsValue("Apple"));

	        // Removing an element
	        map.remove(3);
	        System.out.println("Map after removing key 3: " + map);

	        // Iterating using forEach
	        System.out.println("Iterating using forEach:");
	        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

	        // Iterating using EntrySet
	        System.out.println("Iterating using EntrySet:");
	        for (Map.Entry<Integer, String> entry : map.entrySet()) {
	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	        }
	    }
}
