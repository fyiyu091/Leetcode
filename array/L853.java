package array;

import java.util.Arrays;

/*
    Far away car can never surpass the closer car
    Calculate the time to the target
    From the closest to the furtherest
    It is the time is increasing, then each one of them is a fleet
 */
public class L853 {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] positionAndTimeToTarget = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            positionAndTimeToTarget[i] = new double[] {position[i], (double)(target - position[i]) / speed[i]};
        }

        Arrays.sort(positionAndTimeToTarget, (a, b) -> Double.compare(b[0], a[0]));

        int res = 0;
        double head = Double.MIN_VALUE;
        for (int i = 0; i < positionAndTimeToTarget.length; i++) {
            if (positionAndTimeToTarget[i][1] > head) {
                head = positionAndTimeToTarget[i][1];
                res++;
            }
        }

        return res;
    }
}
