import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int x = 1;
            int y = 0;
            int k = 0;
            while (k < N) {
                y++;
                for (int i = 1; i <= H; i++) {
                    x = i;
                    k++;
                    if (k == N)
                        break;
                }
            }

            System.out.format("%d%02d%n",x,y);
        }

    }

}
