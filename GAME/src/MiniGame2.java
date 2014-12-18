import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;

public class MiniGame2 extends JFrame implements ActionListener{
	
	private Mario mario;
	private int CHARC;
	
	private int r,g,b;
	private int timeRemaining = 0;
	private int countDownTime = 60;
	private int i=1;
	private int score=0;
	private static String Randword = "            ";
	static Random rand = new Random();
	private Timer countdownTimer;
	private Timer countdownTimer2;
	
	private JPanel pInstr = new JPanel();
	private JPanel pWord = new JPanel();
	private JLabel lWord = new JLabel(Randword);
	private JLabel lTitle = new JLabel(new ImageIcon("SMario/minigameW.png"));
	private JLabel lTime = new JLabel("                     Time Remaining = " + String.valueOf(countDownTime));
	private JLabel lAns = new JLabel();
	private JLabel lScore = new JLabel("                                Score = " + score);
	private JButton click = new JButton("Hit me when color matches word!", new ImageIcon("SMario/jumpr.png"));
	private JLabel lLine = new JLabel(new ImageIcon("SMario/line4.png"));
	private JLabel lLine2 = new JLabel(new ImageIcon("SMario/line3.png"));
	
	public MiniGame2(int charc)
	{
		CHARC=charc;
		mario=new Mario(charc);
		
		setContentPane(new JLabel(new ImageIcon("SMario/Mario_back2.jpg")));
		setTitle("Mario");
		setResizable(false);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(3,1));
		
		lTitle.setFont(new Font("Serif", Font.BOLD, 50));
		lTime.setFont(new Font("Serif", Font.BOLD, 25));
		lTime.setForeground(Color.RED);
		lScore.setFont(new Font("Serif", Font.BOLD, 25));
		
		pInstr.setLayout(new GridLayout(3,1));
		pInstr.setBackground(new Color(0,0,0,0));
		pInstr.add(lTitle);
		pInstr.add(lTime);
		pInstr.add(lScore);
		
		lWord.setFont(new Font("Verdana", Font.BOLD, 50));
		pWord.setBackground(new Color(0,0,0,0));
		pWord.add(lLine);
		pWord.add(lWord);
		pWord.add(lLine2);
		
		lAns.setFont(new Font("Book Antiqua", Font.BOLD, 50));

		click.setBackground(Color.WHITE);
		click.addActionListener(this);
		
		add(pInstr);
		add(pWord);
		add(click);
		
		
		countdownTimer = new Timer(1000, new CountdownTimerListener());
		countdownTimer2 = new Timer(1000, new CountdownTimerListener());
		countdownTimer2.start();
		setRGB();
		refresh();
	}
	
	
	public void setRGB()
	{
		int[] rgb = {0,255};  
		
		r = getRandomRGB(rgb);
		g = getRandomRGB(rgb);
		b = getRandomRGB(rgb);
		
		if(r==255 && g==255 && b==255)
			setRGB();
		else
		{
			Color randomColor = new Color(r, g, b);
			lWord.setForeground(randomColor);
		}
	}
	
	static int getRandomRGB(int[] arr) 
	{          
		int rdm = rand.nextInt(arr.length);  
		return arr[rdm];  
	} 
	
	static String getRandomWord(String[] arr) 
	{          
		int rdm = rand.nextInt(arr.length);  
		return arr[rdm];  
	} 
	static void setRandWord() 
	{ 
		String[] word = {"BLACK", "BLUE", "RED", "YELLOW", "GREEN", "CYAN", "PURPLE"};  
		Randword = getRandomWord(word);  
	}     
	
	public void refresh()
	{
		countdownTimer.start();
		
		pWord.removeAll();

		setRandWord();
		lWord.setText(Randword);	//set word
		pWord.add(lLine);
		pWord.add(lWord);
		pWord.add(lLine2);
		setRGB();					//set color
		repaint();
	}
	
	public void check() //check answer when clicked
	{
		if(((r==0 && g==0 && b==0) && Randword == "BLACK") || 
				((r==255 && g==0 && b==0) && Randword == "RED") || ((r==0 && g==255 && b==0) && Randword == "GREEN") ||
				((r==0 && g==0 && b==255) && Randword == "BLUE") || ((r==255 && g==255 && b==0) && Randword == "YELLOW") ||
				((r==255 && g==0 && b==255) && Randword == "PURPLE") || ((r==0 && g==255 && b==255) && Randword == "CYAN"))
		{
			score++;
			lAns.setText("Correct!");
			lAns.setForeground(Color.BLACK);
		}
		else
		{
			lAns.setText("Wrong!");
			lAns.setForeground(Color.RED);
		}
	
		pWord.remove(lLine2);
		pWord.remove(lWord);
		pWord.add(lAns);
		pWord.add(lLine2);
		lScore.setText("                                Score = " + score);
		repaint();
	}
	
	public void stop()
	{
		countdownTimer.stop();
		countdownTimer2.stop();
		if(score <= 8)	//if score less than 5
		 {
			int n = JOptionPane.showConfirmDialog(null,
		            "Sorry, you did not score well, deduct 20 coins to enter Level 3?",
		            "Fail", JOptionPane.YES_NO_OPTION);
			
			if(n==0){
		           if(mario.coin>=20){
		        	   mario.coin=mario.coin-20;
		        	   JOptionPane.showMessageDialog(null, "Enter Level 3.");
		        	   dispose();
		        	   new Frame3(CHARC);
		            }
		            else{
		            	JOptionPane.showMessageDialog(null, "Sorry, your coin(s) is less than 20.");
		            	dispose();
		    			new End(CHARC);
		            }
		        }
		        else {
		        	dispose();
	    			new End(CHARC);
		        }
		 }
    	   
    	else
    	{
            mario.fireballNum=mario.fireballNum+5;
			JOptionPane.showMessageDialog(null, "Congratulation, you score more than 5 and 5 fireballs are added to you. Enter Level 3.");
			dispose();
			new Frame3(CHARC);
    	}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==click)
		{
			timeRemaining = 4;
			countDownTime = countDownTime + 3;
			check();
		}
	}
	
	class CountdownTimerListener implements ActionListener 
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  if (--countDownTime >= 0)
	    	  {
	    		  if(--timeRemaining <= 0) 	
		          //if time counting down reach 0
		          {
		        	  i++;		//Question number ++
		        	  countdownTimer.restart();	
		        	  timeRemaining = 0;
		        	  lTime.setText(String.valueOf("                     Time Remaining = " + String.valueOf(countDownTime)));
		        	  refresh();
		          }
	    	  }
	    	  else
	    	  {
	    		  stop();
	          }//end else
	      }//end method
	  }//end CountdownTimerListener
}//end class



	  

