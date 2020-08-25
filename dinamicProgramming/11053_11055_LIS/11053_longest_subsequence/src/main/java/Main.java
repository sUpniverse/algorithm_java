import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MAX_VALUE = 1000;
    static int[] cache;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int top = 0;

        arr = new int[MAX_VALUE];
        cache = new int[MAX_VALUE];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            cache[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    cache[i] = Math.max(cache[i],cache[j] + 1);
                }
            }
            top = Math.max(top,cache[i]);
        }

        System.out.println(top);

    }
}
