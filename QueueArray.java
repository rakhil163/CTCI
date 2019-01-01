
package com.company;
        import java.util.ArrayList;
        import java.util.EmptyStackException;


public class QueueArray {

    private int numberofStacks = 3;
    private int[] size;
    private int[] values;
    private int stackcapacity;

    public QueueArray(int stacksize)
    {
        stackcapacity = stacksize;
        size = new int[numberofStacks];
        values = new int[numberofStacks * stackcapacity];

    }

    public void push(int stacknum,int ele)
    {
        if(isFull(stacknum))
            System.out.println("Full");
        size[stacknum]++;
        values[indexoftop(stacknum)] =  ele;
    }

    public int pop(int stacknum)
    {
        if(isEmpty(stacknum))
            throw new EmptyStackException();
        int ele = values[indexoftop(stacknum)];
        values[indexoftop(stacknum)] = 0;
        size[stacknum]--;
        return ele;

    }
    public int peek(int stacknum)
    {
        if(isEmpty(stacknum))
            throw new EmptyStackException();
        return values[indexoftop(stacknum)];
    }
    public boolean isFull(int stacknum)
    {
        if(size[stacknum]==stackcapacity)
            return true;
        return false;
    }
    public int indexoftop(int stacknum)
    {
        int offset = stacknum * stackcapacity;
        int s = size[stacknum];
        return offset+s-1;
    }
    public boolean isEmpty(int stacknum)
    {
        if(size[stacknum]==0)
            return true;
        return false;

    }
    public static void main(String args[])
    {
        QueueArray s1 =  new QueueArray(5);
        s1.push(0,1);
        s1.push(1,2);
        s1.push(2,3);
        System.out.println(s1.pop(1));
        System.out.println(s1.pop(2));
        System.out.println(s1.pop(0));

    }

}
