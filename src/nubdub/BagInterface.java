/**
 * 
 */
package nubdub;

/**
 * @author Nabdeep Shrestha (nabdeep)
 * @version 2018.05.05
 *
 */
public interface BagInterface<T> {

    /**
     * Checks if the bag is empty
     * 
     * @return True if the bag contains no entries
     */
    public boolean isEmpty();

    /**
     * Gets the number of objects in the bag
     */
    public int getCurrentSize();
    
    /**
     * Adds an entry to the bag
     * 
     * @param entry The object to be added
     * 
     * @return True if the addition was successful
     */
    public boolean add(T entry);
    
    /**
     * Clears the bag
     */
    public void clear();
    
    /**
     * Removes an unspecified object from the bag
     * 
     * @return The object that was removed
     */
    public T remove();
    
    /**
     * Removes an occurrence of a particular object from the bag, if possible
     */
    public boolean remove(T entry);
    
    /**
     * Counts the number of times an object occurs in the bag
     */
    public int getFrequencyOf(T entry);
    
    /**
     * Tests whether the bag contains a particular object
     */
    public boolean contains(T entry);
    
    /**
     * Outputs contents of bag as an array
     */
    public T[] toArray();
    
    

}
