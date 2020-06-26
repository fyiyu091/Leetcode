package datastructure;

/* ArrayList CRUD */

public class MyArrayList<T> {
    private T[] arr;
    private static final int INITIAL_CAP = 10;
    private int capacity;
    private int size;

    public MyArrayList() {
        this(INITIAL_CAP);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(T val) {
        if (size >= capacity / 2) {
            deepCopyDoubleSize();
        }
        arr[size++] = val;
        return;
    }


    public T get(int idx) {
        if (idx > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return arr[idx];
    }

    public void update(int idx, T val) {
        if (idx > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        arr[idx] = val;
        return;
    }

    public T remove(int idx) {
        if (idx > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        T returnVal = arr[idx];
        int tmp = idx;
        while (tmp < size) {
            arr[tmp] = arr[tmp + 1];
            tmp++;
        }
        if (size <= capacity / 4) {
            deepCopyHalfSize();
        }
        arr[size--] = null;
        return returnVal;
    }

    private void deepCopyDoubleSize() {
        capacity *= 2;
        T[] newArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        return;
    }

    private void deepCopyHalfSize() {
        capacity /= 2;
        T[] newArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        return;
    }
}
