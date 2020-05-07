import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static boolean[][][] check;
    static int N,M,answer;
    static Queue<Dot> queue;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");


        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        check = new boolean[2][N][M];
        queue = new LinkedList<Dot>();
        answer = Integer.MAX_VALUE;

        queue.add(new Dot(0, 0,1,1));
        check[0][0][0] = true;

        for (int i = 0; i < N; i++) {
            String[] split1 = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split1[j]);
            }
        }

        while (!queue.isEmpty()) {

            Dot dot = queue.remove();

            if(dot.x == N-1 && dot.y == M-1) {
                answer = Math.min(answer,dot.count);
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int a = dot.x + dx[i];
                int b = dot.y + dy[i];

                if(a < 0 || a >= N || b < 0 || b >= M) continue;

                if(dot.crash == 1) {
                    if(map[a][b] == 1 && !check[0][a][b]) {
                        queue.add(new Dot(a, b,dot.count+1,dot.crash-1));
                        check[0][a][b] = true;
                    } else if(map[a][b] == 0 && !check[0][a][b]) {
                        queue.add(new Dot(a, b,dot.count+1,dot.crash));
                        check[0][a][b] = true;
                    }
                } else {
                    if(!check[1][a][b] && map[a][b] == 0) {
                        queue.add(new Dot(a, b,dot.count+1,dot.crash));
                        check[1][a][b] = true;
                    }
                }

            }
        }

        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }


    static class Dot {
        int x;
        int y;
        int count;
        int crash;

        public Dot(int x, int y, int count, int crash) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.crash = crash;
        }
    }



}
