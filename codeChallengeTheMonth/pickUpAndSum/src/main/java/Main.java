import java.util.*;

public class Main {

  public static void main(String[] args) {
    int[] numbers = {2,1,3,4,1};
    solution(numbers);
  }

  public static int[] solution(int[] numbers) {
    Set<Integer> numberSet = new TreeSet<>();

    for(int i = 0; i < numbers.length; i++) {
      for(int j = i; j < numbers.length; j++) {
        if(i == j) continue;
        numberSet.add(numbers[i] + numbers[j]);
      }
    }

    List<Integer> list = new ArrayList();
    for(Integer num : numberSet) {
      list.add(num);
    }

    int[] answer = new int[list.size()];
    for(int i = 0; i < list.size(); i++) {
      answer[i]  = list.get(i);
    }


    return answer;
  }

}
