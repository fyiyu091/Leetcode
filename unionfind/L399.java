package unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Evaluate division
   Given a / b = 2.0, b / c = 3.0
   Generate the results for a / c, b / a, x / x
                            6.0    0.5     -1 (Should have throw Exception)

   In general, union find is to find whether the two vertex is in the same group and then union them together
   In this case, we will need more information than that, we need to add the parent / curr value into the vertex's field
   So when we try to get x / y, they will both point to root after findRoot(), then just calculate y.val / x.val
 */
public class L399 {
    class V {
        private String name;
        private V parent;
        private int size;
        private double val;
        V(String name) {
            this.name = name;
            this.parent = this;
            this.val = 1.0;
            this.size = 1;
        }
    }

    class UnionFind {
        // Need to use String to locate the vertex
        Map<String, V> map;

        UnionFind() {
            this.map = new HashMap<>();
        }

        public void union(V v1, V v2) {
            V root1 = findRoot(v1);
            V root2 = findRoot(v2);
            if (root1.size < root2.size) {
                root2.size += root1.size;
                root1.parent = root2;
            }
            else {
                root1.size += root2.size;
                root2.parent = root1;
            }
        }

        public boolean find(V v1, V v2) {
            return findRoot(v1) == findRoot(v2);
        }

        private V findRoot(V v) {
            V curr = v;
            double newVal = curr.val;
            while (curr.parent != curr) {
                newVal *= curr.parent.val;
                curr.parent = curr.parent.parent;
                curr = curr.parent;
            }
            v.parent = curr;
            v.val = newVal;
            return curr;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

    }
}
