package class3;

/**
 * Created by guangshuozang on 6/4/16.
 */
import java.util.Stack;
public class StackWithMin {

        Stack<Integer> stack;
        Stack<Integer> min;
        public StackWithMin() {
            // write your solution here
            stack = new Stack<>();
            min = new Stack<>();
        }

        public int pop() {
            if(stack.isEmpty()) return -1;
            else{
                min.pop();
                return stack.pop();
            }
        }

        public void push(int element) {
            stack.push(element);
            if(element <= min.peek()){
                min.push(element);
            }else{
                min.push(min.peek());
            }
        }

        public int top() {
            if(stack.isEmpty()) return -1;
            else return stack.peek();
        }

        public int min() {
            if(stack.isEmpty()) return -1;
            else return min.peek();
        }


}
