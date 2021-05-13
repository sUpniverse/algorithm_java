public class StringCompression2 {

  public static void main(String[] args) {
    System.out.println(solution("xababcdcdababcdcd"));
  }

  public static int solution(String s) {

    int answer = s.length();

    StringBuilder sb = new StringBuilder();
    // 문자를 잘라야 하는 숫자의 범위
    for(int i = 1; i <= s.length()/2; i++) {
      sb.setLength(0);
      // 단어 하나하나 탐색 0 부터 n까지
      int same;
      for(int j = 0; j+i <= s.length();) {
        same = 0;
        // 숫자의 범위에 따른 압축개수 설정
        String substring = s.substring(j, j+i);
        // 압축할 문자열의 길이 + i 만큼부터 갯수 카운팅
        for(int k = j; k+i <= s.length(); k+=i) {
          // 연달아 같은 문자열이 아니라면 취소
          String sub = s.substring(k, k + i);
          if(!substring.equals(sub)) {
            break;
          }
          j+=i;
          same++;
        }
        if(same > 1) {
          sb.append(same);
        }
        sb.append(substring);
      }
      if(s.length() % i != 0) {
        int remain = s.length() % i;
        sb.append(s.substring(s.length()-remain));
      }
      answer = Math.min(answer, sb.length());
    }
    return answer;
  }
}
