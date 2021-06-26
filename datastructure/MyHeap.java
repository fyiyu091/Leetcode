package datastructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
    Physically, it is array, logically, it is a tree

 */
public class MyHeap {
    private int[] arr;
    private int size;

    public MyHeap(int cap) {
        this.arr = new int[cap];
        this.size = 0;
    }

    public MyHeap(int[] intputArr) {
        arr = Arrays.copyOf(intputArr, intputArr.length * 2);
        size = intputArr.length;
        heapify();
    }

    // Make sure the elements in the array are match the heap's requirement
    private void heapify() {
        // Why is (size - 2) / 2?
        // According to the formula, parent = (child - 1) / 2
        // So here we starts with the parent of the last element in the array?
        // Why not just the last element?
        //
        for (int i = (size - 2) / 2; i >= 0; i--) {
            swim(i);
        }
    }

    public void offer(int val) {
        arr[size] = val;
        size++;
        // Swim after the size change
        swim(size - 1);
        return;
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int ret = arr[0];
        // Need to eliminate arr[0] value completely
        arr[0] = arr[size - 1];
        size--;
        // Do sink after the size change
        sink(0);
        return ret;
    }

    private void swim(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            // minHeap, swim all the way to the top
            if (arr[idx] < arr[parent]) {
                swap(idx, parent);
                idx = parent;
            }
            else {
                break;
            }
        }
        return;
    }

    // Sink the first one all the way down until cannot sink
    private void sink(int idx) {
        // The last one is size - 1, its parent is (size - 2) / 2
        while (idx <= (size - 2) / 2) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            // Assume one side
            int swapIdx = left;
            // Right could be out of bounce
            if (right < size) {
                // Swap only the previous assumption doesn't hold
                if (arr[right] < arr[left]) {
                    swapIdx = right;
                }
            }
            if (arr[idx] > arr[swapIdx]) {
                swap(idx, swapIdx);
            }
            else {
                break;
            }
            idx = swapIdx;
        }
        return;
    }

    private void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return;
    }
}
