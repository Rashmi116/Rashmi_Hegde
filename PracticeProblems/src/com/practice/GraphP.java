package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphP {
	static class Edge{
		int src;
		int dest;
		int weight;
		public Edge(int s,int d,int w){
			this.src=s;
			this.dest=d;
			this.weight=w;
		}
	}
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<Edge>();
			
		}
		graph[0].add(new Edge(0,2,1));
		graph[0].add(new Edge(0,2,2));
		graph[1].add(new Edge(1,2,3));
		
	}
	public static void bfs(ArrayList<Edge> graph[],int V) {
		Queue<Integer> q=new LinkedList<>();
		boolean[] visited=new boolean[V];
		q.add(0);
		while(!q.isEmpty()) {
			int curr=q.remove();
			if(visited[curr]==false) {
				System.out.println(curr);
				visited[curr]=true;
				for(int i=0;i<graph[1].size();i++) {
					Edge e=graph[1].get(i);
					q.add(e.dest);
				}
			}
		}
	}
	public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] visited) {
		
				System.out.println(curr);
				visited[curr]=true;
				for(int i=0;i<graph[curr].size();i++) {
					Edge e=graph[1].get(i);
					if(visited[e.dest]!=true) {
					dfs(graph,e.dest,visited);
					}
				}
			}
		
	

	public static void main(String[] args) {
		int V=4;
		ArrayList<Edge> graph[]=new ArrayList[V];
		boolean[] visited=new boolean[V];
		createGraph(graph);
		bfs(graph,V);
		dfs(graph,0,visited);
		/*for(int i=0;i<graph[1].size();i++) {
			Edge e=graph[1].get(i);
			System.out.println(e.dest+" "+e.weight);
		}*/
		System.out.println();
	}

}
