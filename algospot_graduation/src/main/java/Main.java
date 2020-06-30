import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n,m,k,l;
    static int[] pre,open;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        while (T-- > 0) {

            n = sc.nextInt(); // 총 과목수
            k = sc.nextInt(); // 필수 과목 수
            m = sc.nextInt(); // 최대 학기수
            l = sc.nextInt(); // 한학기에 들을 수 있는 최대 과목수

            pre = new int[12];
            open = new int[10];
            dp = new int[10][1<<12];

            // memoization을 위한 초기화
            for (int i = 0; i < 10; i++)
                Arrays.fill(dp[i], -1);

            // 선수해야할 과목
            for (int i = 0; i < n; i++) {
                int cnt = sc.nextInt();
                for (int j = 0; j < cnt; j++) {
                    int p = sc.nextInt();
                    pre[i] |= (1 << p);
                }
            }

            // 학기마다 개설되는 과목
            for (int i = 0; i < m; i++) {
                int cnt = sc.nextInt();
                for (int j = 0; j < cnt; j++) {
                    int p = sc.nextInt();
                    open[i] |= (1 << p);
                }
            }

            int result = graduation(0, 0);
            if (result == INF) {
                sb.append("IMPOSSIBLE").append("\n");
                continue;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static final int INF = 987654321;

    static int graduation(int count, int now) {
        if(Integer.bitCount(now) >= k) return 0;

        if(count == m) return INF;

        if(dp[count][now] != -1) return dp[count][now];

        dp[count][now] = INF;

        int canTake = (open[count] & ~now);

        for(int i = 0; i < n; i++) {
            if((canTake & (1 << i)) > 0 && (now & pre[i]) != pre[i]) {
                canTake &= ~(1 << i);
            }
        }

        for(int take = canTake;  take > 0; take = ((take-1) & canTake)) {
            if(Integer.bitCount(take) > l) continue;
            dp[count][now] = Math.min(dp[count][now], graduation(count+1, now | take) + 1);
        }

        dp[count][now] = Math.min(dp[count][now], graduation(count+1, now));
        return  dp[count][now];

    }
}