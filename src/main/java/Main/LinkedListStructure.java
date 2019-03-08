package Main;

import java.util.Objects;

public class LinkedListStructure<T> {
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public LinkedListStructure() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void link(T t, Node<T> nextNode) {
        Node<T> prevElement = nextNode.prevElement;
        Node<T> newNode = new Node<>(t, prevElement, nextNode);
        nextNode.prevElement = newNode;
        if (prevElement == null) {
            firstNode = newNode;
        } else {
            prevElement.nextElement = newNode;
        }
        size++;
    }

    public void linkLast(T t) {
        Node<T> existNode = lastNode;
        lastNode = new Node<>(t, existNode, null);
        if (isEmpty()) {
            firstNode = lastNode;
        } else {
            existNode.nextElement = lastNode;
        }
        size++;
    }


    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            linkLast(element);
        } else {
            link(element, getElementByIndex(index));
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getElementByIndex(index).element;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return separate(getElementByIndex(index));
    }

    public int size() {
        return size;
    }

    public Node<T> getElementByIndex(int index) {
        if (index < (size >> 1)) {
            Node<T> x = firstNode;
            return x;
        } else {
            Node<T> x = lastNode;
            for (int i = size - 1; i > index; i--)
                x = x.prevElement;
            return x;
        }
    }

    private T separate(Node<T> n) {
        T element = n.element;
        Node<T> next = n.nextElement;
        Node<T> previous = n.prevElement;

        if (previous == null) {
            firstNode = next;
        } else {
            previous.nextElement = next;
            n.prevElement = null;
        }
        if (next == null) {
            lastNode = previous;
        } else {
            next.prevElement = previous;
            n.nextElement = null;
        }
        n.element = null;
        size--;
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListStructure<?> that = (LinkedListStructure<?>) o;
        return size == that.size &&
                Objects.equals(firstNode, that.firstNode) &&
                Objects.equals(lastNode, that.lastNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "Empty list";
        } else {
            final StringBuffer sb = new StringBuffer("LinkedListStructure{");
            sb.append("size=").append(size);
            sb.append(", firstNode=").append(firstNode.element);
            sb.append(", lastNode=").append(lastNode.element);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class Node<T> {
        private T element;
        private Node<T> prevElement;
        private Node<T> nextElement;


        Node(T element, Node<T> prevElement, Node<T> nextElement) {
            this.element = element;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }
}
