import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Node> nodeList;
    static ArrayList<String> answerList;
    static int[][] edge;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
        String[][] tickets3 = {{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}};
        String[][] tickets4 = {{"ICN","BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO","COO"}, {"BOO", "DOO"} ,{"DOO","BOO"}, {"BOO", "ICN"}, {"COO","BOO"}};

        String[] solution = solution(tickets4);

        System.out.println(solution);

    }

    public static String[] solution(String[][] tickets) {
        nodeList = new ArrayList<Node>();
        edge = new int[10000][10000];
        for(int i = 0; i < tickets.length; i++) {
            Node start = find(tickets[i][0]);


            if(start == null) {
                start = new Node(tickets[i][0]);
                nodeList.add(start);
            }

            Node destination = find(tickets[i][1]);

            if(destination == null) {
                destination = new Node(tickets[i][1]);
                nodeList.add(destination);
            }


            int a = nodeList.indexOf(start);
            int b = nodeList.indexOf(destination);

            edge[a][b]++;
            start.adj.add(destination);
        }

        answerList = new ArrayList<String>();
        DFS(nodeList.get(0));

        String[] array = new String[answerList.size()];
        for(int i = 0 ; i < answerList.size(); i++) {
            array[i] = answerList.get(i);
        }
        return array;
    }

    static Node find(String name) {
        for(Node node : nodeList) {
            if(node.name.equals(name)) {
                return node;
            }
        }
        return null;
    }

    static void DFS(Node node) {
        answerList.add(node.name);
        Collections.sort(node.adj);
        int a = nodeList.indexOf(node);
        for(int i = 0; i < node.adj.size(); i++) {
            Node destination = node.adj.get(i);
            int b = nodeList.indexOf(destination);
            if(edge[a][b] > 0) {
                edge[a][b]--;
                DFS(destination);
            }
        }
    }

    static class Node implements Comparable<Node>{
        String name;
        ArrayList<Node> adj = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }
    }

}
