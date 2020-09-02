import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuttleBus {

    public static void main(String[] args) {
        String solution = solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});

        System.out.println(solution);

    }

    static String solution(int n, int t, int m, String[] timetable){
        List<Integer> list = new ArrayList<>();

        for(String a : timetable){
            String[] split = a.split("[:]");
            list.add(Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]));
        }
        Collections.sort(list);


        int last = 0;
        int start = 0;
        int index = 0;
        int bus = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            while (index < list.size() && count < m && 9*60+(t*i) >= list.get(index)) {
                last = list.get(index);
                count++;
                index++;
                start = count;
            }
            bus = i;
        }

        if(m >= start) {
            last = Math.max(9*60, 9*60+(bus*t));
        } else {
            last--;
        }
        return String.format("%02d:%02d", last / 60, (last % 60));
    }
}
