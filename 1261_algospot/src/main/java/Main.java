import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int n,m,answer;
    static int[][] map,visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[m][n];
        visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            split = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        answer = 0;
        Queue<Dot> queue = new PriorityQueue<>();
        queue.add(new Dot(0, 0, 0));
        visited[0][0] = 0;

        while(!queue.isEmpty()) {
            Dot tmp = queue.remove();
            int x = tmp.x;
            int y = tmp.y;
            int count = tmp.count;

            if(x == m-1 && y == n-1) {
                answer = count;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int ax = dx[i] + x;
                int ay = dy[i] + y;

                if(ax >= 0 && ax < m && ay >= 0 && ay < n) {
                    if(visited[ax][ay] > visited[x][y]+map[ax][ay]) {
                        visited[ax][ay] = visited[x][y]+ map[ax][ay];
                        queue.add(new Dot(ax, ay, visited[ax][ay]));
                    }
                }
            }

        }

        System.out.println(answer);

    }

    static class Dot implements Comparable<Dot>{
        int x;
        int y;
        int count;

        public Dot(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }


        @Override
        public int compareTo(Dot o) {
            return this.count < o.count ? -1 : 1;
        }
    }

}
