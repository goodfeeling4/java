package graph;

import java.util.Scanner;

public class GraphDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Graph Operations Demo");

        boolean running = true;
        while (running) {
            int choice = getChoice(sc);
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1: {
                    int n = getNumVertices(sc);
                    DirectedGraph dg = new DirectedGraph(n);
                    dg.getGraph(sc);
                    dg.display();
                    System.out.println("Is strongly connected? " + dg.isConnected());
                    dg.displayDegrees();
                    break;
                }
                case 2: {
                    int n = getNumVertices(sc);
                    WeightedGraph wg = new WeightedGraph(n);
                    wg.getGraph(sc);
                    wg.displayWeights();
                    System.out.println("Is connected? " + wg.isConnected());
                    int s = getSource(sc);
                    int d = getDest(sc);
                    wg.dijkstra(s, d);
                    break;
                }
                default:
                    System.out.println("Invalid option");
            }
            System.out.println();
        }

        sc.close();
        System.out.println("Exiting demo.");
    }

    private static int getChoice(Scanner sc) {
        while (true) {
            System.out.println("Choose: 1) Directed Graph 2) Weighted Graph 0) Exit");
            int choice = sc.nextInt();
            if (choice == 0 || choice == 1 || choice == 2) return choice;
            System.out.println("Invalid option");
        }
    }

    private static int getNumVertices(Scanner sc) {
        while (true) {
            System.out.print("Number of vertices: ");
            int n = sc.nextInt();
            if (n > 0) return n;
            System.out.println("Invalid number of vertices");
        }
    }

    private static int getSource(Scanner sc) {
        while (true) {
            System.out.print("Enter source for shortest path: ");
            int s = sc.nextInt();
            if (s >= 0) return s;
            System.out.println("Invalid source");
        }
    }

    private static int getDest(Scanner sc) {
        while (true) {
            System.out.print("Enter destination for shortest path: ");
            int d = sc.nextInt();
            if (d >= 0) return d;
            System.out.println("Invalid destination");
        }
    }
}
