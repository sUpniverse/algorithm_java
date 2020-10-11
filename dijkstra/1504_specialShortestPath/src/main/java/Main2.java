import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    static int n,e;
    static ArrayList<Node>[] arrayLists;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayLists[a].add(new Node(b, c));
            arrayLists[b].add(new Node(a, c));
        }

        dist = new int[n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int a1 = dijkstra(1, v1) + dijkstra(v1, v2) +  dijkstra(v2, n);
        int a2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        int min = Math.min(a1, a2);

        if(min == Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        dist[start] = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(visited[temp.index]) continue;
            for (Node node : arrayLists[temp.index]) {
                if(!visited[node.index] && dist[node.index] > dist[temp.index] + node.cost) {
                    dist[node.index] =  dist[temp.index] + node.cost;
                    queue.offer(new Node(node.index, dist[node.index]));
                }
            }
        }

        if(dist[end] == Integer.MAX_VALUE || dist[end] == Integer.MIN_VALUE)
            dist[end] = Integer.MIN_VALUE;
        return dist[end];
    }




    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
