package Main.newStack;

import java.util.EmptyStackException;
import java.util.Objects;

public class NewStack<T> {
    private int size;
    private Node<T> nextElement;

    public void linkFirst(T t) {
        if (nextElement == null) {
            nextElement = new Node<>(t, null);
        } else {
            nextElement = new Node<>(t, nextElement);
        }
        size++;
    }

    public T separate() throws EmptyStackException {
        if (size != 0) {
            T element = nextElement.getElement();
            nextElement.setElement(null);
            nextElement = nextElement.getNextElement();
            size--;
            return element;
        } else {
            new EmptyStackException();
        }
        return null;
    }

    public void push(T element) {
        linkFirst(element);
    }

    public T pop() {
        return separate();
    }

    public T peek() {
        if (size != 0) {
            return nextElement.getElement();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewStack<?> that = (NewStack<?>) o;

        for (int i = 0; i < size; i++) {
            if (!nextElement.getElement().equals(that)) {
                return false;
            }
        }
        return size == that.size;
    }

    public int hashCode() {
        int result = Objects.hashCode(size);
        for (int i = 0; i < size; i++) {
            return result = 31 * result + nextElement.getElement().hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "Empty stack";
        }
        final StringBuffer sb = new StringBuffer("NewStack: ");
        sb.append("size is ");
        sb.append(size());
        sb.append(", top element is ");
        sb.append(nextElement.getElement());
        return sb.toString();
    }
}
