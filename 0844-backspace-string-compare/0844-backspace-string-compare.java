class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>stack=new Stack<>();
        Stack<Character>stac=new Stack<>();
        for(int i=0;i<s.length();i++){
       char ch= s.charAt(i);
       if( ch=='#'){
         if(!stack.isEmpty()){
            stack.pop();
         }
         }else{
       stack.push(ch);
         }

    }
     for(int i=0;i<t.length();i++){
        char ch=t.charAt(i);
        if( ch=='#'){
            if(!stac.isEmpty()){
                stac.pop();
            }
            }else{
               stac.push(ch);
            }
        }
        return stack.equals(stac);
     }
        }
    
    

