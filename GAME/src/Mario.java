import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Mario {
	
	private int dx;
	public int y;
	private int character;
	private boolean turn=false;
	private Image still;
	private ImageIcon image1=new ImageIcon("SMario/still.png");
	private ImageIcon image2=new ImageIcon("SMario/left.png");
	private ImageIcon image3=new ImageIcon("SMario/jumpr.png");
	private ImageIcon image4=new ImageIcon("SMario/stillg.png");
	private ImageIcon image5=new ImageIcon("SMario/leftg.png");
	private ImageIcon image6=new ImageIcon("SMario/jumprg.png");
	private static ArrayList fireballs;
	public int x, nx2, nx, left, dy;
	public static int fireballNum=0, coin=0, life=2;
	
	public Mario(int charc){
		character=charc;
		if(character==1)
			still= image1.getImage();
		if(character==2)
			still= image4.getImage();
		left=75;
		x=75;
		nx2=585;
		nx=0;
		y=365;
		fireballs=new ArrayList();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(left, y, 16, 26);
	}
	
	public void move(){
		if(dx!=-1){
			if(left+dx<=75)
				left=left+dx;
			else{
				x=x+dx;
				nx2=nx2+dx;
				nx=nx+dx;
			}
		}
		else{
			if(left+dx>0)
				left=left+dx;
		}
	}
	
	public void fire(){
		if(fireballNum>0 && turn==false){
			fireballNum--;
			Fireball fireball=new Fireball(left+16, y+26/2);
			fireballs.add(fireball);
		}
	}
	
	public static ArrayList getFireball(){
		return fireballs;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Image getImage(){
		return still;
	}
	
	public int getdx(){
		return dx;
	}
	
	public int getnX2(){
		return nx2;
	}
	
	public int getLeft(){
		return left;
	}
	
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT){
			dx=-1;
			if(character==1)
				still=image2.getImage();
			if(character==2)
				still=image5.getImage();
			turn=true;
		}
		
		if(key==KeyEvent.VK_RIGHT){
			dx=1;
			if(character==1)
				still=image1.getImage();
			if(character==2)
				still=image4.getImage();
			turn=false;
		}
		if(key==KeyEvent.VK_UP){
			dy=1;
			if(character==1)
				still=image3.getImage();
			if(character==2)
				still=image6.getImage();
		}
		
		if(key==KeyEvent.VK_SPACE)
			fire();
	}
	
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT)
			dx=0;
		if(key==KeyEvent.VK_RIGHT)
			dx=0;
		if(key==KeyEvent.VK_UP){
			dy=-1;
			if(character==1)
				still=image1.getImage();
			if(character==2)
				still=image4.getImage();
		}
		
	}

}
