package amazonoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
   Two sum in an array, need to find the max
   The relationship is that
   movie1 + movie2 + 30 = flightDuration

 */
public class ArrangeMovie {
    class PairInt {
        int first, second;
        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public PairInt IDsOfMovies(int flightDuration, int numMovies, ArrayList<Integer> movieDuration) {
        if (movieDuration == null || movieDuration.size() == 0 || numMovies <= 0 || flightDuration < 30) {
            return new PairInt(-1, -1);
        }

        // map stores curr movie and its index
        Map<Integer, Integer> map = new HashMap<>();
        PairInt res = new PairInt(-1, -1);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < movieDuration.size(); i++) {
            int curr = movieDuration.get(i);
            int complement = flightDuration - 30 - curr;
            if (map.containsKey(complement)) {
                if (curr > max || complement > max) {
                    res.first = map.get(complement);
                    res.second = i;
                    max = Math.max(curr, movieDuration.get(map.get(complement)));
                }
            }
            map.put(curr, i);
        }

        return res;
    }
}
