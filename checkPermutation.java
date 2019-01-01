package com.company;

public class checkPermutation {

    boolean isPermutation(String s1,String s2)
    {
        char[]  schar = s1.toCharArray();
        char[]  s2char = s2.toCharArray();
        java.util.Arrays.sort(schar);
        java.util.Arrays.sort(s2char);
        return java.util.Arrays.equals(schar,s2char);
    }

    boolean perm(String s1,String s2)
    {
        int[] alphaTable = new int[128];
        char[]  schar = s1.toCharArray();
        for(char c:schar)
        {
            alphaTable[c]++;
        }
        char[]  s2char = s2.toCharArray();
        for(char c1:s2char)
        {
            alphaTable[c1]--;
            if(alphaTable[c1]<0)
                return false;
        }
        return true;

    }

    public static void main(String args[])
    {
        checkPermutation chp = new checkPermutation();
        String s1= "";
        String s2="pedal";
        if(s1.length()!=s2.length())
            System.out.println("False");
        //System.out.println(chp.isPermutation(s1,s2));
        System.out.println(chp.perm(s1,s2));
    }

}
