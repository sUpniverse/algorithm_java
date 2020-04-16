import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int M,N,tomato,count;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Dot> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        tomato = 0;
        count = 0;
        int value = 0;
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == 0) {
                    tomato++;
                } else if(value == 1) {
                    queue.add(new Dot(i, j));
                }
            }
        }
        if(tomato == 0) {
            System.out.println(0);
            return;
        }

        // 하루 경과 카운트
        // 하루 경과했을때, 현재의 1인 토마토들의 좌우위아래를 1로 바꿔줌
        // 전체 스캔

        while (!queue.isEmpty()) {
            Dot dot = queue.remove();
            find(dot.x, dot.y);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, map[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    ans = 0;
                }
            }
        }

        System.out.println(ans-1);
    }

    static void find(int x, int y) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(map[nx][ny] == 0 && !visited[nx][ny]) {
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
