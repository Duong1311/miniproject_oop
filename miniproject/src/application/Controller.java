package application;

import java.io.IOException;

import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Controller {
	@FXML
	Graph graph = new Graph();
	@FXML
	Stage stage;
	Scene scene;
	Parent root;
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
	void showGraph(AnchorPane root,Graph g)
	{
		for(int i = 0 ; i< g.getListVertex().size();i++)
		{
			Vertex v = g.getListVertex().get(i);
			root.getChildren().add(addButton(v));
		}
		for(int i = 0 ; i< g.getListEdge().size();i++) {
			Edge e = g.getListEdge().get(i);
			addLine(root,e);
		}
	}
	 	Button addButton(Vertex v)
	 	{
	 		double guiX = v.getGuiX();
			double guiY = v.getGuiY();
			int id = v.getId();
			Button roundButton = new Button(Integer.toString(id));
			roundButton.setLayoutX(guiX);
			roundButton.setLayoutY(guiY);
			//((FlowPane) root).setHgap(x);
	        //((FlowPane) root).setVgap(y);
			roundButton.setStyle(
		            "-fx-background-radius: 15em; " +
		            "-fx-min-width: 30px; " +
		            "-fx-min-height: 30px; " +
		            "-fx-max-width: 30px; " +
		            "-fx-max-height: 30px;"
		    );
			return roundButton;
	 	}
		 
	 	public void addLine(Parent root,Edge e)
	 	{
	 		Vertex from = e.getFrom();
 			Vertex to =	e.getTo();
 			boolean check;
 		
 			drawArrowLine(e.getFrom().getGuiX(),e.getFrom().getGuiY(),
 						  e.getTo().getGuiX(),e.getTo().getGuiY(),	root);
 			
	 	}
	 	
	 	public static void drawArrowLine(double startX, double startY, double endX, double endY, Parent root) {
		      // get the slope of the line and find its angle
		      double slope = (startY - endY) / (startX - endX);
		      double lineAngle = Math.atan(slope);
		      Line line = null;
		      double arrowAngle = startX > endX ? Math.toRadians(45) : -Math.toRadians(225);
		      double x=15;
		      System.out.println("thong so "+startX+" "+startY+" "+endX+" "+endY);
		      if(startX<endX) { 
		    	  if(startY<endY) {
		    		  System.out.println("case 1");
		    		  line = new Line(startX+x -x* Math.cos(lineAngle + arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle + arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle - arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle - arrowAngle));
		    	  }
		    	  else {
		    		  System.out.println("case 2");
		    		  line = new Line(startX+x - x* Math.cos(lineAngle - arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle - arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle + arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle + arrowAngle));
		    	  } 
		      }
		      
		      if(startX>endX) {
		    	  if(startY<endY) {
		    		  System.out.println("case 3");
		    		  line = new Line(startX+x - x* Math.cos(lineAngle + arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle + arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle - arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle - arrowAngle));
		    	  }
		    	  else {
		    		  System.out.println("case 4");
		    		  line = new Line(startX+x - x* Math.cos(lineAngle - arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle - arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle + arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle + arrowAngle));
		    	  } 

		      }
		      double lineLength = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
		      double arrowLength = lineLength / 10;

		      // create the arrow legs
		      Line arrow1 = new Line();
		      arrow1.setStartX(line.getEndX());
		      arrow1.setStartY(line.getEndY());
		      arrow1.setEndX(line.getEndX() + 5* Math.cos(lineAngle - arrowAngle));
		      arrow1.setEndY(line.getEndY() + 5* Math.sin(lineAngle - arrowAngle));

		      Line arrow2 = new Line();
		      arrow2.setStartX(line.getEndX());
		      arrow2.setStartY(line.getEndY());
		      arrow2.setEndX(line.getEndX() + 5*Math.cos(lineAngle + arrowAngle));
		      arrow2.setEndY(line.getEndY() + 5* Math.sin(lineAngle + arrowAngle));

		      ((AnchorPane) root).getChildren().addAll(line, arrow1, arrow2);
		   }
		public Graph getGraph() {
			return graph;
		}
		public void setGraph(Graph graph) {
			this.graph = graph;
		}
		
}
