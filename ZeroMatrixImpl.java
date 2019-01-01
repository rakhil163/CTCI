package com.company;
import java.util.HashSet;

public class ZeroMatrixImpl {
    HashSet<Integer> hr = new HashSet<>();
    HashSet<Integer> hc = new HashSet<>();
    void checkforZerores(int[][] ar)
    {
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[0].length;j++)
            {
                if(ar[i][j]==0)
                {
                    hr.add(i);
                    hc.add(j);
                }
            }
        }
    }
    public void insertZeroes(int[][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(hr.contains(i)||hc.contains(j))
                    arr[i][j] = 0;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+"\t");
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int ar[][]={{0,01,02,03},{10,11,12,13},{20,21,22,23},{30,31,32,33}};
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[0].length;j++)
                System.out.print(ar[i][j]+"\t");
            System.out.println();
        }
        System.out.println();
        ZeroMatrixImpl z = new ZeroMatrixImpl();
        z.checkforZerores(ar);
        z.insertZeroes(ar);

    }
}
