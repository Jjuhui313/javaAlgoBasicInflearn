package algo07_10;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 07-10 Tree 말단 노드까지의 가장 짧은 경로
 *
 * BFS로 풀어보기
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

    public static int bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node cur = q.poll();

                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    q.offer(cur.rt);
                }

            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(bfs(root));

    }
}
