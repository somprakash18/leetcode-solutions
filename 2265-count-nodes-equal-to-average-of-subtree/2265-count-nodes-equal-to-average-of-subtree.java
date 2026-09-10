/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
        private int result=0;
        private int[]solve(TreeNode root){
            if(root==null){
                return new int[]{0,0};

            }
            int[]left=solve(root.left);
            int[]right=solve(root.right);
            int leftSum=left[0];
            int leftCount=left[1];
            int rightSum=right[0];
            int rightCount=right[1];
            int sum=leftSum+rightSum+root.val;
            int count = leftCount + rightCount + 1;
            int average=sum/count;
            if(average==root.val){
                result++;
            }
            return new int[]{sum,count};
        }
         public int averageOfSubtree(TreeNode root) {
            result=0;
            solve(root);
            return result;
    }
}