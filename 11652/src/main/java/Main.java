import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Map<Long,Integer> map = new HashMap<>();

        int max_count = 0;
        long max = 0;

        for(int i = 0 ; i < size; i++) {
            long l = Long.parseLong(br.readLine());
            if(map.containsKey(l)) {
                map.put(l, map.get(l)+1);
                if(max_count == map.get(l)) {
                    max = Math.min(max, l);
                } else if (max_count < map.get(l)) {
                    max = l;
                    max_count = map.get(l);
                }
            } else {
                map.put(l, 1);
                if(map.size() == 1) {
                    max = l;
                    max_count = 1;
                }

                if(max_count == 1) {
                    max = Math.min(max, l);
                }
            }
        }

        System.out.println(max);
    }
}
