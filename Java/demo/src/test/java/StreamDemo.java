import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {
    List<String> names=List.of("Tom", "Alice", "Bob", "Jim", "Mike", "Jane","28TheCat");

   @Test
    public void test1(){
       List<String> result =  names.stream()
              .filter(name->name.length()==3)
              .collect(Collectors.toList());
       System.out.println(result);
   }
   @Test
    public void test2(){
       names.stream()
               .limit(2)
               .forEach(System.out::println);
   }
   @Test
    public void test3(){
       names.stream()
               .skip(2)
               .forEach(System.out::println);
   }
   @Test
    public void test4(){
       names.stream()
               .distinct()
               .forEach(System.out::println);
   }
   @Test
    public void test5(){
       Long result=names.stream().map(name->name.toUpperCase())
               .count() ;
       System.out.println(result);
       names.stream().map(name->name.toUpperCase())
               .forEach(System.out::println);
    }
}
