class MyQueue {
    Stack<Integer>stack=new Stack<>();
    Stack<Integer>stac=new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
    stack.push(x);
        
        
    }
    
    public int pop() { if(stac.isEmpty()){
            while(!stack.isEmpty()){
            stac.push(stack.pop());
            }
        }
        return stac.pop();
    }
    
    public int peek() {
         if(stac.isEmpty()){
            while(!stack.isEmpty()){
            stac.push(stack.pop());
            }
        }
      return  stac.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty()&&stac.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */