package Algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;
import MyDate.MyDate;
import Step.step.*;


public abstract class Algorithm {
	
	protected Graph graph = new Graph();
	static List<DetailStep>  detailStep = new ArrayList<DetailStep>();
	static List<PseudoStep>  pseudoStep = new ArrayList<PseudoStep>();
	
	List<PseudoStep>  PseudoList = new ArrayList<PseudoStep>();
	static int size=0;
	public int getSize() {
			return size;
		}


	public void setSize(int size) {
			this.size = size;
		}
	
	
	
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

	public List<PseudoStep> getPseudoList() {
		return PseudoList;
	}

	



	
}
