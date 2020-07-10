import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");



        StringBuilder sb = new StringBuilder();
        int num1 = Integer.parseInt(sb.append(split[0]).reverse().toString());
        sb.setLength(0);
        int num2 = Integer.parseInt(sb.append(split[1]).reverse().toString());

        int num = Math.max(num1, num2);

        System.out.println(num);

    }
}
