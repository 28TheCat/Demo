import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CustomTreeSet {
    @Test
    public void test(){
        Set<String> set=new TreeSet<>(Comparator.comparingInt(String::length));
        set.add("hello");
        set.add("world");
        set.add("hello world");
        set.add("dog");
        set.add("elephant");
        set.add("cat");
        set.add("lion");

        System.out.println(set);
        System.out.println(set.size());
    }
}
