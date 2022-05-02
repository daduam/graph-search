import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome!");

        System.out.print("Enter the number of elements in the search space: ");
        int nNodes = scanner.nextInt();

        System.out.println("Choose a graph type:");
        System.out.println("\t1. Directed graph");
        System.out.println("\t2. Undirected graph");
        System.out.print("Enter an option: ");
        int graphType = scanner.nextInt();
        int maxEdges = getMaxEdges(graphType, nNodes);

        System.out.print("Enter the number of edges in the graph (1 - " + maxEdges + "): ");
        int mEdges = scanner.nextInt();

        System.out.print("Enter the node number of search goal (1 - " + nNodes + "): ");
        int goal = scanner.nextInt();

        System.out.println("Choose the graph search algorithm to use:");
        System.out.println("\t1. Breath-first Search");
        System.out.println("\t2. Depth-first Search");
        System.out.println("\t3. Iterative Deepening");
        System.out.println("\t4. A* Search");
        System.out.print("Enter an option (1-4): ");
        int searchOption = scanner.nextInt();

        // Generate random graph with n_nodes and m_edges

        if (searchOption == 1) {
            bfs();
        } else if (searchOption == 2) {
            dfs();
        } else if (searchOption == 3) {
            iterativeDeepening();
        } else if (searchOption == 4) {
            aStarSearch();
        }
    }

    public static int getMaxEdges(int graphType, int nNodes) {
        if (graphType == 1) {
            return nNodes * (nNodes - 1);
        } else {
            return (nNodes * (nNodes - 1)) / 2;
        }
    }

    public static void bfs() {
    }

    public static void dfs() {
    }

    public static void iterativeDeepening() {
    }

    public static void aStarSearch() {
    }
}
