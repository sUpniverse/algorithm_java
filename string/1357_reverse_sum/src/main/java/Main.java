import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String[] num = s.split(" ");

    StringBuilder sb = new StringBuilder();

    sb.append(num[0]);

    int num1 = Integer.parseInt(sb.reverse().toString());
    sb.setLength(0);

    sb.append(num[1]);
    int num2 = Integer.parseInt(sb.reverse().toString());
    sb.setLength(0);

    int sum = num1 + num2;
    String result = sb.append(sum).reverse().toString();

    System.out.println(Integer.parseInt(result));
  }

}
