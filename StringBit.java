package com.company;

public class StringBit {
    boolean isUnique(String str)
    {
        int checker=0;
        for(int i=0;i<str.length(); i++)
        {
            int val=str.charAt(i)-'a';
            if((checker & (1<<val))>0)
            {
                return false;
            }
            checker |=(1<<val);
        }
        return true;
    }
    public static void main(String args[])
    {
        StringBit s=new StringBit();
        System.out.println(s.isUnique("zbzbn" ));

    }
}
