import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] order = {{0,1},{0,-1},{-1,0},{1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] split = s.split("");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int x = Integer.parseInt(split[2]);
        int y = Integer.parseInt(split[3]);
        int k = Integer.parseInt(split[4]);

        int[][] map = new int[N][M];

        map[x][y] = 0;
        for(int i = 0; i < x; i++) {
            String[] count = br.readLine().split("");
            for(int j = 0; j < y; j++)
                map[x][y] = Integer.parseInt(count[j]);
        }

        String[] orders = br.readLine().split("");
        for(int i = 0; i < k; i++) {
            int num = Integer.parseInt(orders[i]);
            int dx = x + order[num-1][0];
            int dy = y + order[num-1][1];
            if(dx >= 0 || dx < x || dy >= 0 || dy < y) {
                if(map[dx][dy] == 0) {

                } else {

                }
            }
        }


    }
}
