import java.util.ArrayDeque;
import java.util.Deque;

public class DequeuePOC {

	public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println("===== Deque Operations =====");
        
        // Adding elements at both ends
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(25);

        System.out.println("Deque after insertions: " + deque);

        // Removing elements from both ends
        deque.removeFirst();
        deque.removeLast();

        System.out.println("Deque after removals: " + deque);

        // Accessing first and last element
        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());

        // Performance testing
        int size = 100000;
        measureTime("Adding elements at First", () -> {
            Deque<Integer> testDeque = new ArrayDeque<>();
            for (int i = 0; i < size; i++) testDeque.addFirst(i);
        });

        measureTime("Adding elements at Last", () -> {
            Deque<Integer> testDeque = new ArrayDeque<>();
            for (int i = 0; i < size; i++) testDeque.addLast(i);
        });

        measureTime("Removing elements from First", () -> {
            Deque<Integer> testDeque = new ArrayDeque<>();
            for (int i = 0; i < size; i++) testDeque.addFirst(i);
            for (int i = 0; i < size; i++) testDeque.removeFirst();
        });

        measureTime("Removing elements from Last", () -> {
            Deque<Integer> testDeque = new ArrayDeque<>();
            for (int i = 0; i < size; i++) testDeque.addLast(i);
            for (int i = 0; i < size; i++) testDeque.removeLast();
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
