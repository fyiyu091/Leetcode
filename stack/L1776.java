package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
    The key is to find which car of the current car i to crash into?
    Two reasons that i can crash into k
    1. Si > Sk (speed)
    2. k never crashes || i crashes into k before k crashes into another car in front of k

    Two reasons that i can't crash into k
    1. Si <= Sk (speed)
    2. k crashed into another k + 1 ... car before i crashes into k

    For any car in front of i, if i can't crashes into k, there is no fucking chance that the car can crash into k

    Keep a stack that i, i + 1, i + 2 ... -> i would crash into i + 1
 */
public class L1776 {
    public double[] getCollisionTimes(int[][] cars) {
        // To store the index of the car
        Deque<Integer> stack = new ArrayDeque<>();
        double[] res = new double[cars.length];
        Arrays.fill(res, -1.0);

        for (int i = cars.length - 1; i >= 0; i--) {
            int[] currCar = cars[i];
            while (!stack.isEmpty()) {
                int[] nextCar = cars[stack.peek()];
                // Use a function to determine if currCar can crash into the nextCar
                if (currCar[1] > nextCar[1] && (res[stack.peek()] == -1 || crashTime(currCar, nextCar) <= res[stack.peek()])) {
                    res[i] = crashTime(currCar, nextCar);
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }

        return res;
    }

    private double crashTime(int[] currCar, int[] nextCar) {
        int dist = nextCar[0] - currCar[0];
        int speed = currCar[1] - nextCar[1];
        return (double) dist / speed;
    }
}
