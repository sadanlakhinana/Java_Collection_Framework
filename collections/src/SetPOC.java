import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPOC {
	public static void main(String[] args) {
        System.out.println("<---------------- HashSet (Unordered) ---------------->");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Orange");
        hashSet.add("Mango");
        hashSet.add("Apple"); // Duplicate - ignored
        System.out.println("HashSet: " + hashSet); // Order is unpredictable

        System.out.println("<---------------- LinkedHashSet (Insertion Order) ---------------->");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Mango");
        linkedHashSet.add("Apple"); // Duplicate - ignored
        System.out.println("LinkedHashSet: " + linkedHashSet); // Preserves insertion order

        System.out.println("<---------------- TreeSet (Sorted Order) ---------------->");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");
        treeSet.add("Mango");
        treeSet.add("Apple"); // Duplicate - ignored
        System.out.println("TreeSet: " + treeSet); // Sorted order (A-Z)

        System.out.println("<---------------- Performance Analysis ---------------->");

        int size = 100000;
        measureTime("HashSet Add", () -> {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) set.add(i);
        });

        measureTime("LinkedHashSet Add", () -> {
            Set<Integer> set = new LinkedHashSet<>();
            for (int i = 0; i < size; i++) set.add(i);
        });

        measureTime("TreeSet Add", () -> {
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < size; i++) set.add(i);
        });

        measureTime("HashSet Contains", () -> {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) set.add(i);
            for (int i = 0; i < size; i++) set.contains(i);
        });

        measureTime("TreeSet Contains", () -> {
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < size; i++) set.add(i);
            for (int i = 0; i < size; i++) set.contains(i);
        });

        measureTime("HashSet Remove", () -> {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) set.add(i);
            for (int i = 0; i < size; i++) set.remove(i);
        });

        measureTime("TreeSet Remove", () -> {
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < size; i++) set.add(i);
            for (int i = 0; i < size; i++) set.remove(i);
        });
    }

    // Method to measure execution time
    private static void measureTime(String operation, Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.println(operation + " took: " + (end - start) / 1_000_000 + " ms");
    }
}
