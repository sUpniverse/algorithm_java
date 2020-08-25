import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] cache;
    static int[] arr;
    static int MAX_VALUE = 1000;

    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());

        cache = new int[MAX_VALUE];
        arr = new int[MAX_VALUE];
        int top = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < number; i++) {
            cache[i] = arr[i];
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    cache[i] = Math.max(cache[i],cache[j]+arr[i]);
                }
            }
            top = Math.max(top,cache[i]);
        }

        System.out.println(top);
    }
}
