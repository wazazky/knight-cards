
package application;

import static java.lang.System.exit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.File;

import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
//import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
class Interfaz {
	private static Scene tittleScreen;
	public static Scene soloScreen;
	private static Scene opcionesScreen;
	public static AudioClip music;
	public static AudioClip music2;
	
	
	
	private static Parent TittleContent(Stage primaryStage) {
		Pane root = new Pane();
		root.setPrefSize(1200, 700);
		Image menu= new Image("res/menu.gif");
		ImageView img = new ImageView(menu);
		img.setFitWidth(1200);
		img.setFitHeight(700);
		root.getChildren().add(img);

		Alert alertAyuda = new Alert(Alert.AlertType.INFORMATION);
		alertAyuda.setTitle("Proyecto");
		alertAyuda.setHeaderText("INFORMACION DEL JUEGO");
		alertAyuda.setContentText(
				"JUEGO: Seleccione cada carta en 1 turno, para realizar una accion, ya sea atacar, defender o curar\n"
						+ "OPCIONES: Aqui podras modificar el sonido y ver los creditos del juego.");
		alertAyuda.setHeight(500);

		Tittle tittle = new Tittle("KNIGHT CARDS");
		tittle.setTranslateX(75);
		tittle.setTranslateY(200);
		

		MenuItem solo = new MenuItem("JUGAR");
		solo.setOnMouseReleased(e ->{
			music.stop();
			music2.play();
			music2.setVolume(0.55);
			primaryStage.setScene(soloScreen);});
		MenuItem salir = new MenuItem("SALIR");
		MenuItem opciones = new MenuItem("OPCIONES");
		opciones.setOnMouseReleased(e -> primaryStage.setScene(opcionesScreen));
		salir.setOnMouseReleased(e -> exit(0));

		MenuBox vboxTittle = new MenuBox(solo, opciones, salir);
		vboxTittle.setTranslateX(140);
		vboxTittle.setTranslateY(300);

		MenuItem ayuda = new MenuItem("AYUDA");
		ayuda.setOnMouseReleased(event -> alertAyuda.showAndWait());

		root.getChildren().addAll(tittle, vboxTittle, ayuda);
		return root;
	}

