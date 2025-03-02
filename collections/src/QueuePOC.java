import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePOC {

	public static void main(String[] args) {
        System.out.println("<---------------- LinkedList as Queue ---------------->");
        
        Queue<String> queue = new LinkedList<>();

        // Adding elements to the Queue (FIFO)
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Orange");

        System.out.println("Queue: " + queue); // [Apple, Banana, Orange]

        // Removing elements (FIFO)
        System.out.println("Removed: " + queue.poll()); // Apple
        System.out.println("Queue after removal: " + queue); // [Banana, Orange]

        // Viewing the front element
        System.out.println("Front Element: " + queue.peek()); // Banana

        System.out.println("<---------------- PriorityQueue ---------------->");
        
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        // Adding elements to the PriorityQueue (Natural Order)
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(20);

        System.out.println("PriorityQueue: " + priorityQueue); // Order is based on priority

        // Removing elements (Smallest first)
        System.out.println("Removed: " + priorityQueue.poll()); // 10
        System.out.println("PriorityQueue after removal: " + priorityQueue); // [20, 30]

        // Viewing the highest priority element
        System.out.println("Top Priority Element: " + priorityQueue.peek()); // 20

        System.out.println("<---------------- Performance Analysis ---------------->");

        int size = 100000;
        measureTime("LinkedList Enqueue", () -> {
            Queue<Integer> testQueue = new LinkedList<>();
            for (int i = 0; i < size; i++) testQueue.offer(i);
        });

        measureTime("LinkedList Dequeue", () -> {
            Queue<Integer> testQueue = new LinkedList<>();
            for (int i = 0; i < size; i++) testQueue.offer(i);
            for (int i = 0; i < size; i++) testQueue.poll();
        });

        measureTime("PriorityQueue Enqueue", () -> {
            Queue<Integer> testQueue = new PriorityQueue<>();
            for (int i = 0; i < size; i++) testQueue.offer(i);
        });

        measureTime("PriorityQueue Dequeue", () -> {
            Queue<Integer> testQueue = new PriorityQueue<>();
            for (int i = 0; i < size; i++) testQueue.offer(i);
            for (int i = 0; i < size; i++) testQueue.poll();
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
