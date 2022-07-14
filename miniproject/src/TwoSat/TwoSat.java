package TwoSat;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Algorithm.Algorithm;
import Algorithm.SSC;
import Graph.Graph;
import Graph.Vertex;
	
public class TwoSat {
	
	Graph graph=new Graph();
	Algorithm SCC = new SSC();
	Stack<Stack<Vertex>> SCCStack=new Stack<Stack<Vertex>>();
	
	public static void main(String[] args) {
		TwoSat TS = new TwoSat();
		TS.run();
		System.out.println("\nRun complete! Congrate");
		//	a.setDate(g);
		//	a.explore();
			// set up dc algorithm nao dc su dung
	}
	
	int numberOfClauses=0;
	int numberOfVariables=0;
	private static List<Integer> firstVar
	= new ArrayList<Integer>();
	private static List<Integer> secondVar
	= new ArrayList<Integer>();
	
	public TwoSat(){
		numberOfClauses=2;
		numberOfVariables=2;
		firstVar.add(1);
		firstVar.add(-1);
		secondVar.add(2);
		secondVar.add(-2);
		generateGraph();
	}
	
	public void reset() {
		numberOfClauses=0;
		numberOfVariables=0;
		firstVar.clear();
		secondVar.clear();
		graph=new Graph();
	}
	
	public void generateGraph(){	
		for(int i=1; i<=numberOfVariables;i++){
			graph.addVertex(i);
			graph.addVertex(-i);
		}
		for(int i=0; i<numberOfClauses;i++){	
			
			int x = firstVar.get(i);
			int y = secondVar.get(i);
			
			if (graph.hasEdge(-x,y)==false)
				graph.addEdge(-x, y);
			if (graph.hasEdge(-y,x)==false)
				graph.addEdge(-y, x);
		}
	}
	
	public void run(){
		SCC.setData(graph);
		SCC.explore();
		
		
		//SCCStack=SCC.getSCC();
	}
	
	
	
	
	public Graph getGraph() {
		return graph;
	}
	public int getNumberOfClauses() {
		return numberOfClauses;
	}
	public void setNumberOfClauses(int numberOfClauses) {
		this.numberOfClauses = numberOfClauses;
	}
	public int getNumberOfVariables() {
		return numberOfVariables;
	}
	public void setNumberOfVariables(int numberOfVariables) {
		this.numberOfVariables = numberOfVariables;
	}
	
	
}
