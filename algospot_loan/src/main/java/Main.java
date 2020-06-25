import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());

            double N = Double.parseDouble(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            double P = Double.parseDouble(st.nextToken());

            double select = select(N, M, P);

            sb.append(select).append("\n");

        }

        System.out.println(sb);

    }

    static double balance(double N, int M, double rate, double C) {
        double result = N;

        for(int i = 0; i < M; i++) {
            result *= (1.0+(rate/12.0)/100);
            result -= C;
        }
        return result;
    }

    static double select(double N,int M, double rate) {
        double min = 0;
        double max = N * (1.0+(rate/12.0)/100.0);

        for(int i = 0; i < 100; i++) {
            double mid = (min + max) / 2.0;
            if(balance(N,M,rate, mid) <= 0)
                max = mid;
            else
                min = mid;
        }
        return max;
    }
}
