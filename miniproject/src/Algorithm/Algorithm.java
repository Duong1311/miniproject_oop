package Algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Graph.Graph;
import Graph.Vertex;
import MyDate.MyDate;
import Step.step.*;


public abstract class Algorithm {
	
	protected Graph graph = new Graph();
	protected static List<DetailStep>  detailStep = new ArrayList<DetailStep>();
	protected static List<PseudoStep>  pseudoStep = new ArrayList<PseudoStep>();
	
	public MyDate setDate(MyDate date) {
		// TODO Auto-generated method stub
		date.acceptDate();
		return date;
	}
	public void setData(Graph gr)
	{
		//gr.createGraph();
		setGraph(gr);
	}
	
	
	
	
	public List<PseudoStep> getPseudoStep() {
		return pseudoStep;
	}
	public static void setPseudoStep(List<PseudoStep> pseudoStep) {
		Algorithm.pseudoStep = pseudoStep;
	}
	public abstract void explore();
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	public abstract Stack<Stack<Vertex>> getSCC();
	
	
}
