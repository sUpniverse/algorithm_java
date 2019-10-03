import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] cache;


    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        cache = new long[201][201];

        for(int i = 1; i <= k; i++) {
            cache[0][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=k; j++) {
                cache[i][j] = (cache[i-1][j] + cache[i][j-1]) % 1000000000;
            }
        }

        System.out.println(cache[n][k] % 1000000000);
    }
}
