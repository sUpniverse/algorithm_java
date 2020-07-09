import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();
        char[] chars = s.toCharArray();
        int count = 0;
        int word = 0;

        while (count ++ < chars.length-1) {
            if (chars[count] == ' ')
                word++;
        }

        if(chars.length > 0 && count > 0)
            System.out.println(word+1);
        else
            System.out.println(0);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int count = 0;
//        while (st.hasMoreTokens()) {
//            st.nextToken();
//            count++;
//        }
//
//        System.out.println(count);
    }
}
