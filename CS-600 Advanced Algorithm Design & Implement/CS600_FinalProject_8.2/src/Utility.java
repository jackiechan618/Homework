/*****************************************************************************
 * Author: Feng Chen
 * Project: 8.2 FordFulkerson
 * 
 * This is Utility Class
 * 
 ******************************************************************************/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Utility {

	public void getMaxFlowBFS(int start, int sink, FordFulkerson f) {
		f.setMaxFlow(0);

		// Set the value to 0
		for (int i = 0; i <= sink; i++) {
			for (int j = 0; j <= sink; j++) {
				f.setFlow(i, j, 0);
			}
		}

		// Check if there is argument path
		System.out.println("The argument path are:");
		while (true) {
			for (int i = 0; i < f.getNumbers(); i++) {
				f.setVisited(i, false);
			}
			f.setParent(start, -1);

			// if there is a argument path from the start to the sink, then break;
			if (BFS(start, sink, f)) {
				Stack<Integer> intStack = new Stack<Integer>();
				for (int i = sink; f.getParent(i) >= start; i = f.getParent(i)) {
					intStack.push(i);
				}
				while (!intStack.empty()) {
					System.out.print(intStack.pop() + "-");
				}
				System.out.println();
				int diff = Integer.MAX_VALUE;
				for (int i = sink; f.getParent(i) >= start; i = f.getParent(i)) {
					if (diff > f.getGraph(f.getParent(i), i)
							- f.getFlow(f.getParent(i), i)) {
						diff = f.getGraph(f.getParent(i), i)
								- f.getFlow(f.getParent(i), i);
					}
				}
				for (int i = sink; f.getParent(i) >= start; i = f.getParent(i)) {
					f.setFlow(f.getParent(i), i, f.getFlow(f.getParent(i), i)
							+ diff);
					f.setFlow(i, f.getParent(i), f.getFlow(f.getParent(i), i)
							- diff);
				}
				f.setMaxFlow(f.getMaxFlow() + diff);

			} else {
				break;
			}
		}
		System.out.println("The MaxFlow is " + f.getMaxFlow() + "\n");
	}

	public boolean BFS(int start, int sink, FordFulkerson f) {
		// Store all the number into a iniQue
		Queue<Integer> iniQue = new LinkedList<Integer>();
		iniQue.add(start);
		f.setVisited(start, true);

		while (!iniQue.isEmpty()) {
			int number = iniQue.poll();
			for (int i = 0; i < f.getNumbers(); i++) {
				boolean v = f.getVisited(i);
				int g = f.getGraph(number, i);
				int f_value = f.getFlow(number, i);
				if (!v && (g - f_value > 0)) {
					iniQue.add(i);
					f.setVisited(i, true);
					f.setParent(i, number);
				}
			}
		}

		return f.getVisited(sink);
	}

	
	/**
	 * Get the value and path by using Depth first search
	 * 
	 * @param start
	 * @param sink
	 */
	public void getMaxFlowDFS(int start, int sink, FordFulkerson f) {
		f.setMaxFlow(0);

		// Set the value to 0
		for (int i = 0; i <= sink; i++) {
			for (int j = 0; j <= sink; j++) {
				f.setFlow(i, j, 0);
			}
		}

		// Check if there is argument path
		System.out.println("The argument path are:");
		while (true) {
			for (int i = 0; i < f.getNumbers(); i++) {
				f.setVisited(i, false);
			}
			f.setParent(start, -1);

			// if there is a argument path from the start to the sink, then break
			DFS(start, sink, f);
			if (f.getVisited(sink)) {
				Stack<Integer> intStack = new Stack<Integer>();
				for (int i = sink; f.getParent(i) >= start; i = f.getParent(i)) {
					intStack.push(i);
				}
				while (!intStack.empty()) {
					System.out.print(intStack.pop() + "-");
				}
				System.out.println();
				int diff = Integer.MAX_VALUE;
				for (int i = sink; f.getParent(i) >= start; i = f.getParent(i)) {
					if (diff > f.getGraph(f.getParent(i), i) - f.getFlow(f.getParent(i), i)) {
						diff = f.getGraph(f.getParent(i), i) - f.getFlow(f.getParent(i), i);
					}
				}
				for (int i = sink; f.getParent(i) >= start; i = f.getParent(i)) {
					f.setFlow(f.getParent(i), i, f.getFlow(f.getParent(i), i) + diff);
					f.setFlow(i, f.getParent(i), f.getFlow(i, f.getParent(i)) - diff);
				}
				f.setMaxFlow(f.getMaxFlow() + diff);

			} else {
				break;
			}
		}
		System.out.println("The MaxFlow is " + f.getMaxFlow() + "\n");
	}

	
	/**
	 * Implemented by DFS algorithm and using recursive method to implement
	 * 
	 * @param start
	 * @param sink
	 */
	private void DFS(int start, int sink, FordFulkerson f) {
		f.setVisited(start, true);
		for (int i = 0; i < f.getNumbers(); i++) {
			boolean v = f.getVisited(i);
			int g = f.getGraph(start, i);
			int f_value = f.getFlow(start, i);

			if (!v && (g - f_value > 0)) {
				f.setParent(i, start);
				f.setVisited(i, true);
				DFS(i, sink, f);
			}
		}
	}
}
