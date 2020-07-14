import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Node> list = new ArrayList<Node>();

        st = new StringTokenizer(br.readLine());
        Node root = new Node(st.nextToken(), null, null, null);
        Node l = new Node(st.nextToken(), null, null, root);
        Node r = new Node(st.nextToken(), null, null, root);
        root.setL(l);
        root.setR(r);
        list.add(root);
        list.add(l);
        list.add(r);

        for(int i = 1 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            String a = st.nextToken();
            String b = st.nextToken();
            for(int j = 1; j < list.size(); j++) {
                Node node = list.get(j);
                if(node.getData().equals(k)) {
                    l = new Node(a, null, null, node);
                    r = new Node(b, null, null, node);
                    node.setL(l);
                    node.setR(r);
                    list.add(l);
                    list.add(r);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        sb.append("\n");
        inOrder(root, sb);
        sb.append("\n");
        postOrder(root, sb);


        System.out.println(sb);

    }


    static void preOrder(Node node,StringBuilder sb) {
        if(node == null || ".".equals(node.getData())) {
            return;
        }

        sb.append(node.getData());
        preOrder(node.getL(), sb);
        preOrder(node.getR(), sb);

    }

    static void inOrder(Node node,StringBuilder sb) {
        if(node == null || ".".equals(node.getData())) {
            return;
        }

        inOrder(node.getL(), sb);
        sb.append(node.getData());
        inOrder(node.getR(), sb);

    }

    static void postOrder(Node node,StringBuilder sb) {
        if(node == null || ".".equals(node.getData())) {
            return;
        }

        postOrder(node.getL(), sb);
        postOrder(node.getR(), sb);
        sb.append(node.getData());

    }


    static class Node {
        String data;
        Node L;
        Node R;
        Node parent;

        public Node(String data, Node l, Node r, Node parent) {
            this.data = data;
            L = l;
            R = r;
            this.parent = parent;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getL() {
            return L;
        }

        public void setL(Node l) {
            L = l;
        }

        public Node getR() {
            return R;
        }

        public void setR(Node r) {
            R = r;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}
