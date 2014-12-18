import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Board1 extends JPanel implements ActionListener, Runnable{
	
	private Mario mario;
	private Enermy e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
	private Mushroom mushroom;
	private Coin c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	private Coin c11, c12, c13, c14, c15, c16, c17, c18, c19, c20;
	private Coin c21, c22, c23, c24, c25, c26, c27, c28, c29, c30;
	private Coin c31, c32, c33, c34, c35, c36, c37, c38, f1, f2;
	private Image background;
	private Timer time;
	private Thread animator;
	private boolean check=false;
	private boolean peak=false;
	private boolean done=false;
	private boolean lost=false;
	private boolean next=false;
	private static Font font=new Font("Serif", Font.BOLD, 20);
	public int value=365;
	private JFrame frame;
	private int CHARC;
	
	public Board1(int charc, JFrame FRAME){
		frame=FRAME;
		CHARC=charc;
		Random rand = new Random();  
		mario=new Mario(charc);
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon image=new ImageIcon("SMario/background1.png");
		background=image.getImage();
		time=new Timer(5, this);
		time.start();
		
		e1=new Enermy(350, 375, "SMario/e1.png");
		e2=new Enermy(450+100, 365, "SMario/e2.png");
		e3=new Enermy(550+200, 365, "SMario/e2.png");
		e4=new Enermy(650+300, 375, "SMario/e1.png");
		e5=new Enermy(750+400, 365, "SMario/e2.png");
		e6=new Enermy(850+500, 365, "SMario/e2.png");
		e7=new Enermy(950+600, 375, "SMario/e1.png");
		e8=new Enermy(1050+700, 375, "SMario/e1.png");
		e9=new Enermy(1150+800,  375, "SMario/e1.png");
		e10=new Enermy(1250+900, 365, "SMario/e2.png");
		
		mushroom=new Mushroom(1700, 375, "SMario/mushroom.png");
		
		c1=new Coin(185, 330, "SMario/coin1.png");
		c2=new Coin(185, 345, "SMario/coin1.png"); 
		c3=new Coin(200, 330, "SMario/coin1.png");
		c4=new Coin(200, 345, "SMario/coin1.png");
		c5=new Coin(215, 330, "SMario/coin1.png");
		c6=new Coin(215, 345, "SMario/coin1.png");
		c7=new Coin(350, 320, "SMario/coin2.png");
		c8=new Coin(366, 320, "SMario/coin2.png");
		c9=new Coin(382, 320, "SMario/coin2.png");
		c10=new Coin(398, 320, "SMario/coin2.png");
		f1=new Coin(414, 320, "SMario/star.png");
		c11=new Coin(585, 330, "SMario/coin1.png");
		c12=new Coin(600, 345, "SMario/coin1.png");
		c13=new Coin(615, 330, "SMario/coin1.png");
		c14=new Coin(630, 345, "SMario/coin1.png");
		c15=new Coin(885, 345, "SMario/coin1.png");
		c16=new Coin(900, 345, "SMario/coin1.png"); 
		c17=new Coin(915, 345, "SMario/coin1.png");
		c18=new Coin(1000, 320, "SMario/coin2.png");
		f2=new Coin(1016, 320, "SMario/star.png");
		c19=new Coin(1032, 320, "SMario/coin2.png");
		c20=new Coin(1064, 320, "SMario/coin2.png");
		c21=new Coin(1096, 320, "SMario/coin2.png");
		c22=new Coin(1255, 330, "SMario/coin1.png");
		c23=new Coin(1248, 345, "SMario/coin1.png");
		c24=new Coin(1263, 345, "SMario/coin1.png");
		c25=new Coin(1315, 330, "SMario/coin1.png");
		c26=new Coin(1315, 345, "SMario/coin1.png");
		c27=new Coin(1330, 330, "SMario/coin1.png");
		c28=new Coin(1330, 345, "SMario/coin1.png");
		c29=new Coin(1446, 320, "SMario/coin2.png");
		c30=new Coin(1462, 320, "SMario/coin2.png");
		c31=new Coin(1478, 320, "SMario/coin2.png");
		c32=new Coin(1550, 345, "SMario/coin1.png");
		c33=new Coin(1566, 345, "SMario/coin1.png");
		c34=new Coin(1650, 345, "SMario/coin1.png");
		c35=new Coin(1666, 329, "SMario/coin1.png");
		c36=new Coin(1682, 313, "SMario/coin1.png");
		c37=new Coin(1698, 329, "SMario/coin1.png");
		c38=new Coin(1714, 345, "SMario/coin1.png");
		f1.isCoin=false;
		f2.isCoin=false;
		
	}
	
	public void actionPerformed(ActionEvent e){
		try {
			checkCollisions();
		} catch (LineUnavailableException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		} catch (IOException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		} catch (UnsupportedAudioFileException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}
		
		ArrayList fireballs=mario.getFireball();
		for(int i=0; i<fireballs.size(); i++){
			Fireball ball=(Fireball)fireballs.get(i);
			if(ball.getVisible()==true)
				ball.move();
			else
				fireballs.remove(i);
		}
		
		mario.move();
		
		if(mario.x>400)
			e1.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			e2.move(mario.getdx(), mario.getLeft());
		if(mario.x>450)
			e3.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			e4.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			e5.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			e6.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			e7.move(mario.getdx(), mario.getLeft());
		if(mario.x>450)
			e8.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			e9.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			e10.move(mario.getdx(), mario.getLeft());
		if(mario.x>400)
			mushroom.move(mario.getdx(), mario.getLeft());
		
		c1.move(mario .getdx(), mario.getLeft());
		c2.move(mario.getdx(), mario.getLeft());
		c3.move(mario.getdx(), mario.getLeft());
		c4.move(mario.getdx(), mario.getLeft());
		c5.move(mario.getdx(), mario.getLeft());
		c6.move(mario.getdx(), mario.getLeft());
		c7.move(mario.getdx(), mario.getLeft());
		c8.move(mario.getdx(), mario.getLeft());
		c9.move(mario.getdx(), mario.getLeft());
		c10.move(mario.getdx(), mario.getLeft());
		c11.move(mario.getdx(), mario.getLeft());
		c12.move(mario.getdx(), mario.getLeft());
		c13.move(mario.getdx(), mario.getLeft());
		c14.move(mario.getdx(), mario.getLeft());
		c15.move(mario.getdx(), mario.getLeft());
		c16.move(mario.getdx(), mario.getLeft());
		c17.move(mario.getdx(), mario.getLeft());
		c18.move(mario.getdx(), mario.getLeft());
		c19.move(mario.getdx(), mario.getLeft());
		c20.move(mario.getdx(), mario.getLeft());
		c21.move(mario.getdx(), mario.getLeft());
		c22.move(mario.getdx(), mario.getLeft());
		c23.move(mario.getdx(), mario.getLeft());
		c24.move(mario.getdx(), mario.getLeft());
		c25.move(mario.getdx(), mario.getLeft());
		c26.move(mario.getdx(), mario.getLeft());
		c27.move(mario.getdx(), mario.getLeft());
		c28.move(mario.getdx(), mario.getLeft());
		c29.move(mario.getdx(), mario.getLeft());
		c30.move(mario.getdx(), mario.getLeft());
		c31.move(mario.getdx(), mario.getLeft());
		c32.move(mario.getdx(), mario.getLeft());
		c33.move(mario.getdx(), mario.getLeft());
		c34.move(mario.getdx(), mario.getLeft());
		c35.move(mario.getdx(), mario.getLeft());
		c36.move(mario.getdx(), mario.getLeft());
		c37.move(mario.getdx(), mario.getLeft());
		c38.move(mario.getdx(), mario.getLeft());
		f1.move(mario.getdx(), mario.getLeft());
		f2.move(mario.getdx(), mario.getLeft());
		
		repaint();
	} 
	
	public void checkCollisions() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		Rectangle r1=e1.getBounds();
		Rectangle r2=e2.getBounds();
		Rectangle r3=e3.getBounds();
		Rectangle r4=e4.getBounds();
		Rectangle r5=e5.getBounds();
		Rectangle r6=e6.getBounds();
		Rectangle r7=e7.getBounds();
		Rectangle r8=e8.getBounds();
		Rectangle r9=e9.getBounds();
		Rectangle r10=e10.getBounds();
		
		ArrayList fireballs=mario.getFireball();
		for(int i=0; i<fireballs.size(); i++){
			Fireball ball=(Fireball)fireballs.get(i);
			Rectangle f1=ball.getBounds();
			if(r1.intersects(f1) && e1.getAlive()){
				e1.isAlive=false;
				ball.visible=false;
			}
			else if(r2.intersects(f1) && e2.getAlive()){
				e2.isAlive=false;
				ball.visible=false;
			}
			else if(r3.intersects(f1) && e3.getAlive()){
				e3.isAlive=false;
				ball.visible=false;
			}
			else if(r4.intersects(f1) && e4.getAlive()){
				e4.isAlive=false;
				ball.visible=false;
			}
			else if(r5.intersects(f1) && e5.getAlive()){
				e5.isAlive=false;
				ball.visible=false;
			}
			else if(r6.intersects(f1) && e6.getAlive()){
				e6.isAlive=false;
				ball.visible=false;
			}
			else if(r7.intersects(f1) && e7.getAlive()){
				e7.isAlive=false;
				ball.visible=false;
			}
			else if(r8.intersects(f1) && e8.getAlive()){
				e8.isAlive=false;
				ball.visible=false;
			}
			else if(r9.intersects(f1) && e9.getAlive()){
				e9.isAlive=false;
				ball.visible=false;
			}
			else if(r10.intersects(f1) && e10.getAlive()){
				e10.isAlive=false;
				ball.visible=false;
			}
		}
		
		Rectangle mush=mushroom.getBounds();
		Rectangle mario1=mario.getBounds();
		Rectangle coin1=c1.getBounds();
		Rectangle coin2=c2.getBounds();
		Rectangle coin3=c3.getBounds();
		Rectangle coin4=c4.getBounds();
		Rectangle coin5=c5.getBounds();
		Rectangle coin6=c6.getBounds();
		Rectangle coin7=c7.getBounds();
		Rectangle coin8=c8.getBounds();
		Rectangle coin9=c9.getBounds();
		Rectangle coin10=c10.getBounds();
		Rectangle coin11=c11.getBounds();
		Rectangle coin12=c12.getBounds();
		Rectangle coin13=c13.getBounds();
		Rectangle coin14=c14.getBounds();
		Rectangle coin15=c15.getBounds();
		Rectangle coin16=c16.getBounds();
		Rectangle coin17=c17.getBounds();
		Rectangle coin18=c18.getBounds();
		Rectangle coin19=c19.getBounds();
		Rectangle coin20=c20.getBounds();
		Rectangle coin21=c21.getBounds();
		Rectangle coin22=c22.getBounds();
		Rectangle coin23=c23.getBounds();
		Rectangle coin24=c24.getBounds();
		Rectangle coin25=c25.getBounds();
		Rectangle coin26=c26.getBounds();
		Rectangle coin27=c27.getBounds();
		Rectangle coin28=c28.getBounds();
		Rectangle coin29=c29.getBounds();
		Rectangle coin30=c30.getBounds();
		Rectangle coin31=c31.getBounds();
		Rectangle coin32=c32.getBounds();
		Rectangle coin33=c33.getBounds();
		Rectangle coin34=c34.getBounds();
		Rectangle coin35=c35.getBounds();
		Rectangle coin36=c36.getBounds();
		Rectangle coin37=c37.getBounds();
		Rectangle coin38=c38.getBounds();
		Rectangle flower1=f1.getBounds();
		Rectangle flower2=f2.getBounds();
		
		if(mario1.intersects(mush) || mario.x>2040)
			next=true;
		
		if(mario1.intersects(coin1) && c1.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c1.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin2) && c2.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c2.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin3) && c3.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c3.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin4) && c4.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c4.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin5) && c5.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c5.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin6) && c6.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c6.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin7) && c7.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c7.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin8) && c8.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c8.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin9) && c9.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c9.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin10) && c10.isCoin==true){
			c10.isCoin=false;
			f1.isCoin=true;
		}
		if(mario1.intersects(coin11) && c11.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c11.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin12) && c12.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c12.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin13) && c13.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c13.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin14) && c14.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c14.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin15) && c15.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c15.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin16) && c16.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c16.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin17) && c17.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c17.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin18) && c18.isCoin==true){
			c18.isCoin=false;
			f2.isCoin=true;
		}
		if(mario1.intersects(coin19) && c19.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c19.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin20) && c20.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c20.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin21) && c21.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c21.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin22) && c22.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c22.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin23) && c23.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c23.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin24) && c24.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c24.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin25) && c25.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c25.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin26) && c26.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c26.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin27) && c27.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c27.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin28) && c28.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c28.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin29) && c29.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c29.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin30) && c30.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c30.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin31) && c31.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c31.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin32) && c32.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c32.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin33) && c33.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c33.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin34) && c34.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c34.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin35) && c35.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c35.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin36) && c36.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c36.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin37) && c37.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c37.isCoin=false;
			mario.coin++;
		}
		if(mario1.intersects(coin38) && c38.isCoin==true){
			File url = new File("SMario/coin.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			c38.isCoin=false;
			mario.coin++;
		}
		
		if(mario1.intersects(flower1) && f1.isCoin==true){
			File url = new File("SMario/fireball.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
			f1.isCoin=false;
			mario.fireballNum=mario.fireballNum+5 ;
		} 
		if(mario1.intersects(flower2) && f2.isCoin==true){
			File url = new File("SMario/fireball.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream( url );
			clip.open(ais);
			clip.start();
		 	f2.isCoin=false;
			mario.fireballNum=mario.fireballNum+5;
		}
		
		if(mario1.intersects(r1) && e1.isAlive==true)
			lost=true;
		if(mario1.intersects(r2) && e2.isAlive==true)
			lost=true;
		if(mario1.intersects(r3) && e3.isAlive==true)
			lost=true;
		if(mario1.intersects(r4) && e4.isAlive==true)
			lost=true;
		if(mario1.intersects(r5) && e5.isAlive==true)
			lost=true;
		if(mario1.intersects(r6) && e6.isAlive==true)
			lost=true;
		if(mario1.intersects(r7) && e7.isAlive==true)
			lost=true;
		if(mario1.intersects(r8) && e8.isAlive==true)
			lost=true;
		if(mario1.intersects(r9) && e9.isAlive==true)
			lost=true;
		if(mario1.intersects(r10) && e10.isAlive==true)
			lost=true;
	
	}
	
	public void paint(Graphics g){
		
		if(lost){
			frame.dispose();
			if(mario.life>=1){
				mario.life--;
				new Frame1(CHARC);
			}
			else
				new End(CHARC);
		}
		
		if(next){
		 	frame.dispose();
			new MiniGame1(CHARC);
		}
		
		if(mario.dy==1 && check==false){
			check=true;
			animator=new Thread(this);
			animator.start();
		}
		
		super.paint(g);
		
		Graphics2D g2d=(Graphics2D) g;
		if((mario.getX()-255)%1600==0)
			mario.nx=0;
		if((mario.getX()-1055)%1600==0)
			mario.nx2=0;
		g2d.drawImage(background, 585-mario.nx2, 0, null);
		if(mario.getX()>=255)
			g2d.drawImage(background, 585-mario.nx, 0, null);
		g2d.drawImage(mario.getImage(), mario.left, value, null);
		if(mario.getdx()==-1){
			g2d.drawImage(background, 585-mario.getnX2(), 0, null);
			g2d.drawImage(mario.getImage(), mario.left, value, null);
		}
		
		ArrayList fireballs=mario.getFireball();
		for(int i=0; i<fireballs.size(); i++){
			Fireball ball=(Fireball)fireballs.get(i);
			g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(), null);
		}
		
		g2d.setFont(font);
		g2d.drawString("Level 1", 10, 20);
		g2d.drawString("Life(s): "+mario.life, 120, 20);
		g2d.drawString("Coin(s): "+ mario.coin, 250, 20);
		g2d.drawString("Fireball(s): "+ mario.fireballNum, 370, 20);
		
		if(mario.x>400)
			if(e1.getAlive()==true)
				g2d.drawImage(e1.getImage(), e1.getX(), e1.getY(), null);
		if(mario.x>400)
			if(e2.getAlive()==true)
				g2d.drawImage(e2.getImage(), e2.getX(), e2.getY(), null);
		if(mario.x>400)
			if(e3.getAlive()==true)
				g2d.drawImage(e3.getImage(), e3.getX(), e3.getY(), null);
		if(mario.x>400)
			if(e4.getAlive()==true)
				g2d.drawImage(e4.getImage(), e4.getX(), e4.getY(), null);
		if(mario.x>400)
			if(e5.getAlive()==true)
				g2d.drawImage(e5.getImage(), e5.getX(), e5.getY(), null);
		if(mario.x>400)
			if(e6.getAlive()==true)
				g2d.drawImage(e6.getImage(), e6.getX(), e6.getY(), null);
		if(mario.x>400)
			if(e7.getAlive()==true)
				g2d.drawImage(e7.getImage(), e7.getX(), e7.getY(), null);
		if(mario.x>400)
			if(e8.getAlive()==true)
				g2d.drawImage(e8.getImage(), e8.getX(), e8.getY(), null);
		if(mario.x>400)
			if(e9.getAlive()==true)
				g2d.drawImage(e9.getImage(), e9.getX(), e9.getY(), null);
		if(mario.x>400)
			if(e10.getAlive()==true)
				g2d.drawImage(e10.getImage(), e10.getX(), e10.getY(), null);
		
		if(c1.getCoin()==true)
			g2d.drawImage(c1.getImage(), c1.getX(), c1.getY(), null);
		if(c2.getCoin()==true)
			g2d.drawImage(c2.getImage(), c2.getX(), c2.getY(), null);
		if(c3.getCoin()==true)
			g2d.drawImage(c3.getImage(), c3.getX(), c3.getY(), null);
		if(c4.getCoin()==true)
			g2d.drawImage(c4.getImage(), c4.getX(), c4.getY(), null);
		if(c5.getCoin()==true)
			g2d.drawImage(c5.getImage(), c5.getX(), c5.getY(), null);
		if(c6.getCoin()==true)
			g2d.drawImage(c6.getImage(), c6.getX(), c6.getY(), null);
		if(c7.getCoin()==true)
			g2d.drawImage(c7.getImage(), c7.getX(), c7.getY(), null);
		if(c8.getCoin()==true)
			g2d.drawImage(c8.getImage(), c8.getX(), c8.getY(), null);
		if(c9.getCoin()==true)
			g2d.drawImage(c9.getImage(), c9.getX(), c9.getY(), null);
		if(c10.getCoin()==true)
			g2d.drawImage(c10.getImage(), c10.getX(), c10.getY(), null);
		if(c11.getCoin()==true)
			g2d.drawImage(c11.getImage(), c11.getX(), c11.getY(), null);
		if(c12.getCoin()==true)
			g2d.drawImage(c12.getImage(), c12.getX(), c12.getY(), null);
		if(c13.getCoin()==true)
			g2d.drawImage(c13.getImage(), c13.getX(), c13.getY(), null);
		if(c14.getCoin()==true)
			g2d.drawImage(c14.getImage(), c14.getX(), c14.getY(), null);
		if(c15.getCoin()==true)
			g2d.drawImage(c15.getImage(), c15.getX(), c15.getY(), null);
		if(c16.getCoin()==true)
			g2d.drawImage(c16.getImage(), c16.getX(), c16.getY(), null);
		if(c17.getCoin()==true)
			g2d.drawImage(c17.getImage(), c17.getX(), c17.getY(), null);
		if(c18.getCoin()==true)
			g2d.drawImage(c18.getImage(), c18.getX(), c18.getY(), null);
		if(c19.getCoin()==true)
			g2d.drawImage(c19.getImage(), c19.getX(), c19.getY(), null);
		if(c20.getCoin()==true)
			g2d.drawImage(c20.getImage(), c20.getX(), c20.getY(), null);
		if(c21.getCoin()==true)
			g2d.drawImage(c21.getImage(), c21.getX(), c21.getY(), null);
		if(c22.getCoin()==true)
			g2d.drawImage(c22.getImage(), c22.getX(), c22.getY(), null);
		if(c23.getCoin()==true)
			g2d.drawImage(c23.getImage(), c23.getX(), c23.getY(), null);
		if(c24.getCoin()==true)
			g2d.drawImage(c24.getImage(), c24.getX(), c24.getY(), null);
		if(c25.getCoin()==true)
			g2d.drawImage(c25.getImage(), c25.getX(), c25.getY(), null);
		if(c26.getCoin()==true)
			g2d.drawImage(c26.getImage(), c26.getX(), c26.getY(), null);
		if(c27.getCoin()==true)
			g2d.drawImage(c27.getImage(), c27.getX(), c27.getY(), null);
		if(c28.getCoin()==true)
			g2d.drawImage(c28.getImage(), c28.getX(), c28.getY(), null);
		if(c29.getCoin()==true)
			g2d.drawImage(c29.getImage(), c29.getX(), c29.getY(), null);
		if(c30.getCoin()==true)
			g2d.drawImage(c30.getImage(), c30.getX(), c30.getY(), null);
		if(c31.getCoin()==true)
			g2d.drawImage(c31.getImage(), c31.getX(), c31.getY(), null);
		if(c32.getCoin()==true)
			g2d.drawImage(c32.getImage(), c32.getX(), c32.getY(), null);
		if(c33.getCoin()==true)
			g2d.drawImage(c33.getImage(), c33.getX(), c33.getY(), null);
		if(c34.getCoin()==true)
			g2d.drawImage(c34.getImage(), c34.getX(), c34.getY(), null);
		if(c35.getCoin()==true)
			g2d.drawImage(c35.getImage(), c35.getX(), c35.getY(), null);
		if(c36.getCoin()==true)
			g2d.drawImage(c36.getImage(), c36.getX(), c36.getY(), null);
		if(c37.getCoin()==true)
			g2d.drawImage(c37.getImage(), c37.getX(), c37.getY(), null);
		if(c38.getCoin()==true)
			g2d.drawImage(c38.getImage(), c38.getX(), c38.getY(), null);
		
		if(f1.getCoin()==true)
			g2d.drawImage(f1.getImage(), f1.getX(), f1.getY(), null);
		if(f2.getCoin()==true)
			g2d.drawImage(f2.getImage(), f2.getX(), f2.getY(), null);
		
		if(mushroom.getAlive()==true)
			g2d.drawImage(mushroom.getImage(), mushroom.getX(), mushroom.getY(), null);
			
	}
	
	private class AL extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			mario.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			mario.keyPressed(e);
		}
	}
		
	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
		beforeTime=System.currentTimeMillis();
		while(done==false){
			cycle();
			timeDiff=System.currentTimeMillis()-beforeTime;
			sleep=10-timeDiff;
			if(sleep<0)
				sleep=2;
			try{
				Thread.sleep(sleep);
			}catch(Exception e){
				
			}
			beforeTime=System.currentTimeMillis();
		}
		done=false;
		peak=false;
		check=false;
	}
	
	public void cycle(){
		if(peak==false){
			value--;
			mario.y=value;
		}
		if(value==320){
			peak=true;
			mario.y=value;
		}
		if(peak==true && value <= 365){
			value++;
			mario.y=value;
			if(value==365)  
				done=true;
		}
	}
}
