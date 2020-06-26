package amazonoa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonAfterNdays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0) {
            return new int[0];
        }

        Set<String> set = new HashSet<>();
        boolean repeat = false;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] cell = nextDay(cells);
            if (!set.add(Arrays.toString(cell))) {
                repeat = true;
                break;
            }
            else {
                cells = cell;
                count++;
            }
        }

        if (repeat) {
            N %= count;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }

        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] res = new int[cells.length];
        res[0] = 0;
        res[res.length - 1] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                res[i] = 1;
            }
            else {
                res[i] = 0;
            }
        }
        return res;
    }
}
