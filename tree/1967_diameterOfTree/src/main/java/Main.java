import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static ArrayList<Node>[] arrayLists;
    static int[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<Node>();
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayLists[a].add(new Node(b, c));
            arrayLists[b].add(new Node(a, c));
        }

        BFS(1);

        int edge = getMax();
        BFS(edge);

        int second = check[getMax()];

        System.out.println(second);

    }

    private static int getMax() {
        int max = 0;
        int edge = 0;
        for(int i  = 1; i <= n; i++) {
            if(max < check[i]) {
                max = check[i];
                edge = i;
            }
        }
        return edge;
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        check = new int[n+1];

        queue.add(start);
        check[start] = 0;

        while (!queue.isEmpty()) {
            Integer a = queue.poll();
            for(Node node : arrayLists[a]) {
                if(check[node.v] > 0)
                    continue;
                queue.add(node.v);
                check[node.v] = check[a] + node.w;
            }
        }
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
