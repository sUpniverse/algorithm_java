import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int T = Integer.parseInt(s);

    while (T --> 0) {

      int n = Integer.parseInt(br.readLine());
      String string = br.readLine();
      String[] split = string.split(" ");

      int[] arr = new int[n+1];
      int[] sum = new int[n+1];

      for(int i = 1; i <= n; i++) {
        arr[i] = Integer.parseInt(split[0]);
        sum[i] = arr[i] + sum[i-1];
      }

      int[][] dp = new int[n+1][n+1];

      for(int gap = 1; gap < n; gap++) {
        for(int start = 1; start+gap < n; start++) {
          int end = start+gap;
          dp[start][gap] = Integer.MAX_VALUE;
          for(int mid = start; mid < end; mid++) {
            dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid+1][end]);
          }
          dp[start][end] += sum[end] - sum[start-1];
        }
      }
      System.out.println(dp[1][n]);
    }
  }

}
