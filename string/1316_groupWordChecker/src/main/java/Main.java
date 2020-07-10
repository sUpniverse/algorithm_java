import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int t = 0; t < T; t++) {
            char[] chars = br.readLine().toCharArray();
            boolean flag = false;
            for(int i = 0; i < chars.length; i++) {
                int j = i;
                while (j < chars.length && chars[i] == chars[j]) {
                    j++;
                }
                for(int k = j; k < chars.length; k++) {
                    if(chars[i] == chars[k])
                        flag = true;
                }

                if(flag) {
                    sum++;
                    break;
                }
            }
        }

        System.out.println(T-sum);
    }
}
