package Graph;

public class Edge {
	
	
	private Vertex from;
	private Vertex to;
	private String label;
	private int weight;
	
	public Edge( Vertex from,Vertex to) {
		this.setFrom(from);
		this.setTo(to);
	}
	
	public Edge() {
		weight=1;
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
