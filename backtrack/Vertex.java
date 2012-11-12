/** 
 * @author Craig Cuthbertson
 * @GUID 1002386c
 * @title Alg3 AE1
 * 
 * Class to represent the adjacency list for each vertex in system */

import java.util.LinkedList;

public class Vertex {
	private LinkedList<Node> adjList; //Adjacency list for vertex
	private int number;	//vertex number
	private boolean visited;
	private int predecessor;
	
	public Vertex(int i) {
		this.adjList = new LinkedList<Node>();
		this.number = i;
		visited = false;
	}
	
	/** getters and setters */
	
	public void setVisit(boolean state){
		this.visited = state;
	}
	
	public LinkedList<Node> getAdjList(){
        return adjList;
    }
	
	public int getPredecessor(){
		return this.predecessor;
	}
	
	public void setPredecessor(int predecessor){
		this.predecessor = predecessor;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void visit(){
		visited = true;
	}
	
	public boolean visited(){
		return visited==true;
	}
	
}
