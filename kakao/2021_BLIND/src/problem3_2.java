import java.util.ArrayList;
import java.util.List;

public class problem3_2 {

    public static void main(String[] args) {
        solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
    }

    

    static int[] solution(String[] info, String[] query) {

        String[][] applyList = new String[info.length][5];

        for(int i = 0; i < info.length; i++) {
            String[] inform = info[i].split(" ");
            applyList[i][0] = inform[0];
            applyList[i][1] = inform[1];
            applyList[i][2] = inform[2];
            applyList[i][3] = inform[3];
            applyList[i][4] = inform[4];
        }
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

            for (int j = 0; j < applyList.length; j++) {
                if((sSc  <= Integer.parseInt(applyList[j][4]) && (sLan.equals("-") || sLan.equals(applyList[j][0])) && ((sPart.equals("-") || sPart.equals(applyList[j][1])) && (sEx.equals("-") || sEx.equals(applyList[j][2]))
                        && (sFo.equals("-") || sFo.equals(applyList[j][3])))))
                    count++;
            }
            answer[i] = count;
        }

        return answer;
    }

}
