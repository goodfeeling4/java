package graph;

import java.util.Scanner;

public class DirectedGraph extends Graph {

    public DirectedGraph(int n) {
        super(n);
    }

    @Override
    public void getGraph(Scanner sc) {
        System.out.println("Enter adjacency matrix for directed graph (rows of 0/1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
            }
        }
    }

    public int[] outdegree() {
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) sum += (adj[i][j] != 0 ? 1 : 0);
            out[i] = sum;
        }
        return out;
    }

    public int[] indegree() {
        int[] in = new int[n];
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) sum += (adj[i][j] != 0 ? 1 : 0);
            in[j] = sum;
        }
        return in;
    }

    public void displayDegrees() {
        int[] in = indegree();
        int[] out = outdegree();
        System.out.println("Vertex\tIndegree\tOutdegree");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t" + in[i] + "\t\t" + out[i]);
        }
    }

    // For directed graphs, isConnected could mean strongly connected.
    // We'll implement a simple check for strong connectivity using Kosaraju's algorithm.
    @Override
    public boolean isConnected() {
        // Check reachability from 0 to all
        if (!isAllReachableFrom(0, adj)) return false;
        // Build transpose
        int[][] trans = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) trans[j][i] = adj[i][j];
        // Check reachability in transpose
        return isAllReachableFrom(0, trans);
    }

    private boolean isAllReachableFrom(int src, int[][] matrix) {
        boolean[] visited = new boolean[n];
        java.util.Queue<Integer> q = new java.util.ArrayDeque<>();
        q.add(src); visited[src] = true; int count = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (matrix[u][v] != 0 && !visited[v]) {
                    visited[v] = true; q.add(v); count++;
                }
            }
        }
        return count == n;
    }
}
