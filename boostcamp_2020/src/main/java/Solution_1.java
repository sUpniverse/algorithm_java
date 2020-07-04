public class Solution_1 {

    public static void main(String[] args) {
        String[][] n = {{"가을", "우주", "너굴"},{"봄","여울","봄봄"},{"너굴", "너울", "여울", "서울"}};

        for(int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i]));
        }

    }

    static boolean solution(String[] name_list) {
        boolean answer = false;

        for(int i = 0; i < name_list.length - 1; i++)
            for(int j = i+1; j < name_list.length; j++) {
                answer = isPartialMatch(name_list[i],name_list[j]);
                if(answer)
                    return answer;
            }

        return answer;
    }

    static boolean isPartialMatch(String a, String b) {
        boolean flag = false;

        int aLength = a.length();
        int bLength = b.length();

        String[] aSpilt = a.split("");
        String[] bSpilt = b.split("");

        for(int i = 0; i < bLength-aLength+1; i++) {
            int count = 0;
            while (count < aLength) {
                if(aSpilt[count] != bSpilt[i+count])
                    break;
                count++;
            }

            if(count == aLength -1) {
                flag = true;
                break;
            }
        }


        return flag;
    }

}
