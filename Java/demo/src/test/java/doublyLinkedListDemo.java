import com.wangyating.DoublyLinkedList;
import org.junit.Test;

public class doublyLinkedListDemo {
    @Test
    public void test(){
        DoublyLinkedList list=new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(11);
        list.add(123);

        list.printForward();
        list.printBackward();
    }
}
