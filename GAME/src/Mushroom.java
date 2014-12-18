import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Mushroom {
	
	private Image mushroom;
	private int x, y;
	public boolean isAlive=true;

	public Mushroom(int startX, int startY, String location){
		x=startX;
		y=startY;
		ImageIcon image1=new ImageIcon(location);
		mushroom=image1.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 16, 16);
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
		return mushroom;
	}
	
	public void move(int dx, int left){
		if(dx==1 && !((left+dx)<75))
			x=x-dx;
	}
}
