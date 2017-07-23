package class3;

import java.util.Stack;

/**
 * Created by guangshuozang on 6/4/16.
 */
public class QueueByTwoStacks {

  /*
    When the queue is empty, poll() and peek() should return null.
    stack1: input, just push
    stack2: output, first move stack1 to stack2, then pop
*/


  private int size;
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;
  public QueueByTwoStacks() {
    // Write your solution here.
    this.size = 0;
    this.stack1 = new Stack<>();
    this.stack2 = new Stack<>();
  }

  public Integer poll() {
    if(size == 0){
      return null;
    }
    if(stack2.isEmpty()){
      while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
    }
    size --;
    return stack2.pop();
  }

  public void offer(int element) {
    size ++;
    stack1.push(element);
  }

  public Integer peek() {
    if(size == 0){
      return null;
    }
    if(stack2.isEmpty()){
      while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }



}
