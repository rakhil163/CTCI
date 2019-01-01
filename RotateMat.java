package com.company;

public class RotateMat {

    public void rotate(int[][] arr)
    {
        int zero[][]= new int[arr.length][arr.length];
        int size = arr.length;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                zero[i][j] = arr[size-j-1][i];
            }
        }
       print(zero);

    }
    public void rotateMatrixInPlace(int[][] arr)
    {
        int n=arr.length;
        for(int layer=0;layer<n/2;layer++)
        {
            int first = layer;
            int last= n-1-layer;
            for(int i=first;i<last;i++)
            {
                int offset = i-first;
                int top = arr[first][i];
                arr[first][i] = arr[last-offset][first];
                arr[last-offset][first] = arr[last][last-offset];
                arr[last][last-offset] = arr[i][last];
                arr[i][last] = top;
            }
        }
        print(arr);

    }
    void print(int arr[][])
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        RotateMat r = new RotateMat();
        int ar[][]={{00,01,02,03},{10,11,12,13},{20,21,22,23},{30,31,32,33}};
        r.print(ar);
        System.out.println();
        r.rotate(ar);
        System.out.println();
        r.rotateMatrixInPlace(ar);
    }
}
