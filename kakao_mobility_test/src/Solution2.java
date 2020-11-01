import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        solution(new String[][]{{"david", "frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}}, "david");
//        solution(new String[][]{{"david", "demi"}, {"frank", "demi"}, {"demi", "james"}}, "frank");
    }

    public static String[] solution(String[][] friends, String user_id) {

        HashMap<String,List<Person>> graph = new HashMap<>();

        for(int i = 0 ; i < friends.length; i++) {
            if(graph.containsKey(friends[i][0])) {
                graph.get(friends[i][0]).add(new Person(friends[i][1]));
            } else {
                List<Person> people = new ArrayList<>();
                people.add(new Person(friends[i][1]));
                graph.put(friends[i][0],people);
            }

            if(graph.containsKey(friends[i][1])) {
                graph.get(friends[i][1]).add(new Person(friends[i][0]));
            } else {
                List<Person> people = new ArrayList<>();
                people.add(new Person(friends[i][0]));
                graph.put(friends[i][1],people);
            }
        }

        List<Person> people = graph.get(user_id);

        Map<String,Integer> count = new HashMap<>();
        for(Person person : people) {
            for(Person friend : graph.get(person.userId)) {
                if(friend.userId == user_id) continue;
                if(count.containsKey(friend.userId)) {
                    count.put(friend.userId,count.get(friend.userId)+1);
                } else {
                    count.put(friend.userId,1);
                }
            }
        }

        int max = 0;

        Iterator<Map.Entry<String, Integer>> iterator = count.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            max = Math.max(max,next.getValue());
        }

        List<String> friendList = new ArrayList<>();

        iterator = count.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            if(next.getValue() == max)
                friendList.add(next.getKey());
        }

        Collections.sort(friendList);

        String[] answer = new String[friendList.size()];
        for(int i = 0; i < friendList.size(); i++) {
            answer[i] = friendList.get(i);
        }
        return answer;

    }

    static class Person{
        private String userId;

        public Person(String userId) {
            this.userId = userId;
        }
    }
}
