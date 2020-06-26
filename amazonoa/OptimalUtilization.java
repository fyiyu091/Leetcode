package amazonoa;

import java.lang.reflect.Array;
import java.util.*;

public class OptimalUtilization {
    public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        List<List<Integer>> res = new ArrayList<>();
        int len1 = forwardRouteList.length;
        int len2 = returnRouteList.length;
        Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
        Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
        int left = 0;
        int right = len2 - 1;
        int maxSoFar = Integer.MIN_VALUE;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        while (left < len1 && right >= 0) {
            int sum = forwardRouteList[left][1] + returnRouteList[right][1];
            if (sum > maxTravelDist) {
                right--;
                continue;
            }
            if (sum >= maxSoFar) {
                int r = right;
                map.putIfAbsent(sum, new ArrayList<>());
                // returnRouteList has duplicate
                // What if forwardRouteList also has duplicate
                while (r >= 0 && returnRouteList[r][1] == returnRouteList[right][1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(forwardRouteList[left][0], returnRouteList[r][0]);
                    map.get(sum).add(list);
                    r--;
                }
                maxSoFar = sum;
            }
            while (left + 1 < len1 && forwardRouteList[left][1] == forwardRouteList[left + 1][1]) {
                left++;
            }
            left++;
        }
        return map.get(maxSoFar);
    }
    /* O(n^2) time complexity */
//    public List<int[]> solution(List<int[]> a, List<int[]> b, int target){
//        Map<Integer, List<int[]>> map = new HashMap<>();
//
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j < b.size(); j++) {
//                int sum = a.get(i)[1] + b.get(j)[1];
//                List<int[]> idxList = map.getOrDefault(sum, new ArrayList<>());
//                idxList.add(new int[] {a.get(i)[0], b.get(j)[0]});
//                map.put(sum, idxList);
//            }
//        }
//
//        List<Integer> allSums = new ArrayList<>();
//        for (int i : map.keySet()) {
//            if (i < target) {
//                allSums.add(i);
//            }
//            else if (i == target) {
//                return map.get(i);
//            }
//        }
//
//        if (allSums.isEmpty()) {
//            return new ArrayList<>();
//        }
//
//        return map.get(Collections.max(allSums));
//    }
}
