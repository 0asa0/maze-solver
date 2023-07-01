# maze-solver

A maze can be represented as a graph, if each juncture (intersection) in the maze is
considered to be a vertex, and edges are added to the graph between adjacent
junctures that are not blocked by a wall.

In this project, expected to solve a given maze in four different ways, by
first converting the maze into a graph, and then applying the following standard graph
algorithms.

1. Depth-First-Search
 /* public QueueInterface<T> getDepthFirstSearch(T origin, T end)
 * return depth-first search traversal order between origin vertex and end vertex


2. Breadth-First-Search
 /* public QueueInterface<T> getBreadthFirstSearch(T origin, T end)
 * return breadth-first search traversal order between origin vertex and end vertex

3. Shortest Path Algorithm
/* public int getShortestPath(T begin, T end, StackInterface<T> path)
* return the shortest path between begin vertex and end vertex

4. Cheapest Path Algorithm
In this part, the maze is reorganized in a way that there are some costs to visit a path
during traversals. The gamer wants to the cheapest cost path at the end of traversal. The
cost of each path is randomly generated between 1 and 4. The edge costs should be
printed in the output of your program. According to these costs, the cheapest path and
the least cost should be printed using your own written getCheapestPath method.
/** Precondition: path is an empty stack (NOT null) */
/* Use EntryPQ instead of Vertex in Priority Queue because multiple entries contain the same
* vertex but different costs - cost of path to vertex is EntryPQ's priority value
* public double getCheapestPath(T begin, T end, StackInterface<T> path)
* return the cost of the cheapest path
*/


