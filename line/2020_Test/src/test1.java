public class test1 {

    public static void main(String[] args) {

    }

    static int solution(int[][] boxes) {
        int answer = boxes.length;

        boolean[] check = new boolean[boxes.length];
        check(boxes, check);

        for(int i = 0; i < boxes.length; i++) {
            for(int j = 0; j < boxes.length; j++) {
                if(!check[i] && !check[j]) {
                    if(boxes[i][0] == boxes[j][0]){
                        int tmp = 0;
                        tmp = boxes[i][1];
                        boxes[i][1] = boxes[j][0];
                        boxes[j][0] = tmp;
                        break;
                    } else if(boxes[i][0] == boxes[j][1]) {
                        int tmp = 0;
                        tmp = boxes[i][1];
                        boxes[i][1] = boxes[j][1];
                        boxes[j][1] = tmp;
                        break;
                    } else if(boxes[i][1] == boxes[j][0]) {
                        int tmp = 0;
                        tmp = boxes[i][0];
                        boxes[i][0] = boxes[j][0];
                        boxes[j][0] = tmp;
                        break;
                    } else if(boxes[i][1] == boxes[j][1]) {
                        int tmp = 0;
                        tmp = boxes[i][0];
                        boxes[i][0] = boxes[j][1];
                        boxes[j][1] = tmp;
                        break;
                    }
                }
            }
        }

        check(boxes,check);

        for(int i =0; i < check.length; i++) {
            if(check[i])
                answer--;
        }

        return answer;
    }

    private static void check(int[][] boxes, boolean[] check) {
        for(int i = 0; i < boxes.length; i++) {
            if(boxes[i][0] == boxes[i][1])
                check[i] = true;
        }
    }


}
