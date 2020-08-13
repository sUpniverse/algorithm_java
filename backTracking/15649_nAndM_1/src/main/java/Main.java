import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;
    static int n;
    static int m;
    static StringBuilder sb;
    static ArrayList<Integer> array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        sb = new StringBuilder();

        array = new ArrayList<Integer>();
        check = new boolean[n+1];

        permutation(0);

        System.out.println(sb);

    }

    static void permutation(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                array.add(i);
                check[i] = true;
                permutation(depth+1);
                array.remove(array.indexOf(i));
                check[i] = false;
            }
        }
    }
}
