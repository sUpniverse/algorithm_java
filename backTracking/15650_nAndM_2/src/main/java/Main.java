import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n;
    static int m;
    static boolean[] check;
    static ArrayList<Integer> array;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        array = new ArrayList<Integer>();
        sb = new StringBuilder();

        combination(0, 0);

        System.out.println(sb);
    }

    static void combination(int index, int depth) {
        if(depth == m){
            for(int a : array)
                sb.append(a).append(" ");
            sb.append("\n");
        }

        for(int i = index+1; i <= n; i++) {
            array.add(i);
            combination(i,depth+1);
            array.remove(array.indexOf(i));
        }
    }
}
