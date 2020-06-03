import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);

        int sum = 0;
        int collect = 0;
        for(int a : arrayList) {
            sum += a + collect;
            collect += a;
        }

        System.out.println(sum);
    }
}
