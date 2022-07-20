package Algorithm;
import java.util.Iterator;
import java.util.Stack;

import Graph.Graph;
import Graph.Vertex;
import Step.step.PseudoStep;
import Step.step.TimeLife;



public class TopoSortDFS extends Algorithm  {
	  Stack<Vertex> stack = new Stack<Vertex>();
	  int V = getGraph().getListVertex().size();
	  String str = new String();
	  boolean visited[] = new boolean[V];

	  

	  static int stepID = 0;
	  public TopoSortDFS(){
		  
		  	PseudoListAdd(0," For each unvisited vertex u");
	    	PseudoListAdd(1," DFS (u)"); 
	    	PseudoListAdd(2," For each neighbor v of u"); 
	    	PseudoListAdd(3," If v is unvisited"); 
	    	PseudoListAdd(4," DFS (v)"); 
	    	PseudoListAdd(5," Else skip v");
	    	PseudoListAdd(6," Finish DFS(u), add u to front of list"); 
	    	
	    }
	
	  
	  PseudoStep StepGenerate(int i,String str)
	  {
		PseudoStep PS = new PseudoStep();
		String s = PseudoList.get(i).getString();
		PS.setData(s, stepID++);
		PS.setDetailStep(str);  
		return PS;
	}
	  void PseudoListAdd(int i,String str)
	  {
		 PseudoStep PS = new PseudoStep();
		 PS.setString(str);
		 PseudoList.add(i, PS);
	  }
	  
	  
	  
	  void topologicalSort(Graph g, Stack<Vertex> stack)
	    {	
			int V = g.getListVertex().size(); 
	        boolean visited[] = new boolean[V];
	        for (int i = 0; i < V; i++)
	            visited[i] = false;
	       
	        
	        
	    	//P DFS (u)   
	    	//D DFS(0)
	    	
	        for (int i = 0; i < V; i++)
	        	if (visited[i] == false)
	            //(chuyen qua DFS lam tiep)
	        	{
	        		
	        		str=" Source : Vertex" +i+"\n Vertex" +i+" is not visited";
	    	        pseudoStep.add(size,StepGenerate(0,str));
	    	        graph.addStateEdge(size+1,null,0);
	    	       	graph.addStateVertex(size++ +1, i, 2);
	    	       	//graph.addStateEdge(i, null, i);
	    	       	
	    	        //P for each unvisited vertex u
	    	    	//D vertex 0 has not been visited
	    	      
	    	    	str =" DFS("+i+")" ;
	    	    	pseudoStep.add(size,StepGenerate(1,str));
	    	    	graph.addStateEdge(size+1,null,0);
	    	    	graph.addStateVertex(size++ +1, i, 2);
	    	        DFSalg(g,i, visited, stack);
	        	}
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
					pseudoStep.add(size,StepGenerate(2,str));
					graph.addStateEdge(size+1,graph.findEdge(id, i.getId()),1);
					graph.addStateVertex(size++ +1, id, 2);
					
					
					//P for each neighbor v of u
					//D try edge i-> it
					//D list =[];
				
				if (!visited[gr.findVertexPosition(i)]) {
					
					str = " Vertex " + i.getId()  +" is unvisited";
					pseudoStep.add(size,StepGenerate(3,str));
					graph.addStateEdge(size+1,null,0);
					graph.addStateVertex(size++ +1, id,i.getId(), 3,2);
				 
					//P if v is unvisited DFS(v)	
					//D vertex i is unvisited DFS(i)
					//D list =[]
					
					str = " DFS(" + i.getId() +")";
					pseudoStep.add(size,StepGenerate(4,str));
					graph.addStateEdge(size+1,null,0);
					graph.addStateVertex(size++ +1, id,i.getId(), 3,2);
				
				    
				    
					DFSalg(gr,i.getId(), visited, DFSStack);
					}
				else {
					
					str=" Vertex "+ i.getId() 
						+ " Has been visited, return to parent node.";
					pseudoStep.add(size,StepGenerate(5,str));
					graph.addStateEdge(size+1,null,0);
					if(graph.findVertex(id).isCompleted()!=true)
						graph.addStateVertex(size++ +1, id,i.getId(), 3,4);
					else
						graph.addStateVertex(size++ +1,i.getId(),4);
					
					graph.findVertex(id).setCompleted(true);
					
					//P else skip v
					
				}	
				}
				
				DFSStack.add(0,gr.getVertex(id));
				str=" Finish DFS("+id+"), Add Vertex "+ id + " to front of list.\n "
						+ DFSStackToString(DFSStack);
				pseudoStep.add(size,StepGenerate(6,str));
				graph.addStateEdge(size+1,null,0);
				graph.addStateVertex(size++ +1,id,4);
				graph.findVertex(id).setCompleted(true);
			   
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
	 size=0;
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