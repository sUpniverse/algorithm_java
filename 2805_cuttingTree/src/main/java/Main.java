import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        int max = 1000000000;
        int min = 0;

        while(min <= max) {
            int mid = (max+min)/2;

            long height = 0;

            for(int a : arrayList) {
                if(a > mid) {
                    height += a - mid;
                }
            }

            if(height >= m) {
                min  = mid+1;
            } else {
                max = mid-1;
            }
        }

        System.out.println(max);

    }
}
