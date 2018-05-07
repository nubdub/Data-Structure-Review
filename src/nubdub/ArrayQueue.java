/**
 * 
 */
package nubdub;

/**
 * @author Nabdeep Shrestha (nabdeep)
 *
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private int capacity;
    private int size;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 1000;
    
    
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayQueue(int capacity) {
        initializeDataFields(capacity);
    }

    /**
     * @param capacity
     */
    private void initializeDataFields(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[capacity];
        queue = temp;
        this.capacity = capacity;
        frontIndex = 0;
        backIndex = 0;
        size = 0;
    }

    @Override
    public void enqueue(T entry) {
        ensureCapacity();
        queue[backIndex] = entry;
        backIndex = incrementIndex(backIndex);
        size++;
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            @SuppressWarnings("unchecked")
            T[] temp = (T[])new Object[newSize];
            queue = temp;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldQueue[frontIndex];
                frontIndex = incrementIndex(frontIndex);
            }
        }
        
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            T front = getFront();
            queue[frontIndex] = null;
            frontIndex = incrementIndex(frontIndex);
            size--;
            return front;
        }
    }

    @Override
    public T getFront() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return queue[frontIndex];
        }
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == incrementIndex(backIndex);
    }

    @Override
    public void clear() {
        initializeDataFields(DEFAULT_CAPACITY);
    }
    
    private int incrementIndex(int index) {
        return (index + 1) % queue.length;
    }
    
    public T[] toArray() {
        return queue;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(queue[i].toString());
            if (i == size - 1) {
                sb.append("]");
            }
            else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
