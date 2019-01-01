package com.company;

import java.util.HashSet;

public class RotateString {
    HashSet<String> hs = new HashSet<>();
    void rotateString(String str)
    {

    }

    public static void main(String args[])
    {
        String str = "waterbottle";
        String str2= str+str;
       // System.out.println(str2);
        String tobefound = "bottlewater";
        if(str2.contains(tobefound))
            System.out.println("true");
        else
            System.out.println("false");


    }

}
