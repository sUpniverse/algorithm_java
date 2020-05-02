import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] check;
    static int n,m,count;
    static int[] x = {0,1,0,-1};
    static int[] y = {-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        while(t--> 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            check = new int[n][m];

            List<Map<Integer,Integer>> list = new ArrayList<>();


            int l = Integer.parseInt(st.nextToken());
            for(int i = 0; i < l; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
                Map<Integer,Integer> coordi = new HashMap<>();
                coordi.put(b, a);
                list.add(coordi);
            }

            // map 전수조사
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 1 && check[i][j] == 0) {
                        DFS(i, j);
                        count++;
                    }
                }
            }

            count = 0;

            // 입력된 좌표만 조사
//            for(Map coordi : list) {
//                coordi.forEach((o, o2) -> {
//                    int i = (Integer) o;
//                    int j = (Integer) o2;
//                     if(map[i][j] == 1 && check[i][j] == 0) {
//                        DFS(i, j);
//                        count++;
//                    }
//                });
//            }

            System.out.println(count);
        }
    }

    static void DFS(int a, int b) {
        check[a][b] = 1;
        for(int i =0; i < 4; i++) {
            int nx = a + x[i];
            int ny = b + y[i];

            if(nx >= 0 && nx < n && ny >=0  && ny < m) {
                if(map[nx][ny] == 1 && check[nx][ny] == 0) {
                    DFS(nx,ny);
                }
            }
        }
    }

}
