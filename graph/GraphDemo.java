package graph;

import java.util.Scanner;

public class GraphDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Graph Operations Demo");
        while (true) {
            System.out.println("Choose: 1) Directed Graph 2) Weighted Graph 0) Exit");
            int choice = sc.nextInt();
            if (choice == 0) break;
            if (choice == 1) {
                System.out.print("Number of vertices: ");
                int n = sc.nextInt();
                DirectedGraph dg = new DirectedGraph(n);
                dg.getGraph(sc);
                dg.display();
                System.out.println("Is strongly connected? " + dg.isConnected());
                dg.displayDegrees();
            } else if (choice == 2) {
                System.out.print("Number of vertices: ");
                int n = sc.nextInt();
                WeightedGraph wg = new WeightedGraph(n);
                wg.getGraph(sc);
                wg.displayWeights();
                System.out.println("Is connected? " + wg.isConnected());
                System.out.print("Enter source and destination for shortest path: ");
                int s = sc.nextInt();
                int d = sc.nextInt();
                wg.dijkstra(s, d);
            } else {
                System.out.println("Invalid option");
            }
            System.out.println();
        }
        sc.close();
        System.out.println("Exiting demo.");
    }
}
