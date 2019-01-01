package com.company;
import java.util.HashMap;
import java.util.Map;
public class Trie {
    private class TrieNode{
        Map<Character,TrieNode> children;
        boolean endofword;
        public TrieNode()
        {
            children = new HashMap<>();
            endofword = false;
        }
    }
    final TrieNode root;
    private Trie()
    {
        root = new TrieNode();
    }
//    public void insert(String word)
//    {
//        TrieNode current = root;
//        for(int i=0;i<word.length();i++)
//        {
//            char ch = word.charAt(i);
//            TrieNode node=current.children.get(ch);
//            if(node ==null)
//            {
//                node = new TrieNode();
//                node.children.put(ch,node);
//            }
//            current = node;
//        }
//        current.endofword = true;
//    }
//    public boolean search(String word)
//    {
//        TrieNode current = root;
//        for(int i=0;i<word.length();i++)
//        {
//            char ch = word.charAt(i);
//            TrieNode t = current.children.get(ch);
//            if(t == null)
//                return false;
//            current = t;
//        }
//
//        return current.endofword;
//    }
public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        current = node;
    }
    //mark the current nodes endOfWord as true
    current.endofword = true;
}

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        return current.endofword;
    }

//    public boolean del(String word)
//    {
//        return delete(root,word,0);
//    }
//
//    boolean delete(TrieNode current,String word,int index)
//    {
//        if(index == word.length())
//        {
//            if(!current.endofword)
//                return false;
//            current.endofword = false;
//            return current.children.size()==0;
//        }
//        char ch = word.charAt(index);
//        TrieNode node = current.children.get(ch);
//        if(node==null)
//        {
//            return false;
//        }
//        boolean val = delete(current,word,index+1);
//        if(val)
//        {
//            current.children.remove(ch);
//            return current.children.size() == 0;
//        }
//        return false;
//    }
public void delete(String word) {
    delete(root, word, 0);
}

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endofword) {
                return false;
            }
            current.endofword= false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }


    public static void main(String args[])
    {
        Trie t = new Trie();
        t.insert("Abc");
        t.insert("aeroplane");
        t.insert("aerobics");
        t.insert("Rakhil");
        System.out.println(t.search("Rakhil"));
        t.delete("Rakhil");
        System.out.println(t.search("Rakhil"));
    }
}
