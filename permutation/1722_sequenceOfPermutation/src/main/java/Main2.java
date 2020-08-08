import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] factorial = new long[n+1];

        factorial[0] = 1;
        for(int i = 1; i <= n; i++)
            factorial[i] = factorial[i-1] * i;

        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            numbers.add(i);

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        if(Integer.parseInt(st.nextToken()) == 1) {
            Long k = Long.parseLong(st.nextToken());
            for(int i = 1; i <= n; i++) {
                long sum = 0;
                for(int j = 0; j < numbers.size(); j++) {
                    sum += factorial[n-i];
                    if(sum >= k) {
                        sum -= factorial[n-i];
                        k -= sum;
                        sb.append(numbers.get(j)+" ");
                        numbers.remove(j);
                        break;
                    }
                }
            }
        } else {
            long sum = 0;
            for(int i = 1; i <= n; i++) {
                int index = numbers.indexOf(Integer.parseInt(st.nextToken()));
                sum += index * factorial[n-i];
                numbers.remove(index);
            }
            sb.append(sum+1);
        }
        System.out.println(sb);
    }
}
