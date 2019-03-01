package application;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Carta {
	
	public String nombre;
	public int grado;
	public int tipo;
	public int costo;
	public int bonus;
	/*
	daño
	cura
	defensa
	veneno
	esquive
	
	*/
	/*
	debilidad
	veneno
	fuerza extra
	*/
	public Carta(String nombre,int tipo){
		
	}
	public Carta(String nombre, int grado, int tipo , int costo){
		this.nombre=nombre;
		this.grado=grado;
		this.tipo=tipo;
		this.costo=costo;
	}
	public static String direcciones(int i) {
		
	String dir []= new String [9];
	dir[0]="res/cartas/carta0.png";
	dir[1]="res/cartas/carta1.png";
	dir[2]="res/cartas/carta2.png";
	dir[3]="res/cartas/carta3.png";
	dir[4]="res/cartas/carta4.png";
	dir[5]="res/cartas/carta5.png";
	dir[6]="res/cartas/carta6.png";
	dir[7]="res/cartas/carta7.png";
	dir[8]="res/cartas/carta8.png";
		return dir [i];
	}
	
	public static Carta[] consCartas() {
		Carta cartas[]=new Carta[9];
		cartas[0]=new Carta("cuchillo",1,1,1);
		cartas[1]=new Carta("espada",2,1,2);
		cartas[2]=new Carta("hacha",3,1,3);
		cartas[3]=new Carta("Escudo Mk1",1,2,1);
		cartas[4]=new Carta("Escudo Mk2",2,2,2);
		cartas[5]=new Carta("Escudo Mk3",3,2,3);
		cartas[6]=new Carta("Bendaje",1,3,1);
		cartas[7]=new Carta("Botiquin",2,3,2);
		cartas[8]=new Carta("BF Botiquin",3,3,3);
		
		return cartas;
	}
	
public static String nombres(int i) {
	String x[]= new String [9];
	x[0]="cuchillo";
	x[1]="espada";
	x[2]="hacha";
	x[3]="Escudo Mk1";
	x[4]="Escudo Mk2";
	x[5]="Escudo Mk3";
	x[6]="Bendaje";
	x[7]="Botiquin";
	x[8]="BF Botiquin";
	return x[i];
}
public static void cambiarCartas (Button carta1, Button carta2, Button carta3 ,ImageView ivcarta[]) {
	int a = Wcore.rng(3);
	int b = 3+Wcore.rng(2);
	int c = 6+Wcore.rng(2);
	int u=Wcore.rng(100);
	carta1.setGraphic(ivcarta[a]);
	carta1.setText(Carta.nombres(a));
	carta2.setGraphic(ivcarta[b]);
	carta2.setText(Carta.nombres(b));
	carta3.setGraphic(ivcarta[c]);
	carta3.setText(Carta.nombres(c));
	
	if (u<5) {
		carta3.setGraphic(ivcarta[8]);
		carta3.setText(Carta.nombres(8));
	}
	
}
	
	
	
	
	
	
/////////////////////////////////////////////////////////////////////
public static int cDamage(Carta carta){
int	efecto =(carta.getGrado()*carta.getGrado());
	return efecto;
}
public static int cDefensa(Carta carta){
int	efecto =(carta.getGrado()*carta.getGrado());
	return efecto;
}
public static int cCura(Carta carta){
int	efecto =(carta.getGrado()*carta.getGrado());
	return efecto;
}
////////////////////////////////////////////////////////////////////
public String getNombre(){
	return nombre;
}
public int getGrado(){
	return grado;
}	
public int getTipo(){
	return tipo;
}
public int getCosto(){
	return costo;
}
public int getBonus(){
	return bonus;
}
public String getTipoS(){
	String tipo=" ";
	if (getTipo()==1){tipo="ataque";}
	if (getTipo()==2){tipo="Defensa";}
	if (getTipo()==3){tipo="Cura";}
	return tipo;
}
public void setNombre(String nombre){
	this.nombre=nombre;
}
public void setGrado(int grado){
	this.grado=grado;
}
public void setTipo(int tipo){
	this.tipo=tipo;
}
public void setCosto(int costo){
	this.costo=costo;
}
public void setBonus(int bonus){
	this.bonus=bonus;
}
/*
public Carta(){
	int a=Wcore.rng(4);
	this.nombre=listaNombres(Wcore.rng(13));
	this.grado=a;
	this.tipo=Wcore.rng(4);
	this.costo=a;
}

public String listaNombres(int n){
	String nombres[]= new String[13];
	nombres[0]="Golpeunico";
	nombres[1]="Martillo";
	nombres[2]="clash";
	nombres[3]="Espada";
	nombres[4]="Destino";
	nombres[5]="Spear";
	nombres[6]="Karambit";
	nombres[7]="Hacha";
	nombres[8]="daga";
	nombres[9]="Arco";
	nombres[10]="Roca";
	nombres[11]="Havoc";
	nombres[12]="IronWave";
	return nombres[n];
	
	
}


public void mostrarCarta(){
System.out.println("////////////////////////////////////////////////////////////");
	System.out.println("//////Carta Selecionada///////////////////////");
System.out.println("Nombre "+getNombre());
System.out.println("Grado "+getGrado());
System.out.println("tipo "+getTipo()+" "+getTipoS());
System.out.println("costo: "+getCosto());
	System.out.println("///////////////////////////////////////////////////////");
}

public static void mostrarCarta3(Carta x[]){
System.out.println("/////////////////////////////////////////////////////////////////////////");	
System.out.println("///////////////////Seleccione una Carta//////////////");	
System.out.println("carta 1		carta 2			carta 3");
System.out.println("Nombre "+x[0].getNombre()+"	Nombre "+x[1].getNombre()+"	Nombre "+x[2].getNombre());
System.out.println("Grado: "+x[0].getGrado()+"	Grado: "+x[1].getGrado()+"	Grado: "+x[2].getGrado());
System.out.println("tipo: "+x[0].getTipoS()+"	tipo: "+x[1].getTipoS()+"	tipo: "+x[2].getTipoS());
System.out.println("costo: "+x[0].getCosto()+"	costo: "+x[1].getCosto()+"	costo: "+x[2].getCosto());
	System.out.println("//////////////////////////////////////////////////////////////////");
}


public static void cEfecto(Personaje a,Personaje b,Carta carta){
int efecto=0;
carta.mostrarCarta();
if (carta.tipo==1){
efecto=cDamage(carta);
if (efecto>=b.getDefensa()){
	efecto=efecto-b.getDefensa();
	b.setDefensa(0);
	b.setVida(b.getVida()-efecto);
	}
if (efecto<=b.getDefensa()){
	b.setDefensa(b.getDefensa()-efecto);
	}
}
if (carta.tipo==2){
efecto=cDefensa(carta);
a.setDefensa(efecto);
}
if (carta.tipo==3){
efecto=cCura(carta);
a.setVida(a.getVida()+efecto);
}	
}*/

}