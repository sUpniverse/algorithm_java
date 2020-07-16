import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int longest;
    static ArrayList<Node> nodeArrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while (T -- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // 트리 구성
            nodeArrayList = new ArrayList<Node>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                nodeArrayList.add(new Node(null, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Node node = setTree(0);

            // 루트노드의 자손들의 높이 계산
            int solve = solve(node);
            sb.append(solve).append("\n");
        }
        System.out.println(sb);
    }

    static int height(Node root) {
        ArrayList<Integer> heights = new ArrayList<Integer>();

        for(int i = 0 ; i < root.getChildren().size(); i++)
            heights.add(height(root.getChildren().get(i)));

        if(heights.isEmpty()) return 0;

        Collections.sort(heights);

        if(heights.size() >= 2)
            longest = Math.max(longest, 2 + heights.get(heights.size()-2) + heights.get(heights.size() - 1));

        return  heights.get(heights.size()-1) + 1;
    }

    static int solve(Node node) {
        longest = 0;

        int h = height(node);
        return Math.max(longest, h);
    }

    static Node setTree(int root) {
        Node node = new Node();

        for(int i = 0; i < nodeArrayList.size(); i++) {
            if(isChild(root, i))
                node.getChildren().add(setTree(i));
        }

        return node;
    }

    static boolean isChild(int parent, int node) {
        //포함 여부를 물어봐야함 (공식적용)
        if(!have(nodeArrayList.get(parent), nodeArrayList.get(node))) return false;
        for(int i = 0; i < nodeArrayList.size(); i++){
            if(i != parent && i != node && have(nodeArrayList.get(parent), nodeArrayList.get(i)) && have(nodeArrayList.get(i),nodeArrayList.get(node)))
                return false;
        }
        return true;
    }

    static boolean have(Node parent, Node node) {
        // 공식 적용 : 부모의 반지름이 자식보다 크고 &&  자식의 반지름 - 부모의 반지름 > 두 중심 거리
        if(parent.getR() > node.getR()) {
            double r =  Math.pow(parent.getR() - node.getR(),2);
            double d = Math.pow(node.x - parent.x, 2) + Math.pow(node.y - parent.y,2);
            if(r > d)
                return true;
        }
        return  false;
    }


    static class Node {
        private List<Node> children = new ArrayList<Node>();
        private int x;
        private int y;
        private int r;

        public Node(List<Node> children, int x, int y, int r) {
            this.children = new ArrayList<Node>();
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public List<Node> getChildren() {
            return children;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getR() {
            return r;
        }

        public Node() {
        }
    }



}
