import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] map;
    static boolean[] visited;
    static int value  = Integer.MIN_VALUE;
    static int r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);

        map = new int[r][c];
        visited = new boolean[26];

        for(int i = 0; i < r; i++) {
            String[] ch = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                map[i][j] = ch[j].charAt(0)-'A';
            }
        }

        search(0, 0, 1);

        System.out.println(value);

    }

    static void search(int x, int y,int count) {
        visited[map[x][y]] = true;
        value = Math.max(value,count);

        for(int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if(ax >= 0 && ax < r && ay >= 0 && ay < c && !visited[map[ax][ay]]) {
                search(ax, ay, count+1);
            }
        }
        visited[map[x][y]] = false;
    }
}
