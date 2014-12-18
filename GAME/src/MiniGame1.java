import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MiniGame1 extends JFrame implements ActionListener{
	
	private Mario mario;
	private Timer countdownTimer;
	private int timeRemaining = 60;
	private JLabel label1=new JLabel(new ImageIcon("SMario/minigameW.png"));
	private JLabel label2 = new JLabel("Remaining time: "+String.valueOf(timeRemaining)+" seconds");
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel l8;
	private JLabel l9;
	private JLabel l10;
	private int r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, numWin=0;
	private int r11, r12, r13, r14, r15, r16, r17, r18, r19, r20;
	private int a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
	private JButton submit=new JButton("Submit");
	private int CHARC;
	public TextField t1=new TextField(5);
	public TextField t2=new TextField(5);
	public TextField t3=new TextField(5);
	public TextField t4=new TextField(5);
	public TextField t5=new TextField(5);
	public TextField t6=new TextField(5);
	public TextField t7=new TextField(5);
	public TextField t8=new TextField(5);
	public TextField t9=new TextField(5);
	public TextField t10=new TextField(5);

	
       
	public MiniGame1(int charc){
		CHARC=charc;
		mario=new Mario(charc);
		setTitle("Mario");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); 
		setContentPane(new JLabel(new ImageIcon("SMario/miniGame.png")));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		countdownTimer = new Timer(1000, new CountdownTimerListener());
		countdownTimer.start();
		
		JPanel p1=new JPanel(new GridLayout(12,3));
		p1.setBackground(Color.WHITE);
		
		Random random=new Random();
		
		r1=random.nextInt(10)+1;
		r2=random.nextInt(10)+1;
		a1=r1+r2;
		
		r3=random.nextInt(10)+1;
		r4=random.nextInt(10)+1;
		a2=r3-r4;
		
		r5=random.nextInt(50)+1;
		r6=random.nextInt(50)+1;
		a3=r5+r6;
		
		r7=random.nextInt(50)+1;
		r8=random.nextInt(50)+1;
		a4=r7-r8;
		
		r9=random.nextInt(100)+1;
		r10=random.nextInt(100)+1;
		a5=r9-r10;
		
		r11=random.nextInt(100)+1;
		r12=random.nextInt(100)+1;
		a6=r11+r12;
		
		r13=random.nextInt(500)+1;
		r14=random.nextInt(500)+1;
		a7=r13+r14;
		
		r15=random.nextInt(500)+1;
		r16=random.nextInt(500)+1;
		a8=r15+r16;
		
		r17=random.nextInt(1000)+1;
		r18=random.nextInt(1000)+1;
		a9=r17-r18;
		
		r19=random.nextInt(1000)+1;
		r20=random.nextInt(1000)+1;
		a10=r19-r20;
		
		l1=new JLabel(" 1.    "+r1+" + "+r2);
		l2=new JLabel(" 2.    "+r3+" - "+r4);
		l3=new JLabel(" 3.    "+r5+" + "+r6);
		l4=new JLabel(" 4.    "+r7+" - "+r8);
		l5=new JLabel(" 5.    "+r9+" - "+r10);
		l6=new JLabel(" 6.    "+r11+" + "+r12);
		l7=new JLabel(" 7.    "+r13+" + "+r14);
		l8=new JLabel(" 8.    "+r15+" + "+r16);
		l9=new JLabel(" 9.    "+r17+" - "+r18);
		l10=new JLabel("10.   "+r19+" - "+r20);
		
		label1.setFont(new Font("Serif", Font.BOLD, 50));
		label2.setFont(new Font("Serif", Font.BOLD, 25));
		label2.setForeground(Color.RED);
		l1.setFont(new Font("Serif", Font.BOLD, 20));
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		l8.setFont(new Font("Serif", Font.BOLD, 20));
		l9.setFont(new Font("Serif", Font.BOLD, 20));
		l10.setFont(new Font("Serif", Font.BOLD, 20));
		
		
		
		add(label1);
		add(label2);
		p1.add(l1);
		p1.add(new JLabel("          ="));
		p1.add(t1);
		p1.add(l2);
		p1.add(new JLabel("          ="));
		p1.add(t2);
		p1.add(l3);
		p1.add(new JLabel("          ="));
		p1.add(t3);
		p1.add(l4);
		p1.add(new JLabel("          ="));
		p1.add(t4);
		p1.add(l5);
		p1.add(new JLabel("          ="));
		p1.add(t5);
		p1.add(l6);
		p1.add(new JLabel("          ="));
		p1.add(t6);
		p1.add(l7);
		p1.add(new JLabel("          ="));
		p1.add(t7);
		p1.add(l8);
		p1.add(new JLabel("          ="));
		p1.add(t8);
		p1.add(l9);
		p1.add(new JLabel("          ="));
		p1.add(t9);
		p1.add(l10);
		p1.add(new JLabel("          ="));
		p1.add(t10);
		p1.add(new JLabel(""));
		p1.add(new JLabel(""));
		p1.add(new JLabel(""));
		p1.add(new JLabel(""));
		p1.add(submit);
		p1.add(new JLabel(""));
		
		add(p1);
		
		submit.setBackground(Color.WHITE);		
		submit.addActionListener(this);		

		setSize(500,500);
	}
	
	
	public void check() throws InterruptedException{
		if(numWin<8){
			int n = JOptionPane.showConfirmDialog(null,
		            "Sorry, you fail to answer most of the questions, deduct 20 coins to enter Level 2?",
		            "Fail", JOptionPane.YES_NO_OPTION);

		        if(n==0){
		           if(mario.coin>=20){
		        	   mario.coin=mario.coin-20;
		        	   JOptionPane.showMessageDialog(null, "Enter Level 2.");
		        	   dispose();
		        	   new Frame2(CHARC);
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
		else{
			mario.fireballNum=mario.fireballNum+5;
			JOptionPane.showMessageDialog(null, "Congratulation, you had answered most of the questions correctly and 5 fireballs are added to you. Enter Level 2.");
			dispose();
			new Frame2(CHARC);
		}
	}


	public void actionPerformed(ActionEvent e){
		if(e.getSource()==submit){
			timeRemaining=0;
		}
	}
	
	class CountdownTimerListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	         if (--timeRemaining > 0) {
	            label2.setText("Remaining time: "+String.valueOf(timeRemaining)+" seconds");
	         } else {
	            label2.setText("               Time's up!               ");
	            countdownTimer.stop();
	            try{
				    if(a1==Integer.parseInt(t1.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a2==Integer.parseInt(t2.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a3==Integer.parseInt(t3.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a4==Integer.parseInt(t4.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a5==Integer.parseInt(t5.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a6==Integer.parseInt(t6.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a7==Integer.parseInt(t7.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a8==Integer.parseInt(t8.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a9==Integer.parseInt(t9.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try{
				    if(a10==Integer.parseInt(t10.getText())){
						numWin++;
					}
				} catch (NumberFormatException nfe) {
				    // Not a number.
				  }
				
				try {
					check();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         }
	      }
	   }
		
}

	  

