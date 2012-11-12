import java.util.LinkedList;

/**
 * @author Craig Cuthbertson
 * @GUID 1002386c
 * @title ALG3 AE1
 * 
 * Class to represent the graph, containing the adjacency lists for all nodes in system.
 * Class also contains methods for backtrack algorithm
 *
 */
public class Graph {
	private Vertex[] vertex;
	private int size;	//size of graph (ie number of vertices)
	
	private LinkedList<Integer> currentPath;
	private LinkedList<Integer> bestPath;
	
	private int currentWeight;
	private int bestWeight;
	
	public Graph(int size) {
		vertex = new Vertex[size];
		this.size = size;
		
		//Create vertexes
		for(int i=0;i<size;i++){
			vertex[i] = new Vertex(i);
		}
		
		currentPath = new LinkedList<Integer>();
		bestPath = new LinkedList<Integer>();
		bestWeight = Integer.MAX_VALUE;
		currentWeight = 0;
	}
	
	public void setInitialNode(int startNode){
		currentPath.addFirst(startNode);
	}
	
	public void printBest(){
		System.out.println("The shortest distance from " + bestPath.getFirst() + " to " + bestPath.getLast() + " is " + bestWeight);
		for(int i=0;i<bestPath.size();i++){
			System.out.print(bestPath.get(i) + " ");
		}
	}

	public Vertex getVertex(int i) {
		return vertex[i];
	}

	public void setVertex(int i) {
		this.vertex[i] = new Vertex(i);
	}
	
	public LinkedList<Integer> getCurrentPath(){
		return currentPath;
	}
	
	public LinkedList<Integer> getBestPath(){
		return bestPath;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/** Find path */
	public void backtrackTry(int currentVertex,int endNode){
		
		//for each vertex adjacent to last item in currentPath
		for(int i=0;i<vertex[currentPath.get(currentVertex)].getAdjList().size();i++){
			Node currentNode = vertex[currentPath.get(currentVertex)].getAdjList().get(i);
			
			
			//for every unvisited node
			if(vertex[currentNode.getNumber()].visited()==false){
				//add node to currentPath
				currentPath.add(currentNode.getNumber());
				currentWeight += currentNode.getWeight();
				
				//mark node as visited
				vertex[currentNode.getNumber()].visit();
				
				//if distance of current is less than distance of best
				if(currentWeight<bestWeight){
					
					//If node is destination
					if(currentNode.getNumber()==endNode){
						//clear bestPath
						bestPath.clear();
						
						//copy currentPath into bestPath
						for(int j=0;j<currentPath.size();j++){
							bestPath.add(currentPath.get(j));
						}
						//update weight
						bestWeight = currentWeight;
					} else {
						//call next item
						backtrackTry(currentVertex+1,endNode);
					}
					
				}
				
				//Remove last item from current path
				currentPath.removeLast();
				//Set v as unvisited
				vertex[currentNode.getNumber()].setVisit(false);
				//Remove weight
				currentWeight -= currentNode.getWeight();
			}
		}
	}
	
}
