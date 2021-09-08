package uiMain;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import uiMain.Inicio.LabelHandler;
import uiMain.Inicio.menuHandler;

public class Usuario { 
	
	private Scene scene2;
	
	
	//Menu 
	MenuBar MenuGeneral;
	
	Menu archivo;
	MenuItem aplicacion;
	MenuItem salir;
	
	Menu procesosyconsultas;
	MenuItem funcionalidad1;
	MenuItem funcionalidad2;
	MenuItem funcionalidad3;
	MenuItem funcionalidad4;
	MenuItem funcionalidad5;
	MenuItem funcionalidad6;
	MenuItem funcionalidad7;
	MenuItem funcionalidad8;
	
	Menu ayuda;
	MenuItem acercade;
	
	//nombre del proceso
	Label nombreproceso;
	//Descripcion del proceso
	Label descripcion;
	
	
	public Usuario() {
		
		BorderPane root = new BorderPane();
		
		//Nombre de la aplicacion parte 0
		Label titulo = new Label("POO Airways");
		titulo.setFont(Font.font ("Calisto MT",FontWeight.NORMAL, 50));
		titulo.setTextFill(Color.WHITE);
		titulo.setPadding(new Insets(20,1, 20, 90));
		
		
		VBox panel1 = new VBox();
		VBox panel2 = new VBox();
		
		//Controladores
		menuHandler ControlMenus= new menuHandler();
		
		
		
		
		//Menu parte 1
		HBox Menu = new HBox();
		
		MenuGeneral = new MenuBar();
		
		archivo = new Menu("Archivo");
		aplicacion = new MenuItem("Aplicacion");
		aplicacion.setOnAction(ControlMenus);
		salir = new MenuItem("Salir");
		salir.setOnAction(ControlMenus);

		archivo.getItems().addAll(aplicacion, salir);

		
		procesosyconsultas = new Menu("Procesos y Consultas");
		funcionalidad1 = new MenuItem("Facturacion");
		funcionalidad2 = new MenuItem("Multa equipaje");
		funcionalidad3 = new MenuItem("Canjear Millas");
		funcionalidad4 = new MenuItem("Despegue");
		funcionalidad5 = new MenuItem("Nuevo Aeropuerto");
		funcionalidad6 = new MenuItem("Nuevo Avion");
		funcionalidad7 = new MenuItem("Nuevo Vuelo");
		funcionalidad8 = new MenuItem("Nuevo Pasajero");
		funcionalidad1.setOnAction(ControlMenus);
		funcionalidad2.setOnAction(ControlMenus);
		funcionalidad3.setOnAction(ControlMenus);
		funcionalidad4.setOnAction(ControlMenus);
		funcionalidad5.setOnAction(ControlMenus);
		funcionalidad6.setOnAction(ControlMenus);
		funcionalidad7.setOnAction(ControlMenus);
		funcionalidad8.setOnAction(ControlMenus);
		procesosyconsultas.getItems().addAll(funcionalidad1,funcionalidad2,funcionalidad3,funcionalidad4,funcionalidad5,funcionalidad6,funcionalidad7,funcionalidad8);
		
		ayuda = new Menu("Ayuda");
		acercade = new MenuItem("Acerca de");
		acercade.setOnAction(ControlMenus);
		ayuda.getItems().add(acercade);
		
		MenuGeneral.getMenus().addAll(archivo,procesosyconsultas,ayuda);
		MenuGeneral.setStyle("-fx-background-color: #FF6B6F;");
		Menu.getChildren().add(MenuGeneral);
		Menu.setStyle("-fx-background-color: #FF6B6F;");
		
		//Nombre del proceso
		nombreproceso= new Label(" ");
		nombreproceso.setFont(Font.font ("Calisto MT",FontWeight.NORMAL, 25));
		nombreproceso.setTextFill(Color.WHITE);
		nombreproceso.setPadding(new Insets(20,1, 20, 360));
		
		//Descripcion de la aplicacion
		descripcion = new Label(" ");
		descripcion.setFont(Font.font ("Calisto MT",FontWeight.NORMAL, 20));
		descripcion.setTextFill(Color.WHITE);
		descripcion.setPadding(new Insets(20,1, 20, 50));

		
		
		 panel2.getChildren().addAll(nombreproceso, descripcion);
		 panel1.getChildren().addAll(Menu,panel2);
		 
		 root.setTop(titulo);
		 root.setCenter(panel1);
		 root.setStyle("-fx-background-color: #2F3A56;");
		 scene2 = new Scene(root,1000,600);
	}
	
	
	public Scene getScene() {
		return scene2;
	}
	
	
	
	
	
	
	//CONTROLADORES
	//CONTROL MENU 
	class menuHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if (control instanceof MenuItem) {
				if(control.equals(salir)) {
					GUI.stage.setScene(GUI.sceneInicio);
				
				}else if(control.equals(aplicacion)){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Aplicacion:");
					alert.setContentText("La aplicacion es el gestor de una aerolínea dedicada al \ntransporte de pasajeros a nivel internacional y nacional en Colombia ");
					alert.showAndWait();
				}
				else if(control.equals(acercade)){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Acerca de");
					alert.setContentText("Autores: \n Raul Vladimir Gaitan Vaca \n Jeff Atwood \n Avram Joel Spolsky ");
					alert.showAndWait();
				}
				
