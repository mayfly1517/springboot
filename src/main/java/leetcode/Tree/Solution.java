package leetcode.Tree;

public class Solution {

    public boolean recur(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null)return true;
        if(t1==null||t2==null||t1.data!=t2.data)return false;
        return recur(t1.left,t2.left)&&recur(t1.right,t2.right);
    }
}
