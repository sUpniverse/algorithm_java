import java.util.*;

public class NewsClustering {
    public static void main(String[] args) {
        int solution = solution("FRANCE", "FRENCH");
        System.out.println(solution);
    }

    static int solution(String str1, String str2) {
        int answer = 0;


        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        List<String> pair1 = getPair(chars1);
        List<String> pair2 = getPair(chars2);

        boolean[] cache = new boolean[pair2.size()];

        double union = 0;
        double intersection = 0;

        Set<String> keySet = new HashSet<>();
        for(String a :pair1) keySet.add(a);
        for(String b :pair2) keySet.add(b);

        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();

            int sum1 = 0;
            for(int i = 0; i < pair1.size(); i++) {
                if(next.equals(pair1.get(i))) {
                    sum1++;
                }
            }

            int sum2 = 0;
            for(int i = 0; i < pair2.size(); i++) {
                if(next.equals(pair2.get(i))) {
                    sum2++;
                }
            }

            intersection += Math.min(sum1, sum2);
            union += Math.max(sum1, sum2);

        }

        if(union == 0) return 1;

        double a = intersection/union;
        System.out.println(a);
        return (int) (a * 65536);
    }

    static List<String> getPair(char[] chars) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < chars.length-1; i++) {
            if(((64 < chars[i] && 91 > chars[i]) || (96 < chars[i] && 123 > chars[i])) && ((64 < chars[i+1] && 91 > chars[i+1]) || (96 < chars[i+1] && 123 > chars[i+1]))) {
                String a = chars[i]+""+chars[i+1];
                list.add(a.toLowerCase());
            }
        }
        return list;
    }


}
