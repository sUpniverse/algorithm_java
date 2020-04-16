import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map,g,build;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Dot> queue;
    static int n;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        g = new int[n][n];
        build = new int[n][n];
        queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                build[i][j] = -1;
                if(map[i][j] == 1) {
                    queue.add(new Dot(i, j));
                    build[i][j] = 0;
                }
            }
        }
        int cnt = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && g[i][j] == 0)  {
                    g[i][j] = cnt;
                    dfs(i, j, cnt);
                    cnt++;
                }
            }
        }



        while (!queue.isEmpty()){
            Dot remove = queue.remove();
            bfs(remove.x,remove.y);
        }

        min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if(g[nx][ny] != g[i][j]) {
                            int tmp = build[nx][ny] + build[i][j];
                            min = Math.min(min, tmp);
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }


    static void bfs(int x, int y) {

        for(int i =0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                if(build[nx][ny] == -1) {
                    queue.add(new Dot(nx, ny));
                    g[nx][ny] = g[x][y];
                    build[nx][ny] = build[x][y] +1;
                }
            }
        }
    }

    static void dfs(int x,int y, int cnt) {

        for(int i =0; i < 4; i++) {
            int nx = x+ dx[i];
            int ny = y+ dy[i];

            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                if(map[nx][ny] == 1 && g[nx][ny] == 0) {
                    g[nx][ny] = cnt;
                    dfs(nx, ny, cnt);
                }
            }
        }
    }

    static private class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
