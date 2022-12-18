//package 알고리즘_과제;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//class Graph {
//	Scanner s;
//	int vertex_num;
//	int edge_num;
//	private ArrayList<ArrayList<Integer>> graph;
//
//	Graph(int vertex_num, int edge_num, Scanner s) {
//		this.s = s;
//		this.vertex_num = vertex_num;
//		this.edge_num = edge_num;
//		this.graph = new ArrayList<ArrayList<Integer>>();
//		for (int i = 0; i < vertex_num; i++) {
//			graph.add(new ArrayList<Integer>());
//		}
//	}
//
//	void put(int x, int y) {
//		graph.get(x).add(y);
//		graph.get(y).add(x);
//	}
//
//	void set_edge() {
//		for (int i = 0; i < edge_num; i++) {
//			int x = s.nextInt();
//			int y = s.nextInt();
//			put(x, y);
//		}
//	}
//
//	void print() {
//		for (int i = 1; i < vertex_num; i++) {
//			Collections.sort(graph.get(i));
//			for (int j = 0; j < graph.get(i).size(); j++) {
//				System.out.print(graph.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
//	}
//
//	void run() {
//		set_edge();
//		print();
//	}
//}
//
//public class Problem8 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int vertex = sc.nextInt();
//		vertex += 1;
//		int edge = sc.nextInt();
//		Graph g = new Graph(vertex, edge, sc);
//		g.run();
//	}
//}