/** 
 * @author Craig Cuthbertson
 * @GUID 1002386c
 * @title ALG3 AE1
 * 
 * Class to represent the vertexes each node is connected to in the system, along with the weight of connection 
 * a weight of 0 indicates the abscence of a connection.
 *
 */

public class Node {
	private int number;
	private int weight;
	
	public Node(int number, int weight) {
		this.number = number;
		this.weight = weight;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
