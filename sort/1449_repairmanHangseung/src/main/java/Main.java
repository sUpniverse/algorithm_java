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

    Arrays.sort(spot);

    int count = 0;
    int now = spot[0];
    for(int i = 0; i < spotSize; i++) {

    }

    System.out.println(count);
  }
}
