import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] check;
    static int min,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new boolean[n];
        min = Integer.MAX_VALUE;

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            find(i,i, 0, 0);
        }

        System.out.println(min);

    }

    static void find(int start, int x,int sum,int cnt) {

        if(cnt == n && start == x) {
            min = Math.min(min,sum);
            return;
        }

        for(int j = 0; j < n; j++) {
            if(map[x][j] > 0 && !check[x]) {
                check[x] = true;
                sum += map[x][j];
                if(sum <= min)  find(start,j,sum,cnt+1);
                check[x] = false;
                sum -= map[x][j];
            }
        }
    }
}
