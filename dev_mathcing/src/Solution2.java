import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution2 {

    public static void main(String[] args) {
        String[] P = {"PM 01:00:00", "PM 12:05:05"};

        String solution = solution(P[1], 1);

        System.out.println(solution);


    }


    public static String solution(String p, int n) {
        String[] a = p.split(" ");
        Date date = new Date();
        int h = 0;
        int m = 0;
        int s = 0;

        String[] time = a[1].split(":");
        h = Integer.parseInt(time[0]);
        m = Integer.parseInt(time[1]);
        s = Integer.parseInt(time[2]);

        if(h == 12){
            h+= 12;
        }
        if("PM".equals(a[0])){
            h+= 12;
            h %= 24;
        }

        int second = ((h * 60 * 60) + (m * 60) + s + n) % (24 * 60 * 60);

        date.setHours(second / (60 * 60));
        second = second % (60 * 60);
        date.setMinutes(second/60);
        second = second % 60;
        date.setSeconds(second);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        return dateFormat.format(date);
    }

}
