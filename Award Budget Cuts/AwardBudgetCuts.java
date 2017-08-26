import java.util.Arrays;
import java.util.Random;

/**
 * Created by qijiawen on 8/26/17.
 */
public class AwardBudgetCuts {

    public static double findGrantsCap(double[] grantsArray, double newBudget) {
        if (grantsArray == null || grantsArray.length == 0) return 0;
        int n = grantsArray.length;

        // sort the array
        Arrays.sort(grantsArray);

        // calculate total amount we need to cut
        double sum = 0;
        for (double g : grantsArray) {
            sum += g;
        }
        double surplus = sum - newBudget;

        // if there is nothing to cut
        if (surplus <= 0) {
            return grantsArray[n - 1];
        }

        // if all need to cut
        if (grantsArray[0] * n > newBudget) {
            return newBudget / (double)n;
        }


        int i = n - 1;
        for (; i >= 1; i--) {
            surplus = surplus - (n - i) * (grantsArray[i] - grantsArray[i - 1]);
            if (surplus <= 0) { // now we got the lower bound
                break;
            }
        }

        return grantsArray[i - 1] + (-surplus / (float)(n-i));
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10);
        double[] grantsArray = new double[n];
        for (int i = 0; i < n; i++) {
            grantsArray[i] = (double)random.nextInt(100);
        }
        double newBudget = random.nextInt(500);
        System.out.println("The grans array is: ");
        for (int i = 0; i < n; i++) {
            System.out.println(grantsArray[i] + "  ");
        }
        System.out.println("The new budget is " + newBudget + " and the result limit is " + findGrantsCap(grantsArray, newBudget));
    }
}