				//FUNCIONALIDADES
				else if(control.equals(funcionalidad1)){
					nombreproceso.setText("Facturacion");
					descripcion.setText("\nEste método es el encargado de generar la factura de cada pasajero en su respectivo vuelo.");
				}
				else if(control.equals(funcionalidad2)){
					nombreproceso.setText("Multa equipaje");
					descripcion.setText("\nEste método devuelve un valor de tipo entero el cual sería el valor de la multa aplicada a un pasajero \npor llevar sobrepeso en su equipaje o por llevar más maletas del número permitido");
				}
				else if(control.equals(funcionalidad3)){
					nombreproceso.setText("Canjear Millas");
					descripcion.setText("\nEste método revisa la cantidad de millas que tiene el Pasajero y aplica un descuento del 2% \npor cada 1000 millas sobre el total del costo del vuelo, para canjear las millas el pasajero debe tener \nmínimo 1000 millas. ");
				}
				else if(control.equals(funcionalidad4)){
					nombreproceso.setText("Despegue");
					descripcion.setText("\nEste método permite hacer despegar un avión, con esto la información del vuelo será eliminada \ny quedaran disponibles para un nuevo vuelo, el avión, los empleados, el aeropuerto de llegada y el de salida, \nademás de eso retornara un informe de los pasajeros junto a un resumen general del gasto y \nlas ganancias del vuelo. ");
				}
				else if(control.equals(funcionalidad5)){
					nombreproceso.setText("Registrar un nuevo Aeropueto");
					descripcion.setText("\nEsta funcionalidad permite el registro de nuevos Aeropuertos para la aerolinea ");
				}
				else if(control.equals(funcionalidad6)){
					nombreproceso.setText("Registrar un nuevo avion");
					descripcion.setText("\nEsta funcionalidad permite el registro de nuevas aviones para la aerolinea ");
				}
				else if(control.equals(funcionalidad7)){
					nombreproceso.setText("Registrar un nuevo vuelo");
					descripcion.setText("\nEsta funcionalidad permite la creacion de nuevos vuelos para la aerolinea con sus respectivos aviones, \naeropuertos de llegada y salida entre otros elementos");
				}
				else if(control.equals(funcionalidad8)){
					nombreproceso.setText("Registrar un nuevo pasajero");
					descripcion.setText("\nEsta funcionalidad permite la creacion de un nuevo pasajero para la aerolinea con su respectivo vuelo, \naeropuerto de llegada y salida, equipaje, factura entre otros elementos");
				}
			}
					
			
		}
		
	}
	
	
	
	
}
