package uiMain;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GUI extends Application {
	
	Scene sceneUsuario = new Usuario().getScene();
	
	static Scene sceneInicio = new Inicio().getScene();
	static Stage stage = new Stage();
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		GUI.stage = stage;
		//stage.setTitle("POO Airways");
		stage.setScene(sceneInicio);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
