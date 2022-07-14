package Algorithm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import Graph.Graph;
import Graph.Vertex;
import Step.step.PseudoStep;



public class TopoSortDFS extends Algorithm  {
	  Stack<Vertex> stack = new Stack<Vertex>();
	  int V = getGraph().getListVertex().size();
	  String str = new String();
	  boolean visited[] = new boolean[V];
	  
	  List<PseudoStep>  TSDPseudoList = new ArrayList<PseudoStep>();
	  static int stepID = 0;
	  public TopoSortDFS(){
		  	TSDPseudoListAdd(0," For each unvisited vertex u");
	    	TSDPseudoListAdd(1," DFS (u)"); 
	    	TSDPseudoListAdd(2," For each neighbor v of u"); 
	    	TSDPseudoListAdd(3," If v is unvisited"); 
	    	TSDPseudoListAdd(4," DFS (v)"); 
	    	TSDPseudoListAdd(5," Else skip v");
	    	TSDPseudoListAdd(6," Finish DFS(u), add u to front of list"); 
	    	
	    }
	
	  
	  PseudoStep StepGenerate(int i,String str)
	  {
		PseudoStep PS = new PseudoStep();
		String s = TSDPseudoList.get(i).getString();
		PS.setData(s, stepID++);
		PS.setDetailStep(str);  
		return PS;
	}
	  void TSDPseudoListAdd(int i,String str)
	  {
		 PseudoStep PS = new PseudoStep();
		 PS.setString(str);
		 TSDPseudoList.add(i, PS);
	  }
	  
	  
	  
	  void topologicalSort(Graph g, Stack<Vertex> stack)
	    {	
			int V = g.getListVertex().size(); 
	        boolean visited[] = new boolean[V];
	        for (int i = 0; i < V; i++)
	            visited[i] = false;
	       
			
	        str=" Source : Vertex 0\n Vertex 0 is not visited";
	        pseudoStep.add(StepGenerate(0,str));
	        //P for each unvisited vertex u
	    	//D vertex 0 has not been visited
	      
	    	str =" DFS(0)" ;
	    	pseudoStep.add(StepGenerate(1,str));
	        //P DFS (u)   
	    	//D DFS(0)
	    	
	        for (int i = 0; i < V; i++)
	        	if (visited[i] == false)
	            //(chuyen qua DFS lam tiep)
	        		DFSalg(g,i, visited, stack);
	      }
		
			public Stack<Integer> getTSDStack_toInteger(){
			Stack<Integer> i = new Stack<Integer>();
			for(int j = 0; j < stack.size();j++)
				i.add(stack.get(j).getId());
			
			return null;
			
		}
	  
	  
	  
	  void DFSalg(Graph gr,int id, boolean visited[],Stack<Vertex> DFSStack)
		{		
				visited[gr.findVertexPosition(gr.findVertex(id))] = true;
				Vertex i;
				
				Iterator<Vertex> it = gr.VertexKe(id).iterator();
				while (it.hasNext()) {
					i = it.next();
					str = " Try " + id + "->" + i.getId();
					pseudoStep.add(StepGenerate(2,str));
					//P for each neighbor v of u
					//D try edge i-> it
					//D list =[];
				
				if (!visited[gr.findVertexPosition(i)]) {
					
					str = " Vertex " + i.getId()  +" is unvisited";
					pseudoStep.add(StepGenerate(3,str));
					//P if v is unvisited DFS(v)	
					//D vertex i is unvisited DFS(i)
					//D list =[]
					
					str = " DFS(" + i.getId() +")";
					pseudoStep.add(StepGenerate(4,str));
					
					DFSalg(gr,i.getId(), visited, DFSStack);
					}
				else {
					
					str=" Vertex "+ i.getId() 
						+ " Has been visited, return to parent node.";
					pseudoStep.add(StepGenerate(5,str));		
					//P else skip v
					
				}	
				}
				
				DFSStack.add(0,gr.getVertex(id));
				str=" Finish DFS("+id+"), Add Vertex "+ id + " to front of list.\n "
						+ DFSStackToString(DFSStack);
				pseudoStep.add(StepGenerate(6,str));
				//P finish DFS(u), add u to front of list
		}
		
	  
	

	  	String DFSStackToString(Stack<Vertex> DFSStack) {
			String str = "";
			str += "List[";
			
			for (int i   = 0 ;i < DFSStack.size();i++)
			{
				if(i==DFSStack.size()-1)
					str += DFSStack.get(i).getId();
				else
					str += DFSStack.get(i).getId() +","; 
			}
			str += "]";
			return str;
		}

		
		
  @Override
  public void explore() {
	// TODO Auto-generated method stub
	
	 topologicalSort(getGraph(),stack);
	}	
		  
	
	
	@Override
	public Stack<Stack<Vertex>> getSCC() {
		// TODO Auto-generated method stub
		return null;
	}
	
	  
	  public Stack<Vertex> getStack() {
		return stack;
	}

	
}