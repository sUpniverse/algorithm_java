import java.io.*;

public class Main {

    static int[][] cache;

    public static void main(String[] agrs) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int n = Integer.parseInt(bufferedReader.readLine());

        cache = new int[101][11];

        System.out.println(bottomUp(n));

    }

    public static long bottomUp(int n) {

        for(int i = 1; i < 10; i++) {
            cache[1][i] = 1;
        }


        for(int i = 2; i <= n; i++) {
            cache[i][0] = cache[i-1][1];
            for(int j = 1; j < 10; j++) {
                cache[i][j] = (cache[i-1][j-1] + cache[i-1][j+1]) % 1000000000;
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += cache[n][i];
        }

        return sum % 1000000000;
    }
}
