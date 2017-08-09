/**
 * Created by qijiawen on 8/8/17.
 */
public class ArrayOfArrayProducts {

    public static int[] arrayOfArrayProducts(int[] arr) {
        // base case:
        if (arr == null || arr.length == 0 || arr.length == 1) return new int[0];

        int[] result = new int[arr.length];
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }
        int right = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, -2};
        int[] result = arrayOfArrayProducts(arr);
        for (int n : result) System.out.println(n);
    }
}
