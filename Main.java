import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    // private static Random random = new Random(1234567890);

    private static final int DIRECTED_GRAPH = 1;
    private static final int UNDIRECTED_GRAPH = 2;

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
        System.out.println("\t1. Breadth-first Search");
        System.out.println("\t2. Depth-first Search");
        System.out.println("\t3. Iterative Deepening");
        System.out.println("\t4. A* Search");
        System.out.print("Enter an option (1-4): ");
        int searchOption = scanner.nextInt();

        ArrayList<HashSet<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nNodes; i++) {
            adjList.add(new HashSet<>());
        }

        int remainingEdges = mEdges;
        int curNode = 1;
        while (remainingEdges > 0) {
            for (int j = 1; j < nNodes && remainingEdges > 0; j++) {
                if (curNode == j) {
                    continue;
                }

                if (random.nextBoolean() && !adjList.get(curNode).contains(j)) {
                    remainingEdges -= 1;
                    adjList.get(curNode).add(j);

                    if (graphType == UNDIRECTED_GRAPH) {
                        adjList.get(j).add(curNode);
                    }
                }
            }
            curNode = (curNode + 1 > nNodes) ? 1 : curNode + 1;
        }

        System.out.println("\nThe generated graph:");
        for (int i = 1; i <= nNodes; i++) {
            System.out.print(i + " -> ");
            adjList.get(i).forEach(v -> System.out.print(v + " "));
            System.out.println();
        }
        System.out.println();

        if (searchOption == 1) {
            bfs(adjList, 1, goal);
        } else if (searchOption == 2) {
            dfs(adjList, 1, goal);
        } else if (searchOption == 3) {
            iterativeDeepening();
        } else if (searchOption == 4) {
            aStarSearch();
        }
    }

    public static int getMaxEdges(int graphType, int nNodes) {
        if (graphType == DIRECTED_GRAPH) {
            return nNodes * (nNodes - 1);
        } else {
            return (nNodes * (nNodes - 1)) / 2;
        }
    }

    public static void bfs(ArrayList<HashSet<Integer>> adjList, int root, int goal) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] explored = new boolean[adjList.size()];

        explored[root] = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == goal) {
                System.out.println("Path leading to goal found!");
                return;
            }

            adjList.get(u).forEach((v) -> {
                if (!explored[v]) {
                    explored[v] = true;
                    queue.add(v);
                }
            });
        }

        System.out.println("No path leading to goal!");
    }

    public static void dfs(ArrayList<HashSet<Integer>> adjList, int root, int goal) {
        Stack<Integer> stack = new Stack<>();
        boolean[] explored = new boolean[adjList.size()];

        stack.push(root);

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (!explored[u]) {
                explored[u] = true;

                if (u == goal) {
                    System.out.println("Path leading to goal found!");
                    return;
                }

                adjList.get(u).forEach((v) -> {
                    stack.push(v);
                });
            }
        }

        System.out.println("No path leading to goal!");
    }

    public static void iterativeDeepening() {
    }

    public static void aStarSearch() {
    }
}
