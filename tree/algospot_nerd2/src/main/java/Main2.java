import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main2 {

    static TreeMap<Integer,Integer> coords;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            coords = new TreeMap<>();
            sum = 0;
            for(int i = 0 ; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                setTree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);


    }

    static void setTree(int x, int y) {

        if(isDominated(x,y)) {
            sum += coords.size();
            return;
        }

        removeDominated(x, y);

        coords.put(x, y);
        sum += coords.size();
    }

    static boolean isDominated(int x, int y) {
        Integer key = coords.ceilingKey(x);
        if(key != null && y < coords.get(key)) return true;
        return false;
    }

    static void removeDominated(int x, int y) {
        Integer key = coords.floorKey(x);
        while (key != null) {
            if(coords.get(key) < y)
                coords.remove(key);
            else
                break;
            key = coords.floorKey(x);
        }
    }

    static class Node {
        int x;
        int y;
        ArrayList<Node> children = new ArrayList<Node>();
    }
}