	////////////////////////////////////////////////////////////////////////////
	// Juego ///
	public static Parent  SoloContent(Stage primaryStage){
		int cont,a,b,c;
		
		
		EndGame end=new EndGame();
		Personaje p1=new Personaje ("Jugador 1",25,true);
		Personaje p2=new Personaje ("Jugador 2",25,false);
		Personaje.mostrar2(p1,p2);
		
		
		
		
		Tittle victoria1 =new Tittle("Victoria "+p1.getNombre());
		victoria1.setVisible(false);
		victoria1.setTranslateX(490);
		victoria1.setTranslateY(250);
	
		Tittle turno1 =new Tittle("Elige");
		turno1.setVisible(true);
		turno1.setTranslateX(100);
		turno1.setTranslateY(600);
		
		Tittle turno2 =new Tittle("Elige");
		turno2.setVisible(false);
		turno2.setTranslateX(850);
		turno2.setTranslateY(600);
		
		Tittle victoria2 =new Tittle("Victoria "+p2.getNombre());
		victoria2.setVisible(false);
		victoria2.setTranslateX(490);
		victoria2.setTranslateY(250);

		Carta baraja[]=new Carta[9];
	    baraja=Carta.consCartas();
	
	    Image barra =new Image("res/cartas/barras.png");
	    ImageView br1= new ImageView(barra);
	    
		String dir[]= new String[9];
		Image icarta[]=new Image[9];
		ImageView ivcarta[]=new ImageView[9];
		
		String dir1[]= new String[6];
		for (cont=0;cont<6;cont++) {
			dir1[cont]=Personaje.direcciones(1,cont);
			}
		
		Image ip0=new Image(dir1[0]);
		Image ip1=new Image(dir1[1]);
		Image ip2=new Image(dir1[2]);
		Image ip3=new Image(dir1[3]);
		Image ip4=new Image(dir1[4]);
		Image ip5=new Image(dir1[5]);
		
		ImageView ivp1=new ImageView(ip0);
		
		ImageView f1 = new ImageView(ip0);
		f1.setVisible(false);
		f1.setImage(EndGame.getImageV());
		ImageView f2 = new ImageView(ip0);
		f2.setVisible(false);
		f2.setImage(EndGame.getImageV());
		
		f1.setX(100); f1.setY(50);
		f2.setX(840); f2.setY(50);
		String dir2[]= new String[6];
		for (cont=0;cont<6;cont++) {
			dir2[cont]=Personaje.direcciones(2,cont);
			}
	
		Image ie0=new Image(dir2[0]);
		Image ie1=new Image(dir2[1]);
		Image ie2=new Image(dir2[2]);
		Image ie3=new Image(dir2[3]);
		Image ie4=new Image(dir2[4]);
		Image ie5=new Image(dir2[5]);
		
		ImageView ivp2=new ImageView(ie0);
			
		for (cont=0;cont<9;cont++) {
		dir[cont]=Carta.direcciones(cont);
		icarta[cont]=new Image(dir[cont]);
		ivcarta[cont]=new ImageView(icarta[cont]);
		}
		ivp1.setX(250);ivp1.setY(470);
		ivp2.setX(875);ivp2.setY(443);
		Image pasar = new Image("res/cartas/btt.png");
		ImageView pst= new ImageView(pasar);
		a=Wcore.rng(3);
		b=3+Wcore.rng(3);
		c=6+Wcore.rng(3);
		
	    HBox cartas = new HBox();
		Button carta1 = new Button(baraja[a].nombre,ivcarta[a]);
		carta1.setContentDisplay(ContentDisplay.TOP);
		Button carta2 = new Button(baraja[b].nombre,ivcarta[b]);
		carta2.setContentDisplay(ContentDisplay.TOP);
		Button carta3 = new Button(baraja[c].nombre,ivcarta[c]);
		carta3.setContentDisplay(ContentDisplay.TOP);
		Button ps=new Button("",pst);
		carta1.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 25));
		carta2.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 25));
		carta3.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 25));
		
		
	Text vidap1 = new Text("Vida ="+p1.getVida()+"/25");
	vidap1.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));
	vidap1.setFill(Color.WHITE);
	vidap1.setStroke(Color.BLACK);
	vidap1.setTranslateX(220);
	vidap1.setTranslateY(420);
	vidap1.isFocused();
	vidap1.toFront();
	
Text vidap2 = new Text("Vida ="+p2.getVida()+"/25");
	vidap2.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));
	vidap2.setFill(Color.WHITE);
	vidap2.setStroke(Color.BLACK);
	vidap2.setTranslateX(830);
	vidap2.setTranslateY(420);
	
	Text ep1 = new Text("Defensa ="+p1.getDefensa()+"/15");
	ep1.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 37));
	ep1.setFill(Color.CYAN);
	ep1.setStroke(Color.BLACK);
	ep1.setTranslateX(80);
	ep1.setTranslateY(500);
	ep1.isFocused();
	ep1.toFront();
	
