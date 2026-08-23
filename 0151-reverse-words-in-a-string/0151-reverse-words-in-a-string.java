class Solution {
    public String reverseWords(String s) {
        String trim=s.trim();
        String[]arr=trim.split("\\s+");
        int i=0,j=arr.length-1;
        while(i<j){
            String temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i=i+1;
            j=j-1;
        }
        return String.join(" ",arr);

    }
}