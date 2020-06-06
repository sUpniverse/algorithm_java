import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int e = Integer.parseInt(st.nextToken()) % 15;
        int s = Integer.parseInt(st.nextToken()) % 28;
        int m = Integer.parseInt(st.nextToken()) % 19;

        int i = 0;
        while(i%15 != e || i%28 !=s || i%19 !=m) i++;


        System.out.println(i);

    }

}
