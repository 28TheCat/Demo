import com.sky.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomComparator {
    @Test
    public void test(){
        List<User> users=new ArrayList<>();
        users.add(new User("Tom", 25));
        users.add(new User("Alice", 30));
        users.add(new User("Bob", 25));
        users.add(new User("David", 20));

        Comparator<User> userComparator=new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()-o2.getAge();
            }
        };
    }
}
