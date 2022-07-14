package application;



import java.util.List;

import Algorithm.Algorithm;
import Algorithm.TopoSortDFS;
import Step.step.PseudoStep;
import javafx.fxml.FXML;


public class TopoSortController extends Controller{
	@FXML
	Algorithm algorithm=new TopoSortDFS();
	public void start() {
		algorithm.setData(graph);
		algorithm.explore();
		List<PseudoStep> pseudoStep= algorithm.getPseudoStep();
		for(int i=0;i<pseudoStep.size();i++)
		{
		System.out.println(pseudoStep.get(i).getString());
		System.out.println(pseudoStep.get(i).getDetailStep().getString());
		System.out.println("");
		}
	}
	public void next() {}
	public void back() {}
	public void auto() {}
	public void stop() {}
	
	
	
	
		public Algorithm getAlgorithm() {
			return algorithm;
		}
		public void setAlgorithm(Algorithm algorithm) {
			this.algorithm = algorithm;
		}

}
