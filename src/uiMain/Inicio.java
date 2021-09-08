package uiMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;





public class Inicio {
	
	private Scene scene1;
	Scene scene2 = new Usuario().getScene();
	
	//menu inicio
	Menu Inicio;
	MenuItem Salir;
	MenuItem Descripcion;
	
	//imagenes aerolinea
	Image imagenAerolinea;
	ImageView imagenviewAerolinea;
	
	//imagenes Integrantes
	ImageView img;
	ImageView img2;
	ImageView img3;
	ImageView img4;
	ImageView img5;
	ImageView img6;
	ImageView img7;
	ImageView img8;
	ImageView img9;
	ImageView img10;
	ImageView img11;
	ImageView img12;
	
	
	//Botton cambio de scena
	Button BottonCambioScena;
	
	//
	Label P5;
	String HojaDeVida1;
	String HojaDeVida2;
	String HojaDeVida3;
	GridPane P6;
	
	//variables extra
	int contador = 0;
	int contador2 = 0;
	
	
	public Inicio() {
		
		
		VBox root = new VBox();
		
		//Controladores
		menuHandler ControlMenus= new menuHandler();
		LabelHandler ControlImagen = new LabelHandler();
		
		
		//Menu Inicio
		Inicio = new Menu("Inicio");
		//controlador Salir
		Salir = new MenuItem("Salir");
		Salir.setStyle(HojaDeVida1);
		Salir.setOnAction(ControlMenus);		
		//controlador Descripcion
		Descripcion = new MenuItem("Descripción");
		Descripcion.setOnAction(ControlMenus);
		Inicio.getItems().addAll(Salir,Descripcion);
		MenuBar menu = new MenuBar();
		menu.getMenus().add(Inicio);
		menu.setStyle("-fx-background-color: #FF6B6F;");
		
		
		
		
		//Partes P3 y P4 en P1
		//p3
		TextArea p3 = new TextArea("\n 	¡Bievenido a POO Airways! \n 	Something special in the air ");	
		p3.setEditable(false);
		p3.setStyle(" -fx-text-inner-color: #2F3A56 ; -fx-background-color: #FF6B6F; -fx-border-radius: 20;");
		p3.setFont(Font.font ("Calisto MT",FontWeight.NORMAL, 25));
		p3.setPrefHeight(120); 
		p3.setPrefWidth(450);
		
		
		//p4
		//imagenes
		
		VBox p4 = new VBox();
		imagenAerolinea = new Image("./imagenes/vuelo1.jpeg");
		imagenviewAerolinea = new ImageView(imagenAerolinea);
		imagenviewAerolinea.setFitHeight(360);
		imagenviewAerolinea.setFitWidth(450);
		imagenviewAerolinea.setOnMouseEntered(ControlImagen);
		p4.setSpacing(15);
		
		
		//botton cambio de ventana
		
		BottonCambioScena = new Button("Ventana de Usuario");
		BottonCambioScena.setPrefSize(450, 40);
		BottonCambioScena.setStyle("7;-fx-border-color: BLACK; -fx-base: #FF6B6F;-fx-text-fill: BLACK;");
		BottonCambioScena.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				GUI.stage.setScene(scene2);
				
			}
			
		});
		p4.getChildren().addAll( imagenviewAerolinea, BottonCambioScena);
		
		VBox P1 = new VBox();
		P1.setPadding(new Insets(10));
		P1.setSpacing(5);
		P1.getChildren().addAll(p3, p4);
		
		
		
		//Partes P5 y P6 en p2
		//P5
		
		P5= new Label();
		HojaDeVida1 = " Nombre: Raul Vladimir Gaitan Vaca       \n  Fecha de nacimiento: 22 de Septiembre de 1999  \n  Documento de Identidad: 1152226458  \n  Resumen: Estudiante de Ingenieria en Sistemas e informatica,\n parte del programa especial PEAMA de la sede Orinoquia";
		HojaDeVida2 = "Nombre: Jeff Atwood        \n Fecha de nacimiento: 1970 (51 años)  \n Documento de Identidad: 300256789  \n Resumen:  Programador, escritor y emprendedor estadounidense, \n cofundó el sitio de preguntas y respuestas de programación \n Stack Overflow y la red Stack Exchange ";
		HojaDeVida3 = "Nombre: Avram Joel Spolsky      \n Fecha de nacimiento: 1965 (56 años)    \n Documento de Identidad: 509283434   \n Resumen:  Ingeniero de software y escritor. En 2008, lanzó junto\n con Jeff Atwood, Stack Overflow, un sitio colaborativo\n para preguntas y respuestas sobre la programación.";
		P5.setPrefHeight(120);
		P5.setPrefWidth(500);
		P5.setStyle("-fx-background-color: #406D96;-fx-border-color: #FF6B6F;");
		P5.setTextFill(Color.WHITE);
		P5.setText(HojaDeVida1);
		P5.setFont(Font.font ("Calisto MT",FontWeight.NORMAL, 16));
		
		//Control de P5
	    P5.setOnMouseClicked(ControlImagen);
		
		
		//P6
		Image image = new Image("./imagenes/img.jpg", 245, 205, false, false);
		img = new ImageView(image);
		Image image1 = new Image("./imagenes/img2.jpg", 245, 205, false, false);
		img2 = new ImageView(image1);
		Image image2 = new Image("./imagenes/img3.jpeg", 245, 205, false, false);
		img3 = new ImageView(image2);
		Image image3 = new Image("./imagenes/img4.jpg", 245, 205, false, false);
		img4 = new ImageView(image3);
		Image image4 = new Image("./imagenes/img9.jpg", 245, 205, false, false);
		img5 = new ImageView(image4);
		Image image5 = new Image("./imagenes/img10.jpg", 245, 205, false, false);
		img6 = new ImageView(image5);
		Image image6 = new Image("./imagenes/img11.jpg", 245, 205, false, false);
		img7 = new ImageView(image6);
		Image image7 = new Image("./imagenes/img12.jpg", 245, 205, false, false);
		img8 = new ImageView(image7);
		Image image8 = new Image("./imagenes/img13.jpg", 245, 205, false, false);
		img9 = new ImageView(image8);
		Image image9 = new Image("./imagenes/img14.jpg", 245, 205, false, false);
		img10 = new ImageView(image9);
		Image image10 = new Image("./imagenes/img15.jpg", 245, 205, false, false);
		img11 = new ImageView(image10);
		Image image11 = new Image("./imagenes/img16.jpg", 245, 205, false, false);
		img12 = new ImageView(image11);
		
		P6 = new GridPane();
	    GridPane.setConstraints(img,0,0);
	    GridPane.setConstraints(img2,0,1);
	    GridPane.setConstraints(img3,1,0);
	    GridPane.setConstraints(img4,1,1);
	    GridPane.setConstraints(img5,0,0);
	    GridPane.setConstraints(img6,0,1);
	    GridPane.setConstraints(img7,1,0);
	    GridPane.setConstraints(img8,1,1);		
	    GridPane.setConstraints(img9,0,0);
	    GridPane.setConstraints(img10,0,1);
	    GridPane.setConstraints(img11,1,0);
	    GridPane.setConstraints(img12,1,1);
		
		P6.getChildren().addAll(img,img2,img3,img4);
	    P6.setVgap(8);
		P6.setHgap(8);
		
		//P2
		VBox P2 = new VBox();
		P2.setSpacing(5);
		P2.getChildren().addAll(P5, P6);
		P2.setPadding(new Insets(10));
		
		
		HBox root0 = new HBox();
		root0.getChildren().addAll(P1,P2);
	
		
	
		//Final de scene1
		root.getChildren().addAll(menu, root0);
		root.setStyle("-fx-background-color: #2F3A56;");
		scene1 = new Scene(root, 1000, 600);
		
	}
	
	public Scene getScene() {
		return scene1;
	}
	
	
	
	
	
	
	//CONTROLADORES
	class menuHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if (control instanceof MenuItem) {
				if(control.equals(Salir)) {
					System.exit(0);
				
				}
				else if(control.equals(Descripcion)){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Descripcion del Programa");
					alert.setContentText("La aplicacion es el gestor de una aerolínea dedicada al transporte de pasajeros a nivel internacional y nacional en Colombia ");
					alert.showAndWait();
				}
				
			}
					
			
		}
		
	}

	
	class LabelHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			Object control = e.getSource();
			
			if (control instanceof Label) {
				if (control.equals(P5)) {
					
					if (contador2 == 0) {
						P5.setText(HojaDeVida2);
						P6.getChildren().clear();
						P6.getChildren().addAll(img5,img6,img7,img8);
						contador2++;
						
					} else if (contador2 == 1) {
						P5.setText(HojaDeVida3);
						P6.getChildren().clear();
						P6.getChildren().addAll(img9,img10,img11,img12);
						contador2++;
						
					} else if (contador2 == 2) {
						P5.setText(HojaDeVida1);
						P6.getChildren().clear();
						P6.getChildren().addAll(img,img2,img3,img4);
						contador2 = 0;
					}
	
				}
			}
			
			if(control instanceof ImageView) {
				if(contador==0) {
					imagenviewAerolinea.setImage(new Image("./imagenes/vuelo2.jpg"));
					contador ++;
				}
				else if(contador==1) {
					imagenviewAerolinea.setImage(new Image("./imagenes/vuelo3.jpg"));
					contador ++;
				}
				else if(contador==2) {
					imagenviewAerolinea.setImage(new Image("./imagenes/vuelo4.jpg"));
					contador ++;
				}
				else if(contador==3) {
					imagenviewAerolinea.setImage(new Image("./imagenes/vuelo1.jpeg"));
					contador =0;
				}

			}
			

		}

	}

}
