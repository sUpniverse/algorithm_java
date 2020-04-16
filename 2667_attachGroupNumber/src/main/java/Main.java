import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,count;


    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0) continue;
                count = 0;
                find(i, j);
                if(count > 0) list.add(count);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int a : list) {
            System.out.println(a);
        }

    }

    static void find(int x,int y) {
        map[x][y] = 0;
        count++;

        for(int i = 0; i <4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n ) {
                if(map[nx][ny] == 1) find(nx,ny);
            }
        }

    }
}