Text ep2 = new Text("Defensa ="+p2.getDefensa()+"/15");
	ep2.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 37));
	ep2.setFill(Color.CYAN);
	ep2.setStroke(Color.BLACK);
	ep2.setTranslateX(1000);
	ep2.setTranslateY(500);
	
	
		ps.setOnMouseClicked(e ->{	
		
			Wcore.sonido("sonido/t.wav",10,1);
			
			end.setAsd(Wcore.inversor(end.getAsd()));
			System.out.print(end.getAsd());
			if(p2.getDefensa()>0) {
				ivp2.setImage(ie5);
				}
			if(p2.getDefensa()<=0) {
				ivp2.setImage(ie0);
				}
			if(p1.getDefensa()>0) {
				ivp1.setImage(ip5);
				}
			if(p1.getDefensa()<=0) {
				ivp1.setImage(ip0);
				}
			
			
			
			ivp2.setX(875);ivp2.setY(443);
			 Carta.cambiarCartas(carta1, carta2, carta3, ivcarta);
			 Personaje.mostrar2(p1,p2);
			 Personaje.inversor(p1);
			 Personaje.inversor(p2);
			turno1.setVisible(p1.getTurno());
			turno2.setVisible(p2.getTurno());
			
			 
		});
		carta1.setOnMouseClicked(e ->{	
			
			
			Wcore.sonido("sonido/a.wav",10,1);
			if (p1.getTurno()==true) {
				Personaje.rDa( p2, p1 ,carta1.getText());
				ivp1.setImage(ip1);
				ivp2.setImage(ie4);
				ivp2.setX(875);ivp2.setY(443);
			}
			
			if (p2.getTurno()==true) {
				Personaje.rDa( p1, p2 ,carta1.getText()); 
				ivp1.setImage(ip4);
				ivp2.setImage(ie1);
				ivp2.setX(790);ivp2.setY(410);
			}
			Personaje.inversor(p1);
			Personaje.inversor(p2);
			turno1.setVisible(p1.getTurno());
			turno2.setVisible(p2.getTurno());
			Carta.cambiarCartas(carta1, carta2, carta3, ivcarta);
			 Personaje.mostrar2(p1,p2);
			  
			vidap1.setText("Vida ="+(p1.getVida())+"/25");
			vidap2.setText("Vida ="+(p2.getVida())+"/25");
			 ep2.setText("Defensa ="+(p2.getDefensa())+"/15");
			 ep1.setText("Defensa ="+(p1.getDefensa())+"/15");
			 
			if (p1.getVida()<=0) {
				victoria2.setVisible(true);
				
				if (end.getAsd()==true) {
			f2.setImage(EndGame.getImageV());
			f1.setImage(EndGame.getImageD());
			f1.setVisible(true);
			f2.setVisible(true);}
				cartas.setVisible(false);
				turno1.setVisible(false);
				turno2.setVisible(false);
				Wcore.sonido("sonido/end.wav",10,1);}
			if (p2.getVida()<=0) {
				victoria1.setVisible(true);
				if (end.getAsd()==true) {
			f1.setImage(EndGame.getImageV());
			f2.setImage(EndGame.getImageD());
			f1.setVisible(true);
			f2.setVisible(true);
			}
				cartas.setVisible(false);
				turno1.setVisible(false);
				turno2.setVisible(false);
				Wcore.sonido("sonido/end.wav",10,1);
				}
		});
		carta2.setOnMouseClicked(e ->{	
			ivp2.setX(875);ivp2.setY(443);
			Wcore.sonido("sonido/s.wav",10,1);
			if (p1.getTurno()==true) {
				Personaje.rDef( p1, p2 ,carta2.getText());
				if(p2.getDefensa()>0) {
					ivp2.setImage(ie5);
					}
					else {
						ivp2.setImage(ie0);
					}
				ivp1.setImage(ip2);
			}
			
			if (p2.getTurno()==true) {
				Personaje.rDef( p2, p1 ,carta2.getText());
				if(p1.getDefensa()>0) {
				ivp1.setImage(ip5);
				}
				else {
					ivp1.setImage(ip0);
				}
				ivp2.setImage(ie2);
			}
			
			Personaje.inversor(p1);
			Personaje.inversor(p2);
			turno1.setVisible(p1.getTurno());
			turno2.setVisible(p2.getTurno());
			Carta.cambiarCartas(carta1, carta2, carta3, ivcarta);
			 Personaje.mostrar2(p1,p2);
			 vidap2.setText("Vida ="+(p2.getVida())+"/25");
			 vidap1.setText("Vida ="+(p1.getVida())+"/25");
			 ep2.setText("Defensa ="+(p2.getDefensa())+"/15");
			 ep1.setText("Defensa ="+(p1.getDefensa())+"/15");
			 
		});
		carta3.setOnMouseClicked(e ->{	
			ivp2.setX(875);ivp2.setY(443);
			Wcore.sonido("sonido/c.wav",10,1);
			
			if (p1.getTurno()==true) {
				Personaje.rC( p1, p2 ,carta3.getText());
				if(p2.getDefensa()>0) {
					ivp2.setImage(ie5);
					}
					else {
						ivp2.setImage(ie0);
					}
				ivp1.setImage(ip3);
			}
			if (p2.getTurno()==true) {
				Personaje.rC( p2, p1 ,carta3.getText());
				if(p1.getDefensa()>0) {
					ivp1.setImage(ip5);
					}
					else {
						ivp1.setImage(ip0);
					}
					ivp2.setImage(ie3);
				}
				
			Personaje.inversor(p1);
			Personaje.inversor(p2);
			turno1.setVisible(p1.getTurno());
			turno2.setVisible(p2.getTurno());
			Carta.cambiarCartas(carta1, carta2, carta3, ivcarta);
			 Personaje.mostrar2(p1,p2);
			 ep2.setText("Defensa ="+(p2.getDefensa())+"/15");
			 ep1.setText("Defensa ="+(p1.getDefensa())+"/15");
			 
			 vidap2.setText("Vida ="+(p2.getVida())+"/25");
			 vidap1.setText("Vida ="+(p1.getVida())+"/25");
		});

		cartas.setLayoutX(190);cartas.setLayoutY(65);
		cartas.getChildren().addAll(carta1, carta2,carta3,ps);
		Pane root = new Pane();
        root.setPrefSize(1200,700);
        MenuItem back = new MenuItem("ATRAS");
		back.setTranslateY(6);
		
		back.setOnMouseReleased(e ->{
			ivp2.setX(875);ivp2.setY(443);
			turno1.setVisible(p1.getTurno());
			turno2.setVisible(p2.getTurno());
			cartas.setVisible(true);
			victoria1.setVisible(false);
			victoria2.setVisible(false);
			end.setAsd(false);
			p1.setVida(25);
			p2.setVida(25);
			p1.setDefensa(0);
			p2.setDefensa(0);
			ivp1.setImage(ip0);
			ivp2.setImage(ie0);
			f2.setVisible(false);
			f1.setVisible(false);
			 vidap2.setText("Vida ="+(p2.getVida())+"/25");
			 vidap1.setText("Vida ="+(p1.getVida())+"/25");
			 ep2.setText("Defensa ="+(p2.getDefensa())+"/15");
			 ep1.setText("Defensa ="+(p1.getDefensa())+"/15");
			music.play();
			music2.stop();
			primaryStage.setScene(tittleScreen);});
	
	    	Image arena= new Image("res/fondo.gif");
            ImageView img = new ImageView(arena);
            img.setFitWidth(1200);
            img.setFitHeight(700);
        root.getChildren().addAll(img,ivp2,br1,cartas,back,vidap1,vidap2,ep1,ep2,ivp1,turno1,turno2,victoria2,victoria1,f1,f2);
        return root;
	
	}




