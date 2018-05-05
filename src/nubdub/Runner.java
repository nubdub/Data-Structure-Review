/**
 * 
 */
package nubdub;

/**
 * @author Nabdeep Shrestha (nabdeep)
 *
 */
public class Runner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Hello");
        stack.push("World");
        System.out.println(stack.toString());
    }

}
