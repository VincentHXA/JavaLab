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

    public static void heapSort(int[] arr) {
        // 最后一个非叶子节点 = n / 2 - 1
        // 构建初始堆
        int len = arr.length;
        for(int i = (len >> 1) - 1; i >= 0; i--) {
            //maxHeap(arr, i, len);
            minHeap(arr, i, len);
        }

        // 逐步构建调整堆
        for(int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);   // 根节点与最小叶子节点交换，根据大顶堆构建递增序列
            //maxHeap(arr, 0, i - 1);
            minHeap(arr, 0, i - 1);
        }
    }

    private static void maxHeap(int[] arr, int minNoLeaf, int len) {
        // 左子节点 = 2 * minNoLeaf + 1
        int left = (minNoLeaf << 1) + 1;
        int right = left + 1;
        int max = left;
        if (left > len) {
            return;
        }
        if (right <= len && arr[right] > arr[left]) {
           max = right;
        }
        if (arr[max] > arr[minNoLeaf]) {
            swap(arr, max, minNoLeaf);
            maxHeap(arr, max, len);
        }
    }

    private static void minHeap(int[] arr, int node, int len) {
        int left = (node << 1) + 1;
        int right = left + 1;
        int min = left;
        if (left > len) {
            return;
        }
        if (right <= len && arr[left] > arr[right]) {
            min = right;
        }
        if (arr[min] < arr[node]) {
            swap(arr, min, node);
            minHeap(arr, min, len);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) >> 1;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, start, end, mid);
        }

    }

    private static void merge(int[] arr, int start, int end, int mid) {
        int[] temp = new int[arr.length];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for(int p = 0; p < k; p++) {
            arr[start + p] = temp[p];
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
