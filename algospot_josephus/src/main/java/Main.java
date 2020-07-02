import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());


            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 1; i <= n; i++)
                arrayList.add(i);

            int v = 0;
            arrayList.remove(0);;

            while (arrayList.size() > 2) {
                v = (v + k-1) % arrayList.size();
                arrayList.remove(v);
            }

            for(int a : arrayList)
                sb.append(a).append(" ");
            sb.append("\n");

        }
        System.out.println(sb);
    }

}
