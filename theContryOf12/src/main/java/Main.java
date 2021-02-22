public class Main {

  public static void main(String[] args) {
    System.out.println(solution(10));
  }

  public static String solution(int n) {
    String[] contry = {"4", "1", "2"};
    StringBuilder sb = new StringBuilder();

    while (n > 0) {
      int remain = n % 3;
      n /= 3;

      if(remain == 0) n--;

      sb.append(contry[remain]);
    }

    return sb.reverse().toString();
  }
}
