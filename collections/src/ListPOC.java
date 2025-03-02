

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListPOC {
	public static void main(String[] args) {
        System.out.println("<---------------- ArrayList ---------------->");
        demonstrateBehavior(new ArrayList<>(), "ArrayList");

        System.out.println("<---------------- LinkedList ---------------->");
        demonstrateBehavior(new LinkedList<>(), "LinkedList");

        System.out.println("<---------------- Vector ---------------->");
        demonstrateBehavior(new Vector<>(), "Vector");

        System.out.println("<---------------- Performance Analysis ---------------->");
        comparePerformance();
    }

    private static void demonstrateBehavior(List<String> list, String type) {
        System.out.println("\nDemonstrating behavior of " + type + ":");

        // Insertion (Maintains Order)
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Apple");  // Duplicate element
        System.out.println("Inserted Elements: " + list);

        // Access by Index
        System.out.println("Element at index 2: " + list.get(2));

        // Removing Element
        list.remove("Apple");  // Removes first occurrence
        System.out.println("After removing 'Apple': " + list);

        // Iteration
        System.out.print("Iterating: ");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }

    private static void comparePerformance() {
        int size = 100000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();

        System.out.println("\nPerformance Comparison (Adding " + size + " elements):");

        measureTime("ArrayList Add", () -> {
            for (int i = 0; i < size; i++) arrayList.add(i);
        });

        measureTime("LinkedList Add", () -> {
            for (int i = 0; i < size; i++) linkedList.add(i);
        });

        measureTime("Vector Add", () -> {
            for (int i = 0; i < size; i++) vector.add(i);
        });

        System.out.println("\nRetrieval Performance:");
        measureTime("ArrayList Get", () -> {
            for (int i = 0; i < size; i++) arrayList.get(i);
        });

        measureTime("LinkedList Get", () -> {
            for (int i = 0; i < size; i++) linkedList.get(i);
        });

        measureTime("Vector Get", () -> {
            for (int i = 0; i < size; i++) vector.get(i);
        });
    }

    private static void measureTime(String operation, Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.println(operation + ": " + (end - start) / 1_000_000 + " ms");
    }
	}

