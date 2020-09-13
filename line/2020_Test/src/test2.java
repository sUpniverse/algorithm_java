import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test2 {

    public static void main(String[] args) {
        solution(new int[]{11, 2, 9, 13, 24}, new int[]{9, 2, 13, 24, 11});
    }

    static int[] solution(int[] ball, int[] order) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < ball.length; i++) {
            linkedList.add(ball[i]);
        }

        List<Integer> pOrder = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> emptyList = new LinkedList<>();
        for(int i =0; i <order.length; i++) {
            if(pOrder.size() > 0) {
                for(int j = 0; j < pOrder.size(); j++) {
                    Integer number = pOrder.get(j);
                    if(linkedList.peekFirst() == number) {
                        linkedList.pollFirst();
                        list.add(number);
                        emptyList.add(j);
                        i = 0;
                    } else if(linkedList.peekLast() == number) {
                        linkedList.pollLast();
                        list.add(number);
                        emptyList.add(j);
                        i = 0;
                    }
                }
            while (!emptyList.isEmpty()) {
                Integer poll = emptyList.poll();
                list.remove(poll);
            }
            }
            if(linkedList.peekFirst() == order[i]) {
                linkedList.pollFirst();
                list.add(order[i]);
                continue;
            } else if(linkedList.peekLast() == order[i]) {
                linkedList.pollLast();
                list.add(order[i]);
                continue;
            } else {
                pOrder.add(order[i]);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i <list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
