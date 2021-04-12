import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

  // dp[n] = dp[n-1] + 지금 or dp[n] = dp[n-2] + 지
  // dp[n] = max(dp[n-1], dp[n-2]) + array[n]
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] array = new int[n+1];

    for(int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }

    int[][] dp = new int[n+1][2];

    dp[0][0] = array[0];
    dp[0][1] = 0;
    dp[1][0] = array[0] + array[1];
    dp[1][1] = array[1];

    for(int i = 2; i < n; i++) {
      dp[i][0] = dp[i-1][1] + array[i];
      dp[i][1] = Math.max(dp[i-2][1], dp[i-2][0]) + array[i];
    }

    System.out.println(Math.max(dp[n-1][1],dp[n-1][0]));
  }
}
