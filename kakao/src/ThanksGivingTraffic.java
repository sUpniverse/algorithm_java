import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThanksGivingTraffic {

    public static void main(String[] args) throws ParseException {
        String[] line = {"2016-09-15 01:00:04.001 2.0s","2016-09-15 01:00:07.000 2s"};
        String[] line2 = {"2016-09-15 01:00:04.002 2.0s","2016-09-15 01:00:07.000 2s"};
        String[] line3 = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                          "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
                          "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        String[] line4 = {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"};
        int solution = solution(line2);
        System.out.println(solution);
    }

    static int solution(String[] lines) throws ParseException {
        int answer = 0;

        List<Log> logList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        for(int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            Date time = format.parse(split[1]);
            Double second = Double.parseDouble(split[2].substring(0, split[2].length() - 1));
            Log log = new Log(time,second);
            logList.add(log);
        }

        if(logList.size() == 1) return 1;

        int[] count = new int[logList.size()];

        for(int i = 0 ; i < logList.size(); i++) {
            long end = logList.get(i).end.getTime();
            for(int j = i; j < logList.size(); j++) {
                long start =  logList.get(j).start.getTime() - 1000;
                if(start < end){
                    System.out.println(format.format(new Date(start)) + "  " + format.format(new Date(end)));
                    count[i]++;
                    answer = Math.max(answer, count[i]);
                }
            }
        }

        return answer;
    }

    static class Log {
        Date start;
        Date end;

        public Log(Date time, double second){
            calculate(time, second);
        }

        void calculate(Date time, double second) {
            long start = (long) (time.getTime() - second* 1000 +1);
            this.start = new Date(start);
            this.end = time;
        }
    }

}
