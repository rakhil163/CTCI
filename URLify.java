package com.company;

public class URLify {

    public void convertToURL(char[] str,int l)
    {
        int spaceCount = 0;

        for(int i=0;i<l;i++)
        {
            if(str[i]==' ')
                spaceCount++;
        }

        int index = l+spaceCount*2;

        System.out.println(index);
//        if(l<index)
//            str[l] = '\0';
        for(int j=l-1;j>=0;j--)
        {
            if(str[j]==' ')
            {
                str[index-1]='0';
                str[index-2]='2';
                str[index-3]='%';
                index = index -3;
            }
            else
            {
                str[index-1] = str[j];
                index = index-1;
            }
        }
        System.out.println(str);

    }

    public static void main(String[] args) {
        //wr78ite your code here
        String str="Vaishnavi Ramesh is awesome            ";
        URLify m = new URLify();
        m.convertToURL(str.toCharArray(),27);
    }
}
