import java.util.Arrays;

public class Test_10 {
    public static void main(String[] args) {
        double[] input = {9,6,9,6}; // try different inputs.
        int n = input.length;
        Element[] a = new Element[n];
        for (int i = 0; i < input.length; i++)
            a[i] = new Element(i, input[i]);

        System.out.println("Original: " + Arrays.toString(a));
        Heapsort(a);

        System.out.println("After sorted: " + Arrays.toString(a));
    }
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
    public static void insertionSort(Element[] a) {
        int i, j, n = a.length;
        Element key;
        for (i = 1; i < n; i++) {
            key = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (a[j].value <= key.value) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }
    public static void bubble (Element [] a) {
        int n = a.length;
        int i, j;
        for (i = 1; i < n; i++) {
            for (j = 0; j < n - i; j++) {
                Element temp;
                if (a[j + 1].value < a[j].value) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    public static void selection (Element [] a) {
        int n = a.length;
        int min;
        for (int i = 0; i < n - 1; i++) {
            min=i;
            for (int j = i + 1; j < n; j++)
                if (a[min].value > a[j].value) min = j;
            {
                Element temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }

        }
    }
    public static void Heapsort(Element [] a) {
        Heapsort.heapsort(a);
    }

    public static class Heapsort {

        private static void swap(Element[] a, int x, int y) {
            Element temp = a[x];
            a[x] = a[y];
            a[y] = temp;
        }

        /*
         * The element at index c bubbles up the heap.
         *
         * Running time O( log n ), or more precisely, O( log size ).
         */
        private static void up(Element[] a, int c) {
            if (c == 0) return;
            int p = (c - 1) / 2;
            if (a[c].value <= a[p].value) return;
            swap(a, c, p);
            up(a, p);
        }

        /*
         * The element at index p bubbles down the heap.
         * Unlike up, we need to pass <em>size</em>.
         *
         * @param p the current node under consideration
         * @param size the size of the current heap, from index 0 to index size - 1.
         *
         * Running time O( log n ), or more precisely, O( log size ).
         */
        private static void down(Element[] a, int p, int size) {
            if (p * 2 + 2 > size) return;
            int larger = p * 2 + 1;
            if (larger + 1 < size && a[larger].value < a[larger+1].value)
                larger++;
            if (a[p].value >= a[larger].value) return;
            swap(a, p, larger);
            down(a, larger, size);
        }

        /*
         * The in-place heapsort algorithm.
         *
         * First, include elements into the virtual heap one by one.
         * Second, remove the max from the virtual heap one by one.
         *
         * Running time O( n log n ).
         */
        public static void heapsort(Element[] a) {
            for (int i = 1; i < a.length; i++)
                up(a, i);
            for (int i = a.length - 1; i > 0; i--) {
                swap(a, 0, i);  // similar to removeMax.
                down(a, 0, i);
                // Uncomment the following line to see the progress.
//                 System.out.println(Arrays.toString(a));
            }
        }
    }


}



