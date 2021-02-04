import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    String[] participant = {"leo", "kiki", "eden"};
    String[] completion = {"eden", "kiki"};
    String solution = solution(participant, completion);
    System.out.println(solution);
  }

  public static String solution(String[] participant, String[] completion) {
    Map<String, Integer> map = new HashMap<>();

    for(String player : participant) {
      if(map.containsKey(player)) {
        map.put(player, map.get(player)+1);
        continue;
      }
      map.put(player, 1);

    }

    for(String winner : completion) {
      Integer count = map.get(winner);
      if(count == 1) {
        map.remove(winner);
        continue;
      }
      map.put(winner, --count);
    }

    String answer = map.entrySet().iterator().next().getKey();

    return answer;
  }

}
