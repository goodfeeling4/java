package graph;

import java.util.*;

public class WeightedGraph extends Graph {
    private int[][] weight; // 0 for no edge, positive for weight
    private static final int INF = Integer.MAX_VALUE / 4;

    public WeightedGraph(int n) {
        super(n);
        this.weight = new int[n][n];
    }

    // read weight matrix; 0 means no edge
    @Override
    public void getGraph(Scanner sc) {
        System.out.println("Enter weight matrix (0 for no edge) row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weight[i][j] = sc.nextInt();
                adj[i][j] = (weight[i][j] != 0 ? 1 : 0);
            }
        }
    }

    // Display weight matrix
    public void displayWeights() {
        System.out.println("Weight Matrix (0 = no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(weight[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Dijkstra from src to dest
    public void dijkstra(int src, int dest) {
        int[] dist = new int[n];
        boolean[] used = new boolean[n];
        int[] prev = new int[n];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[src] = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (u == -1 || dist[j] < dist[u])) u = j;
            }
            if (u == -1 || dist[u] == INF) break;
            used[u] = true;
            for (int v = 0; v < n; v++) {
                if (weight[u][v] != 0) {
                    int w = weight[u][v];
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        prev[v] = u;
                    }
                }
            }
        }

        if (dist[dest] == INF) {
            System.out.println("No path from " + src + " to " + dest);
            return;
        }

        // reconstruct path
        List<Integer> path = new ArrayList<>();
        for (int at = dest; at != -1; at = prev[at]) path.add(at);
        Collections.reverse(path);
        System.out.println("Shortest path from " + src + " to " + dest + ": " + path);
        System.out.println("Minimum distance: " + dist[dest]);
    }

    // connectivity considering edges where weight != 0
    @Override
    public boolean isConnected() {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0); visited[0] = true; int count = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (weight[u][v] != 0 && !visited[v]) {
                    visited[v] = true; q.add(v); count++;
                }
                if (weight[v][u] != 0 && !visited[v]) {
                    visited[v] = true; q.add(v); count++;
                }
            }
        }
        return count == n;
    }
}
