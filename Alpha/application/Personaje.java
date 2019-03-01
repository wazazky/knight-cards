package application;


public class Personaje {
	public String nombre;
	public int vida;
	public int defensa;
	public int pa;//puntos de accion
	public  Boolean turno;
	
	
	public Personaje (String nombre,int vida,boolean turno){
		this.nombre=nombre;
		this.vida=vida;
		this.defensa=0;
		this.pa=3;
		this.turno=turno;
	}
	public  void mostrar(){
		System.out.println ("Nombre; "+getNombre());
		System.out.println ("Vida; "+getVida());
		System.out.println ("Defensa; "+getDefensa());
		System.out.println ("Puntos de accion; "+getPa());
	}
	public static  void mostrar2(Personaje a,Personaje b){
		System.out.println ("");
		System.out.println ("Nombre; "+a.getNombre()+"		Nombre; "+b.getNombre());
		System.out.println ("Vida; "+a.getVida()+"		Vida; "+b.getVida());
		System.out.println ("Defensa; "+a.getDefensa()+"		Defensa; "+b.getDefensa());
		System.out.println ("Puntos de accion; "+a.getPa()+"	Puntos de accion; "+b.getPa());
		System.out.println ("Turno "+a.getTurno()+"		Turno "+b.getTurno());
		System.out.println ("");
	}
	//getters
public String getNombre(){
	return nombre;
}
public int getVida(){
	return vida;
}
public int getDefensa(){
	return defensa;
}
public int getPa(){
	return pa;
}
public Boolean getTurno() {
	return turno;
}
	//setters
public void setNombre(String nombre){
	this.nombre=nombre;
}
public void setVida(int vida){
	this.vida=vida;
}
public void setDefensa(int defensa){
	this.defensa=defensa;
}
public void setPa(int pa){
	this.pa=pa;
}	
public void setTurno(Boolean turno) {
	this.turno=turno;
}
public static void inversor(Personaje x) {
      if (x.getTurno()==true){
    	  x.setTurno(false);
    	  return ;
      }
      if (x.getTurno()==false){
    	  x.setTurno(true);
    	  return ;
      }
}

public static String  direcciones(int p,int i) {
	String x[]=new String[6];

	if (p==1) {
		
		x[0]="res/p/i.gif";
		x[1]="res/p/a.gif";
		x[2]="res/p/s.gif";
		x[3]="res/p/c.gif";
		x[4]="res/p/h.gif";
		x[5]="res/p/is.gif";
	}
	if (p==2) {
		x[0]="res/e/i.gif";
		x[1]="res/e/a.gif";
		x[2]="res/e/s.gif";
		x[3]="res/e/c.gif";
		x[4]="res/e/h.gif";
		x[5]="res/e/is.gif";
	}
	return x[i];
} 
	
public static void rDa(Personaje a ,Personaje b,String x){// recibir daño
	 Carta baraja[]=new Carta[9];
	  baraja=Carta.consCartas();
	  int efecto ;
	
	  if (x.equals(baraja[0].nombre)) {
		  b.setPa(b.getPa()-1); 
		  efecto = Carta.cDamage(baraja[0]);
		  if (efecto>=a.getDefensa()){
				efecto=efecto-a.getDefensa();
				a.setDefensa(0);
				a.setVida(a.getVida()-efecto);
				}
			if (efecto<=a.getDefensa()){
				a.setDefensa(a.getDefensa()-efecto);
				}
			}
	  if (x.equals(baraja[1].nombre)) {
		  b.setPa(b.getPa()-2); 
		  efecto = Carta.cDamage(baraja[1]);
		  if (efecto>=a.getDefensa()){
				efecto=efecto-a.getDefensa();
				a.setDefensa(0);
				a.setVida(a.getVida()-efecto);
				}
			if (efecto<=a.getDefensa()){
				a.setDefensa(a.getDefensa()-efecto);
				}
	  			}
			  if (x.equals(baraja[2].nombre)) {
				  b.setPa(b.getPa()-3); 
				  efecto = Carta.cDamage(baraja[2]);
				  if (efecto>=a.getDefensa()){
						efecto=efecto-a.getDefensa();
						a.setDefensa(0);
						a.setVida(a.getVida()-efecto);
						}
					if (efecto<=a.getDefensa()){
						a.setDefensa(a.getDefensa()-efecto);
						}
					}
			  }
public static void rC(Personaje a ,Personaje b ,String x){// recibir cura
	 Carta baraja[]=new Carta[9];
	  baraja=Carta.consCartas();
	  if(x.equals(baraja[6].nombre)){
			a.setVida(a.getVida()+Carta.cCura(baraja[6]));  a.setPa(a.getPa()-1); 
	  }
	  if(x.equals(baraja[7].nombre)){
			a.setVida(a.getVida()+Carta.cCura(baraja[7])); a.setPa(a.getPa()-2);
	  }
	  if(x.equals(baraja[8].nombre)){
			a.setVida(a.getVida()+Carta.cCura(baraja[8]));	  a.setPa(a.getPa()-3);
	  }
	  if (a.getVida()>25) {
		  a.setVida(25);
	  }		
}

public static void rDef(Personaje a ,Personaje b ,String x){// recibir defensa
	 Carta baraja[]=new Carta[9];
	  baraja=Carta.consCartas();
	  if(x.equals(baraja[3].nombre)){
			a.setDefensa(a.getDefensa()+Carta.cDefensa(baraja[3]));	  a.setPa(a.getPa()-1);
	  }
	  if(x.equals(baraja[4].nombre)){
			a.setDefensa(a.getDefensa()+Carta.cDefensa(baraja[4]));	 a.setPa(a.getPa()-2);
	  }
	  if(x.equals(baraja[5].nombre)){
			a.setDefensa(a.getDefensa()+Carta.cDefensa(baraja[5]));		  a.setPa(a.getPa()-3);
	  }
	  if (a.getDefensa()>15) {
		  a.setDefensa(15);
	  }
}

}
/*
	public static void main(String[] args){
	
		Personaje a =new Personaje("Flash",24);
		Personaje b =new Personaje("Venom",24);
		
		mostrar2(a,b);
	}*/

