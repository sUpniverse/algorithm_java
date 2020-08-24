import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    /*
    * LIS를 응용한 문제 전기줄의 L or R을 정렬한 후 상대방의 값이 증가하는 폭이 가장 긴 부분 수열을 구하면 된다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Pair> list = new ArrayList<Pair>();
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new Pair(l,r));
        }

        Collections.sort(list);

        int[] cache = new int[n];
        cache[0] = 1;
        int max = 0;

        for(int i = 1; i < n; i++) {
            cache[i] = 1;
            for(int j = 0; j < i; j++) {
                if(list.get(j).r < list.get(i).r)
                    cache[i] = Math.max(cache[i],cache[j]+1);
            }

        }

        for(int i = 0; i < n; i++)
            max = Math.max(max,cache[i]);

        System.out.println(n-max);


    }

    static class Pair implements Comparable<Pair> {
        int l;
        int r;

        public int compareTo(Pair o) {
            return this.l - o.l;
        }

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
