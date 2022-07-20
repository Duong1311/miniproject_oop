package Graph;

import java.util.ArrayList;
import java.util.List;

import Step.step.DetailStep;
import javafx.scene.shape.Line;

public class Edge {
	
	
	private Vertex from;
	private Vertex to;
	private String label;
	private int weight;
	private Line line= new Line(); 
	List<Integer> state = new ArrayList<Integer>(); 
	
	public List<Integer> getState() {
		return state;
	}
	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public Edge( Vertex from,Vertex to) {
		this.setFrom(from);
		this.setTo(to);
		this.setWeight(1);
		state.add(0,0);
	}
	
	public Edge() {
		weight=1;
		state.add(0,0);
	}
	
	
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Vertex getFrom() {
		return from;
	}
	public void setFrom(Vertex from) {
		this.from = from;
	}
	public Vertex getTo() {
		return to;
	}
	public void setTo(Vertex to) {
		this.to = to;
	}

	 
	
	
}
