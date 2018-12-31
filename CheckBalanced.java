package com.company;


public class CheckBalanced
{
    public static class TreeNode{
        int data;
        TreeNode left,right,parent;
        TreeNode(int data)
        {
            this.data=data;
            this.parent = null;
        }

    }

    public int isBalanced(TreeNode root)
    {
        if(root==null)
            return -1;

        int heightLeft = isBalanced(root.left);
        int heightRight = isBalanced(root.right);

        return Math.max(heightLeft,heightRight)+1;

    }

    int checkHeight(TreeNode root)
    {
        if(root==null)
            return -1;

        int leftheight = checkHeight(root.left);
        if(leftheight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int rightheight = checkHeight(root.right);
        if(rightheight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int heightDiff = leftheight - rightheight;
        if(Math.abs(heightDiff)>1)
            return Integer.MIN_VALUE;

        else
            return Math.max(leftheight,rightheight)+1;

    }
    boolean isBST(TreeNode root)
    {
        return isBSTRecursive(root,null,null);
    }

    boolean isBSTRecursive(TreeNode root,Integer min,Integer max)
    {
        if(root==null)
            return true;
        if((min!=null && root.data<=min)||(max!=null && root.data>max))
            return false;
        if(!isBSTRecursive(root.left,min,root.data)||!isBSTRecursive(root.right,root.data,max))
            return false;
        return true;
    }

    boolean isBalancedOptimized(TreeNode root)
    {
        return checkHeight(root)!=Integer.MIN_VALUE;
    }

    TreeNode inOrderSucessor(TreeNode n)
    {
        if(n==null)
            return null;
        if(n.right!=null)
            return leftMost(n.right);
        else
        {
            TreeNode q= n;
            TreeNode x = q.parent;
            //if you are on the right subtree,go one step up
            while((x!=null)&&(x.left!=q))
            {
                q=x;
                x=x.parent;
            }
            return x;
        }
    }
    TreeNode leftMost(TreeNode n)
    {
        while(n.left!=null)
        {
            n=n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        // write your code here
        CheckBalanced m= new CheckBalanced();
        TreeNode n= new TreeNode(10);
        n.left = new TreeNode(5);
        n.left.parent = n;
        n.right =new TreeNode(15);
        n.right.parent = n;
        // n.right.right = new TreeNode(0);
        // n.right.right.right = new TreeNode(18);
        System.out.println(m.isBalanced(n));

        int heightLeft = m.isBalanced(n.left);
        int heightRight = m.isBalanced(n.right);
        if(Math.abs(heightLeft - heightRight)>1)
            System.out.println(false);
        else
            System.out.println(true);


        // System.out.println("Optimized Code");
        // System.out.println(m.isBalancedOptimized(n));

        // System.out.println(m.isBST(n));
        System.out.println(m.inOrderSucessor(n.right).data);

    }
}

