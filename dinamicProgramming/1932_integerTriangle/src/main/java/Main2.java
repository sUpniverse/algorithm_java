import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] triangle = new int[n][n];
    int[][] dp = new int[n][n];

    for(int i = 0; i < n; i++) {
      String s = br.readLine();
      String[] split = s.split(" ");
      for(int j = 0; j < i+1; j++) {
        triangle[i][j] = Integer.parseInt(split[j]);
      }
    }

    dp[0][0] = triangle[0][0];
    for(int i = 1; i < n; i++) {
      dp[i][0] = dp[i-1][0]+triangle[i][0];
      dp[i][i] = dp[i-1][i-1]+triangle[i][i];
      for(int j = 1; j < i; j++) {
        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
      }
    }

    int max = 0;
    for(int i = 0; i<n; i++) {
      max = Math.max(max, dp[n-1][i]);
    }

    System.out.println(max);
  }
}
