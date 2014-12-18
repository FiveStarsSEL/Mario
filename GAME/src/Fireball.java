import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Fireball {
	
	private int x, y;
	private Image fireballImg;
	boolean visible;
	
	public Fireball(int startX, int startY){
		x=startX;
		y=startY;
		ImageIcon image1=new ImageIcon("SMario/fireball.png");
		fireballImg=image1.getImage();
		visible=true;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 8, 8);
	}
	
	public void move(){
		x=x+2;
		if(x>500)
			visible=false;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean getVisible(){
		return visible;
	}
	
	public Image getImage(){
		return fireballImg;
	}

}
