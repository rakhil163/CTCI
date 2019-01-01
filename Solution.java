package com.company;
import java.util.*;
public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ll= new ArrayList();

        int consecutiveCount=1;
        int j;
        for(int i=0;i<S.length();)
        {
            List<Integer> l= new ArrayList();
            j=i+1;
            while((j<S.length())&&(S.charAt(i)==S.charAt(j)))
            {
                consecutiveCount++;
                j++;
            }
            if(consecutiveCount >=3)
            {
                l.add(i);
                l.add(j-1);
                ll.add(l);
            }
            i=j;
            consecutiveCount = 1;
        }
        return ll;
    }

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        s.largeGroupPositions("aaabbb");

    }
    }


