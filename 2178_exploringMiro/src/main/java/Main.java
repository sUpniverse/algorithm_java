import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static Queue<Dot> queue;
    static int N,M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }


        queue = new LinkedList<>();
        queue.add(new Dot(0, 0));
        visited[0][0] = true;
        map[0][0] = 1;
        while(!queue.isEmpty()) {
            Dot remove = queue.remove();
            find(remove.x,remove.y);
        }

        System.out.println(map[N-1][M-1]);

    }

    static void find(int x, int y) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >=0 && ny < M) {
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new Dot(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }
    }

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
