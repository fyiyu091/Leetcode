package binaryreduction;

/* Smallest rectangle enclosing black pixels */

public class L302 {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) {
            return 0;
        }
        int left = findStart(image, 0, y, true);
        int right = findEnd(image, y, image[0].length - 1, true);
        int up = findStart(image, 0, x, false);
        int down = findEnd(image, x, image.length - 1, false);

        return (right - left + 1) * (down - up + 1);
    }

    private int findStart(char[][] image, int start, int end, boolean checkVertical) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (hasOne(image, mid, checkVertical)) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int findEnd(char[][] image, int start, int end, boolean checkVertical) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (hasOne(image, mid, checkVertical)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end;
    }

    private boolean hasOne(char[][] image, int idx, boolean checkVertical) {
        if (checkVertical) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][idx] == '1') {
                    return true;
                }
            }
            return false;
        }
        else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[idx][i] == '1') {
                    return true;
                }
            }
            return false;
        }
    }
}
