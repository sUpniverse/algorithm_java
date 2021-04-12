import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String[] split = s.split(" ");
    int n = Integer.parseInt(split[0]);
    int k = Integer.parseInt(split[1]);

    int[] arr = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[k+1];
    dp[0] = 1;

    for(int i = 0; i < n; i++) {
      for(int j = arr[i]; j < k+1; j++) {
        dp[j] += dp[j - arr[i]];
      }
    }
    System.out.println(dp[k]);
  }
}
