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


    /**
     * Initializes an ArrayBag with a default capacity
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * Initializes fields for ArrayBag
     * 
     * @param capacity
     *            The desired capacity of the ArrayBag
     */
    public ArrayBag(int capacity) {
        initializeDataFields(capacity);
    }


    /**
     * @param capacity
     */
    private void initializeDataFields(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
        this.capacity = capacity;
        numberOfEntries = 0;
    }

    /**
     * Determines if bag is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Adds an object to the bag
     * 
     * @param entry
     *            The object to be added to the bag
     * 
     * @return True if the addition was successful
     */
    @Override
    public boolean add(T entry) {
        if (numberOfEntries == capacity) {
            return false;
        }
        else {
            bag[numberOfEntries] = entry;
            numberOfEntries++;
            return true;
        }
    }

    /**
     * Clears the bag
     */
    @Override
    public void clear() {
        initializeDataFields(capacity);
    }

    /**
     * Removes an entry from the bag
     * 
     * @return The removed entry
     */
    @Override
    public T remove() {
        T removed = null;
        if (numberOfEntries > 0) {
            removed = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return removed;
    }

    /**
     * Removes the given entry if it's in the bag
     */
    @Override
    public boolean remove(T entry) {
        if (!contains(entry)) {
            return false;
        }
        else {
            int index = getIndexOf(entry);
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
    }

    /**
     * Gets the number of occurrences of an object in the bag
     */
    @Override
    public int getFrequencyOf(T entry) {
        int counter = 0;
        for (int i = 0; i < bag.length; i++) {
            if (entry.equals(bag[i])) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Checks if the entry is in the bag
     */
    @Override
    public boolean contains(T entry) {
        boolean found = false;
        for (int i = 0; i < bag.length; i++) {
            if (entry.equals(bag[i])) {
                found = true;
                return found;
            }
        }
        return found;
    }


    @Override
    public T[] toArray() {
        return bag;
    }
    
    private int getIndexOf(T entry) {
        int result = -1;
        if (contains(entry)) {
            for (int i = 0; i < bag.length; i++) {
                if (entry.equals(bag[i])) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

}
