import org.junit.Test;

import java.util.Queue;

public class queueDemo {
    @Test
    public void testQueue() {
        Queue<String> queue = new java.util.LinkedList<>();
        queue.offer("hello");
        queue.offer("world");
        queue.offer("java");
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.peek() );
        System.out.println(queue.size());
    }
}
