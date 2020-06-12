import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<Integer> queue;
    static HashMap<Integer,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start  = 0;
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 0) {
                    a = 9;
                }
                start = (start * 10) + a;
            }
        }

        queue = new LinkedList<Integer>();
        queue.add(start);
        map = new HashMap<Integer, Integer>();
        map.put(start, 0);

        StringBuilder sb;
        while(!queue.isEmpty()) {
            int n = queue.poll();
            String value = String.valueOf(n);
            int num = value.indexOf("9");
            int x = num / 3;
            int y = num % 3;

            for(int i = 0 ; i < 4; i++) {
                int ax = x + dx[i];
                int ay = y + dy[i];

                if(ax >= 0 && ax < 3 && ay >= 0 && ay < 3) {
                    sb = new StringBuilder(value);
                    char temp = sb.charAt(num);
                    sb.setCharAt(num, sb.charAt((ax*3)+ay));
                    sb.setCharAt((ax*3)+ay,temp);
                    int change = Integer.parseInt(sb.toString());
                    if(!map.containsKey(change)) {
                        map.put(change, map.get(n)+1);
                        queue.add(change);
                    }
                }
            }
        }

        if(!map.containsKey(123456789)) {
            System.out.println(-1);
            return;
        }

        System.out.println(map.get(123456789));

    }

}
