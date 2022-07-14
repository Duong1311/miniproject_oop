package Algorithm;


import java.util.Iterator;
import java.util.Stack;

import Graph.Graph;
import Graph.Vertex;


public class SSC extends Algorithm{
	
	Stack<Stack<Vertex>> SCC = new Stack<Stack<Vertex>>();
	Stack<Vertex> DFSStack = new Stack<Vertex>();
    int V = getGraph().getListVertex().size();
    boolean visited[] = new boolean[V];
    boolean TwoSatCheck;
    

	void DFSalg(Graph gr,int id, boolean visited[],Stack<Vertex> DFSStack){		
			
			visited[id] = true;
			Vertex i;
			Iterator<Vertex> it = gr.VertexKe(id).iterator();
			
			while (it.hasNext()) {
				i = it.next();
				if (!visited[gr.findVertexPosition(i)]) {
				DFSalg(gr,gr.findVertexPosition(i), visited, DFSStack);
				}
			}
			DFSStack.add(0,gr.getListVertex().get(id));
	}
    
    void DFSall(Graph gr, boolean visited[],Stack<Vertex> DFSStack){
		int size = gr.getListVertex().size();
		for(int i=0;i<size;i++)
			if(!visited[i])
				DFSalg(gr,i, visited, DFSStack);
	}
    
    
	Graph reverseGraph(Graph g){
		int size  = g.getListEdge().size();
		for(int i=0;i<size;i++){
			
			//System.out.println("Loop " +i);
			int eFrom=g.getListEdge().get(0).getTo().getId();
			int eTo=g.getListEdge().get(0).getFrom().getId();
			g.addEdge(eFrom, eTo);
			g.getListEdge().remove(0);
		}	
		return g;
	}
	
	@Override
	public void explore()
	{	
		boolean visited[] = new boolean[getGraph().getListEdge().size()];
		int SCCStackID=0;	
		
		DFSall(getGraph(),visited,DFSStack);
		setGraph(reverseGraph(getGraph()));
		
		boolean rVisited[] = new boolean[getGraph().getListVertex().size()];
		for(int i =0 ; i< DFSStack.size();i++)
		{
			
			Stack<Vertex> stack = new Stack<Vertex>();
			SCC.add(stack);
			
			if(rVisited[i]==false){
				DFSalg(getGraph(),i,rVisited,SCC.get(SCCStackID));
				System.out.println("Start:"+ i + "\nSCCStackID:"+ SCCStackID );
				}
			
			if(stack.isEmpty())
				SCC.remove(SCCStackID);
			else
			{
				int size = SCC.get(SCCStackID).size();
				for(int j = 0; j <size ; j++)
					System.out.println(graph.findVertex(SCC.get(SCCStackID).get(j).getId()).getId() );
				SCCStackID++;
			}
		}
		checkTwoSat();
		System.out.println( isTwoSatCheck());
	}
	
	
	void checkTwoSat()
	{
		for(int i =0 ; i< SCC.size();i++)
			for(int j = 0; j < SCC.get(i).size();j++)
				for(int k = j+1 ; k <SCC.get(i).size();k++)
					if(SCC.get(i).get(j).getId()==-SCC.get(i).get(k).getId())
						TwoSatCheck= false;
					else TwoSatCheck = true;
	}
	
	public boolean isTwoSatCheck() {
		return TwoSatCheck;
	}

	public void setTwoSatCheck(boolean twoSatCheck) {
		TwoSatCheck = twoSatCheck;
	}
	
	
	
	public Stack<Stack<Vertex>> getSCC() {
		return SCC;
	}

	public void setSCC(Stack<Stack<Vertex>> sCC) {
		SCC = sCC;
	}
	
	
	
	
}
