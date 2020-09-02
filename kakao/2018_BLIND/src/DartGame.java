import java.util.ArrayList;

public class DartGame {

    public static void main(String[] args) {
        String a = "1D2S#10S";
        int solution = solution(a);
        System.out.println(solution);
    }

    public static int solution(String dartResult) {
        int answer = 0;

        char[] chars = dartResult.toCharArray();
        ArrayList<Integer> point = new ArrayList<>();
        int i = 0;
        while (i < chars.length){
            int pow = 0;
            int additional = 0;
            if(47 < chars[i] && 58 > chars[i]) {
                if(i > 0 && 49 == chars[i-1] && 48 == chars[i]) {
                    point.remove(point.size()-1);
                    point.add(10);

                } else
                    point.add(chars[i] - 48);
            }
            i++;

            while (i < chars.length && !(47 < chars[i] && 58 > chars[i])) {
                if(chars[i] == 'S') pow = 1;
                else if(chars[i] == 'D') pow = 2;
                else if(chars[i] == 'T') pow = 3;
                else if(chars[i] == '*') additional = 2;
                else if(chars[i] == '#') additional = -1;

                i++;
            }
            point.set(point.size()-1, (int) Math.pow(point.get(point.size()-1),pow));
            if(additional == 2 || additional == -1) {
                if(point.size() > 1 && additional == 2 ) point.set(point.size()-2, point.get(point.size()-2) * additional);
                point.set(point.size()-1, point.get(point.size()-1) * additional);
            }
        }

        for(int a : point) {
            answer+= a;
        }

        return answer;
    }
}