////////////////////////////////////////////////////////////////////////////////
	private static Parent OpcionesContent(Stage primaryStage) {
		Pane root = new Pane();
		root.setPrefSize(1200, 700);

		Image opc=new Image ("res/opciones.gif");
		ImageView img = new ImageView(opc);
		img.setFitWidth(1200);
		img.setFitHeight(700);
		root.getChildren().add(img);

		Alert alertAyuda = new Alert(Alert.AlertType.INFORMATION);
		alertAyuda.setHeaderText("INFORMACION DE OPCIONES");
		alertAyuda.setContentText("Sonido: Ajuste al audio para el usuario" + "\nCreditos: Los creadores del proyecto");
		alertAyuda.setHeight(200);

		Alert alertaCreditos = new Alert(Alert.AlertType.INFORMATION);
		alertaCreditos.setHeaderText("Robledo Lopez Alan Omar.\n" + "Lizarraga Rodriguez Jesus Alberto.");
		alertaCreditos.setContentText("PM Theme musica de fondo.\n");
		alertAyuda.setHeight(200);

		Tittle tittle = new Tittle("O P C I O N E S");
		tittle.setTranslateX(75);
		tittle.setTranslateY(200);

		MenuItem sonido = new MenuItem("SONIDO");
		MenuItem creditos = new MenuItem("CREDITOS");
		MenuItem2 nada = new MenuItem2("NADA");
		MenuItem2 bajo = new MenuItem2("BAJO");
		MenuItem2 medio = new MenuItem2("MEDIO");
		MenuItem2 alto = new MenuItem2("ALTO");
		alto.bg.setFill(Color.RED);

		MenuItem listo = new MenuItem("LISTO");
		listo.setTranslateX(440);
		listo.setTranslateY(550);
		listo.setVisible(false);

		MenuBox vbox = new MenuBox(sonido, creditos);
		vbox.setTranslateX(140);
		vbox.setTranslateY(350);

		MenuBox2 vboxVol = new MenuBox2(nada, bajo, medio, alto);
		vboxVol.setTranslateX(440);
		vboxVol.setTranslateY(350);
		vboxVol.setVisible(false);

		listo.setOnMouseReleased(event -> {
			listo.setVisible(false);
			vboxVol.setVisible(false);
			if (nada.bg.getFill() == Color.RED) {
				music.stop();
				
			}
			if (bajo.bg.getFill() == Color.RED) {
				music.stop();
				music.setCycleCount(AudioClip.INDEFINITE);
				music.setVolume(0.15);
				music2.setVolume(0.15);
				music.play();
			}
			if (medio.bg.getFill() == Color.RED) {
				music.stop();
				music.setCycleCount(AudioClip.INDEFINITE);
				music.setVolume(0.55);
				music2.setVolume(0.55);
				music.play();
			}
			if (alto.bg.getFill() == Color.RED) {
				music.stop();
				music.setCycleCount(AudioClip.INDEFINITE);
				music.setVolume(1.0);
				music2.setVolume(1.0);
				music.play();
			}
		});

		sonido.setOnMouseReleased(event -> {
			vboxVol.setVisible(true);
			listo.setVisible(true);
		});

		nada.setOnMouseReleased(event -> {
			if (bajo.bg.getFill() == Color.RED || medio.bg.getFill() == Color.RED || alto.bg.getFill() == Color.RED) {
				bajo.bg.setFill(Color.TRANSPARENT);
				medio.bg.setFill(Color.TRANSPARENT);
				alto.bg.setFill(Color.TRANSPARENT);
			}
		});
		bajo.setOnMouseReleased(event -> {
			if (nada.bg.getFill() == Color.RED || medio.bg.getFill() == Color.RED || alto.bg.getFill() == Color.RED) {
				nada.bg.setFill(Color.TRANSPARENT);
				medio.bg.setFill(Color.TRANSPARENT);
				alto.bg.setFill(Color.TRANSPARENT);
			}
		});
		medio.setOnMouseReleased(event -> {
			if (bajo.bg.getFill() == Color.RED || nada.bg.getFill() == Color.RED || alto.bg.getFill() == Color.RED) {
				bajo.bg.setFill(Color.TRANSPARENT);
				nada.bg.setFill(Color.TRANSPARENT);
				alto.bg.setFill(Color.TRANSPARENT);
			}
		});
		alto.setOnMouseReleased(event -> {
			if (bajo.bg.getFill() == Color.RED || medio.bg.getFill() == Color.RED || nada.bg.getFill() == Color.RED) {
				bajo.bg.setFill(Color.TRANSPARENT);
				medio.bg.setFill(Color.TRANSPARENT);
				nada.bg.setFill(Color.TRANSPARENT);
			}
		});
		creditos.setOnMouseReleased(event -> alertaCreditos.showAndWait());

		MenuItem ayuda = new MenuItem("AYUDA");
		ayuda.setOnMouseReleased(event -> alertAyuda.showAndWait());

		MenuItem back = new MenuItem("ATRAS");
		back.setTranslateY(660);
		back.setOnMouseReleased(e -> primaryStage.setScene(tittleScreen));

		root.getChildren().addAll(tittle, vbox, vboxVol, ayuda, listo, back);
		return root;
	}

	private static class Tittle extends StackPane {
		Tittle(String name) {
			Rectangle bg = new Rectangle(300, 60);
			bg.setStroke(Color.WHITE);
			bg.setStrokeWidth(2);
			bg.setFill(null);

			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
		}
		
	}

	private static class MenuBox extends VBox {
		MenuBox(MenuItem... items) {
			getChildren().add(createSeparator());

			for (MenuItem item : items) {
				getChildren().addAll(item, createSeparator());
			}
		}

		private Line createSeparator() {
			Line sep = new Line();
			sep.setEndX(175);
			sep.setStroke(Color.DARKGRAY);
			return sep;
		}
	}

	private static class MenuBox2 extends VBox {
		MenuBox2(MenuItem2... items) {
			getChildren().add(createSeparator());

			for (MenuItem2 item : items) {
				getChildren().addAll(item, createSeparator());
			}
		}

		private Line createSeparator() {
			Line sep = new Line();
			sep.setEndX(175);
			sep.setStroke(Color.DARKGRAY);
			return sep;
		}
	}

	public static class MenuItem extends StackPane {
		MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.RED),
					new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK), new Stop(1, Color.RED));

			Rectangle bg = new Rectangle(175, 40);
			bg.setOpacity(0.4);

			Text text = new Text(name);
			text.setFill(Color.DARKGRAY);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);

			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});

			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.DARKGRAY);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.RED);
			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});
		}
	}

	private static class MenuItem2 extends StackPane {
		Rectangle bg;

		MenuItem2(String name) {

			bg = new Rectangle(175, 40);
			bg.setOpacity(0.4);

			Text text = new Text(name);
			text.setFill(Color.DARKGRAY);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
			bg.setFill(Color.TRANSPARENT);

			setOnMousePressed(event -> {
				if (bg.getFill() == Color.TRANSPARENT) {
					bg.setFill(Color.RED);
				} else {
					bg.setFill(Color.TRANSPARENT);
				}
			});
		}

	}
	
	

	private static class SelectMusic {
		int seleccion = 0;
		
		void seleccionM() {
			seleccion = (int) Math.floor(Math.random() * 1);
			if (seleccion == 0)
				try {
					
				music = new AudioClip(this.getClass().getResource("TES_V_Skyrim_Soundtrack.wav").toString());
			
				
				}
			catch (Exception tipoerror) 
			{
				System.out.println("" + tipoerror);
			}
			
				
		}
	}
	private static class SelectMusic2 {
		int seleccion = 0;
	
		void seleccionM() {
			seleccion = (int) Math.floor(Math.random() * 1);
			if (seleccion == 0)
			
			
				try {
				music2 = new AudioClip(this.getClass().getResource("The_Untold.wav").toString());
				}
				catch (Exception tipoerror) 
				{
					System.out.println("" + tipoerror);
				}
				
		}
	}


	void iniciaInterfaz(Stage primaryStage) {
		tittleScreen = new Scene(TittleContent(primaryStage));
		soloScreen = new Scene(SoloContent(primaryStage));
		opcionesScreen = new Scene(OpcionesContent(primaryStage));
		primaryStage.setTitle("CARTAS MEDIEVALES");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(tittleScreen);
		primaryStage.show();
		SelectMusic selectMusic = new SelectMusic();
		SelectMusic2 selectMusic2 = new SelectMusic2();
		selectMusic.seleccionM();
		selectMusic2.seleccionM();
		music.setCycleCount(AudioClip.INDEFINITE);
		music2.setCycleCount(AudioClip.INDEFINITE);
		music.play();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
				exit(0);
			}
		});
	}
	}

	

	
