import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[][] cache;
    static int MAX_VALUE = 1000;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());

        arr = new int[MAX_VALUE];
        cache = new int[MAX_VALUE][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int top = 0;

        for(int i = 0; i < number; i++) {
            cache[i][0] = 1;
            cache[number-i-1][1] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    cache[i][0] = Math.max(cache[j][0] + 1,cache[i][0]);
                }
                if(arr[number-i-1] > arr[number-j-1]) {
                    cache[number-i-1][1] = Math.max(cache[number-j-1][1] + 1,cache[number-i-1][1]);
                }
            }
        }

        for(int i = 0; i < number; i++) {
            top = Math.max(cache[i][0]+cache[i][1],top);
        }

        System.out.println(top-1);
    }
}
