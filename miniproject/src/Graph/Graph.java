package Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.control.Button;
public class Graph {
	//contructions
	
	private static List<Vertex> listOfVertex
		= new ArrayList<Vertex>();
	private static List<Edge> listOfEdge
	= new ArrayList<Edge>();
	private boolean weighted;
	private boolean directed;
	private static Scanner keyboard = new Scanner(System.in);

	public void addVertex(int id) {
		Vertex v= new Vertex(id,Integer.toString(id));
		listOfVertex.add(v);
	}
	public void addVertex(int id,double x,double y,Button button) {
		Vertex v= new Vertex(id,Integer.toString(id),x,y,button);
		listOfVertex.add(v);
	} 
	 
	public Vertex findVertex(int id)
	{
		for(int i=0;i<listOfVertex.size();i++)
	
			if(listOfVertex.get(i).getId()==id)
			return listOfVertex.get(i);
		
		return null;
	}
	public int findVertexPosition(Vertex v)
	{
		for(int i=0;i<listOfVertex.size();i++)
	
			if(listOfVertex.get(i).getId()==v.getId())
				return i;
		
		return -1;
	}
	
	
	public Vertex getVertex(int id) {
		for(int i=0;i<listOfVertex.size();i++)
			
			if(listOfVertex.get(i).getId()==id)
			return listOfVertex.get(i);
		
		return null;
	}
	public Vertex getVertex(Button button) {
		Vertex v = new Vertex();
		v.setId(-1);
		for(int i=0;i<listOfVertex.size();i++){
			boolean check =listOfVertex.get(i).getButton().getText().equals(button.getText());
			if(check)
				v=listOfVertex.get(i);
			
		}
		return v;
	}
	

	public void addEdge(int a,int b){
		Edge e= new Edge();
		e.setFrom(findVertex(a));
		e.setTo(findVertex(b));
		listOfEdge.add(e);
	}
	public void addEdge(int a,int b,int weight){
		Edge e= new Edge();
		e.setFrom(findVertex(a));
		e.setTo(findVertex(a));
		e.setWeight(weight);
		listOfEdge.add(e);
	}
	
	
	public void addEdge(Vertex a,Vertex b){
		Edge e= new Edge(a,b);
		listOfEdge.add(e);
	}
	public boolean hasEdge(int eFrom,int eTo)
	{
		for(int j =0; j< listOfEdge.size();j++)	
			if(listOfEdge.get(j).getFrom().getId()==eFrom
					&& listOfEdge.get(j).getTo().getId()==eTo)
				return true;
		return false;
	}
	

	public List<Vertex> VertexKe(int id) {
		List<Vertex> l = new ArrayList<Vertex>();
	/*	Edge e= new Edge();
		for(int i =0; i< listOfVertex.size();i++) {
			e.setFrom(A);
			e.setTo(listOfVertex.get(i));
			if(listOfEdge.contains(e)) {
				l.add(listOfVertex.get(i));
			}
		} */
		for(int i=0;i< listOfEdge.size();i++) {
			if(listOfEdge.get(i).getFrom().getId()==id) {
				l.add(listOfEdge.get(i).getTo());
			}
		}
		
		return l;
	}
	
	public void deleteVertex(int id) {
		 //xoa dinh
		 for(int i =0; i< listOfVertex.size();i++)	
			 if(listOfVertex.get(i).getId()==id)
				 listOfVertex.remove(i);
		//xoa canh
		 for(int i =0; i< listOfEdge.size();i++)	
			 if(listOfEdge.get(i).getFrom().getId()==id)
				 listOfVertex.remove(i);
			 else if (listOfEdge.get(i).getTo().getId()==id)
			 	 listOfVertex.remove(i);
			 ;
	
	}
	
	

	public void createGraph(){
		System.out.println("How many Vertext:");
		int vNumber = keyboard.nextInt();
		for(int i =0; i< vNumber;i++)	
			addVertex(i);
		
		System.out.println("How many Edge:");
		int eNumber = keyboard.nextInt();
		
		for(int i =0; i< eNumber;i++)	{
			
		System.out.println("Edge:" + (i+1) );		
		System.out.println("From");
		int eFrom = keyboard.nextInt();
		System.out.println("To");
		int eTo = keyboard.nextInt();
		
			if(hasEdge(eFrom,eTo)==true)
			{
				System.out.println("ERR: Already have this link!");
				i=i-1;
				continue;
			}
	
		addEdge(listOfVertex.get(eFrom).getId(),listOfVertex.get(eTo).getId());
		
		}
			
	}
	public void resetGraph() {
		listOfVertex.clear();
		listOfEdge.clear();
		weighted=false;
		directed=true;
	}
	
	
	
	
	public List<Vertex> getListVertex(){
		return listOfVertex;
	}
	public List<Edge> getListEdge(){
		return listOfEdge;
	}
	
	public boolean isWeighted() {
		return weighted;
	}
	public void setWeighted(boolean weighted) {
		this.weighted = weighted;
	}
	public boolean isDirected() {
		return directed;
	}
	public void setDirected(boolean directed) {
		this.directed = directed;
	}


}