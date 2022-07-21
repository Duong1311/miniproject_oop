package application;

import java.io.IOException;

import Graph.Graph;
import Graph.Vertex;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addEdgeController extends Controller{
	@FXML

	boolean hasPressFirstButton=false;
	Button firstButton;
	Button secondButton;
	@FXML
	Stage stage;
	Scene scene;
	
	
	public void exit(ActionEvent event) throws IOException
	{
		FXMLLoader loader= new FXMLLoader(getClass().getResource("PrimaryStage.fxml"));
		Parent root = loader.load();
		stage = (Stage)( (Node) event.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		showGraph(( AnchorPane)root,graph);   
		stage.setScene(scene);
		stage.show();
	}
	
	
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	
	

 
	public void addEdge(Parent root, Scene scene) {
		
		
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() { 
	         @Override 
	         public void handle(ActionEvent e) { 
	        	if(!((Button) e.getTarget()).getText().equals("Done")) 
	        		{System.out.println("Just click button: "+((Button) e.getTarget()).getText());
	        	
	        	if(hasPressFirstButton==false) 
	        		{
	        		hasPressFirstButton=true;
	     			firstButton=(Button) e.getTarget();
	        		}
	        	else if((Button) e.getTarget()==firstButton)
	        	{
	        		System.out.println("ERR: Choose another Vertex!");
	        	} 
	     		else {
	     			hasPressFirstButton=false;
	     			secondButton=(Button) e.getTarget();
	     			System.out.println("Done");
	     			
	     			Vertex from = graph.getVertex(firstButton);
	     			Vertex to =	graph.getVertex(secondButton);
	  
	     			if(graph.hasEdge(from.getId(),to.getId())==true) {
	     				System.out.println(from.getId()+" "+to.getId());
	     				System.out.println("ERR: Already have this link!");
	     			}
	     			else {
	     				graph.addEdge(from,to);
	     				addLine(root,graph.getListEdge().get(graph.getListEdge().size()-1));
	     			}
	     			
		        
	     			}
	     		
	        	}	
	     	 } 
	      };  
	     scene.addEventFilter(ActionEvent.ACTION, eventHandler); 
	}
	
	
	
	
	
}
