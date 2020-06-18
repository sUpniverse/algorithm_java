import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int n,answer;
    static long m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());


        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;

        int first = 0;
        int second = 0;
        int sum = 0;

        while (true) {
            if(sum >= m) {
                sum -= array[first++];
                answer = Math.min(answer, second-first+1);
            } else if (second == n){
                break;
            } else {
                sum += array[second++];

            }
        }

        if(answer == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}
