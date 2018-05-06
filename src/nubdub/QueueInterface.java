/**
 * 
 */
package nubdub;

/**
 * @author Nabdeep Shrestha (nabdeep)
 *
 */
public interface QueueInterface<T> {

    public void enqueue(T entry);
    
    public T dequeue() throws EmptyQueueException;
    
    public T getFront() throws EmptyQueueException;
    
    public boolean isEmpty();
    
    public void clear();
    
}
