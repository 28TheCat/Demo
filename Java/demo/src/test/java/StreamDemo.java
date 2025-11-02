import org.junit.Test;
import java.util.List;

public class StreamDemo {

    /**
     * 案例1：筛选偶数并求平方
     */
    @Test
    public void testFilterAndMap() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .forEach(System.out::println);
    }

    /**
     * 案例2：筛选以'h'开头的字符串
     */
    @Test
    public void testFilterString() {
        List<String> list = List.of("hello", "world", "hello world");

        list.stream()
                .filter(s -> s.startsWith("h"))
                .forEach(System.out::println);
    }

    @Test
    public void testToUpper() {
        List<String> list = List.of("hello", "world", "hello world");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
