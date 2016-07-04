/*****************************************************************************
 * Author: Feng Chen
 * 
 * @param graph
 * @param numbers
 * 
 * This is FordFulkerson Class:
 * Using the parameter graph and number to construct the Class FordFulkerson
 * 
 ******************************************************************************/

public class FordFulkerson {
	private int parent[];
	private boolean visited[];
	private int graph[][];
	private int flow[][];
	private int number;
	private int maxFlow;

	public FordFulkerson(int number, int[][] graph) {
		this.graph = graph;
		this.number = number;
		this.flow = new int[number][number];
		this.parent = new int[number];
		this.visited = new boolean[number];
	}

	public void setMaxFlow(int i) {
		this.maxFlow = i;
	}

	public void setFlow(int i, int j, int k) {
		this.flow[i][j] = k;
	}

	public int getNumbers() {

		return this.number;
	}

	public void setVisited(int i, boolean b) {
		this.visited[i] = b;
	}

	public void setParent(int start, int i) {
		this.parent[start] = i;

	}

	public boolean getVisited(int i) {
		return this.visited[i];
	}

	public int getGraph(int number, int i) {
		return this.graph[number][i];
	}

	public int getFlow(int number, int i) {
		return this.flow[number][i];
	}

	public int getParent(int i) {
		return this.parent[i];
	}

	public int getMaxFlow() {
		return this.maxFlow;
	}
}
