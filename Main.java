package com.company;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		String[] names = {"penis museum", "bdsm in nature", "bestiality", "inflation", "reproduction theater"};
		int[][][] uglyGraph = {
				{{1, 7}, {2, 3}},
				{{0, 7}, {2, 1}, {3, 2}, {4, 6}},
				{{0, 3}, {1, 1}, {3, 2}}, 
				{{2, 2}, {1, 2}, {4, 4}},
				{{1, 6}, {3, 4}}
				};
		//next project is to make the graph...
		//all the edges for each node, need to find way to get nodes when only have list of edges
		//keep track of edges?
		Node[] graph =  new Node[uglyGraph.length];
		for(int i = 0; i < uglyGraph.length; i++) {
			ArrayList<int[]> edges = new ArrayList<int[]>(Arrays.asList(uglyGraph[i]));
			graph[i] = new Node(edges, names[i], i);
		}
		int start = 0;
		graph[start].setDistance(0);
		PathAlgo pathFinder = new PathAlgo(graph, names);
		System.out.println(pathFinder.pathTo(4));
	}
}
