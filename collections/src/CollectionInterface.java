import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class collections {
	public static void main(String[] args) {
        // Creating a Collection (ArrayList implementation)
        Collection<String> collection = new ArrayList<>();

        // Adding elements to the collection
        collection.add("Apple");
        collection.add("Orange");
        collection.add("Banana");
        collection.add("Mango");
        collection.add("Durian");
        collection.add("Papaya");
        collection.add("Apple"); // Duplicate allowed

        System.out.println("Collection after adding elements: " + collection);

        System.out.println("\n<<------------------------------------------------------------------->>");
        
        // Removing an element (first occurrence of "Apple")
        collection.remove("Apple");
        System.out.println("Collection after removing 'Apple': " + collection);

        System.out.println("\n<<------------------------------------------------------------------->>");

        // Getting the size of the collection
        System.out.println("The size of collection is: " + collection.size());

        System.out.println("\n<<------------------------------------------------------------------->>");

        // Iterating over the collection
        Iterator<String> iterator = collection.iterator();
        System.out.print("Iterating over collection: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " --> ");
        }

        System.out.println("\n<<------------------------------------------------------------------->>");

        // Checking if a specific element exists
        System.out.println("Collection contains 'Mango': " + collection.contains("Mango"));

        System.out.println("\n<<------------------------------------------------------------------->>");

        // Clearing the collection
        collection.clear();
        System.out.println("Checking whether the collection is empty: " + collection.isEmpty());
    }}