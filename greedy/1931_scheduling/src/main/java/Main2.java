import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {

    /*
    * 조건. 회의 시간이 짧고 겹치지 시간이 겹치지 않도록 많이 만들어야 함
    * 1. 일단 회의 시간이 빨리 끝나고 빨리 시작하는 순으로 정렬
    * 2. 정렬 된 리스트에서 끝나는 시간을 기준으로, 다음에 올 수 있는 스케줄을 검색
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            scheduleList.add(new Schedule(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(scheduleList);

        int end = 0;
        int count = 0;
        for(Schedule schedule :  scheduleList) {
            if(end <= schedule.start) {
                end = schedule.end;
                count++;
            }
        }
        System.out.println(count);

    }

    static class Schedule implements Comparable<Schedule>{
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public int compareTo(Schedule o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

}
