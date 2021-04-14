import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] array = new int[n+1];

    for(int i = 1; i <= n; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[n+1];

    dp[1] = array[1];
    if(n > 1) {
      dp[2] = dp[1] + array[2];
    }

    for(int i = 3 ; i <= n; i++) {
      dp[i] = Math.max(dp[i-2] + array[i], Math.max(dp[i-3]+array[i-1]+array[i], dp[i-1]));
    }


    System.out.println(dp[n]);

  }
}
