package com.company;
import java.util.ArrayList;
import java.util.Arrays;
public class Node {
	private ArrayList<int[]>edges;
	private Node parent;
	private int distance;
	private boolean visited;
	private String name;
	private int index;
	//nodes at forks
	
	//first number of edge index of neighboring node
	//second number is weight to get to node
	public Node(ArrayList<int[]>edges, Node parent, String name, int index) {
		this.edges = edges;
		this.parent = parent;
		distance = 1000000;
		this.visited = false;
		this.name = name;
		this.index = index;
	
	}
	public Node(ArrayList<int[]> edges, String name, int index) {
		this(edges, null, name, index);
	}
	public Node(int index) {
		this(new ArrayList<int[]>(), null, "", index);
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getDistance() {
		return distance;
	}
	public boolean setDistance(int dist) {
		if(dist < distance) {
			//System.out.println(dist);
			distance = dist;
			return true;
		}
		return false;
	}
	public ArrayList<int[]> getEdges(){
		return edges;
	}
	public void addEdge(int[] edge) {
		edges.add(edge);
	}
	public String getName(){
		return name;
	}
	public int getIndex() {
		return index;
	}
	public String toString() {
		String ret = "(";
		for(int[] i : edges) {
			ret = ret + Arrays.toString(i) + ", ";
		}
		ret = ret.substring(0, ret.length()-2);
		ret += ")";
		return ret;
	}
	public void visit() {
		this.visited = true;
	}
	public boolean isVisited() {
		return this.visited;
	}
}
