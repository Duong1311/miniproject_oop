package Step.step;

import Graph.Edge;
import Graph.Vertex;

public class TimeLife {
	Vertex v;
	Edge e;
	 public TimeLife(Vertex v) {
		 this.setVertex(v);
	 }
	 public TimeLife(Edge e) {
		 this.setEdge(e);
	 }
	public Vertex getVertex() {
		return v;
	}
	public void setVertex(Vertex v) {
		this.v = v;
	}
	public Edge getEdge() {
		return e;
	}
	public void setEdge(Edge e) {
		this.e = e;
	}
}
