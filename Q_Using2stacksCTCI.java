package com.company;
import java.util.EmptyStackException;
import java.util.Stack;

public class QUTS {
    Stack<Integer> stackOldest,stackNewest;
    public QUTS()
    {
        stackOldest = new Stack<>();
        stackNewest = new Stack<>();
    }
    void push(int ele)
    {
        stackNewest.push(ele);
    }
    void shiftElements()
    {
        while(stackNewest.size()!=0)
        {
            int ele =  stackNewest.pop();
            stackOldest.push(ele);
        }
    }
    int pop()
    {
        if(stackOldest.isEmpty() && stackNewest.isEmpty())
            throw new EmptyStackException();
        if(stackOldest.isEmpty())
            shiftElements();
        return stackOldest.pop();
    }
    int peek()
    {
        if(stackOldest.isEmpty() && stackNewest.isEmpty())
             throw new EmptyStackException();
        if(stackOldest.isEmpty())
            shiftElements();
        return stackOldest.peek();
    }




    public static void main(String args[])
    {
        QUTS q = new QUTS();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }
}
