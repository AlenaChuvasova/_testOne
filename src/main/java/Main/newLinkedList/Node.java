package Main.newLinkedList;

public class Node<T> {
    private T element;
    private Node<T> nextElement;
    private Node<T> previousElement;

    public Node(Node<T> previousElement, T element, Node<T> nextElement) {
        this.element = element;
        this.nextElement = nextElement;
        this.previousElement = previousElement;
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

    public void setNextElement(Node<T> nextElement) {
        this.nextElement = nextElement;
    }

    public Node<T> getPreviousElement() {
        return previousElement;
    }

    public void setPreviousElement(Node<T> previousElement) {
        this.previousElement = previousElement;
    }
}

