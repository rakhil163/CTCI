package com.company;

import java.util.LinkedList;
import java.util.*;
public class CTCI {

    public static class Node{
        int data;
        Node left,right;
        Node(int data)
        {
            this.data= data;
        }
    }

//    ArrayList<LinkedList<Node>> bfs(Node root) {
//        ArrayList<LinkedList<Node>> result = new ArrayList<>();
//
//        LinkedList<Node> current = new LinkedList<>();
//        if (root != null)
//            current.add(root);
//
//        while (current.size() > 0) {
//            result.add(current);
//            LinkedList<Node> parent = current;
//            current = new LinkedList<>();
//            for(Node p : parent)
//            {
//                if(p.left!=null)
//                    current.add(p);
//                if(p.right!=null)
//                    current.add(p);
//            }
//
//        }
//        return result;
//    }

    void createlevel(Node root,ArrayList<LinkedList<Node>>lists,int level)
    {
        if(root==null)
            return;
        LinkedList<Node>list=null;
        if(lists.size()==level)
        {
            list=new LinkedList<Node>();
            lists.add(list);
        }
        else
        {3
            list=lists.get(level);
        }
        list.add(root);
        createlevel(root.left,lists,level+1);
        createlevel(root.right,lists,level+1);
    }

    ArrayList<LinkedList<Node>>createlevel(Node root)
    {
        ArrayList<LinkedList<Node>>lists=new ArrayList<LinkedList<Node>>();
        createlevel(root,lists,0);
        return lists;

    }


    public static void main(String args[])
    {
        CTCI c = new CTCI();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        c.createlevel(root);
    }
}
