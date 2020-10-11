import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class problem3 {
    public static void main(String[] args) {
        solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
    }

    static int[] solution(String[] info, String[] query) {

        List<Information> applyList = new ArrayList<>();

        for(int i = 0; i < info.length; i++) {
            String[] inform = info[i].split(" ");
            applyList.add(new Information(inform[0],inform[1],inform[2],inform[3],Integer.parseInt(inform[4])));
        }

        Collections.sort(applyList, new Comparator<>() {
            @Override
            public int compare(Information information, Information t1) {
                return t1.score - information.score;
            }
        });

        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and ");
            String[] remain = split[3].split(" ");
            String sLan = split[0];
            String sPart = split[1];
            String sEx = split[2];
            String sFo = remain[0];
            int sSc = Integer.parseInt(remain[1]);

            int count = 0;

            for (Information information : applyList) {
                if(information.score < sSc) break;
                if((sSc  <= information.score) && (sLan.equals("-") || sLan.equals(information.language)) && ((sPart.equals("-") || sPart.equals(information.part)) && (sEx.equals("-") || sEx.equals(information.experience))
                        && (sFo.equals("-") || sFo.equals(information.soulFood))))
                    count++;
            }
            answer[i] = count;
        }

        return answer;
    }


    static class Information{
        String language;
        String part;
        String experience;
        String soulFood;
        int score;

        public Information(String language, String part, String experience, String soulFood, int score) {
            this.language = language;
            this.part = part;
            this.experience = experience;
            this.soulFood = soulFood;
            this.score = score;
        }

    }

}
