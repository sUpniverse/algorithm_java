import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] list;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[n];
        if(Integer.parseInt(st.nextToken()) == 1) {

        } else {
            for(int i =0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            
        }

    }
}
