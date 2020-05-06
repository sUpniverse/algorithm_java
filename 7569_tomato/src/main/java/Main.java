import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;
    static int M,N,H,count,tomato;
    static Queue<Dot> queue;
    static int[] dx = {0,-1,0,1,0,0};
    static int[] dy = {-1,0,1,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        queue = new LinkedList<>();
        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                st  = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    map[i][j][k] = a;
                    if(a == 0) {
                        tomato++;
                    } else if(a == 1) {
                        queue.add(new Dot(i, j, k));
                    }
                }
            }
        }


        if(tomato == 0) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()) {
            Dot dot = queue.remove();
            for(int i = 0; i < 6; i++) {
                int a = dx[i] + dot.x;
                int b = dy[i] + dot.y;
                int c = dz[i] + dot.z;
                if(a >= 0 && a < N && b >= 0 && b < M && c >= 0 && c < H) {
                    if(map[a][b][c] == 0) {
                        map[a][b][c] = map[dot.x][dot.y][dot.z] + 1;
                        queue.add(new Dot(a, b, c));
                    }
                }
            }
        }

        count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < H; k++) {
                    if(map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    count = Math.max(count, map[i][j][k]);
                }
            }
        }
        System.out.println(count-1);
    }


    static class Dot {
        int x;
        int y;
        int z;

        public Dot(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
