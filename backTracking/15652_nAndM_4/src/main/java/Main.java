import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n;
    static int m;
    static ArrayList<Integer> array;
    static StringBuilder sb;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        array = new ArrayList<Integer>();
        sb = new StringBuilder();
        visited = new int[n+1];

        condition(1,0);

        System.out.println(sb);

    }

    public static void condition(int value, int depth){
        if(depth == m) {
            for(int a : array)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = value; i <= n; i++) {
            array.add(i);
            condition(i,depth+1);
            array.remove(array.size()-1);
        }
    }
}
