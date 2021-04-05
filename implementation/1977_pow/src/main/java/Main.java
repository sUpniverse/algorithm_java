import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    boolean isFirst = true;
    int sum = 0;
    int min = 0;

    for(int i = 1; i < M; i++) {
      if(i*i > M) break;
      if(i*i >= N && i*i <= M) {
        int num = i * i;
        if(isFirst) {
          isFirst = false;
          min = num;
        }
        sum += num;
      }
    }
    if(sum == 0) {
      System.out.println(-1);
    } else {
      System.out.println(sum);
      System.out.println(min);
    }
  }
}
