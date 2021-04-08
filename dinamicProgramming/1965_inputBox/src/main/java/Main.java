import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] array = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        // 나보다 작으면서도 && 내 dp값보다 더 큰 값을 가진 녀석
        if (array[j] < array[i] && dp[i] <= dp[j]) {
          dp[i] = dp[j] + 1;
        }
      }
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}
