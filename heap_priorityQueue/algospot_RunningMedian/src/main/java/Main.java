import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        List<Long> arrayList;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long[] array = new long[n];
            arrayList = new ArrayList<Long>();

            array[0] = 1983;
            arrayList.add(array[0]);
            long sum = 1983;

            for(int i = 1; i < n; i++) {
                array[i] = (array[i-1]*a+b) % 20090711;
                arrayList.add(array[i]);
                Collections.sort(arrayList);
                sum += arrayList.size() % 2 == 0 ?  arrayList.get(arrayList.size()/2 - 1) : arrayList.get(arrayList.size()/2);
            }

            sb.append(sum % 20090711).append("\n");
        }

        System.out.println(sb);
    }


}
