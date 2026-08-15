class Solution {
    public String intToRoman(int num) {
        int[]value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<value.length;i++){
            while(num>=value[i]){
                ans.append(roman[i]);
                num-=value[i];
            }
        }
        return ans.toString();
    }
}