package com.company;

import java.util.ArrayList;

public class MinHeightBST {
    public class Node{
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
        }
    }

//    void createBST(ArrayList<Integer> arr)
//    {
//        int length = arr.size();
//        Node n = new Node(arr.get(length/2));
//        root = n;
//
//        int pos = arr.size()/2;
//        while(pos>=0)
//        {
//              root.left = new Node(arr.get(pos-1))  ;
//              root.right = new Node(arr.get(pos+1));
//
//              pos = pos/2;
//              root = new Node(arr.get(pos));
//        }
//        while(pos<length)
//        {
//            root.left = new Node(arr.get(pos-1))  ;
//            root.right = new Node(arr.get(pos+1));
//
//            pos = pos/2;
//            root = new Node(arr.get(pos));
//        }
//
//    }
    Node createBSTRecursive(ArrayList<Integer> arr,int low,int high)
    {
        if(low>high)
        {
            return null;
        }
        int mid = (low+high)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBSTRecursive(arr,low,mid-1);
        root.right = createBSTRecursive(arr,mid+1,high);
        return root;
    }
    void inorderTraversal(Node root)
    {
        if(root==null)
            return ;
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);

    }






    public static void main(String args[])
    {
        ArrayList<Integer> a= new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);

        //System.out.println(a);

        MinHeightBST m = new MinHeightBST();
       // m.createBST(a);
        Node root = m.createBSTRecursive(a,0,a.size()-1);
        m.inorderTraversal(root);
    }
}
