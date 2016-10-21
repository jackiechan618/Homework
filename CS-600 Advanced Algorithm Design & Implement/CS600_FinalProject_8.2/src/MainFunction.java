/*****************************************************************************
 * Author: Feng Chen Project: 8.2 FordFulkerson
 * 
 * This is Main Class
 * 
 ******************************************************************************/

public class MainFunction {
	public static void main(String[] args) {
		int number;
		number = 6;
		int[][] graph = new int[number][number];
		graph[0][1] = 16;
		graph[0][2] = 13;
		graph[1][2] = 10;
		graph[2][1] = 4;
		graph[3][2] = 9;
		graph[1][3] = 12;
		graph[2][4] = 14;
		graph[4][3] = 7;
		graph[3][5] = 20;
		graph[4][5] = 4;

		FordFulkerson f = new FordFulkerson(number, graph);

		// method 1: BFS
		System.out.println("BFS method:");
		Utility u = new Utility();
		u.getMaxFlowBFS(0, number - 1, f);

		// method 2: DFS
		System.out.println("DFS method:");
		u.getMaxFlowDFS(0, number - 1, f);
	}

}
