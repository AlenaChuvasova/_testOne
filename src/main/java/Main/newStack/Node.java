package Main.newStack;

public class Node<T> {
    private T element;
    private Node<T> nextElement;

    public Node(T element, Node<T> nextElement) {
        this.element = element;
        this.nextElement = nextElement;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNextElement() {
        return nextElement;
    }

}
