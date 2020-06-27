package math;

/*
    Bulb switcher
    Input: 3
    Output: 1
    Explanation:
    At first, the three bulbs are [off, off, off].
    After first round, the three bulbs are [on, on, on].
    After second round, the three bulbs are [on, off, on].
    After third round, the three bulbs are [on, off, off].

    n = 8, 1 means on, 0 means off
    1st round: 1 1 1 1 1 1 1 1
               1 0 1 0 1 0 1 0
               1 0 0 0 0 0 0 0

    n = 4
    1 1 1 1
    1 0 1 0  turn off
    1 0 0 0  toggle
    1 0 0 1  toggle

    n = 5
    1 1 1 1 1
    1 0 1 0 1
    1 0 0 0 0
    1 0 0 1 0
    1 0 0 0 1

    The bulb needs to eventually be on, only if it is being toggled odd times
    At ith round, the bulb will be toggled when the bulb % ith == 0
    So only the number like 4, 9, 16, 25 can be toggled odd times
    So we will need to count from 1 to n, how many of those numbers are included
 */
public class L319 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
