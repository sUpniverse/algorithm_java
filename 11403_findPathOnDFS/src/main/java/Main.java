import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] ans;
    static int[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        ans = new int[n][n];
        check = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int m = Integer.parseInt(st.nextToken());
                map[i][j] = m;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && check[i] != 1) {
                    DFS(i,j);
                }
            }
            Arrays.fill(check,0);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void DFS(int a,int b) {
        check[b] = 1;
        ans[a][b] = 1;
        for(int i = 0 ; i < n; i++ ) {
            if(map[b][i] == 1 && check[i] != 1) {
                DFS(a,i);
            }
        }
    }
}
