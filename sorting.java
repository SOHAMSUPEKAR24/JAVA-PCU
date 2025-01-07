public class sorting {

    //bubble Sort Class
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //Selection sort Class
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = temp;
        }
    }
     //Insertion sort class
    public static void insertionSort(int[] b) {
        int n = b.length;
        for (int i = 1; i < n; i++) {
            int key = b[i];
            int j = i - 1;

            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j = j - 1;
            }
            b[j + 1] = key;
        }
    } 

        

    public static void main(String[] args) {

        //Bubble Sort Call
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println( );

        //Selection sort call
        int[] a = {64, 25, 12, 22, 11};
        selectionSort(a);
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j]+ " ");
        }
        System.out.println( );

        //insertion sort call
        int[] b = {12, 11, 13, 5, 6};
        insertionSort(b);
        for (int h = 0; h< b.length; h++) {
            System.out.print(b[h] + " ");
        }
    }
        
    }


