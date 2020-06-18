import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int n,m,answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++) {
            array[i]  = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < n ; i++) {
            search(0, i);
        }

        System.out.println(answer);

    }

    static void search(int sum, int idx) {
        if(idx == n) {
            if(sum == m) {
                answer++;
            }
            return;
        }

        if(sum == m) {
            answer++;
            return;
        }


        search(sum+array[idx],idx+1);

    }
}
