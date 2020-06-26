package microsoftoa;

public class LightBulbSwitcher {
    public int numTimesAllBlue(int[] light) {
        if (light == null || light.length == 0) {
            return 0;
        }

        int max = 0;
        int res = 0;
        for (int i = 0; i < light.length; i++) {
            if (light[i] > max) {
                max = light[i];
            }

            if (max == i + 1) {
                res++;
            }
        }
        return res;
    }
}
