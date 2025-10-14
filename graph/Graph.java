package graph;

import java.util.*;

public abstract class Graph {
    protected int n; // number of vertices
    protected int[][] adj; // adjacency matrix

    public Graph(int n) {
        this.n = n;
        this.adj = new int[n][n];
    }

    // Read graph data from user
    public abstract void getGraph(Scanner sc);

    // Display adjacency matrix
    public void display() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check connectivity using BFS treating nonzero entries as edges.
    public boolean isConnected() {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (adj[u][v] != 0 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    count++;
                }
                // For undirected-like adjacency matrix, also check reverse edge
                if (adj[v][u] != 0 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    count++;
                }
            }
        }
        return count == n;
    }
}
