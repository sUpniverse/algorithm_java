import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    HashMap<String, Integer> map = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);

    for(int i = 0 ; i < n; i++) {
      map.put(br.readLine(), 0);
    }

    List<String> list = new ArrayList<>();
    for(int i = 0; i < m; i++) {
      String word = br.readLine();
      if(map.containsKey(word)) {
        list.add(word);
        map.remove(word);
      }
    }

    Collections.sort(list);
    StringBuilder sb = new StringBuilder();


    sb.append(list.size()).append("\n");
    for(String t : list) {
      sb.append(t).append("\n");
    }

    System.out.print(sb.toString());
  }
}
