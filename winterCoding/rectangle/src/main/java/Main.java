public class Main {

  public static void main(String[] args) {
    System.out.println(solution(1, 1));
  }

  public static long solution(int x, int y) {
    long sum = 0;
    for(int i = 1; i < x; i++) {
      sum += Long.valueOf(y)*i/Long.valueOf(x);
    }

    return sum*2;
  }

}
