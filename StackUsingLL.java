package com.company;

import java.util.EmptyStackException;

public class StackUsingLL<T> {
    private static class StackNode<T>{
        T data;
        StackNode<T> next;
        StackNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }
    StackNode<T> top;
    public T pop(){
        if (top==null)
            throw new EmptyStackException();
        T ele = top.data;
        top = top.next;
        return ele;
    }
    public T peek()
    {
        if(top==null)
            throw new EmptyStackException();
        return top.data;
    }
    public void push(T data)
    {
        if(top==null)
        {
            StackNode<T> t = new StackNode<T>(data);
            top = t;
        }
        else
        {
            StackNode<T> t = new StackNode<T>(data);
            t.next = top;
            top = t;
        }
    }
    public boolean isEmpty()
    {
        if(top==null)
            return true;
        return false;
    }
    public static void main(String args[])
    {
        StackUsingLL<Integer> s = new StackUsingLL<>();
        s.push(1);
        s.push(2);

        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());

    }

}


