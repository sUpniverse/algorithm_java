public class problem1 {

    public static void main(String[] args) {
//        solution("*!!!(())*A..A..AAa..a**...*11*334......4");
        String solution = solution("=.=");
        System.out.println(solution);
    }

    static String solution(String new_id) {
        String lowerId = new_id.toLowerCase();

        char[] chars = lowerId.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(!((chars[i] > 96 && chars[i] < 123) || (chars[i] > 47 && chars[i] < 58) || chars[i] == '.' || chars[i] == '-' || chars[i] == '_' || chars[i] == '.')) {
                String replace = lowerId.replace(chars[i] + "", "");
                lowerId = replace;
            }
        }

        while (lowerId.contains("..")) {
            lowerId = lowerId.replace("..", ".");
        }

        if(lowerId.length() > 0 && lowerId.charAt(0) == '.')
            lowerId = lowerId.substring(1);

        if(lowerId.length() > 0  && lowerId.charAt(lowerId.length()-1) == '.')
            lowerId = lowerId.substring(0, lowerId.length()-1);

        if(lowerId.length() == 0) {
            lowerId = "a";
        }

        if(lowerId.length() >= 16) {
            lowerId = lowerId.substring(0,15);
            if(lowerId.charAt(lowerId.length()-1) == '.')
                lowerId = lowerId.substring(0, lowerId.length()-1);
        }

        if(lowerId.length() <= 2 ) {
            char c = lowerId.charAt(lowerId.length() - 1);
            while (lowerId.length() < 3){
                lowerId += c;
            }
        }

        return lowerId;
    }
}
