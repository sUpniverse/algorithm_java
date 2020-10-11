public class StringCompression {
    public static void main(String[] args) {

    }

    static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 0) return 0;
        String[] split = s.split("");
        for(int i = 1; i <= s.length()/2+1; i++) {
            if(s.length() < i)  return answer;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < split.length; ) {
                int count = 0;
                int start = j;
                String t = "";
                for(int k = start; k < start+i; k++) {
                    if(k < split.length)
                        t+=split[k];
                }
                while (j+t.length() <= split.length && t.equals(s.substring(j,j+t.length()))) {
                    count++;
                    j+= t.length();
                }
                if(count > 1) sb.append(count);
                sb.append(t);
            }
            answer = Math.min(sb.length(), answer);
        }
        return answer;
    }

}
