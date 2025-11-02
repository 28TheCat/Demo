import com.sky.DoublyLinkedList;
import org.junit.Test;

import java.util.ArrayList;

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
