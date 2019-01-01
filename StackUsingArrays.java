package com.company;
import java.util.ArrayList;
import java.util.EmptyStackException;


public class StackUsingArrays {

    private int numberofStacks = 3;
    private int[] size;
    private int[] values;
    private int stackcapacity;

    public StackUsingArrays(int stacksize)
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
        size[stacknum]--;
        values[indexoftop(stacknum)] = 0;
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
        StackUsingArrays s1 =  new StackUsingArrays(5);
        s1.push(1,1);
        s1.push(2,2);
        s1.push(3,3);
        System.out.println(s1.pop(1));
        System.out.println(s1.peek(1));

    }

}
