package collections_utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CollectionsUtilityMethods {

	public static void main(String[] args) {
		try(Scanner scanner=new Scanner(System.in)) {
			List<Integer> list= new ArrayList<Integer>();
			int size;
			System.out.println("Enter number of elements:");
			size=scanner.nextInt();
			
			System.out.println("Insert the elements");
			for(int i=0;i<size;i++) {
				if(!scanner.hasNextInt()) {
					throw new InputMismatchException("Invalid type. Please enter integers only");
				}else {
				list.add(scanner.nextInt());
				}
			}
			
			if(list.isEmpty()) {
				throw new NullPointerException("List is empty. Cannot perform operations");
			}
			
			  // 1. Sorting the list in ascending order
            Collections.sort(list);
            System.out.println("Sorted List: " + list);

            // 2. Shuffling the list randomly
            Collections.shuffle(list);
            System.out.println("Shuffled List: " + list);

            // 3. Reversing the list order
            Collections.reverse(list);
            System.out.println("Reversed List: " + list);

            // 4. Performing a binary search
            Collections.sort(list); // Ensure list is sorted
            System.out.println("Sorted List for Binary Search: " +list);

            System.out.println("Enter the element to search:");
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Invalid input. Please enter an integer.");
            }
            int searchElement = scanner.nextInt();
            int index = Collections.binarySearch(list, searchElement);
            if (index >= 0) {
                System.out.println("Element " + searchElement + " found at index: " + index);
            } else {
                System.out.println("Element " + searchElement + " not found in the list.");
            }
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println("Error:"+e.getMessage());
		}catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unexpected error: "+e.getMessage());
		}
	}
}
