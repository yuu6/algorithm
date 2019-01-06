package com.yuu6.algorithms.inorderTraversal;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> res = new ArrayList<>();

    TreeNode root = null;

    public Solution(String[] args) {
        //首先构建一个树
        if (args.length >= 1) {
            root = new TreeNode(Integer.valueOf(args[0]));
            root.left = null;
            root.right = null;
        }
        construct(root, 0, args);
    }

    private void construct(TreeNode root, int i, String[] args) {
        System.out.println(args[0]);
        if(i>=args.length){
            return;
        }
        if ((2 * i + 1) < args.length && args[(2 * i + 1)]!=null) {
            System.out.println(args[2*i+1]);
            TreeNode temp = new TreeNode(Integer.valueOf(args[(2 * i + 1)]));
            root.left = temp;
            temp.left = null;
            temp.right = null;
            construct(temp, 2 * i + 1, args);//构建左子树
        }
        if ((2 * i + 2) < args.length && args[(2 * i + 2)]!=null) {
            TreeNode temp = new TreeNode(Integer.valueOf(args[(2 * i + 2)]));
            temp.left = null;
            temp.right = null;
            root.right = temp;
            construct(temp, 2 * i + 2, args);//构建右字数
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        bainli(root);
        System.out.println(res);
        return res;
    }

    public void bainli(TreeNode root) {
        while (root == null) {
            return ;
        }
        visit(root);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    private void visit(TreeNode root) {
        res.add(root.val);
        System.out.print(root.val);
    }

    public static void main(String[] args) {
        //根据
        Solution solution = new Solution(args);
        solution.inorderTraversal(solution.root);
//        System.out.println();
    }
}
