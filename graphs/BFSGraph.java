import java.util.*;

public class BFSGraph 
{
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    public BFSGraph(int vertices) 
    {
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= vertices; i++) 
        {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int src, int dest) 
    {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void BFS(int startVert) 
    {
        boolean[] visited = new boolean[vertices + 1];

        Queue<Integer> que = new LinkedList<>();
        visited[startVert] = true;
        que.offer(startVert);

        while (!que.isEmpty()) 
        {
            int currVert = que.poll();
            System.out.print(currVert + " ");

            for (int adjVertex : adjList.get(currVert)) 
            {
                if (!visited[adjVertex]) 
                {
                    visited[adjVertex] = true;
                    que.offer(adjVertex);
                }
            }
        }
        System.out.println();
    }

    public void displayGraph() 
    {
        System.out.println("Adj List is: ");
        for (int i = 1; i <= vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++) 
            {
                System.out.print(adjList.get(i).get(j));
                if (j < adjList.get(i).size() - 1) 
                {
                    System.out.print(" , ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        BFSGraph graph = new BFSGraph(n);

        System.out.print("Enter number of edges: ");
        int edgeCount = sc.nextInt();
        System.out.println("Make the edges, SRC, DEST: ");

        for (int i = 0; i < edgeCount; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph.addEdge(v1, v2);
        }

        graph.displayGraph();

        System.out.print("Enter the SRV Vertex: ");
        int startVert = sc.nextInt();
        graph.BFS(startVert);

        sc.close();
    }
}
