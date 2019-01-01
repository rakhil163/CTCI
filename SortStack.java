package com.company;
import java.util.Stack;
public class SortStack {

    Stack<Integer> s,sorted;
    SortStack()
    {
        s = new Stack<>();
        sorted = new Stack<>();

    }

    void sortStack(int ele)
    {
        int temp = ele;

        while(!sorted.isEmpty())
        {
            if(ele<sorted.peek())
            {
                s.push(sorted.pop());
            }
            else
            {
                sorted.push(ele);
                break;
            }
        }
        while(!s.isEmpty())
        {
            sorted.push(s.pop());
        }
        if(sorted.isEmpty())
        {
            sorted.push(ele);
        }


    }

    void print()
    {
        while(!sorted.isEmpty())
        {
            System.out.println(sorted.pop());
        }
    }









    public static void main(String args[])
    {
        SortStack s = new SortStack();
        s.sortStack(10);
        s.sortStack(20);
        s.sortStack(15);
        s.print();

    }



}
