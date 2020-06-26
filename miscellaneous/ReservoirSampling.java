package miscellaneous;

import java.util.Random;

/* Given a very large array with size N, try to get K samples
   And each sample's picked possibility is K/N
 */
public class ReservoirSampling {
    public int[] reservoirSampling(int[] input, int k) {
        // corner case

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = input[i];
        }

        for (int i = k; i < input.length; i++) {
            int idx = new Random().nextInt(i);
            if (idx < k) {
                res[idx] = input[i];
            }
        }

        return res;
    }
}
