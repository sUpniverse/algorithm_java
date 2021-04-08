import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] coin = new int[n];
      String s = br.readLine();
      String[] split = s.split(" ");
      for(int i = 0; i < n; i++) {
        coin[i] = Integer.parseInt(split[i]);
      }
      int k = Integer.parseInt(br.readLine());

      int[] dp = new int[k+1];
      dp[0] = 1;


      for(int i = 0; i < n; i++) {
        for(int j = coin[i]; j < k+1; j++) {
          dp[j] += dp[j - coin[i]];
        }
      }
      System.out.println(dp[k]);
    }
  }
}
