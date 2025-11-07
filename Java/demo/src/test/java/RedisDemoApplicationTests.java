import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisDemoApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testString(){
        //存储数据
        redisTemplate.opsForValue().set("name","29mio");
        //获取数据
        Object name= redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }
}

