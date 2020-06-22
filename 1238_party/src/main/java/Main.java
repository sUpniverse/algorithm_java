import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int d =  Integer.parseInt(st.nextToken());
            int t =  Integer.parseInt(st.nextToken());
            map[s][d] = t;
            dist[i] = Integer.MAX_VALUE;
        }


        dist[2] = 0;
        Queue<Dot> queue = new PriorityQueue<Dot>();
        queue.add(new Dot(0, dist[0]));

        while(!queue.isEmpty()) {
            Dot tmp = queue.remove();

            if(dist[tmp.idx] < tmp.dist) continue;

            for(int i = 1; i < m; i++) {
                if(dist[i] > dist[tmp.idx] + map[tmp.idx][i]) {
                    dist[i] = dist[tmp.idx] + map[tmp.idx][i];
                    queue.add(new Dot(i, dist[i]));
                }
            }
        }

    }

    private static class Dot {
        int idx;
        int dist;

        public Dot(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
