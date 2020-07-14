import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(".".equals(s) || s.length() == 0) {
                break;
            }
            char[] chars = s.toCharArray();
            int[] table = table(chars);

            int partial = s.length() - table[s.length() - 1];
            if((s.length() % partial) != 0)
                sb.append(1).append("\n");
            else
                sb.append(s.length() / partial).append("\n");



        }

        System.out.println(sb);
    }

    static int[] table(char[] a) {
        int[] table = new int[a.length];

        int j = 0;

        for(int i = 1; i < a.length; i++) {

            while (j > 0 && a[i] != a[j]) {
                j = table[j-1];
            }

            if(a[i] == a[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }
}
