import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

        static int[] cache;
//        static int[][] cache;


        public static void main(String[] args) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            int n = Integer.parseInt(reader.readLine());
//            cache = new int[1001][11];
            cache = new int[11];

            System.out.println(bottomUp(n));

        }

        public static int bottomUp(int n) {

            for(int i = 0; i  < 10; i++) {
                cache[i] = 1;
            }

            for(int i = 1; i < n; i++ ) {
                for(int j = 1; j < 10; j++) {
                    cache[j]  = (cache[j] + cache[j-1]) % 10007;
                }
            }

            int sum = 0;
            for(int i = 0 ; i < 10; i++) {
                sum += cache[i];
            }

//            for(int i = 2; i <= n; i++) {
//                for(int j = 0; j < 10; j++) {
//                    int sum = 0;
//                    for(int k = j; k < 10; k++) {
//                        sum += cache[i-1][k];
//                    }
//                    cache[i][j] = sum % 10007;
//                }
//            }

//            for(int i = 2; i <= n; i++ ) {
//                cache[i][0] = 1;
//                for(int j = 1; j < 10; j++) {
//                    cache[i][j]  = (cache[i-1][j] + cache[i][j-1]) % 10007;
//                }
//            }
//
//            int sum = 0;
//            for(int i = 0 ; i < 10; i++) {
//                sum += cache[n][i];
//            }


            return sum % 10007;
        }
}
