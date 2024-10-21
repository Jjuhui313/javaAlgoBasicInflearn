package algo07_09;

/*
 * 07-09 Tree 말단 노드까지의 가장 짧은 경로
 *
 * BFS로 풀어야 하는 문제지만 DFS로 먼저 풀어보기
 * */

class Node {
    public int data;
    public Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}
public class Main {

    public static int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(DFS(0, root));
    }
}
