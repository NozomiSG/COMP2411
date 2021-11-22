import java.util.Arrays;

/**
 * 
 * @author Yixin Cao (September 11, 2021)
 *
 * A better implementation of insertion sort.
 * 
 * The ith major iteration of insertion sort puts element a[i] to its correct position.
 * Your algorithm should use *binary search* to find the position of the first element 
 * that is greater than (> not >=) a[i], or i if there does exist such an element.
 * 
 * Read the {@code Element} class carefully before you start.
 * It uses an extra field *originalPos* to store the index of this element in the input.
 * When an element is output, originalPos is printed in parentheses.
 * 
 * If your implementation is correct, elements of the same value should respect their original order,
 * e.g., for input {1.25, 0, 1.25, 2.5, 10, 2.5, 1.25, 5, 2.5}, the output should be  
 * [0.0 (1), 1.25 (0), 1.25 (2), 1.25 (6), 2.5 (3), 2.5 (5), 2.5 (8), 5.0 (7), 10.0 (4)].
 */
public class Sorting_20074794d_ZHUGuanYu { // Please change!
	/*
	 * Each element has a double value and the original position in the input array.
	 */
	static class Element {
	    private final int originalPos;
	    double value;
	    public Element(int i, double v) {
	        originalPos = i; 
	        value = v;
	    }
	    public String toString() {
	        return (value) + " (" + originalPos + ")";
	    }
	}
    
    /**
     * VERY IMPORTANT.
     * 
     * I've discussed this question with the following students:
     *     1. None
     *     2. 
     *     3. 
     *     ... 
     * 
     * I've sought help from the following Internet resources and books:
     *     1. None
     *     2. 
     *     3. 
     *     ... 
     * 
     * Running time: O(nlogn).
     */ 
    public static void insertionSort(Element[] a) {
        Element key;
        int low, high, mid;
        for (int i=1; i<a.length; i++) {
            key = a[i];
            low = 0;
            high = i-1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (a[mid].value > key.value)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            if (a[low] != key) {
                for (int j = i - 1; j >= low; j--) a[j + 1] = a[j];
                a[low] = key;
            }
        }
    }

    public static void main(String[] args) {
        double[] input = {1.25, 0, 1.25, 2.5, 10, 2.5, 1.25, 5, 2.5}; // try different inputs.
        int n = input.length;
        Element[] a = new Element[n];
        for (int i = 0; i < input.length; i++)
            a[i] = new Element(i, input[i]);
        
        System.out.println("Original: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("After sorted: " + Arrays.toString(a));
    }
}


