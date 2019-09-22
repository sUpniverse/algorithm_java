import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {

    public static final String RECEIVE  = "RECEIVE";
    public static final String DELETE  = "DELETE";
    public static final String SAVE  = "SAVE";


    public String[] solution(String[] record) {


        Queue<String> tempQueue = new LinkedList();
        Stack<String> tempStack = new Stack<String>();
        Queue<String> parmaQueue = new LinkedList();

        for(String order : record) {
            String[] s = order.split(" ");
            if(s[0].equals(RECEIVE)) {
                tempQueue.add(s[1]);
                tempStack.add(s[1]);
            } else if(s[0].equals(SAVE) && !tempQueue.isEmpty()) {
                while(!tempQueue.isEmpty()) {
                    parmaQueue.add(tempQueue.poll());
                }
            } else if(s[0].equals(DELETE) && !tempQueue.isEmpty()) {
                String pop = tempStack.pop();
                tempQueue.remove(pop);
            }
        }

        int SIZE = parmaQueue.size();

        String[] answer = new String[SIZE];

        for(int i = 0; i < SIZE; i++) {
            answer[i] = parmaQueue.poll();
        }

        return answer;
    }


}
