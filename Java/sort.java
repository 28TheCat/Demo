import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sort {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        Collections.sort(list);
        System.out.println(list);
    }

}
