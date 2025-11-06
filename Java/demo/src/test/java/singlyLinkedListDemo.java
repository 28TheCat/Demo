import com.wangyating.SinglyLinkedList;
import org.junit.Test;

public class singlyLinkedListDemo {
    @Test
    public void test(){
        SinglyLinkedList list=new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(11);
        list.add(123);
        list.printList();
    }
}
