import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    String[] text = {"119", "97674223", "1195524421"};
    System.out.println(solution(text));
  }

  public static boolean solution(String[] phone_book) {
    HashMap<String, String> map = new HashMap<>();

    boolean answer = true;

    for(String a : phone_book) {
      map.put(a, "1");
    }

    for(String a : phone_book) {
      for(int idx = 0; idx < a.length(); idx++) {
        if(map.containsKey(a.substring(0, idx)))
          answer = false;
      }
    }



    return answer;
  }


}
