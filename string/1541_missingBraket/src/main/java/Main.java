import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String[] split = s.split("-");

    int ans = 0;

    for(int i = 0; i < split.length; i++) {
      String[] num = split[i].split("\\+");
      int sum = 0;
      for(int j = 0; j < num.length; j++) {
        sum += Integer.parseInt(num[j]);
      }
      if(i == 0) {
        ans = sum;
        continue;
      }
      ans -= sum;
    }

    System.out.println(ans);
  }

}
