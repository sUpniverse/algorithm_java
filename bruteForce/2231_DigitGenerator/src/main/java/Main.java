import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String txt = br.readLine();
        int n = Integer.parseInt(txt);
        int num = 0;

        for(int i = num - (txt.length() * 9); i < n; i++) {
            num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if(sum+i == n) {
                num = i;
                break;
            }
        }
        System.out.println(num);
    }

}
