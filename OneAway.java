package com.company;

public class OneAway {

    boolean checkInsertDelete(char[] str1,char[] str2)
    {
        int i=0,j=0;
        boolean morethanoneinsert = false;
        while((i<str1.length)&&(j<str2.length))
        {
            if(str1[i]!=str2[j])
            {
                i++;
                if(morethanoneinsert)
                    return false;
                morethanoneinsert = true;
            }
            else
            {
                i++;
                j++;
            }
        }
        return true;
    }

    boolean checkReplace(char[] str1,char[] str2)
    {
        int i=0;
        boolean morethanreplace = false;
        while(i<str1.length)
        {
            if(str1[i]!=str2[i])
            {
                if(morethanreplace)
                    return false;
                morethanreplace = true;
            }
            i++;
        }
        return true;
    }
    public static void main(String args[])
    {
        OneAway o = new OneAway();
        String str = "Hello";
        String str2 = "Pello";
        if(Math.abs(str.length()-str2.length())==1)
        {
            if(str.length()>str2.length())
                System.out.println(o.checkInsertDelete(str.toCharArray(),str2.toCharArray()));
            else
                System.out.println(o.checkInsertDelete(str2.toCharArray(),str.toCharArray()));
        }
        else if(str.length()==str2.length())
            System.out.println(o.checkReplace(str.toCharArray(),str2.toCharArray()));
        else
            System.out.println("False");


    }
}
