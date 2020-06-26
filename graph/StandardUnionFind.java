package graph;

public class StandardUnionFind {
    class Vertex {
        int val;
        Vertex parent;
        int size;

        Vertex(int val) {
            this.val = val;
            this.parent = this;
            this.size = 1;
        }
    }

    public boolean find(Vertex p, Vertex q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(Vertex p, Vertex q) {
        Vertex pRoot = findRoot(p);
        Vertex qRoot = findRoot(q);
        if (pRoot.size < qRoot.size) {
            pRoot.parent = qRoot;
            pRoot.size += qRoot.size;
        }
        else {
            qRoot.parent = pRoot;
            qRoot.size += pRoot.size;
        }
    }

    private Vertex findRoot(Vertex v) {
        Vertex curr = v;
        while (curr.parent != curr) {
            curr.parent = curr.parent.parent;
            curr = curr.parent;
        }

        // Have the vertex to be the root's child
        v.parent = curr;
        return curr;
    }
}
