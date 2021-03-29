import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int spotSize = sc.nextInt();
    int length = sc.nextInt();

    int[] spot = new int[spotSize];

    for(int i = 0; i < spotSize; i++) {
      spot[i] = sc.nextInt();
    }

    int count = 0;

    Arrays.sort(spot);
    int range = (int) (spot[0] - 0.5+length);
    count++;

    for(int i = 1; i < spotSize; i++) {
      if(range < (int)(spot[i]+0.5)) {
        range = (int)(spot[i] - 0.5+length);
        count++;
      }
    }

    System.out.println(count);
  }
}
