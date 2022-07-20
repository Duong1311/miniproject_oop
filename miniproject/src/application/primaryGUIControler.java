package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class primaryGUIControler  extends Controller {
	@FXML
	
	
	public void AddVertex(ActionEvent event) throws IOException
	{	
		
		FXMLLoader loader= new FXMLLoader(getClass().getResource("DrawGraphPanel.fxml"));
		root = loader.load();
		stage = (Stage)( (Node) event.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		showGraph(( AnchorPane)root,graph);
			
		Controller  controller = new  addVertexController();
	  	((addVertexController) controller).addVertex(root,scene);
	    
	    stage.setScene(scene);
		stage.show();
	}
	
	
	public void AddEdge(ActionEvent event) throws IOException
	{	
		
		FXMLLoader loader= new FXMLLoader(getClass().getResource("DrawEdgePanel.fxml"));
		root = loader.load();
		stage = (Stage)( (Node) event.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		
		
		
		
		showGraph(( AnchorPane)root,graph);
		Controller controller = new  addEdgeController();
	  	((addEdgeController) controller).addEdge(root,scene);
	  	
		stage.setScene(scene);
		stage.show();
	}
	
	public void TopoSort(ActionEvent event) throws IOException, InterruptedException{
		
			FXMLLoader loader= new FXMLLoader(getClass().getResource("TopoSort.fxml"));
			root = loader.load();
			stage = (Stage)( (Node) event.getSource() ).getScene().getWindow();
			scene = new Scene(root);
			Controller controller = new  TopoSortController();
			((TopoSortController) controller).start();
			
			showGraph(( AnchorPane)root,graph);
			
			stage.setScene(scene);
			stage.show();
			
		
		
	}
	public void Bipartite(ActionEvent event) throws IOException, InterruptedException{
		
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Bipartite.fxml"));
		root = loader.load();
		stage = (Stage)( (Node) event.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		Controller controller = new  BipartiteGraphCheckerController();
		((BipartiteGraphCheckerController) controller).start();
		
		showGraph(( AnchorPane)root,graph);
		
		stage.setScene(scene);
		stage.show();
		
	
	
}
	
	
	
	
	
	
}
