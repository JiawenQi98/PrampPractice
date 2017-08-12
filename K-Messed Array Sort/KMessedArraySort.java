import java.util.PriorityQueue;

/**
 * Created by qijiawen on 8/12/17.
 */
public class KMessedArraySort {

    // Insertion Sort O(N * K)
    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = x;
        }

        return arr;
    }

    // Min Heap
    public static int[] sortKMessedArray(int[] arr, int k) {
        int n = arr.length;

        // create an empty min-heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // build the min-heap from the first k+1 elements of arr
        for (int i = 0; i <= k; i++) {
            priorityQueue.add(arr[i]); // insert an element into priority queue is O(logK)
        }

        // extract the top element from the min-heap and assign it to the next available array index, push the next array element into the min-heap
        for (int i = k + 1; i < arr.length; i++) {
            arr[i - (k + 1)] = priorityQueue.poll(); // remove an element from priority queue is O(logK)
            priorityQueue.add(arr[i]);
        }

        // extract all remaining elements from the min-heap and assign them to the next available array index
        for (int i = 0; i <= k; i++) {
            arr[n - k - 1 + i] = priorityQueue.poll();
        }

        return arr;
    }

    public static void main (String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;

        // insertion sort
        int[] arr_new1 = insertionSort(arr);

        for (int a : arr_new1) {
            System.out.println(a);
        }

        // min heap
        int[] arr_new2 = sortKMessedArray(arr, k);

        for (int a : arr_new2) {
            System.out.println(a);
        }
    }

}
