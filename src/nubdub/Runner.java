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
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("Hello");
        stack.push("World");
        System.out.println(stack.toString());
        
        ArrayStack<String> stack2 = new ArrayStack<>(3);
        stack2.push("Hello");
        stack2.push("World");
        stack2.push("Yeet");
        stack2.push("Lmao");
        System.out.println(stack2.toString());
    }

}
