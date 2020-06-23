import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Edge>[] graph;
    static int n,m,t,s,g,h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];

            for(int i = 1; i < n+1; i++) graph[i] = new ArrayList<Edge>();

            for(int i = 1; i < m+1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if((a == g && b == h) || (a == h && b == g)) {
                    graph[a].add(new Edge(b, c*2-1));
                    graph[b].add(new Edge(a, c*2-1));
                    continue;
                }
                graph[a].add(new Edge(b, c*2));
                graph[b].add(new Edge(a, c*2));
            }


            ArrayList<Integer> answer = new ArrayList<>();

            for(int i = 1; i < t+1; i++) {
                st = new StringTokenizer(br.readLine());
                int d =  Integer.parseInt(st.nextToken());
                answer.add(d);
            }

            int[] dist = dijkstra(s);

            Collections.sort(answer);
            for(int i : answer) {
                if(dist[i] % 2 == 1)
                    sb.append(i).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, 10_000_000);
        boolean[] visited = new boolean[n+1];
        Queue<Edge> queue = new PriorityQueue<Edge>();
        queue.add(new Edge(start, 0));

        dist[start] = 0;

        while (!queue.isEmpty()) {
            Edge next = queue.poll();

            if(visited[next.index]) continue;
            visited[next.index] = true;

            for(Edge edge : graph[next.index]) {
                if(dist[edge.index] > edge.distance + dist[next.index]) {
                    dist[edge.index] = edge.distance + dist[next.index];
                    queue.add(new Edge(edge.index,dist[edge.index]));
                }
            }
        }
        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int index;
        int distance;

        public Edge(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }

    }
}
