package math;

/* Calculate the covered area by two rectangles
   Calculate total covered area - the common area
   Problem is how to calculate the common area? Need to find width and height

 */
public class L223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if (E >= C || G <= A || F >= D || H <= B) {
            return area1 + area2;
        }
        else {
            return area1 + area2 - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
    }
}
