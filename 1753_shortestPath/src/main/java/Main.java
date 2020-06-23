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
        queue.add(new Node(s, 0));    // S의 원소 시작점을 맨처음에 넣어준다.

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();        // S의 원소를 추출

            if(dist[tmp.idx] < tmp.cost) continue;  // 새로 탐색된 노드의 거리가 이미 탐색된 거리보다 크다면 바로 pass

            for(Node node : graph[tmp.idx]) {       // 새로 탐색된 노드의 인접한 노드의 거리를 이용하여 갱신(크면 갱신 작으면 놔둠)
                if(dist[node.idx] > dist[tmp.idx] + node.cost) {
                    dist[node.idx] = dist[tmp.idx] + node.cost;
                    queue.add(new Node(node.idx,dist[node.idx]));   // 갱신된 노드들은 방문하지 않은 노드에 해당하므로 큐에 넣어서 또 탐색에 나섬
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
