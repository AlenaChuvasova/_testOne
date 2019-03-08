package Main;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

public class StackTest {

    @Test
    public void constructorCreateTest() {
        new StackStructure<>(String.class,10);
        new StackStructure<>(Character.class,2);
    }

    @Test(expected = Exception.class)
    public void constructorExceptionTest() {
        new StackStructure<>(Integer.class,-1);
        new StackStructure<>(String.class,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongSizeConstructorTest(){
        new StackStructure<>(-2);
    }

    @Test(expected = Exception.class)
    public void isEmptyTest() {
        Assert.assertTrue(new StackStructure<>(String.class,-1).isEmpty());
        Assert.assertTrue(new StackStructure<>(String.class,0).isEmpty());
    }

    @Test
    public void isEmptyPopOnes(){
        StackStructure<String> myStack = new StackStructure<>(String.class,3);
        myStack.push("OnePush");
        myStack.pop();
        Assert.assertTrue(myStack.isEmpty());
    }

    @Test
    public void pushTest() {
        StackStructure<Integer> stack = new StackStructure<>(Integer.class,5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void sizeEmptyStack(){
        Assert.assertEquals(0,new StackStructure<String>().size());
    }

    @Test
    public void sizePushTest(){
        StackStructure<String> myStack = new StackStructure<>(String.class,3);
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        Assert.assertEquals(myStack.size(),3);
    }

    @Test(expected = EmptyStackException.class)
    public void popTest(){
        StackStructure<Integer> stack = new StackStructure<>(Integer.class,2);
        stack.pop();
    }

    @Test
    public void popElement(){
        StackStructure<Character> stack = new StackStructure<>(Character.class,3);
        Character c = 'c';
        stack.push(c);
        stack.push(c);
        Assert.assertEquals(stack.pop(),c);
    }

    @Test(expected = EmptyStackException.class)
    public void peekTest(){
        StackStructure<Integer> stack = new StackStructure<>(Integer.class,2);
        stack.peek();
    }

    @Test
    public void peekElement(){
        StackStructure<Character> stack = new StackStructure<>(Character.class,3);
        Character c = 'c';
        Character c1 = 'b';
        stack.push(c);
        stack.push(c1);
        Assert.assertEquals(stack.peek(),c1);
    }
    @Test
    public void equalsTwoStacks(){
        StackStructure<String> stack = new StackStructure<>();
        stack.push("A");
        stack.push("B");
        StackStructure<String> stack1 = new StackStructure<>();
        stack.push("A");
        stack.push("B");
        Assert.assertTrue(stack.equals(stack1));
        Assert.assertTrue(stack1.equals(stack));
    }

    @Test
    public void equalsTheSameStack(){
        StackStructure<Integer> stackStructure = new StackStructure<>(Integer.class,2);
        Assert.assertTrue(stackStructure.equals(stackStructure));

    }

    @Test
    public void hashCodeTest(){
        StackStructure<String> stack = new StackStructure<>();
        stack.push("A");
        stack.push("B");
        StackStructure<String> stack1 = new StackStructure<>();
        stack.push("A");
        stack.push("B");
        Assert.assertEquals(stack.hashCode(),stack1.hashCode());
    }

    @Test
    public void toStringEmptyStack(){
        StackStructure<String> stack = new StackStructure<>(0);
        Assert.assertEquals("Empty stack", stack.toString());
    }

    @Test
    public void toStringTest(){
        StackStructure<String> stack = new StackStructure<>(String.class,2);
        stack.push("A");
        stack.push("B");
        Assert.assertEquals("StackStructure{array=[A, B], size=2, top=1}", stack.toString());

    }






}
