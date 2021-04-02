import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String[] split = s.split(" ");
    int[] number = new int[8];

    boolean a = true;
    boolean d = true;
    boolean mix = true;

    for(int i = 0; i < 8; i++) {
      number[i] = Integer.parseInt(split[i]);
      if(number[i] != i+1) {
        a = false;
      }
      if (number[i] != 8 - i) {
        d = false;
      }
    }

    if(a || d) {
      mix = false;
    }

    if(a) {
      System.out.println("ascending");
    } else if(d) {
      System.out.println("descending");
    } else if(mix) {
      System.out.println("mixed");
    }
  }

}
