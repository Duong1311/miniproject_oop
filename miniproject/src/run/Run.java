package run;
import Graph.Graph;
import application.GUI;

	

public class Run {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		GUI gui= new GUI();
		gui.setGraph(g);
		gui.run(args);
}
}
	