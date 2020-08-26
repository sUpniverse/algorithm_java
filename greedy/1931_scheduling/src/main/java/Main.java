import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();

        StringTokenizer st;
        while (n -- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            schedules.add(new Schedule(a,b));
        }

        schedules.sort(new Comparator<Schedule>() {
            public int compare(Schedule o1, Schedule o2) {
                if(o1.end > o2.end) {
                    return 1;
                } else if(o1.end == o2.end) {
                    if(o1.start > o2.start) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        int count = 0;
        int endTime = 0;
        for(Schedule schedule : schedules) {
            if(endTime <= schedule.start) {
                count++;
                endTime = schedule.end;
            }
        }

        System.out.println(count);
    }

    static class Schedule {

        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
