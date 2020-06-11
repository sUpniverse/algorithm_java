import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[100000];

        StringTokenizer st;

        //에라토스 테네스의 체 (소수 구하기)
        for(int i = 2; i < 10000; i++) {
            prime[i] = true;
        }

        for(int i = 2; i*i< 10000; i++) {
            for(int j = i*i; j <10000; j+=i) {
                prime[j] = false;
            }
        }
        //

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[] check = new boolean[10000];
            int[] count = new int[10000];

            Queue<Integer> queue = new LinkedList<Integer>();

            check[n] = true;
            queue.add(n);

            while(!queue.isEmpty()) {
                int v = queue.poll();

                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 10; j++) {
                        if(i == 0 && j == 0) continue;
                        int change = change(i, j, v);
                        if(prime[change] && !check[change]) {
                            count[change] = count[v] + 1;
                            check[change] = true;
                            queue.add(change);
                        }
                    }
                }
            }

            System.out.println(count[m]);
        }
    }

    static int change(int idx,int num,int value) {
        StringBuilder sb = new StringBuilder(String.valueOf(value));
        sb.setCharAt(idx, (char)(num+'0'));
        return Integer.parseInt(sb.toString());
    }


}
