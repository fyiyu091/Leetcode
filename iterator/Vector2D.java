package iterator;

public class Vector2D {
    private int[][] matrix;
    private int row;
    private int col;
    public Vector2D(int[][] v) {
        this.matrix = v;
        this.row = 0;
        this.col = 0;
        moveToNext();
    }

    public int next() {
        int val = matrix[row][col++];

        // Need to move to the next element
        moveToNext();
        return val;
    }

    public boolean hasNext() {
        return row < matrix.length && col < matrix[row].length;
    }

    private void moveToNext() {
        while (row < matrix.length && col == matrix[row].length) {
            row++;
            col = 0;
        }
    }
}
