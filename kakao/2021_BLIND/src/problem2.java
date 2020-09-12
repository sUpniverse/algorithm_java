import java.util.*;

public class problem2 {

    static  HashMap<String,Integer> map;

    public static void main(String[] args) {

        solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4});

    }

    static String[] solution(String[] orders, int[] course) {


        List<String> courseList = new ArrayList<>();
        for(int i = 0; i <course.length; i++) {
            map = new HashMap<>();
            List<String> orderList = new ArrayList<>();
            for(int j = 0; j < orders.length; j++) {
                char[] chars = orders[j].toCharArray();
                Arrays.sort(chars);
                String orderText = String.valueOf(chars);
                dfs("", 0, 0,course[i],orderText);
            }

            if(map.size() > 0) {
                int a = course[i];
                map.forEach((s, integer) -> {
                    if(s.length() == a) {
                        if(integer > 1) {
                            orderList.add(s);
                        }
                    }
                });

                Map.Entry<String,Integer> max = null;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (max == null || entry.getValue().compareTo(max.getValue()) > 0) {
                        max = entry;
                    }
                }
                String key = max.getKey();
                for(String o : orderList) {
                    if(map.get(o) == map.get(key))
                        courseList.add(o);
                }
            }
        }

        Collections.sort(courseList,String.CASE_INSENSITIVE_ORDER);

        String[] answer = new String[courseList.size()];
        for(int i = 0; i < courseList.size(); i++) {
            answer[i] = courseList.get(i);
        }

        return answer;
    }

    static void dfs(String text,int index,int now ,int level, String a) {
        if(level == now) {
            if(map.containsKey(text)) {
                map.replace(text, map.get(text)+1);
                return;
            }
            map.put(text, 1);
            return;
        }

        for(int i = index; i < a.length(); i++) {
            String nText = text + a.charAt(i);
            dfs(nText,i+1,now+1,level,a);
        }
    }


}
