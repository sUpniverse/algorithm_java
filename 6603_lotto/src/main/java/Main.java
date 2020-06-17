import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] list;

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = -1;

        do {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            list = new int[n];
            boolean[] visited = new boolean[50];
            sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            choice("",0,0);
            System.out.println(sb);

        }while (n != 0);

    }

    static void choice(String number, int idx,int now) {
        if(idx == 6) {
            sb.append(number);
            sb.append("\n");
            return;
        }

        for(int i = now; i <= now+n-6; i++) {
            if(i < n) {
                choice(number+list[i]+" ",idx+1,i+1);
            }
        }
    }
}
