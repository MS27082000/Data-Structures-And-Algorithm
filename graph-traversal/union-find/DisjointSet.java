/** Disjoint Set Union (Union-Find): maintain a partition of elements into groups with near-constant-time `find` and `union` */
public class DisjointSet {

    private final int[] parent, size;
    private int components;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;                                          // every element starts as its own group (its own root)
            size[i] = 1;
        }
    }

    // find with PATH COMPRESSION: point every node on the way directly at the root, flattening the tree
    int find(int x) {
        int root = x;
        while (parent[root] != root) root = parent[root];
        while (parent[x] != root) {                                 // second pass: compress
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    // union by SIZE: hang the smaller tree under the larger one so trees stay shallow. Returns false if they were already together
    boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
        parent[rb] = ra;
        size[ra] += size[rb];
        components--;
        return true;
    }

    boolean connected(int a, int b) { return find(a) == find(b); }
    int sizeOf(int x) { return size[find(x)]; }
    int components() { return components; }

    public static void main(String[] args) {
        // With both optimisations each operation costs O(alpha(n)) amortised, where alpha is the inverse Ackermann function (< 5 in practice)
        DisjointSet ds = new DisjointSet(7);
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(5, 6);
        System.out.println(ds.connected(1, 3));                     // true
        System.out.println(ds.connected(1, 4));                     // false
        System.out.println(ds.components());                        // 3  ({0}, {1,2,3}, {4,5,6})
        ds.union(3, 4);
        System.out.println(ds.connected(1, 5));                     // true (merged through 3-4)
        System.out.println(ds.sizeOf(1));                           // 6  ({1,2,3,4,5,6})
        System.out.println(ds.union(1, 5));                         // false (already in the same set)
        System.out.println(ds.components());                        // 2  ({0}, {1..6})
    }
}
