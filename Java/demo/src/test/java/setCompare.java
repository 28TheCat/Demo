import org.junit.Test;

import java.util.*;

public class setCompare {
    @Test
    public void test(){
        HashSet<String> hashSet=new HashSet<>();
        LinkedHashSet<String> linkedHashSet=new LinkedHashSet();
        TreeSet<String > treeSet=new TreeSet<>();

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.addAll(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Monday"));
        System.out.println("ArrayList:");
        System.out.println(arrayList);

        System.out.println("HashSet:");
        hashSet.addAll(arrayList);
        System.out.println(hashSet);

        System.out.println("LinkedHashSet:");
        linkedHashSet.addAll(arrayList);
        System.out.println(linkedHashSet);

        System.out.println("TreeSet:");
        treeSet.addAll(arrayList);
        System.out.println(treeSet);

    }
}
