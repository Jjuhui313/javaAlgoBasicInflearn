package algo07_07;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 07-07 이진트리 순회(넓이우선탐색 : 레벨탐색)
 *
 * bfs로 구현해보기
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
    public static void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            L++;
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        bfs(root);
    }
}
