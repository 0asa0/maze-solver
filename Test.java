import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import ADTPackage.LinkedQueue;
import ADTPackage.LinkedStack;
import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;
import GraphPackage.DirectedGraph;

public class Test {
	
	
	public static void main(String[] args) throws IOException {
		
		DirectedGraph<String> graph = new DirectedGraph<String>();
		
		int[][] arr = MazeReader.readFile("maze1.txt");
		
		ArrayList <String> vertexarr = new ArrayList<>();
		String vertex; 
		
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				if (arr[i][j] == 0)                               // adding vertex
				{
					vertex = i + "-" + j;
					vertexarr.add(vertex);
					graph.addVertex(vertex);
				}
				//System.out.print(arr[i][j]);
			}
			//System.out.println("");
		}
		
		
		
		int[][] arr2 = arr;
		for (int i = 0; i < arr2.length; i++) 
		{
			for (int j = 0; j < arr2[i].length; j++)
			{
				if ((j+1) < arr2[i].length) {
					
					if (arr2[i][j] == 0 && arr2[i][j + 1] == 0) 
					{
						graph.addEdge(i +"-" +j, i +"-" + (j + 1));
					}
				}
				if ((j-1) >= 0) {
					
					if (arr2[i][j] == 0 && arr2[i][j - 1] == 0) 
					{
						graph.addEdge(i +"-" +j, i + "-" + (j - 1));          // Adding edges
					}
				}
				if ((i+1) < arr2.length) {
					
					if (arr2[i][j] == 0 && arr2[i + 1][j] == 0) 
					{
						graph.addEdge(i +"-" +j, (i + 1) + "-" + j);
					}
				}
				if ((i-1) >= 0) {
					
					if (arr2[i][j] == 0 && arr2[i - 1][j] == 0) 
					{
						graph.addEdge(i +"-" +j, (i - 1) + "-" + j);
					}
				}
				if (arr2[i][j] == 0) {
					arr2[i][j] = 2;
				}
			}
		}
		
		System.out.println("");
		String[][] adjmat = new String[vertexarr.size() + 1][vertexarr.size() + 1];
		adjmat[0][0] = "0";
		for (int i = 0; i < vertexarr.size() ; i++) 
		{
			adjmat[0][i+1] = vertexarr.get(i);
			adjmat[i+1][0] = vertexarr.get(i);
		}
		for (int i = 0; i < adjmat.length; i++) 
		{
			for (int j = 0; j < adjmat[i].length ; j++) 
			{
				if (i+1 <= vertexarr.size() && j+1 <= vertexarr.size()) {                      //adjacency matrix 
					if (graph.hasEdge(vertexarr.get(i), vertexarr.get(j))) {
						adjmat[i+1][j+1]= "T";  
					}
					else {
						adjmat[i+1][j+1] = ".";
					}
				}
				System.out.print(adjmat[i][j]);
			}
			System.out.println("");
		}
		
		
		StackInterface<String> path = new LinkedStack<>();
		StackInterface<String> path2 = new LinkedStack<>();
		QueueInterface<String> bfs = new LinkedQueue<>();
		QueueInterface<String> dfs = new LinkedQueue<>();
		int shortest;
		double cheapest;
		System.out.println("");
		System.out.println("Number of edges found: " + graph.getNumberOfEdges());
		System.out.println();
		bfs = graph.getBreadthFirstSearch("0-1", vertexarr.get(vertexarr.size()-1));
		dfs = graph.getDepthFirstSearch("0-1", vertexarr.get(vertexarr.size()-1));
		shortest = graph.getShortestPath("0-1", vertexarr.get(vertexarr.size()-1) , path);
		cheapest = graph.getCheapestPath("0-1", vertexarr.get(vertexarr.size()-1) , path2);
		
		
	}
}
