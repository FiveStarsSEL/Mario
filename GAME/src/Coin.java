import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Coin{
	
	private Image coin;
	private int x, y;
	public boolean isCoin=true;

	public Coin(int startX, int startY, String image){
		x=startX;
		y=startY;
		ImageIcon image1=new ImageIcon(image);
		coin=image1.getImage();
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
	
	public boolean getCoin(){
		return isCoin;
	}
	
	public Image getImage(){
		return coin;
	}
	
	public void move(int dx, int left){
		if(dx==1 && !((left+dx)<75))
			x=x-dx;
	}
}
