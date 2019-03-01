package application;

import java.util.*;
import java.io.*; 
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Wcore
{

	public static void sonido(String direccion,int temp ,int eleccion)//sonido 
	{
	try {
		if (eleccion ==1) {
		//String soundName = "yourSound.wav";    
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(direccion).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		Thread.sleep(temp);
		}
		if (eleccion ==0) {
			Clip sonido = AudioSystem.getClip();
			File a = new File(direccion);
			sonido.open(AudioSystem.getAudioInputStream(a));;
			sonido.start();

			Thread.sleep(temp);
			sonido.close();}
		}
		catch (Exception tipoerror) 
		{
			System.out.println("" + tipoerror);
		}
	}
	
	public static int rng(int dis)
	{
		Random rand = new Random();
		int valor = rand.nextInt(dis);
		
		return valor;
	}
	
public static String leer()//String variable = Wcore.leer();
	{
		String lectura = new String();
		InputStreamReader lectroTeclado = new InputStreamReader (System.in);
		BufferedReader buffer =new BufferedReader(lectroTeclado);
		try 
		{
			lectura = buffer.readLine();
		}catch (IOException IOerror){
			System.out.println("Error al leer el teclado");
			System.out.println(IOerror);
		}
		return lectura;
	}
	
public  static void limpiar(int dis)
		{
			for(int i=1;i<dis;i++)
				System.out.println("\n");
		}
	
	
	
	public static float conviertecadenaF(String cadena)
{
	return Float.parseFloat(cadena);
}

	public static int conviertecadenaI(String cadena)
{
	return Integer.parseInt(cadena);
}
public static String convierteInt(int numero) {
	
	return String.valueOf(numero);
	
	
}	
public static int sum(int a) {
	 a++;
	return a;
}
public static Boolean inversor(Boolean x) {
	x=!x;
	return x;
}
/*
public static void cImagen(ImageView a) {
	String dir1[]= new String[6];
	Image ip1[]=new Image[6];
	ImageView ivp1=new ImageView();
	
	String dir2[]= new String[6];
	Image ip2[]=new Image[6];
	ImageView ivp2=new ImageView();
	
	int cont;
	for (cont=0;cont<6;cont++) {
		dir1[cont]=Personaje.direcciones(1,cont);
		ip1[cont]=new Image(dir1[cont]);
		}
		ivp1=new ImageView(ip1[0]);
		
	for (cont=0;cont<6;cont++) {
		dir2[cont]=Personaje.direcciones(2,cont);
		ip2[cont]=new Image(dir2[cont]);
		}
		ivp2=new ImageView(ip2[3]);
		a=ivp2;
	
}*/
/*
	public void pumpOnce(){
	    p = p + 1;
	    initHeart();
	    //Here goes what ever it takes to make stuff working!!
	    p = p - 1;
	    initHeart();
	}*/
}
