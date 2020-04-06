import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        String num1 = s[0] + s[1];
        String num2 = s[2] + s[3];
        System.out.println(Long.parseLong(num1)+Long.parseLong(num2));
    }
}
