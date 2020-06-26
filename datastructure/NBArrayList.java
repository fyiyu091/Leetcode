package datastructure;

/* Using array to implement an ArrayList and support CRUD operations */

public class NBArrayList<T> {
     private static final int INITIAL_CAP = 10;
     private T[] arr;
     private int size;
     private int cap;

     public NBArrayList() {
        this(INITIAL_CAP);
     }

     public NBArrayList(int capacity) {
         this.arr = (T[]) new Object[capacity];
         this.size = 0;
         this.cap = capacity;
     }

     public void add(T t) {
         arr[size++] = t;
         if (size >= cap / 2) {
             doubleCap();
         }
     }

     // set an element at the specific idx, throw exception is idx is >= size
     public void set(int idx, T t) throws Exception {
         if (idx >= this.size || idx < 0) {
             throw new IndexOutOfBoundsException();
         }
         arr[size] = t;
     }

     // remove the element at the specific idx
     public T remove(int idx) throws Exception {
         if (idx >= this.size || idx < 0) {
             throw new IndexOutOfBoundsException();
         }
         T ret = arr[idx];
         removeThenShift(idx);
         if (size < cap / 4) {
             halfCap();
         }
         return ret;
     }

     private void doubleCap() {
         T[] newArr = (T[]) new Object[this.cap * 2];
         for (int i = 0; i < size; i++) {
             newArr[i] = arr[i];
         }
         arr = newArr;
     }

     private void halfCap() {
         T[] newArr = (T[]) new Object[this.cap / 2];
         for (int i = 0; i < size; i++) {
             newArr[i] = arr[i];
         }
         arr = newArr;
     }

     // Remove the element at the idx then shift all element
     private void removeThenShift(int idx) {
         for (int i = idx; i < size; i++) {
             arr[i] = arr[i + 1];
         }
         size--;
     }
}
