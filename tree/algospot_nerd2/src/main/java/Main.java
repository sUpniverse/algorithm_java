import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            count = 0;
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            Node root = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            count++;
            sum = count;
            for(int i = 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                setTree(root,new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                sum += count;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static void setTree(Node root, Node node) {
        if(root.p < node.p && root.q < node.q) {
            if(root.R == null) root.R = node;
            else setTree(root.R, node);
            return;
        }
        if(root.L == null) {
            root.L = node;
            count++;
        }
        else setTree(root.L, node);
    }


    static class Node {
        int p;
        int q;
        Node L;
        Node R;

        public Node(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}
