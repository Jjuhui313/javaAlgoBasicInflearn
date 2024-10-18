package algo07_05;

/*
 * 07-05 이진트리 순회(깊이우선탐색)
 *
 * 전위, 중위, 후위순회를 각각 dfs로 구현해보기
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
    //전위순회
    public static void predfs(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        predfs(root.lt);
        predfs(root.rt);

    }

    //중위순회
    public static void middfs(Node root) {
        if (root == null) {
            return;
        }

        middfs(root.lt);
        System.out.print(root.data + " ");
        middfs(root.rt);

    }

    //후위순회
    public static void backdfs(Node root) {
        if (root == null) {
            return;
        }

        backdfs(root.lt);
        backdfs(root.rt);
        System.out.print(root.data + " ");

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        predfs(root);
        System.out.println();
        middfs(root);
        System.out.println();
        backdfs(root);
        System.out.println();
    }
}
