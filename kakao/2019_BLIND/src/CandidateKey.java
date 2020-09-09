import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {


    public static void main(String[] args) {
        int solution = solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
        System.out.println(solution);
    }

    static int solution(String[][] relation) {
        int n = relation[0].length;
        List<Integer> answerList = new ArrayList<>();


        for(int i = 1; i <= (1<<n); i++) {
            Set<String> validator = new HashSet<>();
            for(int k = 0; k < relation.length; k++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j <n; j++) {
                    if((i & 1<<j) != 0){
                        sb.append(relation[k][j]);
                    }
                }
                validator.add(sb.toString());
            }

            //유일성 및 최소성 검사
            if(validator.size() == relation.length && checkSubSet(answerList, i)) {
                answerList.add(i);
            }
        }


        return answerList.size();
    }

    static boolean checkSubSet(List<Integer> answerList,int index) {
        for(int i = 0; i < answerList.size(); i++) {
            if((answerList.get(i)&index) == answerList.get(i)) return false;
        }
        return true;
    }

}
