import java.util.ArrayList;
import java.util.Collections;

public class Main2 {

    public static void main(String[] args) {
        String[] oper = {"I 16","D 1"};
        String[] oper2 = {"I 7","I 5","I -5","D -1"};
        String[] oper3 = {"I 16","I -5643","D -1","D 1","D 1","I 123","D -1"};
        String[] oper4 = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6" };
        int[] solution = solution(oper4);
        System.out.println(solution[0] +" "+solution[1]);
    }

    public static int[] solution(String[] operations) {
        ArrayList<Integer> array = new ArrayList<>();

        for(int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            String order = split[0];
            int number = Integer.parseInt(split[1]);

            if(order.equals("I")) {
                array.add(number);
                Collections.sort(array);
                continue;
            }

            if(!array.isEmpty() && number == -1) {
                array.remove(0);
            } else if(!array.isEmpty() && number == 1) {
                array.remove(array.size()-1);
            }
        }

        int[] answer = new int[2];
        if(array.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        answer[0] = array.get(array.size()-1);
        answer[1] = array.get(0);

        return answer;
    }
}
