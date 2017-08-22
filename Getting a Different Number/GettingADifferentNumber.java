import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qijiawen on 8/21/17.
 */
public class GettingADifferentNumber {

    // time O(nlogn) space O(n)
    public static int getDifferentNumberBruteForce(int[] arr) {
        int n = arr.length;
        int[] arrSorted = Arrays.copyOf(arr, n);
        Arrays.sort(arrSorted);

        for (int i = 0; i < n; i++) {
            if (i != arrSorted[i]) {
                return i;
            }
        }

        return n;
    }

    // time O(N), space O(N)
    public static int getDifferentNumberEfficient(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for (int a : arr) {
            set.add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return n;
    }

    public static int getDifferentNumberInPlace(int[] arr) {
        int n = arr.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = arr[i];
            while (temp < n && arr[temp] != temp) {
                int t = temp;
                temp = arr[temp];
                arr[temp] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != arr[i]) {
                return i;
            }
        }

        return n;
    }

    public static void main (String[] args) {
        int[] arr1 = {0, 1, 2};
        System.out.println(getDifferentNumberBruteForce(arr1));
        int[] arr2 = {1, 3, 0, 2};
        System.out.println(getDifferentNumberEfficient(arr2));
        int[] arr3 = {100000, 9999};
        System.out.println(getDifferentNumberInPlace(arr3));
    }
}
