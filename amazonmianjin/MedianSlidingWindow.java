package amazonmianjin;

/* Median of sliding window */

import java.util.Comparator;
import java.util.TreeSet;

public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (nums[o1] != nums[o2]) {
                    if (nums[o1] > nums[o2]) return 1;
                    else return -1;
                } else {
                    return o1 - o2;
                }
            }
        };

        TreeSet<Integer> leftSet = new TreeSet<>(comp);
        TreeSet<Integer> rightSet = new TreeSet<>(comp);

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (!leftSet.remove(i - k)) {
                    rightSet.remove(i - k);
                }
            }

            addElement(leftSet, rightSet, nums, i);
            if (i >= k - 1) {
                setRes(res, leftSet, rightSet, i - k + 1, nums);
            }
        }

        return res;
    }

    private void addElement(TreeSet<Integer> leftSet, TreeSet<Integer> rightSet, int[] nums, int i) {
        if (leftSet.isEmpty() || nums[i] <= nums[leftSet.last()]) {
            leftSet.add(i);
        }
        else {
            rightSet.add(i);
        }
        while (leftSet.size() > rightSet.size() + 1) {
            rightSet.add(leftSet.pollLast());
        }

        while (rightSet.size() > leftSet.size()) {
            leftSet.add(rightSet.pollFirst());
        }
    }

    private void setRes(double[] res, TreeSet<Integer> leftSet, TreeSet<Integer> rightSet, int i, int[] nums) {
        if (leftSet.size() == rightSet.size()) {
            res[i] = (double) (nums[leftSet.last()] / 2.0 + nums[rightSet.first()] / 2.0);
        }
        else {
            res[i] = (double) nums[leftSet.last()];
        }
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        System.err.println(a - b);
        System.err.println(b - a);
        System.err.println(a + b);
    }
}
