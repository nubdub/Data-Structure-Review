/**
 * 
 */
package nubdub;

import java.util.EmptyStackException;

/**
 * @author Nabdeep Shrestha (nabdeep)
 * @version 2018.05.05
 *
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node topNode;
    private int size;


    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }


    /**
     * @param size
     *            the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public void push(T entry) {
        Node newNode = new Node(entry, topNode);
        topNode = newNode;
        size++;

    }


    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            T removed = peek();
            topNode = topNode.next;
            size--;
            return removed;
        }
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return topNode.data;
        }
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = topNode;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            else {
                sb.append("]");
            }
            current = current.next;
        }
        return sb.toString();
    }


    /**
     * @author Nabdeep Shrestha (nabdeep)
     * @version 2018.05.05
     *
     */
    private class Node {

        private T data;
        private Node next;


        public Node(T entry, Node nextNode) {
            data = entry;
            next = nextNode;
        }

    }

}
