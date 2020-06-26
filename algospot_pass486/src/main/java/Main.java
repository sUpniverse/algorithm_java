import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());
            int answer = 0;

            for(int i = lo; i <= hi; i++) {
                int cnt =0;
                for(int j=1; j*j<i; j++) {
                    if(i%j==0)
                        cnt+=2;

                    if(j*j==i)          //제곱수 확인
                        cnt++;
                }

                if(cnt == n)
                    answer++;
            }


            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}
