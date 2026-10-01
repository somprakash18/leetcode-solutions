class Solution {
    public String decodeString(String s) {
        Stack<Integer>numbers=new Stack<>();
        Stack<String>strings=new Stack<>();
       int num=0;
       String current="";
       for(char ch:s.toCharArray()){
         if(Character.isDigit(ch)){
            num=num*10+(ch-'0');

         }else if(ch=='['){
           numbers.push(num);
           strings.push(current);
           num=0;
           current="";
         }else if(ch==']'){
            int repeat=numbers.pop();
            String previous=strings.pop();
            String temp="";
            for (int i=0;i<repeat;i++){
                temp+=current;
            }
            current=previous+temp;
         }else{
            current+=ch;
         }
       }
       return current;
    }
}