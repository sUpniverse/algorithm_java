import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();


        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i <k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            arrayList.add(a);
        }

        Collections.sort(arrayList);

        long max = arrayList.get(k-1);
        long min = 1;
        long mid = 0;
        while(min <= max) {
            mid = (max+min)/2;
            long count = 0;
            for(int a : arrayList) {
                count += a / mid;
            }

            if (count >= n) {
                min = mid+1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}
