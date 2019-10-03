    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {

        static int[][] cache;
        static int[] arr;
        static int MAX_VALUE = 300;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int number = Integer.parseInt(br.readLine());

            cache = new int[2][MAX_VALUE];
            arr = new int[MAX_VALUE];

            for(int i = 0; i < number; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            cache[0][0] = arr[0];
            cache[1][0] = 0;
            cache[0][1] = arr[0] + arr[1];
            cache[1][1] = arr[1];
            for(int i = 2; i < number; i++) {
                cache[0][i] = cache[1][i-1] + arr[i];
                cache[1][i] = Math.max(cache[0][i-2],cache[1][i-2]) + arr[i];
            }

            int top = Math.max(cache[0][number-1],cache[1][number-1]);
            System.out.println(top);

        }
    }
