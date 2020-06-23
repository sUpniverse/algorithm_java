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
        int e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[e+1];
        int[] distance = new int[e+1];

        for(int i = 1; i < e+1; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < v+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Edge> queue = new PriorityQueue<>();

        queue.add(new Edge(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()) {
            Edge poll = queue.poll();

            if(distance[poll.index] < poll.distance) continue;

            for(Edge edge : graph[poll.index]) {
                if(distance[edge.index] > edge.distance + distance[poll.index]) {
                    distance[edge.index] = edge.distance + distance[poll.index];
                    queue.add(new Edge(edge.index, distance[edge.index]));
                }

            }
        }

        System.out.println(distance[end]);


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
