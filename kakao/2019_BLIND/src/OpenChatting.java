import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatting {

    public static void main(String[] args) {
        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
    }

    static String[] solution(String[] record) {

        Map<String,String> userList = new HashMap<>();
        List<String> history = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                history.add(s[1]+" 님이 들어왔습니다.");
                if(userList.containsKey(s[1])) {
                    userList.replace(s[1],s[2]);
                    continue;
                }
                userList.put(s[1],s[2]);
            } else if(s[0].equals("Change")){
                if(userList.containsKey(s[1])) {
                    userList.replace(s[1],s[2]);
                    continue;
                }
            } else {
                history.add(s[1]+" 님이 나갔습니다.");
            }
        }

        String[] answer = new String[history.size()];
        for(int i = 0; i < history.size(); i++) {
            String[] s = history.get(i).split(" ");
            String userName = userList.get(s[0]);
            answer[i] = userName+s[1]+" "+s[2];
        }

        return answer;
    }

}
