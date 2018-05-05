/**
 * 
 */
package nubdub;

/**
 * @author Nabdeep Shrestha (nabdeep)
 *
 */
public class ArrayBag<T> implements BagInterface<T> {
    
    private T[] bag;
    private int numberOfEntries;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 25;
    
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean add(T entry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(T entry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getFrequencyOf(T entry) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T entry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

}
