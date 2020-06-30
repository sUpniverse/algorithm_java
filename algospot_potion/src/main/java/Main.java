import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] r;
    static int[] p;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            r = new int[n];
            p = new int[n];
            answer = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());

            }

            get();
            for(int i = 0; i < n; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void get() {
        int gcd = r[0];
        for(int i = 1; i < n; i++)
            gcd = gcd(gcd, r[i]);

        int a = gcd;

//        do {
//            a++;
//        } while (r[0]*a/gcd < p[0]);

        for(int i = 0 ; i < n; i++) {
            a = Math.max(a, ceil(p[i]*gcd,r[i]));
        }

        for(int i = 0; i < n; i++) {
            answer[i] = (r[i]*a/gcd) - p[i];
        }

    }

    static int ceil(int a, int b) {
        return (a + b -1) / b;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
