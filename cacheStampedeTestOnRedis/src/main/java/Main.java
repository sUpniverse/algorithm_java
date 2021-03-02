import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Main {

  private static final int TTL = 60;
  private static final String SET_SCRIPT = "redis.call('mset', KEYS[1], ARGV[1], KEYS[2], ARGV[2]);" +
                                           "redis.call('expire', KEYS[1], ARGV[3]);" +
                                           "redis.call('expire', KEYS[2], ARGV[3]);";
  private static final String GET_SCRIPT = "return {" +
                                                    "redis.call('mget', KEYS[1], KEYS[2])," +
                                                    "redis.call('ttl', KEYS[1])" +
                                                   "}";
  private static JedisCluster jedisCluster;
  private static final double BETA = 1.0;

  public static void main(String[] args) {
    jedisCluster = new JedisCluster(new HostAndPort("localhost", 7379));
    get("test", (i) -> i+":test");


  }


  public static String get(String key, Function<String, String> recomputer) {
    List<Object> ret = (List<Object>) jedisCluster.eval(GET_SCRIPT, 2, key, getDeltaKey(key));
    List<String> valueList = (List<String>) ret.get(0);
    String data = valueList.get(0);
    String deltaStr = valueList.get(1);
    Random random = new Random();
    long now = System.currentTimeMillis();

    if(data == null ||
            (now - Long.valueOf(deltaStr) * BETA * Math.log(random.nextDouble())) >= (long) ret.get(1)) {
      long start = System.currentTimeMillis();
      data = recomputer.apply(key);
      long computationTime = (System.currentTimeMillis() - start) * 1000;
      jedisCluster.eval(SET_SCRIPT, 2, key, getDeltaKey(key), data, String.valueOf(computationTime), String.valueOf(TTL));
    }

    return data;
  }

  private static String getDeltaKey(String key) {
    return null;
  }

}
