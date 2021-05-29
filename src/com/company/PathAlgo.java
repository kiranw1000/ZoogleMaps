package com.company;
import java.util.ArrayList;
import java.util.Collections;
public class PathAlgo {
	private Node[] graph;
	private ArrayList<Node> unvisitedNodes;
	private ArrayList<Node> visitedNodes;
	private boolean doneVisiting;
	private String[] names;
	//must set source node distance to zero and all others to very high number
	//before putting graph into path algo
	public PathAlgo(Node[] graph, String[] names) {
		this.graph = graph;
		unvisitedNodes = new ArrayList<Node>();
		for(Node n : graph) {
			unvisitedNodes.add(n);
		}
		visitedNodes = new ArrayList<Node>();
		doneVisiting = false;
		this.names = names;
	}
	public PathAlgo(Node[] graph) {
		this(graph, null);
	}
	public void visitNodes() {
		while(visitedNodes.size() < graph.length) {
			int shortestDist = 1000000;
			int index = 0;
			for(int i = 0; i < unvisitedNodes.size(); i++) {
				if(unvisitedNodes.get(i).getDistance() < shortestDist) {
					shortestDist = unvisitedNodes.get(i).getDistance();
					index = i;
				}
			}
			Node check = unvisitedNodes.remove(index);
			visitedNodes.add(check);
			for(int[] j : check.getEdges()) {
				if(graph[j[0]].setDistance(check.getDistance() + j[1])) {
					graph[j[0]].setParent(check);
				}
			}
		}
		doneVisiting = true;
	}
	public static ArrayList<Integer> intBackTrack(Node n){
		ArrayList<Integer> path = new ArrayList<Integer>();
		Node currentNode = n;
		path.add(currentNode.getIndex());
		while(currentNode.getParent() != null) {
			currentNode = currentNode.getParent();
			path.add(currentNode.getIndex());
		}
		return path;
	}
	public static ArrayList<Integer> intPathTo(Node n){
		ArrayList<Integer> ret = intBackTrack(n);
		Collections.reverse(ret);
		return ret;
	}
	public static String pathToName(ArrayList<Integer> path, String[] names) {
		String ret = "";
		for(int i : path) {
			ret += names[i] + " -> ";
		}
		return ret.substring(0, ret.length() - 4);
	}
	public String pathTo(Node n) {
		if(!doneVisiting) {
			visitNodes();
		}
		if(names != null) {
			return pathToName(intPathTo(n), names);
		}else {
			return intPathTo(n).toString();
		}
	}
	public String pathTo(int index) {
		return pathTo(graph[index]);
	}
	//convert from edges to graph?
	
}
