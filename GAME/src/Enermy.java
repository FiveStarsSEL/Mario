import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Enermy {
	
	private Image enermy;
	private int x, y;
	public boolean isAlive=true;
	private String imageName;

	public Enermy(int startX, int startY, String image){
		x=startX;
		y=startY;
		imageName=image;
		ImageIcon image1=new ImageIcon(image);
		enermy=image1.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 16, 26);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean getAlive(){
		return isAlive;
	}
	
	public Image getImage(){
		return enermy;
	}
	
	
	
	public void move(int dx, int left){
		if(dx==1 && imageName!="SMario/e4.png" && imageName!="SMario/e3.png")
			x=x-2;
		else if(dx!=1 && imageName!="SMario/e4.png" && imageName!="SMario/e3.png")
			x=x-1 ;
		
		if(dx==1 && imageName=="SMario/e4.png")
			x=x-3;
		else if(dx!=1 && imageName=="SMario/e4.png") 
			x=x-2;
		
		if(dx==1 && imageName=="SMario/e3.png")
			x=x-3;
		else if(dx!=1 && imageName=="SMario/e3.png") 
			x=x-2;
		
	}
}
