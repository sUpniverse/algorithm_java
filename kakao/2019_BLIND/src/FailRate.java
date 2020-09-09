import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailRate {

    public static void main(String[] args) {
        solution(8, new int[]{1,2,3,4,5,6,7});
    }

    static int[] solution(int N, int[] stages) {

        double[] stage = new double[N+1];

        for(int i = 0; i < stages.length; i++) {
            int now = stages[i];
            if(now > N) continue;
            stage[now]++;
        }


        List<Stage> stageList = new ArrayList<>();
        int total = stages.length;
        for(int i = 1; i <= N; i++) {
            double rate = 0;
            if(total > 0)
                rate = stage[i] / total;
            if(Double.isNaN(rate)) {
                rate = 0;
            }
            stageList.add(new Stage(rate,i));
            total -= stage[i];
        }

        Collections.sort(stageList);

        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).index;
        }
        return answer;
    }

    static class Stage implements Comparable<Stage>{
        double failRate;
        int index;

        public Stage(double failRate, int index) {
            this.failRate = failRate;
            this.index = index;
        }

        @Override
        public int compareTo(Stage stage) {
            if(this.failRate == stage.failRate)
                return this.index - stage.index;
            if(this.failRate > stage.failRate)
                return -1;
            return 1;
        }
    }
}
