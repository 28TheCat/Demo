import org.junit.Test;
import java.util.Base64;

public class base64Demo {
    @Test
    public void test() {
        String str = "wangyating";

        String encoded = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println("编码后：" + encoded);

        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decoded = new String(decodedBytes);
        System.out.println("解码后：" + decoded);
    }
}
