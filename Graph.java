package com.company;
import java.util.*;

public class Graph {
    private int v;
    LinkedList<Integer> adj[];

    Graph(int v)
    {
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    void printNodes()
    {
        int u=0;

        while(u<adj.length)
        {
            for (int i = 0; i < adj[u].size(); i++)
                System.out.println(adj[u].get(i));
            System.out.println("**");
            u++;
        }

    }

    public boolean findThroughBFS(int u,int w)
    {
        Queue<Integer> q= new LinkedList();
        boolean visited[] = new boolean[v];
        visited[u] = true;
        q.add(u);
        while(!q.isEmpty())
        {
            int temp = q.poll();
            Iterator<Integer> i = adj[temp].listIterator();
            while(i.hasNext())
            {
                int n= i.next();
                if(n==w)
                    return true;
                //bfs code
                if(!visited[n])
                {
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
        return false;

    }
    void dfs(int u,int w,boolean[] visited)
    {

        visited[u]=true;
        Iterator<Integer> it = adj[u].listIterator();
        while(it.hasNext())
        {
            int n = it.next();
            if(!visited[n])
            {
                dfs(n,w,visited);
            }
        }


    }
    boolean findThroughDFS(int u,int w)
    {
        boolean[] visited =  new boolean[v];
        dfs(u,w,visited);
        return visited[w];
    }
    public static void main(String args[])
    {
        Graph g= new Graph(4);
        g.addEdge(0,1);
        //g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);


        int u = 3,v=3;
        g.printNodes();

//        System.out.println(g.findThroughBFS(u,v));
        System.out.println(g.findThroughDFS(u,v));



    }
}
