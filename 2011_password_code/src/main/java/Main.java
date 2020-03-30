import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cache[];


    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String number = br.readLine();

        if (number.charAt(0) == '0') {
            System.out.println(0);
        } else {

            int char_length = number.length();
            char[] chars = number.toCharArray();
            cache = new int[5001];

            cache[0] = 1;
            cache[1] = 1;

            for (int i = 2; i <= char_length; i++) {
                // 한자리 숫자가 될 수 있을 때
                if (chars[i - 1] > '0' && chars[i - 1] <= '9') {
                    cache[i] = cache[i - 1] % 1000000;
                }

                // 2자리 숫자가 될 수 있을 때
                if ((chars[i - 2] >= '1' && chars[i - 1] >= '0') && (chars[i - 2] <= '2' && chars[i - 1] <= '6')) {
                    cache[i] = (cache[i] + cache[i - 2]) % 1000000;
                }
            }

            System.out.println(cache[char_length]%1000000);
        }
    }

}
