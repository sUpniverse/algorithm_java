import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Dot>[] map;
    static int n,m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        int[] dist = new int[n+1];
        int[] result = new int[n+1];

        for(int i = 1; i < n+1; i++) {
            map[i] = new ArrayList<Dot>();
        }

        for(int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int d =  Integer.parseInt(st.nextToken());
            int t =  Integer.parseInt(st.nextToken());
            map[s].add(new Dot(d, t));

        }


        for(int i = 1; i < n+1; i++) {
            result[i] =  dijkstra(x,i,dist) + dijkstra(i, x, dist);     //갔다가 와야 하므로 가는 최단거리 + 오는 최단거리
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i < n+1; i++) {
           max = Math.max(max, result[i]);
        }

        System.out.println(max);

    }

    private static int dijkstra(int start, int end, int[] dist) {

        for(int i = 1; i < n+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        Queue<Dot> queue = new PriorityQueue<Dot>();
        queue.add(new Dot(start, 0));

        while(!queue.isEmpty()) {
            Dot tmp = queue.remove();

            if(dist[tmp.idx] < tmp.dist) continue;

            for(Dot dot : map[tmp.idx]) {
                if(dist[dot.idx] > dist[tmp.idx] + dot.dist) {
                    dist[dot.idx] = dist[tmp.idx] + dot.dist;
                    queue.add(new Dot(dot.idx, dist[dot.idx]));
                }

            }
        }

        return dist[end];
    }

    private static class Dot implements Comparable<Dot>{
        int idx;
        int dist;

        public Dot(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Dot o) {
            return this.dist - o.dist;
        }
    }
}
