import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] dx = {-1,0,1,0,-1,-1,1,1};
    static int[] dy = {0,1,0,-1,-1,1,-1,1};
    static int w,h,count;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            map = new int[h][w];
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            list = new ArrayList<>();
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 0) continue;
                    find(i,j);
                    if(count>0) list.add(1);
                }
            }
            System.out.println(list.size());

        }
    }

    static void find(int x, int y) {
        map[x][y] = 0;
        count++;
        for(int i = 0; i < 8; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if(map[nx][ny] == 1) find(nx,ny);
            }
        }
    }
}
