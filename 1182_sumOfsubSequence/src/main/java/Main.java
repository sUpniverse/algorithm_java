import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] sequence;
    static int value,s,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());


        value =0;
        sequence  = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            composition(0, i, 0, 0);
        }

        System.out.println(value);

    }

    static void composition(int sum, int size,int count, int idx) {
        if(count == size) {
            if(sum == s) value++;
            return;
        }

        for(int i = idx; i < n; i++) {
            sum += sequence[i];
            composition(sum, size, count+1, i+1);
            sum -= sequence[i];
        }
    }

}
