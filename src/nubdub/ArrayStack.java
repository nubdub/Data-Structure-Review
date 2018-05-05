/**
 * 
 */
package nubdub;

import java.util.EmptyStackException;

/**
 * @author Nabdeep Shrestha (nabdeep)
 *
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] stack;
    private int topIndex;
    private boolean initialized = false;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 1000;


    public ArrayStack(int capacity) {
        initializeDataFields(capacity);
    }


    /**
     * @param capacity
     */
    private void initializeDataFields(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempArr = (T[])new Object[capacity];
        stack = tempArr;
        topIndex = -1;
        initialized = true;
        this.capacity = capacity;
    }


    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }


    @Override
    public void push(T entry) {
        ensureCapacity();
        stack[topIndex + 1] = entry;
        topIndex++;
    }


    private void ensureCapacity() {
        if (topIndex + 1 == capacity) {
            maxCapIsFull();
            @SuppressWarnings("unchecked")
            T[] tempArr = (T[])new Object[capacity + 100];
            copyTo(stack, tempArr);
            stack = tempArr;
        }
    }


    private void copyTo(T[] arr1, T[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }


    private void maxCapIsFull() {
        if (topIndex + 1 == MAX_CAPACITY) {
            throw new IllegalStateException("Max capacity has been reached");
        }
    }


    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removed = stack[topIndex];
        stack[topIndex] = null;
        topIndex--;
        return removed;
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[topIndex];
    }


    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }


    @Override
    public void clear() {
        initializeDataFields(DEFAULT_CAPACITY);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = topIndex; i >= 0; i--) {
            sb.append(stack[i].toString());
            if (i == 0) {
                sb.append("]");
            }
            else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
