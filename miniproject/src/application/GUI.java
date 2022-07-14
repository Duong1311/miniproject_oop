package application;

import Graph.Graph;

public class GUI {
	Graph graph = new Graph();
	primaryGui pG = new primaryGui();
	Controller controller = new Controller();
	
	
	public void run(String[] args)
	{
		controller.setGraph(graph);
		pG.run(args);
		
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph g) {
		this.graph = g;
	}
	
	
	
}
