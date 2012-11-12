import java.io.*;
import java.util.*;

/**
 program to find shortest path using Dijkstra's algorithm
 */
public class Main {

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();

		String inputFileName = args[0]; // input file name
  
		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);
		
		//Create a new graph of size corresponding to size specified by input file
		Scanner lineScanner = new Scanner(in.nextLine());
		int graphSize = lineScanner.nextInt();
		Graph graph = new Graph(graphSize);
		
		//For each node in graph
		for(int i=0;i<graphSize;i++){
			lineScanner = new Scanner(in.nextLine());
			
			//loop through adding each to adjList for vertex i
			for(int j=0;j<graphSize;j++){
				int vertexVal = lineScanner.nextInt();
				
				if(vertexVal!=0){
					//Create new list node
					Node newNode = new Node(j,vertexVal);
					
					//Add to adjList
					graph.getVertex(i).getAdjList().add(newNode);
				}
			}
		}
		
		
		lineScanner = new Scanner(in.nextLine());
		
		int startNode = lineScanner.nextInt();
		int endNode = lineScanner.nextInt();
		
		graph.setInitialNode(startNode);
		

		reader.close();
		
		
		//Mark initial node as visited
		graph.getVertex(startNode).visit();
		
		// call backtrack algorithm
		graph.backtrackTry(0,endNode);

		//display results
		graph.printBest();
		
		// end timer and print total time
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
	}

}
