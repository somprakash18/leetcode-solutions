class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>stack=new Stack<>();
        for(String op:operations){
            if(!op.equals("C")&&!op.equals("D")&&!op.equals("+")){
            int score=Integer.parseInt(op);
            stack.push(score);
        }
        else if(op.equals("C")){
            stack.pop();
        }
        else if(op.equals("D")){
            int score=stack.peek()*2;
            stack.push(score);
        }
        else if(op.equals("+")){
            int last=stack.pop();
            int secondlast=stack.peek();
            stack.push(last);
            stack.push(last+secondlast);
        }
    }
    int sum=0;
    while(!stack.isEmpty()){
        sum+=stack.pop();
    }
    return sum;
    }
}