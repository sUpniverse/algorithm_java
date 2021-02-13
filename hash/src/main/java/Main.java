import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    System.out.println(solution(clothes));
  }

  public static int solution(String[][] clothes) {
    int answer = 1;

    HashMap<String, Integer> clothType = new HashMap<>();

    for(String[] cloth : clothes) {

      clothType.put(cloth[1], clothType.getOrDefault(cloth[1], 0)+1);
    }

    for(Integer value : clothType.values()) {
      answer *= (value+1);
    }


    return answer-1;
  }


}
