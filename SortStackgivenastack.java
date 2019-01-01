package com.company;
import java.util.Stack;
public class SortStack {
    public void sortmystack(Stack<Integer>s)
    {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty())
        {
            int temp = s.pop();
            while(!r.isEmpty()&&r.peek()>temp)
            {
                s.push(r.pop());
            }
            r.push(temp);
        }
        while(!r.isEmpty())
            s.push(r.pop());
        //System.out.println(s.peek());

    }

    void printStack(Stack<Integer> s)
    {
        for(Integer i:s)
        {
            System.out.println(i);
        }

    }

    public static void main(String args[])
    {
        Stack<Integer> s = new Stack<Integer>();
        SortStack ss = new SortStack();
        s.push(10);
        s.push(40);
        s.push(4);
        s.push(30);
        s.push(100);
        ss.sortmystack(s);
        ss.printStack(s);
    }
}
