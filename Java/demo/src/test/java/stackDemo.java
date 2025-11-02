import org.junit.Test;

import java.util.Stack;

public class stackDemo {
    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("Java");
        System.out.println(stack.pop());//出栈元素
        System.out.println(stack.peek());//栈顶元素
        System.out.println(stack.size());//java出栈了
    }
}
