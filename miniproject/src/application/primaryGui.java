package application;
	
import Graph.Graph;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class primaryGui  extends Application {
	@FXML
	Graph graph;
	
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("PrimaryStage.fxml"));
			Parent root = loader.load();
			Scene scene1 = new Scene(root);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run(String[] args) {
		launch(args);
	}	
	
}







