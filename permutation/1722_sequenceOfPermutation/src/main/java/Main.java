import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
                for(int j = 0; j <= numbers.size(); j++) {
                    if(factorial[n-i] >= k) {
                        sb.append(numbers.get(j)+" ");
                        numbers.remove(j);
                        break;
                    }
                    k -= factorial[n-i];
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
