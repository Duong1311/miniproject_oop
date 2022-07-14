package run;
import Graph.Graph;
import application.GUI;

	

public class Run {
	
	public static void main(String[] args) {
		
		//Algorithm a = new TopoSortDFS();
		Graph g = new Graph();
		GUI gui= new GUI();
		gui.setGraph(g);
		gui.run(args);
		//a.setData(g);
		//Context c = new Context();
		//c.setAlgorithm(a); 
		//c.doExporation();
		/*for(int i=0;i<a.getPseudoStep().size();i++)
		{
		System.out.println(a.getPseudoStep().get(i).getString());
		System.out.println(a.getPseudoStep().get(i).getDetailStep().getString());
		System.out.println("");
		}*/
		
		System.out.println("\nRun complete! Congrate");
		//	a.setDate(g);
		//	a.explore();
			// set up dc algorithm nao dc su dung
}
}
	