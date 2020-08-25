import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Main {

    static int[] cache;
    static int[] arr;
    static int MAX_VALUE = 100000;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringTokenizer st;

        cache = new int[MAX_VALUE];
        arr = new int[MAX_VALUE];

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        cache[0] = arr[0];
        int top = cache[0];
        for(int i = 1; i < n; i++) {
            cache[i] = Math.max(cache[i-1]+arr[i], arr[i]);
            top = Math.max(top,cache[i]);
        }

        System.out.println(top);

    }
}
