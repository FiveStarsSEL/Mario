import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Win extends JFrame implements ActionListener{
	
	private Mario mario;
    private JButton b1 = new JButton ("Yes");
    private JButton b2 = new JButton ("No");
    
	public Win(int charc){
		
		mario=new Mario(charc);
		setTitle("Mario");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); 
		setContentPane(new JLabel(new ImageIcon("SMario/Win.jpg")));
		setLayout(null);
		b1.setBounds(200, 230, 100, 30);
		b2.setBounds(200, 270, 100, 30);
		add(b1);
		add(b2);
		
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setSize(500,500);
	} 
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			try {
				mario.coin=0;
				mario.fireballNum=0;
				mario.life=3;
				dispose();
				Loading loading=new Loading();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b2){
			System.exit(0);
		}
	}
		
}

	  

