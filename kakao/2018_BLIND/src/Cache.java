import java.util.HashMap;
import java.util.Map;

public class Cache {

    public static void main(String[] args) {
        int size = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA","Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int solution = solution(size, cities);
        System.out.println(solution);
    }

    static int solution(int cacheSize, String[] cities) {
        Map<String,Integer> cache = new HashMap<>();

        int answer = 0;

        if(cacheSize == 0) return cities.length*5;

        for(String city : cities) {
            String lowCity = city.toLowerCase();

            if(cache.containsKey(lowCity)) {
                answer += 1;
                cache.replace(lowCity, 0);
            } else {
                answer +=5;
                if(cache.size() >= cacheSize) {
                    String maxKey ="";
                    int maxValue = Integer.MIN_VALUE;
                    for(String key : cache.keySet()) {
                        Integer value = cache.get(key);
                        if(maxValue < value){
                            maxKey = key;
                            maxValue = value;
                        }
                    }
                    cache.remove(maxKey);
                }
                cache.put(lowCity, 0);
            }
            for(String key : cache.keySet()) {
                cache.replace(key, cache.get(key)+1);
            }
        }
        return answer;
    }



}
