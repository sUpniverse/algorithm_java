import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindPathGame {
    public static void main(String[] args) {
        solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});

    }

    static int[][] solution(int[][] nodeinfo) {

        List<Node> nodeList = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }

        Collections.sort(nodeList);

        Tree root = new Tree();
        root.root = nodeList.get(0);
        for(int i = 1; i < nodeList.size();i ++) {
            root.insert(nodeList.get(i));
        }

        List<Integer> preList = new ArrayList<>();
        preOrder(preList, root.root);
        List<Integer> postList = new ArrayList<>();
        postOrder(postList, root.root);

        int[][] answer = new int[2][nodeinfo.length];

        for(int i = 0; i < nodeList.size(); i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }

        return answer;
    }

    static void preOrder(List<Integer> list, Node node) {
        if(node == null) return;

        list.add(node.index);
        preOrder(list, node.l);
        preOrder(list, node.r);
    }

    static void postOrder(List<Integer> list, Node node) {
        if(node == null) return;

        postOrder(list, node.l);
        postOrder(list, node.r);
        list.add(node.index);
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int index;
        Node l;
        Node r;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public int compareTo(Node node) {
            if(this.y == node.y) {
                return this.x - node.x;
            }
            return node.y - this.y;
        }
    }

    static class Tree{
        Node root;

        void insert(Node node) {
            Node parent = root;
            while (true) {
                if(parent.x > node.x) {
                    if(parent.l != null)
                        parent = parent.l;
                    else {
                        parent.l = node;
                        break;
                    }

                } else if(parent.x < node.x) {
                    if(parent.r != null)
                        parent = parent.r;
                    else{
                        parent.r = node;
                        break;
                    }
                }
            }
        }
    }

}
