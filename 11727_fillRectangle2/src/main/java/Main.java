import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] cache;

    public static void main(String[] agrs) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int n = Integer.parseInt(bufferedReader.readLine());

        cache = new int[n+1];

        System.out.println(bottomUp(n));
    }

    public static int topDown(int n) {

        if(n == 0 || n == 1) return 1;
        if(cache[n] != 0) return cache[n];

        cache[n] = (topDown(n-1) + 2*topDown(n-2)) % 10007;

        return cache[n];
    }

    public static int bottomUp(int n) {

        cache[0] = 1;
        cache[1] = 1;

        for(int i = 2; i <= n; i++) {
            cache[i] = (cache[i-1] + (2 * cache[i-2])) % 10007;
        }
        return cache[n];
    }
}
