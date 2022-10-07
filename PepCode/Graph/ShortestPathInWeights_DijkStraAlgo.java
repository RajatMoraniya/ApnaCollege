package PepCode.Graph;

import java.io.*;
import java.util.*;

public class ShortestPathInWeights_DijkStraAlgo {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;

        Pair(int v , String psf , int wsf){
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        /*
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
*/

        int src = Integer.parseInt(br.readLine());
        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[vtces];
        pq.add(new Pair(src , src+"" ,0 ));

        while(!pq.isEmpty()){
            Pair top = pq.remove();
            if(visited[top.v]==true){
                continue;
            }
            visited[top.v]=true;
            System.out.println(top.v + " via " + top.psf + " @ " + top.wsf);

            for(Edge e : graph[top.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr , top.psf+e.nbr, top.wsf+e.wt));
                }
            }
        }
    }
}
