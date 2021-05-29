package com.company;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		String[] names = {"Kiran Exhibit(Limited Time)", "The Anatomy of Bugs Bunny", "Live Performance of Castaways", "Furry Inflation", "Reproduction Theater"};
		//this array contains a list of edges for each node
		//for example, node 0 has the edges {1, 7} and {2, 3}
		//first index in each edge is the index of the node that the node is connected to
		//second index is the weight of the edge connecting the nodes (for the map, weight will be distance)
		//the algorithm wants to minimize the total weight(distance) to get from one node to another
		//running it with a specific start node will generate the shortest paths to all the other nodes from the start node
		int[][][] uglyGraph = {
				{{1, 7}, {2, 3}},
				{{0, 7}, {2, 1}, {3, 2}, {4, 6}},
				{{0, 3}, {1, 1}, {3, 2}}, 
				{{2, 2}, {1, 2}, {4, 4}},
				{{1, 6}, {3, 4}}
				};
		
		Node[] graph =  new Node[uglyGraph.length];
		for(int i = 0; i < uglyGraph.length; i++) {
			ArrayList<int[]> edges = new ArrayList<int[]>(Arrays.asList(uglyGraph[i]));
			graph[i] = new Node(edges, names[i], i);
		}
		int start = 0;
		graph[start].setDistance(0);
		PathAlgo pathFinder = new PathAlgo(graph, names);
		System.out.println(pathFinder.pathTo(2));
	}
}
