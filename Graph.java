import java.io.*;
import java.util.*;

public class Graph
{
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }

    void delEdge(int u, int v)
    {
        for (int i = 0; i < adj[u].size(); i++)
        {
            if (adj[u].get(i) == v)
            {
                adj[u].remove(i);
                break;
            }
        }

        for (int i = 0; i < adj[v].size(); i++)
        {
            if (adj[v].get(i) == u)
            {
                adj[v].remove(i);
                break;
            }
        }
    }

    Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();

            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }

            else if (i != parent)
                return true;
        }
        return false;
    }

    Boolean isCyclic()
    {
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int u = 0; u < V; u++)
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
        return false;
    }

    void getResult(ArrayList<Integer> uArrayList, ArrayList<Integer> vArrayList, Graph g1, int[] resultArray)
    {
        for (int i = 0; i < uArrayList.size(); i++)
        {
            g1.delEdge(uArrayList.get(i), vArrayList.get(i));
            if (!(g1.isCyclic()))
            {
                resultArray[0] = uArrayList.get(i);
                resultArray[1] = vArrayList.get(i);
                break;
            }
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[][] edge = new int[N][2];
        for (int i_edge = 0; i_edge < N; i_edge++)
        {
            String[] arr_edge = br.readLine().split(" ");
            for (int j_edge = 0; j_edge < arr_edge.length; j_edge++)
            {
                edge[i_edge][j_edge] = Integer.parseInt(arr_edge[j_edge]);
            }
        }

        int[] out_ = solve(N, edge);
        System.out.print(out_[0]);
        for (int i_out_ = 1; i_out_ < out_.length; i_out_++)
        {
            System.out.print(" " + out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static int[] solve(int N, int[][] edge)
    {
        // Type your code here
        Graph g1 = new Graph(N + 1);

        String[] stringArray = new String[N];
        int u = 0;
        int v = 0;

        int[] resultArray = new int[2];

        String element = "";
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                u = edge[i][j];
                element = element + u + "";
            }
            stringArray[i] = element;
            element = "";
        }

        Arrays.sort(stringArray);

        ArrayList<Integer> uArrayList = new ArrayList<>();
        ArrayList<Integer> vArrayList = new ArrayList<>();

        for (int i = 0; i < stringArray.length; i++)
        {
            char ch1 = stringArray[i].charAt(0);
            char ch2 = stringArray[i].charAt(1);
            u = Integer.parseInt(ch1 + "");
            v = Integer.parseInt(ch2 + "");
            g1.addEdge(u, v);
            uArrayList.add(u);
            vArrayList.add(v);
        }

        g1.getResult(uArrayList, vArrayList, g1, resultArray);
        return resultArray;
    }

}
