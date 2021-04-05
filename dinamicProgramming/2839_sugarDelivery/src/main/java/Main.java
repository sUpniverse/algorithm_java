import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int five = N / 5;
    int three = 0;
    int remain  = N % 5;

    while (five >= 0) {
      if(remain % 3 == 0) {
        three = remain / 3;
        remain %= 3;
        break;
      }

      remain+=5;
      five--;
    }

    if(remain == 0)
      System.out.println(five+three);
    else
      System.out.println(-1);
  }
}
