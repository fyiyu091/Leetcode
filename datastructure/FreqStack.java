package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
    Use two maps
    <Number, its Frequency>
    <Frequency, a stack of all the elements that have this frequency>
 */
public class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> freqStack;
    int maxFreq;

    public FreqStack() {
        this.freq = new HashMap<>();
        this.freqStack = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int valFreq = freq.get(val);
        if (!freqStack.containsKey(valFreq)) {
            freqStack.put(valFreq, new ArrayDeque<>());
        }
        freqStack.get(valFreq).push(val);
        maxFreq = Math.max(maxFreq, valFreq);
    }

    public int pop() {
        Deque<Integer> stack = freqStack.get(maxFreq);
        int res = stack.pop();
        freq.put(res, freq.get(res) - 1);
        if (stack.isEmpty()) {
            freqStack.remove(maxFreq);
            maxFreq--;
        }

        return res;
    }
}
