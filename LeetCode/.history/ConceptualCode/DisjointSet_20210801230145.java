import java.util.HashMap;

public class DisjointSet {
    private HashMap<Long,Node> map = new HashMap<>();

    class Node {
        long data;
        int rank;
        Node parent;
    }

    public void makeSet(int data) {
        Node n = new Node(data);
        

    }

}
