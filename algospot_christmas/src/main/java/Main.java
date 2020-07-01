import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] psum;
    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            psum = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            psum[0] = 0;
            for(int i = 1; i <= n; i++) {
                psum[i] = (a[i-1] + psum[i-1]) % k;
            }

            System.out.println(one(k)+" "+multiple(k));
        }
    }

    static int one(int k) {
        int mod = 20091101;
        int answer = 0;
        long[] count = new long[k];

        for(int i = 0 ; i < psum.length; i++)
            count[psum[i]]++;

        for(int i = 0; i < k; i++) {
            if(count[i] >= 2)
                answer = (int) (answer + ((count[i] * (count[i]-1)) / 2 )) % mod;
        }

        return answer;
    }

    static int multiple(int k) {
        int[] dp = new int[psum.length];
        int[] prev = new int[k];

        Arrays.fill(prev, -1);

        for(int i = 0; i < psum.length; i++) {
            if(i > 0)
                dp[i] = dp[i-1];
            else
                dp[i] = 0;

            int loc = prev[psum[i]];
            if(loc != -1) dp[i] = Math.max(dp[i],dp[loc]+1);

            prev[psum[i]] = i;
        }

        return dp[psum.length-1];
    }
}
