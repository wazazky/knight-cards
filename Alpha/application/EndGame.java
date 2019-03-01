package application;

import javafx.scene.image.Image;

public class EndGame {
private boolean asd;

public EndGame () {
	this.asd=false;
}
	public static Image getImageV() {
		int r;
		r=Wcore.rng(4);
		Image imageV[]=new Image[5];
		imageV[0]=new Image ("res/cartas/v1.gif");
		imageV[1]=new Image ("res/cartas/v2.gif");
		imageV[2]=new Image ("res/cartas/v3.gif");
		imageV[3]=new Image ("res/cartas/v4.gif");
		imageV[4]=new Image ("res/cartas/v5.gif");
		return imageV[r];
	}
	
	public static Image getImageD() {
		int r;
		r=Wcore.rng(6);
		Image imageD[]=new Image[6];
		imageD[0]=new Image("res/cartas/d1.gif");
		imageD[1]=new Image("res/cartas/d2.gif");
		imageD[2]=new Image("res/cartas/d3.gif");
		imageD[3]=new Image("res/cartas/d4.gif");
		imageD[4]=new Image("res/cartas/d5.gif");
		imageD[5]=new Image("res/cartas/d6.gif");
		return imageD[r];
	}
	public boolean getAsd() {
		return asd;
	}
	public void setAsd(boolean asd) {
		this.asd = asd;
	}
 

}
