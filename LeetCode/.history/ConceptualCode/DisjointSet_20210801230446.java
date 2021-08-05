import java.util.HashMap;

public class DisjointSet {
    private HashMap<Long,Node> map = new HashMap<>();

    class Node {
        long data;
        int rank;
        Node parent;

        public Node(long data) {
            this.data = data;
            parent  = this;
            rank = 0;
        }
    }

    public void makeSet(long data) {
        Node n = new Node(data);
        map.put(data,n);

    }

    public void union()

}
