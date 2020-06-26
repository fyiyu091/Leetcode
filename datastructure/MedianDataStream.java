package datastructure;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianDataStream {
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;
    private int size;

    /** initialize your data structure here. */
    public MedianDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>((a, b) -> (a - b));
        size = 0;
    }

    public void addNum(int num) {
        size++;
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        }
        else {
            minHeap.offer(num);
        }

        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        return;
    }

    public double findMedian() {
        if (!maxHeap.isEmpty()) {
            if (size % 2 == 0) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            }
            else {
                return (double) maxHeap.peek();
            }
        }
        return 0.0;
    }
}
