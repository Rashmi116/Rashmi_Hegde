package com.wiley.greedy;

import java.util.LinkedList;

public class WeightedGraph {

	static class Edge {
		char source;
		char destination;
		int weight;

		public Edge(char source, char destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	static class Graph {
		int vertices;
		LinkedList<Edge>[] adjacencylist;

		Graph(int vertices) {
			this.vertices = vertices;
			adjacencylist = new LinkedList[vertices];
			// initialize adjacency lists for all the vertices
			for (int i = 0; i < vertices; i++) {
				adjacencylist[i] = new LinkedList<>();
			}
		}

		public void addEgde(char source, char destination, int weight) {
			int sourceIndx=source-'A';
			int destIndx=destination-'A';
			Edge edge = new Edge(source, destination, weight);
			adjacencylist[sourceIndx].addFirst(edge); // for directed graph
		}

		public void printGraph() {
			for (int i = 0; i < vertices; i++) {
				LinkedList<Edge> list = adjacencylist[i];
				for (int j = 0; j < list.size(); j++) {
					System.out.println("vertex-" +list.get(j).source + " is connected to " + list.get(j).destination + " with weight "
							+ list.get(j).weight);
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEgde('A', 'B', 2);
		graph.addEgde('A', 'D', 8);
		graph.addEgde('B', 'E', 6);
		graph.addEgde('B', 'D', 5);
		graph.addEgde('D', 'E', 3);
		graph.addEgde('D', 'F', 2);
		graph.addEgde('E', 'F', 1);
		graph.addEgde('E', 'C', 9);
		graph.addEgde('F', 'C', 3);
		

		graph.printGraph();
	}

}

//In computer science, a problem is said to have optimal substructure , if optimal solution can be constructed from optimal solutions of its sub problems
