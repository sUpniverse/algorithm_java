import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] person = new int[n];
        for(int i = 0; i < n; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person);

        int sum = 0;
        int time = 0;
        for(int i = 0; i < n; i++) {
            sum += time + person[i];
            time += person[i];
        }

        System.out.println(sum);

    }
}
