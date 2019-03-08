package Main;

import Main.newStack.NewStack;
import org.junit.Assert;
import org.junit.Test;

public class NewStackTest {

    @Test
    public void pushTest() {
        NewStack<Integer> stack = new NewStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void sizeEmptyStack() {
        Assert.assertEquals(0, new NewStack<String>().size());
    }

    @Test
    public void sizePushTest() {
        NewStack<String> myStack = new NewStack<>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        Assert.assertEquals(myStack.size(), 3);
    }

    @Test
    public void popTest() {
        NewStack<Integer> stack = new NewStack<>();
        stack.pop();
    }

    @Test
    public void popElement() {
        NewStack<Character> stack = new NewStack<>();
        Character c = 'c';
        stack.push(c);
        stack.push(c);
        Assert.assertEquals(stack.pop(), c);
    }

    @Test
    public void peekTest() {
        NewStack<Integer> stack = new NewStack<>();
        stack.peek();
    }

    @Test
    public void peekElement() {
        NewStack<Character> stack = new NewStack<>();
        Character c = 'c';
        Character c1 = 'b';
        stack.push(c);
        stack.push(c1);
        Assert.assertEquals(stack.peek(), c1);
    }

    @Test
    public void toStringEmptyStack() {
        NewStack<String> stack = new NewStack<>();
        Assert.assertEquals("Empty stack", stack.toString());
    }

    @Test
    public void equalsTheSameStack() {
        NewStack<Integer> newStack = new NewStack<>();
        Assert.assertTrue(newStack.equals(newStack));
    }

    @Test
    public void equalsAfterSizeChanges(){
        NewStack<String> stack = new NewStack<>();
        stack.push("A");
        NewStack<String> stack1 = new NewStack<>();
        stack1.push("A");
        stack.pop();
        Assert.assertFalse(stack.equals(stack1));
    }

    @Test
    public void equalsTwoStacks() {
        NewStack<String> stack = new NewStack<>();
        stack.push("A");
        stack.push("B");
        NewStack<String> stack1 = new NewStack<>();
        stack1.push("A");
        stack1.push("B");
        Assert.assertEquals(stack.equals(stack1),stack1.equals(stack));
    }

    @Test
    public void equalsDifferentTest(){
        NewStack<String> stack = new NewStack<>();
        Assert.assertFalse(stack.equals(new Object()));
        Assert.assertFalse(stack.equals(null));
    }

    @Test
    public void equalsDifferentTypeTest(){
        NewStack<String> stack = new NewStack<>();
        NewStack<Integer> stack1 = new NewStack<>();
        stack.push("A");
        stack1.push(1);
        Assert.assertFalse(stack.equals(stack1));
    }

    @Test
    public void hashCodeTest() {
        NewStack<String> stack = new NewStack<>();
        stack.push("A");
        stack.push("B");
        NewStack<String> stack1 = new NewStack<>();
        stack1.push("A");
        stack1.push("B");
        Assert.assertEquals(stack.hashCode(), stack1.hashCode());
    }

    @Test
    public void hashCodeAfterSizeChanges(){
        NewStack<String> stack = new NewStack<>();
        stack.push("A");
        NewStack<String> stack1 = new NewStack<>();
        stack1.push("A");
        stack1.pop();
        Assert.assertNotEquals(stack.hashCode(),stack1.hashCode());
    }

    @Test
    public void hashCodeSizeTest(){
        NewStack<String> stack = new NewStack<>();
        stack.push("A");
        stack.push("B");
        Assert.assertTrue(stack.hashCode()==stack.hashCode());
    }

    @Test
    public void toStringTest() {
        NewStack<String> stack = new NewStack<>();
        stack.push("A");
        stack.push("B");
        Assert.assertEquals("NewStack: size is 2, top element is B", stack.toString());
    }
}
