import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String split = s[0];
        int size = split.length();
        int num = Integer.parseInt(s[1]);
        int sum = 0;
        for(int i = 0; i < size; i++) {
            if(split.charAt(i) >= '0' && split.charAt(i) <= '9')
                sum += (split.charAt(i)- 48) * Math.pow(num, size-i-1);
            else
                sum += (split.charAt(i)- 55) * Math.pow(num, size-i-1);

        }
        System.out.println(sum);
    }

    private static void toN(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while(a > 0) {
            if((a%b) > 9)
                sb.append((char)(a%b-10+'A'));
            else
                sb.append((char)(a%b+'0'));
            a/=b;
        }

        System.out.println(sb.reverse());
    }
}
