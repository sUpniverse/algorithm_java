import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int origin = Integer.parseInt(s);
    int cycleNum = 0;
    int count = 0;

    int first = origin / 10;
    int second = origin % 10;
    if(origin < 10) {
      first = 0;
    }

    cycleNum = (first + second) % 10;
    cycleNum += second * 10;
    count++;
    while (origin != cycleNum) {
      first = cycleNum / 10;
      second = cycleNum % 10;
      cycleNum = (first + second) % 10;
      cycleNum += second * 10;
      count++;
    }

    System.out.println(count);
  }
}
