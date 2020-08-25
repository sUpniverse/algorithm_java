import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] things = new int[n+1][2];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(things[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-things[i][0]] +  things[i][1]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }

}
