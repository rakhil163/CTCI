import java.util.*;
public class StackOfPlates {

    ArrayList<Stack> ars = new ArrayList<>();
    int stackCapacity  = 2;
    int size[];
    Stack<Integer> getLastStack()
    {
        if(ars.size()==0)
            throw new EmptyStackException();
        return ars.get(ars.size()-1);
    }

    void push(int ele)
    {
        if(ars.isEmpty())
        {
            Stack<Integer> s1 = new Stack<>();
            s1.push(ele);
            ars.add(s1);
        }
        else {
            Stack s = getLastStack();
            if (s.size() < stackCapacity) {
                s.push(ele);

            } else {
                Stack<Integer> st = new Stack<Integer>();
                st.push(ele);
                ars.add(st);
            }
        }
    }
    void print()
    {
        for(int i=0;i<ars.size();i++)
        {
            System.out.println("Inside one stack ");
            for(int j=0;j<ars.get(i).size();j++)
            {
                System.out.println(ars.get(i).get(j));
            }
        }
    }
    public int pop()
    {
        Stack s1= getLastStack();
        if(s1==null)
            throw new EmptyStackException();
        System.out.println(s1.pop());
        int v = (Integer)s1.pop();
        if(s1.size()==0)
        {
            ars.remove(ars.size()-1);
        }
        return v;

    }
    public static void main(String args[])
    {
        StackOfPlates sop = new StackOfPlates();
        sop.push(10);
        sop.push(20);
        sop.push(30);
        sop.push(40);
        sop.push(50);
        sop.push(60);
        System.out.println(sop.pop());
        System.out.println(sop.pop());
        System.out.println(sop.pop());
        //System.out.println(sop.pop());
        //sop.print();
    }
}
