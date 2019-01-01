package com.company;

import java.util.NoSuchElementException;

public class Queue_CTCI<T> {
    private static class QueueNode<T>{
        T data;
        QueueNode<T> next;
        QueueNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }
    QueueNode<T> first;
    QueueNode<T> last;
    public void add(T data)
    {
        QueueNode<T> t= new QueueNode<T>(data);;
        if(last!=null)
        {
            last.next = t;
        }
        last = t;
        if(first==null)
        {
            first = last;
        }
    }
    public T remove(){
        if(first==null)
        {
            throw new NoSuchElementException();
        }
        T d =first.data;
        first = first.next;
        if(first==null)
            last= null;
        return d;
    }
    public T peek()
    {
        if(first==null)
            throw new NoSuchElementException();
        return first.data;
    }
    public boolean isEmpty(){
        if(first==null)
            return true;
        return false;
    }
    public static void main(Integer args[])
    {
        Queue_CTCI<Integer> qll = new Queue_CTCI();
        qll.add(10);
        qll.add(9);
        System.out.println(qll.peek());
    }
}
