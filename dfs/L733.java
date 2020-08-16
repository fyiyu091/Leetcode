package dfs;

import java.util.HashSet;
import java.util.Set;

/*
    Flood fill the image from src to all 3 directional connected pixels
 */
public class L733 {
    private final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) {
            return image;
        }

        int originColor = image[sr][sc];
        Set<Integer> visited = new HashSet<>();
        dfs(image, sr, sc, newColor, originColor, visited);
        return image;
    }

    private void dfs(int[][] image, int cr, int cc, int newColor, int originColor, Set<Integer> visited) {
        image[cr][cc] = newColor;
        visited.add(cr * image[0].length + cc);
        for (int[] dir : DIRECTIONS) {
            int nextR = cr + dir[0];
            int nextC = cc + dir[1];
            if (nextR >= 0 && nextR < image.length && nextC >=0 && nextC < image[0].length &&
                    image[nextR][nextC] == originColor && !visited.contains(nextR * image[0].length + nextC)) {
                dfs(image, nextR, nextC, newColor, originColor, visited);
            }
        }
    }
}
