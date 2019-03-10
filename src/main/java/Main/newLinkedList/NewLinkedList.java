package Main.newLinkedList;

import java.util.Objects;

public class NewLinkedList<T> {
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public NewLinkedList() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public NewLinkedList(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        return size;
    }

    private void linkLast(T t) {
        Node<T> last = lastNode;
        Node<T> newNode = new Node<>(last, t, null);
        lastNode = newNode;
        if (last == null)
            firstNode = newNode;
        else
            last.setNextElement(newNode);
        size++;
    }

    private void link(T t, Node<T> nextNode) {
        Node<T> oldNode = nextNode.getPreviousElement();
        Node<T> newNode = new Node<>(oldNode, t, nextNode);
        nextNode.setPreviousElement(newNode);
        newNode.setPreviousElement(newNode);
        oldNode.setNextElement(newNode);
        size++;
    }

    private T separate(Node<T> n) {
        T element = n.getElement();
        Node<T> next = n.getNextElement();
        Node<T> previous = n.getPreviousElement();
        firstNode = next;
        next.setPreviousElement(previous);
        n.setNextElement(null);
        n.setElement(null);
        size--;
        return element;
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
        return getElementByIndex(index).getElement();
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return separate(getElementByIndex(index));
    }

    public Node<T> getElementByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size / 2) {
            Node<T> x = firstNode;
            for (int i = 0; i < index; i++)
                x = x.getNextElement();
            return x;
        } else {
            Node<T> x = lastNode;
            for (int i = size - 1; i > index; i--)
                x = x.getPreviousElement();
            return x;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewLinkedList<?> that = (NewLinkedList<?>) o;

        for (int i = 0; i < size; i++) {
            if (!get(i).equals(that.get(i))) {
                return false;
            }
        }
        return size == that.size;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        for (int i = 0; i <= size; i++) {
            return result = 31 * result + get(i).hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "Empty list";
        } else {
            final StringBuffer sb = new StringBuffer("NewLinkedList ");
            sb.append("[");
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    sb.append(get(i));
                    break;
                }
                sb.append(get(i) + ", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
