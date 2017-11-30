import java.util.Stack;

/**
 * An implementation of the Graph interface. Help received from reader and
 * geeksforgeeks.org/topological-sorting/
 * 
 * @author jovanikimble
 */
public class GraphAdjMatrix implements Graph {
	boolean[][] matrix;

	public GraphAdjMatrix(int size) {
		this.matrix = new boolean[size][size];
	}

	@Override
	public void addEdge(int v1, int v2) {
		this.matrix[v1][v2] = true;
	}

	/**
	 * Private helper method for topologicalSort() that recursively runs the
	 * algorithm on any vertex not yet visited
	 * 
	 * @param v
	 *            current vertex
	 * @param visited
	 *            visited array
	 * @param stack
	 *            stack
	 */
	private void topologicalSort(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		int[] neighbors = neighbors(v);
		for (int i = 0; i < neighbors.length; i++) {
			if (!visited[neighbors[i]]) {
				topologicalSort(neighbors[i], visited, stack);
			}
		}

		stack.push(v);
	}

	@Override
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[this.matrix.length];

		// initializing everything in visited array to false
		for (boolean b : visited) {
			b = false;
		}

		// Runs sort on every vertex not yet visited.
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				topologicalSort(i, visited, stack);
			}
		}

		// Prints the contents of the stack
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Graph#neighbors(int)
	 */
	@Override
	public int[] neighbors(int vertex) {
		int count = 0;

		// Get exact size array needs to be
		for (int i = 0; i < this.matrix.length; i++) {
			if (matrix[vertex][i]) {
				count++;
			}
		}

		// Populate array
		int[] neighbors = new int[count];
		int pos = 0;
		for (int i = 0; i < this.matrix.length; i++) {
			if (matrix[vertex][i]) {
				neighbors[pos] = i;
				pos++;
			}
		}

		return neighbors;
	}
}
