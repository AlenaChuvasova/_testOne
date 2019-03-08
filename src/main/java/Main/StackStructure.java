package Main;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

public class StackStructure<T> {
    //Stack
    //push, pop, size, equals, hashcode, toString

    private T[] array;
    private int size;
    private int top;


    public StackStructure(Class<T> element, int size) {

        this.size = size;
        this.top = -1;
        this.array = (T[]) Array.newInstance(element, size);
    }

    public StackStructure(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public StackStructure() {

    }

    public boolean isEmpty() {

        return (top == -1);
    }

    public void push(T t) {
        if (top < size - 1) {
            array[++top] = t;
        }
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T res = array[top];
        array[top--] = null;
        return res;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T x = null;
        if (top >= 0) {
            x = array[top];
        }
        return x;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackStructure<?> that = (StackStructure<?>) o;
        return size == that.size &&
                top == that.top &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, top);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        if (this.size()==0) {
            return "Empty stack";
        } else {

            final StringBuffer sb = new StringBuffer("StackStructure{");
            sb.append("array=").append(array == null ? "null" : Arrays.asList(array).toString());
            sb.append(", size=").append(size);
            sb.append(", top=").append(top);
            sb.append('}');
            return sb.toString();
        }
    }
}
