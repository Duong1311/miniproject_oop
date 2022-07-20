package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import Graph.Graph;
import Graph.Vertex;
import Step.step.DetailStep;
import Step.step.PseudoStep;
import Step.step.TimeLife;

public class BipartiteGraphChecker extends Algorithm {
	Scanner keyboard = new Scanner(System.in);
	String str = new String();
	String s2 = new String();
	List<PseudoStep>  BGCPseudoList = new ArrayList<PseudoStep>();
	static int stepID = 0;
	public BipartiteGraphChecker() {
	
		BGCPseudoListAdd(0," For each unvisited vertex u");
    	BGCPseudoListAdd(1," DFS (u)"); 
    	BGCPseudoListAdd(2," For each neighbor v of u"); 
    	BGCPseudoListAdd(3," If v is unvisited, different color"); 
    	BGCPseudoListAdd(4," DFS (v)"); 
    	BGCPseudoListAdd(5," Else if u and v have the same color");
    	BGCPseudoListAdd(6," Not bipartite graph, exit."); 
	}
	void BGCPseudoListAdd(int i, String str) {
		PseudoStep PS = new PseudoStep();
		 PS.setString(str);
		 BGCPseudoList.add(i, PS);
	}
	PseudoStep StepGenerate(int i,String str)
	  {
		PseudoStep PS = new PseudoStep();
		String s = BGCPseudoList.get(i).getString();
		PS.setData(s, stepID++);
		PS.setDetailStep(str);  
		return PS;
	}
	 boolean isBipartite(Graph gr,int id, boolean visited[],int color[]) {
		Vertex i;
		
		Iterator<Vertex> it = gr.VertexKe(id).iterator();// for each neighbor v of u
		while (it.hasNext()) {  
			i = it.next();
			str = " Try " + id + "->" + i.getId();
			pseudoStep.add(StepGenerate(2,str));
		if (!visited[i.getId()]) {//Try egde u->v 
			str = " Give vertex " + i.getId()  +" different color from vertex "+id ;
			pseudoStep.add(StepGenerate(3,str));
			visited[i.getId()]=true;
			color[i.getId()]=	1 - color[id];//give color v different color u
			str = " DFS(" + i.getId() +")";
			pseudoStep.add(StepGenerate(4,str));
			if(!isBipartite(gr,i.getId(), visited, color))   // DFS(v)
				return false;
			}
		else if(color[id]==color[i.getId()]) { //u and v same color
			str = "Vertex " + id + "and vertex "+ i.getId()+"have the same color.";
			pseudoStep.add(StepGenerate(5,str));
			return false;
			}
		//else continue
		}
		
		return true;
	}


	@Override
	public void explore() {
		// TODO Auto-generated method stub
		
		int V = graph.getListVertex().size();
	     boolean visited[] = new boolean[V];
	     int color[]= new int[V+1];
	     Arrays.fill(color,-1);
	     //System.out.println("Input Id Vertex start :");
	     //int b = keyboard.nextInt();
	     str=" Vertex 0 is not visited";
	     pseudoStep.add(StepGenerate(0,str));
	     str=" DFS(0)";
	     pseudoStep.add(StepGenerate(1,str));
	     
	     visited[0]=true;
		 color[0]=0;
	     if(isBipartite(graph,0,visited,color)) {
	    	 //System.out.print("This is a bipartite graph!\n");
	    	 str=" This is a bipartite graph!\n";
		     pseudoStep.add(StepGenerate(6,str));
	     }
	     else {//System.out.print("This is not a bipartite graph!\n");
	    	 str=" This is not a bipartite graph!\n";
		     pseudoStep.add(StepGenerate(7,str));
	     }	
	}


	@Override
	public Stack<Stack<Vertex>> getSCC() {
		// TODO Auto-generated method stub
		return null;
	}

}