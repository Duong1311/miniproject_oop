package application;



import java.io.IOException;
import java.util.List;

import Algorithm.Algorithm;
import Algorithm.TopoSortDFS;
import Graph.Edge;
import Graph.Vertex;
import Step.step.PseudoStep;
import Step.step.TimeLife;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;




public class TopoSortController extends Controller{
	@FXML
	Algorithm algorithm=new TopoSortDFS();
	
	public Label L0=new Label();
	public Label L1=new Label();
	public Label L2=new Label();
	public Label L3=new Label();
	public Label L4=new Label();
	public Label L5=new Label();
	public Label L6=new Label();
	public Label detail=new Label();
	Label tempLabel=L0;
	int  tempInt=0;
	Vertex tempVertex = new Vertex();
	Edge tempEdge = new Edge();

	
	List<PseudoStep> pseudoStep= algorithm.getPseudoStep();
	List<PseudoStep> pseudoList= algorithm.getPseudoList();
	

	public void start() throws InterruptedException, IOException {
		algorithm.setData(graph);
		algorithm.explore();
		
}
			
		
	public void next() {
		if(graph==null) {}
		
		else if(tempInt!=algorithm.getSize()) {
			resetColor(tempLabel);
			nextConfig(tempInt);
			detail.setText(pseudoStep.get(tempInt).getDetailStep().getString());
			tempInt+=1;

		}
		else tempInt-=1;
	}
	private void nextConfig(int tempInt) {
		for(int j = 0 ; j< graph.getListVertex().size();j++) {
			
			
			tempVertex=graph.getVertex(j);
			changeColor(tempVertex.getButton(),tempVertex.getState().get(tempInt+1));
		}
		for(int j = 0 ; j< graph.getListEdge().size();j++) {
			tempEdge=graph.getListEdge().get(j);
			changeColor(tempEdge.getLine(),tempEdge.getState().get(tempInt+1));
		}
		
		for(int j = 0 ; j<pseudoList.size();j++)
			if(pseudoStep.get(tempInt).getString().equals(pseudoList.get(j).getString()))
			{
			
				switch(j)
				{
				case 0:
					changeColor(L0);
					tempLabel=L0;
					break;
				case 1:
					changeColor(L1);
					tempLabel=L1;
					break;
				case 2:
					changeColor(L2);
					tempLabel=L2;
					break;
				case 3:
					changeColor(L3);
					tempLabel=L3;
					break;
				case 4:
					changeColor(L4);
					tempLabel=L4;
					break;
				case 5:
					changeColor(L5);
					tempLabel=L5;
					break;
				case 6:
					changeColor(L6);
					tempLabel=L6;
					break;
				}
		}
}




	public void back() {
		
		if(graph==null) {}
		else {
			tempInt-=1;
			if(tempInt!=-1) {
				resetColor(tempLabel);
				backConfig(tempInt);
				detail.setText(pseudoStep.get(tempInt).getDetailStep().getString());
				
			}
		else tempInt+=1;
		}
	}
	private void backConfig(int tempInt2) {
		for(int j = 0 ; j< graph.getListVertex().size();j++) {
			tempVertex=graph.getVertex(j);
			changeColor(tempVertex.getButton(),tempVertex.getState().get(tempInt+1));
		}
		for(int j = 0 ; j< graph.getListEdge().size();j++) {
			tempEdge=graph.getListEdge().get(j);
			changeColor(tempEdge.getLine(),tempEdge.getState().get(tempInt+1));
		}
	
		for(int j = 0 ; j<pseudoList.size();j++)
			if(pseudoStep.get(tempInt).getString().equals(pseudoList.get(j).getString()))
			{switch(j)
				{
				case 0:
					changeColor(L0);
					tempLabel=L0;
					break;
				case 1:
					changeColor(L1);
					tempLabel=L1;
					break;
				case 2:
					changeColor(L2);
					tempLabel=L2;
					break;
				case 3:
					changeColor(L3);
					tempLabel=L3;
					break;
				case 4:
					changeColor(L4);
					tempLabel=L4;
					break;
				case 5:
					changeColor(L5);
					tempLabel=L5;
					break;
				case 6:
					changeColor(L6);
					tempLabel=L6;
					break;
				}
		}
		
	}


		public Algorithm getAlgorithm() {
			return algorithm;
		}
		public void setAlgorithm(Algorithm algorithm) {
			this.algorithm = algorithm;
		}

}
