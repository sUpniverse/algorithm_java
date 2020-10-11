import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] graph;
    static int e,v;
    static boolean flag = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        e = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[e+1];
        int[] distance = new int[e+1];
        visited = new boolean[e+1];

        for(int i = 0; i < e+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i < v+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int a1 = dijkstra(1,v1,distance) + dijkstra(v1, v2, distance) + dijkstra(v2, e, distance);
        int a2 = dijkstra(1,v2,distance) + dijkstra(v2, v1, distance) + dijkstra(v1, e, distance);

        int answer = Math.min(a1, a2);

        if(flag) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);

    }

    private static int dijkstra(int start, int end, int[] distance) {
        for(int i = 1; i < e+1; i++) distance[i] = Integer.MAX_VALUE;
        for(int i = 1; i < e+1; i++) visited[i] = false;

        Queue<Edge> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge tmp = queue.poll();
            if(visited[tmp.index]) continue;
            for(Edge edge : graph[tmp.index]) {

                if(!visited[edge.index] && distance[edge.index] > distance[tmp.index] + edge.distance) {
                    distance[edge.index] = distance[tmp.index] + edge.distance;
                    queue.add(new Edge(edge.index, distance[edge.index]));

                }
            }
        }

        if(distance[end] == Integer.MAX_VALUE || distance[end] == Integer.MIN_VALUE)
            flag = true;

        return distance[end];
    }

    static class Edge implements Comparable<Edge> {
        int index;
        int distance;

        public Edge(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
}
