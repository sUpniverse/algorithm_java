import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static StringBuilder sb;
    static List<String> list;
    static boolean[] check;


    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
        String[][] tickets3 = {{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}};
        String[][] tickets4 = {{"ICN","BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO","COO"}, {"BOO", "DOO"} ,{"DOO","BOO"}, {"BOO", "ICN"}, {"COO","BOO"}};

        String[] solution = solution(tickets2);

        System.out.println(solution);

    }

    public static String[] solution(String[][] tickets) {

        sb = new StringBuilder();
        list = new ArrayList<String>();

        for(int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String destination = tickets[i][1];
            check = new boolean[tickets.length];

            if(start.equals("ICN")) {
                sb.setLength(0);
                sb.append(start).append(",");
                check[i] = true;
                DFS(tickets, destination, 1);
            }
        }
        Collections.sort(list);
        String[] split = list.get(0).split(",");

        return split;
    }


    static void DFS(String[][] tickets, String end, int count) {
        sb.append(end).append(",");

        if(count == tickets.length) {
            list.add(sb.toString());
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String destination = tickets[i][1];

            if(start.equals(end) && !check[i]) {
                check[i] = true;
                DFS(tickets, destination,count+1);
                check[i] = false;
                sb.setLength(sb.length()-4);
            }
        }
    }


}
