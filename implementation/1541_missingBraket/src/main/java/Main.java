import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String[] split = s.split("\\D");

    String[] special = s.split("\\d");


    List<Integer> numbers = new ArrayList<>();
    for(String t : split) {
      numbers.add(Integer.parseInt(t));
    }

    List<String> operators = new ArrayList<>();
    for(String t : special) {
      if(!t.equals("")) {
        operators.add(t);
      }
    }

    for(String a : operators) {
      System.out.println(a);
    }


    Stack<Integer> stack = new Stack<>();

  }

}
