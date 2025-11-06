import com.wangyating.Jedis.util.JedisConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class jedis {

    private Jedis jedis;
    private JedisPool jedisPool;

    @Before
    public void setUp() {
        // 从连接池获取连接
        jedisPool = JedisConnectionFactory.getPool();
        jedis = jedisPool.getResource();
        jedis.auth("123456");
        jedis.select(0);
    }

    @After
    public void tearDown() {
        // 归还jedis连接到连接池
        if (jedis != null) {
            jedis.close(); // 不是真关闭，是放回连接池
        }
    }

    @Test
    public void testString() {
        String result = jedis.set("name", "28mio");
        System.out.println("result = " + result);
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void testHash() {
        jedis.hset("user:1", "name", "28mio");
        jedis.hset("user:1", "age", "18");
        jedis.hset("user:1", "phone", "123456789");

        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println("map = " + map);
    }
}
