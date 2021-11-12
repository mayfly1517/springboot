package leetcode;

import leetcode.Tree.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    /**
     * 构建二叉树
     * @param list 输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> list) {
        TreeNode node=null;
        if(list==null||list.isEmpty())return null;
        Integer data =list.removeFirst();
        if(data!=null){
            node=new TreeNode(data);
            node.left=createBinaryTree(list);
            node.right=createBinaryTree(list);
        }
        return node;

    }
    /**
     * 二叉树前序遍历 根->左->右
     * @oaram node 二叉树结点
     */
    public static void preOrderTraversal(TreeNode node){
        if(node==null)return;
        System.out.print(node.data+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    /**
     * 中序遍历 左根右
     * @param node
     */
    public static void inOrderTraversal(TreeNode node){
        if(node==null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data);
        inOrderTraversal(node.right);
    }
    /**
     * 后序遍历 左右根
     * @param node
     */
    public static void postOrderTraversal(TreeNode node){
        if(node==null)return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data);
    }
    /**
     * 非递归 前中后序遍历 ***GITHUB***
     */
    public  List<Integer>preOrderTraversal1(TreeNode root){
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node==null)continue;
            list.add(node.data);
            stack.push(node.right);/**  先右后左，先遍历左子树*/
            stack.push(node.left);
        }
        return  list;
    }
//    public List<Integer> postOrderTraversal1(TreeNode root){
//        List<Integer>list=new ArrayList<>();
//        Stack<TreeNode>stack=new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//
//            postOrderTraversal1(root.left);
//        }
//    }


    /**
     * 层序遍历
     */
    public static void levelOrder(TreeNode root){
        if(root==null)return ;
        Queue<TreeNode>queue=new LinkedBlockingQueue<>();
        TreeNode curr;
        queue.add(root);
        while(!queue.isEmpty()){
            curr=queue.remove() ;
            System.out.print(curr.data);
            if(curr.left!=null)queue.add(root.left);
            if(curr.right!=null)queue.add((root.right));
        }
    }

}
