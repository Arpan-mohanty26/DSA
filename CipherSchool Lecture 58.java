
package graphs;
import java.util.*;
class GraphImp
{
HashMap<Integer, HashSet<Integer>> graph = new HashMap<>(); //Structure Created
void addVertex(int data)
if(graph.containsKey(data))
{
//if vertex already present
System.out.println("Error: Vertex "+data+" already exists.");
return;
}
graph.put(data, new HashSet<>()); //Added a vertex
}
void addEdge(int start, int end)
graph.get(start).add(end);
I
void print()
{
System.out.println("Vertices are: " + graph.keySet());
for (Integer x: graph.keySet())
{
System.out.print("Neighbors of "+x+" are: ");
System.out.println(graph.get(x));//Printing the set containing
}
public class GraphSM {
public static void main(String[] args) {
GraphImp g new GraphImp();
g.addVertex(0);
g.addVertex(1);
g.addVertex(2);
g.addVertex(3);
g.addVertex(4);
g.print();
g.addEdge(0, 1);
g.addEdge(0, 1); //we don't want a multiedge
g.addEdge(0, 2);
g.addEdge(0, 3); 
g.addEdge(1, 3);
g.addEdge(2, 4);
g.addEdge(3, 4);
g.print();
}
}
