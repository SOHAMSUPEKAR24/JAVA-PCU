package Work;

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

    //Merge Sort class
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    //Quicksort class
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        //Bubble Sort Call
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //Selection sort call
        int[] a = {64, 25, 12, 22, 11};
        selectionSort(a);
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();

        //insertion sort call
        int[] b = {12, 11, 13, 5, 6};
        insertionSort(b);
        for (int h = 0; h < b.length; h++) {
            System.out.print(b[h] + " ");
        }
        System.out.println();

        //mergesort call
        int[] c = {12, 11, 13, 5, 6, 7};
        mergeSort(c, 0, c.length - 1);
        for (int value : c) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        //Quick sort call
        int[] d = {10, 7, 8, 9, 1, 5};
        quickSort(d, 0, d.length - 1);
        for (int value : d) {
            System.out.print(value + " ");
        }


    }

}
