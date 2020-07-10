import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String a = br.readLine();
        String b = br.readLine();

        int[] table = table(b);
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        int  j = 0;
        for(int i = 0; i < a.length(); i++) {
            while (j > 0 && a.charAt(i) != b.charAt(j)) {
                j = table[j-1];
            }

            if(a.charAt(i) == b.charAt(j)) {
                if(j == b.length()-1) {
                    count++;
                    queue.add(i-j+1);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }

        if(count > 0) {
            sb.append(count).append("\n");
            for(int n : queue)
                sb.append(n).append(" ");
        } else {
            sb.append(0);
        }

        System.out.println(sb);
    }


    static int[] table(String a) {
        char[] chars = a.toCharArray();
        int[] array = new int[chars.length];

        int j = 0;
        for(int i = 1; i < chars.length; i++) {
            while (j > 0 && chars[i] != chars[j])
                j = array[j-1];
            if(chars[i] == chars[j]){
                j++;
                array[i] = j;
            }
        }

        return array;
    }

}
