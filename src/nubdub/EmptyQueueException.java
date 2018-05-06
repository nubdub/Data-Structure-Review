/**
 * 
 */
package nubdub;

/**
 * @author Nabdeep Shrestha (nabdeep)
 *
 */
public class EmptyQueueException extends Exception {

    public EmptyQueueException() {
        super();
    }
    
    public EmptyQueueException(String str) {
        super(str);
    }
    
}
