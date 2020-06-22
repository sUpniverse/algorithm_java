import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[n+1];

        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] dist = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        for(int i = 0; i < n+1; i++) dist[i] = Integer.MAX_VALUE;

        Queue<Node> queue = new PriorityQueue<Node>();

        dist[s] = 0;
        queue.add(new Node(s, 0));

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            if(dist[tmp.idx] < tmp.cost) continue;

            for(Node node : graph[tmp.idx]) {
                if(dist[node.idx] > dist[tmp.idx] + node.cost) {
                    dist[node.idx] = dist[tmp.idx] + node.cost;
                    queue.add(new Node(node.idx,dist[node.idx]));
                }
            }

        }

        for(int i = 1; i < n+1; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }



    }

    private static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
