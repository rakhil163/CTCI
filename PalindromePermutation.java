package com.company;
import java.util.Map;
import java.util.HashMap;

public class PalindromePermutation {

    public boolean isPermutation(String str)
    {
        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
        int count;
        char[] schar = str.toCharArray();
        for(char c:schar) {
            if(hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            }
            else {
                hm.put(c,1);
            }
        }
//        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
//            Character key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key+" "+value);
//        }
        int length = str.length();
        boolean oneOdd = false;
        if(length%2==0)
            oneOdd = true;
        for(Integer i:hm.values())
        {
            if(i%2!=0)
            {
                if(oneOdd)
                    return false;
                oneOdd = true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // write your code here
        String str = "AABBCCC";
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.isPermutation(str));
    }
}

