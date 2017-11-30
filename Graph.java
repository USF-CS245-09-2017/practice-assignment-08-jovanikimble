
public interface Graph {

	// Eventually, our graphs will include more functions than this
	// ... but let's start here.
	/**
	 * Adds an edge to the graph going from vertex v1 to vertex v2
	 * 
	 * @param v1
	 *            source vertex
	 * @param v2
	 *            destination vertex
	 */
	public void addEdge(int v1, int v2);

	/**
	 * Runs a topological sort on the graph
	 * 
	 */
	public void topologicalSort();

	/**
	 * Method returns all of the neighbors of the passed in vertex The size of
	 * the returned int array is the exact size. All values are valid
	 * 
	 * @param vertex
	 * @return int array
	 */
	public int[] neighbors(int vertex);

}
