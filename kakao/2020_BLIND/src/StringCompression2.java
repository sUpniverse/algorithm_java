public class StringCompression2 {

  public static void main(String[] args) {
    solution("aaa");
  }

  public static int solution(String s) {


    int n = Integer.MAX_VALUE;
    int answer = 0;

    StringBuilder sb = new StringBuilder();
    // 문자를 잘라야 하는 숫자의 범위
    for(int i = 1; i < n; i++) {
      sb.setLength(0);
      // 단어 하나하나 탐색 0 부터 n까지
      for(int j = 0; j < s.length()/2; j+=i) {
        int same = 0;
        // 숫자의 범위에 따른 압축개수 설정
        String substring = s.substring(j, j+i-1);
        // 압축할 문자열의 길이 + i 만큼부터 갯수 카운팅
        for(int k = j+i; k < s.length(); k+=i) {
          // 연달아 같은 문자열이 아니라면 취소
          if(!substring.equals(s.substring(k, k+i-1))) {
            break;
          }
          same++;
        }
        if(same > 0) {
          sb.append(same).append(substring);
        }
      }
      answer = Math.min(answer, sb.length());
    }
    return answer;
  }
}
