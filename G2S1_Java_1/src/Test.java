import java.util.Arrays;

public class Test {
    static class Element {
        private int originalPos;
        double value;
        public Element(int i, double v) {
            originalPos = i;
            value = v;
        }
        public String toString() {
            return (String.valueOf(value)) + " (" + String.valueOf(originalPos) + ")";
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
            min = i;
            for (int j = i + 1; j < n; j++)
                if (a[min].value > a[j].value) min = j;
            {
                Element temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }

        }
    }
    public static void main(String[] args) {
        double input[] = {2, 0, 0, 2}; // try different inputs.
        int n = input.length;
        Element[] a = new Element[n];
        for (int i = 0; i < input.length; i++)
            a[i] = new Element(i, input[i]);

        System.out.println("Original: " + Arrays.toString(a));
        selection(a);
        System.out.println("After sorted: " + Arrays.toString(a));
    }
}





