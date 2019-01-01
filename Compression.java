package com.company;

public class Compression {

    public void compress(char[] c)
    {
        String str= new String();
        int j,count=1;
        for(int i=0;i<c.length;)
        {
            str = str + c[i];

            j=i+1;

            while ((j<c.length)&&(c[j] == c[i])){
                    count++;
                    j++;
                }

            str = str + count;
            count = 1;
            i = j;
        }
        System.out.println(str);
    }


    public static void main(String args[])
    {
        Compression comp = new Compression();
        String str="aaacc";
        comp.compress(str.toCharArray());
    }
}
