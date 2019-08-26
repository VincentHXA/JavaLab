package sorting;

public class Sorting {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        int len = arr.length;

        for(int i = 0; i < len - 1; i++) {
           for(int j = i + 1; j < len; j++) {
              if(arr[i] > arr[j]) {
                  swap(arr, i, j);
              }
           }
        }
    }

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        int len = arr.length;

        for( int i = 1; i < len; i++ ) {
            int j = i-1;
            int temp = arr[i];
            while(j >= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        if(start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int benchmark = arr[start];
        while (start < end) {
            while (start < end && benchmark <= arr[end]) {
                end--;
            }
            if (start < end) {
                arr[start] = arr[end];
            }
            while (start < end && benchmark >= arr[start]) {
                start++;
            }
            if (start < end) {
                arr[end] = arr[start];
            }
        }
        arr[start] = benchmark;
        return start;
    }

    public static void shellSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        int k = arr.length / 2;
        while(k >= 1) {
            shellInsertSort(arr, k);
            k = k / 2;
        }
    }

    private static void shellInsertSort(int[] arr, int k) {
        for (int i=k; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - k;
            while (j >= 0 && arr[j] > temp) {
                arr[j + k] = arr[j];
                j = j - k;
            }
            arr[j + k] = temp;
        }
    }

    public static void mergeSort(int[] arr) {

    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
