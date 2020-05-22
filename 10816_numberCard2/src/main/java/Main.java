import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken()) + 10000000;
            array[a] = array[a] + 1;
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken()) + 10000000;
            sb.append(array[b]+" ");
        }

        System.out.println(sb);
    }
}
