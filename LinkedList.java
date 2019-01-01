package com.company;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Stack;
import java.util.Deque;
import java.lang.*;
public class LinkedList {

    Node head,left;
    static int i=0;
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next= null;
        }
    }
    void printList()
    {
        Node n = head;
        while(n!=null)
        {
            System.out.println(n.data);
            n = n.next;
        }
    }
    void removeDuplicates()
    {
        HashSet<Integer> h = new HashSet<Integer>();
        Node n = head;

        Node prev = null;
        while(n!=null)
        {
            if(h.contains(n.data))
            {
                prev.next = n.next;
            }
            else
                h.add(n.data);
            prev=n;
            n= n.next;
        }
    }

    /*void removeDuplicatesWithoutHS()
    {
        Node n = head;
        Node prev = null;
        Node compare;
        while(n.next!=null)
        {
            prev=n;
            compare=n.next;
            while(compare!=null)
            {
                if(n.data==compare.data){
                    if(compare.next == null)
                        prev.next = null;
                    else
                        prev.next = compare.next;
                }

                    prev =  compare;
                    compare = compare.next;

            }

            n =  n.next;

        }
    }*/
    void removeDuplicatesWithoutHS()
    {
        Node current = head;
        while(current!=null)
        {
            Node runner = current;
            while(runner.next!=null)
            {
                if(runner.next.data==current.data)
                    runner.next = runner.next.next;
                else
                    runner=runner.next;
            }
            current = current.next;
        }

    }
    public void returnktolast(int k)
    {
        int count =0;
        Node current = head;
        while(current!=null)
        {
            count++;
            current=current.next;
        }
        System.out.println("count"+count);
        int i = count - k;
        int j=1;
        current = head;
        if(i<0)
        {
            System.out.println("out of Bounds");
            return;
        }
        while(j<i && i>0)
        {
            current=current.next;
            j++;
        }
        System.out.println(current.data);

    }
    public static int returnktolastrecursion(Node head,int k)
    {

        if (head == null)
            return 0;
       int index = returnktolastrecursion(head.next,k)+1;
       if(index ==  k)
           System.out.println(head.data);
       return index;

    }
    public void returnKtoLastStack(int k)
    {
        Stack<Integer> s = new Stack<Integer>();
        Node current = head;
        while(current!=null)
        {
            s.push(current.data);
            current = current.next;
        }
        int i=0;
        while(i<k)
        {
            s.pop();
            i++;
        }
        System.out.println(s.peek());
    }
    public void returnntolast(int k)
    {
        Node p1 = head,p2= head;
        int i=0;
        while(i<k)
        {
            p2=p2.next;
            i++;
        }
        while(p2!=null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p1.data);
    }
    public void deleteMiddleNode()
    {
//        Node p1=head,p2=head,prev=null;
//        while((p2.next!=null) && (p2!=null))
//        {
//            prev=p1;
//            p2=p2.next.next;
//            p1=p1.next;
//        }
//        prev.next = p1.next;

        Node p1 = head,p2=head,prev=null;
        //if (head != null)
        //{
            while ((p2 != null) && (p2.next != null))
            {
                prev = p1;
                p2 = p2.next.next;
                p1 = p1.next;
            }
//            System.out.println("The middle element is [" +
//                    p1.data + "] \n");
            prev.next=p1.next;
        //}

    }
    Boolean checkPalindrome()
    {
        Deque d= new ArrayDeque();
        Node current = head;

        while(current != null)
        {
            d.add(current.data);
            current=current.next;

        }

        while(d.size()>1)
        {
            if(d.getFirst() != d.getLast())
                return false;

            d.removeFirst();
            d.removeLast();
        }
        return true;
    }
    public boolean checkPalindromeRecursion()
    {
        left = head;
        return checkP(head);
    }
    public boolean checkP(Node right)
    {
        if(right == null)
            return true;
        boolean x = checkP(right.next);
        if(!x)
            return false;
        boolean y = (left.data == right.data);
        left = left.next;
        return y;
    }
    public void partition(int part) {
        Node curr = head;
        Node onestart = null;
        Node oneend = null;
        Node twostart = null;
        Node twoend = null;
        while (curr != null) {
            if (curr.data < part) {
                if (onestart == null) {
                    onestart = new Node(curr.data);
                    oneend = onestart;
                    oneend.next = null;
                } else {
                    oneend.next = new Node(curr.data);
                    oneend = oneend.next;
                }
            } else {
                if (twostart == null) {
                    twostart = new Node(curr.data);
                    twoend = twostart;
                    twoend.next = null;
                } else {
                    twoend.next = new Node(curr.data);
                    twoend = twoend.next;
                }
            }
            curr = curr.next;

        }
        oneend.next = twostart;
        curr = onestart;
        while(curr!=null)
        {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public int loopDetection()
    {
        Node slowptr = head,fastptr =head;
        while((fastptr!=null)&&(fastptr.next!=null))
        {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(fastptr == slowptr)
                break;
        }
        if(fastptr==null && fastptr.next==null)
        {
            return -1;
        }
        slowptr = head;
        while(fastptr!=slowptr)
        {
            slowptr = slowptr.next;
            fastptr =  fastptr.next;
        }
        return fastptr.data;
    }
    public void intersection(Node head,Node head1)
    {
        HashSet<Node> h = new HashSet<Node>();
        Node current = head;
        while(current!=null)
        {
            h.add(current);
            current = current.next;
        }
        current = head1;
        while(current!=null)
        {
            if(h.contains(current))
            {
                System.out.println("Intersection Detected. Value : "+current.data);
                break;
            }
            current = current.next;
        }
    }
    public void intersection2(Node head,Node head1)
    {
        Node current = head;
        int count=0,count2=0;
        while(current!=null)
        {
            count++;
            current=current.next;
        }
        Node current1 = head1;
        while(current1!=null)
        {
            count2++;
            current1=current1.next;
        }
        int diff = Math.abs(count-count2);
        if(count > count2)
        {
            while(diff>0)
            {
                head=  head.next;
                diff--;
            }
        }
        else
        {
            while(diff>0)
            {
                head1=  head1.next;
                diff--;
            }
        }
        current = head;
        current1=head1;
        while(current1!=null)
        {
            if(current==current1)
            {
                System.out.println(current.data);
                break;
            }
            current = current.next;
            current1 = current1.next;
        }

    }
    public void addLL(Node head,Node head1) {
        Node curr = head, curr1 = head1;
        int sum = 0;
        Stack<Integer> s = new Stack<Integer>();
        int carry = 0;
        while ((curr != null) || (curr1 != null)) {
            sum = (curr != null ? curr.data : 0) + (curr1 != null ? curr1.data : 0) + carry;
            if (sum >= 10) {
                s.push(sum % 10);
                carry = 1;
            } else {
                s.push(sum);
                carry = 0;
            }
                if (curr!=null && curr.next != null)
                    curr = curr.next;
                else
                    curr = null;
                if (curr1!=null && curr1.next != null)
                    curr1 = curr1.next;
                else
                    curr1 = null;
        }
            while (!s.isEmpty()) {
                System.out.println(s.pop());

            }
        }

    public static void main(String args[])
    {
        LinkedList ll = new LinkedList();
        LinkedList ll1 = new LinkedList();
        ll.head = new Node(1);
        Node second = new Node(1);
        Node third = new Node(9);
        Node fourth = new Node(2);

        ll.head.next = second;
        second.next = third;
        third.next=fourth;



        ll1.head = new Node(1);
        Node fifth = new Node(2);
        ll1.head.next = fifth;
        //fourth.next = second;

        //ll1.head = new Node(1);
       // Node fifth = new Node(22);

        //ll1.head.next = fifth;
        //fifth.next = ll.head;
       // ll.removeDuplicates();
        //ll.removeDuplicatesWithoutHS();
        //ll.returnktolast(10);
       // ll.returnKtoLastStack(4);

        //ll.returnktolastrecursion(ll.head,2);
        //ll.returnntolast(4);
       // ll.deleteMiddleNode();
       // System.out.println(ll.checkPalindromeRecursion());
        //System.out.println(ll.checkPalindrome());
       ll.printList();

       ll1.printList();
        //ll.partition(5);
        ll.addLL(ll.head,ll1.head);
        //System.out.println(ll.loopDetection());
        //ll.intersection(ll.head,ll1.head);
     //   ll.intersection2(ll.head,ll1.head);
    }
}
