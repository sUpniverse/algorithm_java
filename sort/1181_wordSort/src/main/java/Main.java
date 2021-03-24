import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    List<String> list = new ArrayList<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int size = Integer.parseInt(s);

    Set<String> set = new HashSet<>();

    for(int i = 0; i < size; i++) {
      set.add(br.readLine());
    }
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }


    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
          if(o2.length() == o1.length()) {
            return o1.compareTo(o2);
          }
          return o1.length() - o2.length();
      }
    });

    StringBuilder sb = new StringBuilder();
    for(String a : list) {
      sb.append(a).append("\n");
    }

    System.out.println(sb.toString());
  }
}
