import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Loading extends JFrame {
	
	private JLabel l1 = new JLabel("Welcome to Mario");
	private JLabel l2 = new JLabel(new ImageIcon("SMario/still.png"));
	private int x = 20, y = 350;
	
	public Loading() throws InterruptedException{
		setTitle("Mario");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(new JLabel(new ImageIcon("SMario/loading.gif")));
		setBackground(Color.WHITE);
		setLayout(new FlowLayout());
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		setSize(500,500);
		setLayout(null);
		
		moving();
		
	    dispose();
	    new EnterName();
	    
	}	
	
	public void moving() throws InterruptedException
	{
		Dimension size = l2.getPreferredSize();
		x=x+2;
		if(x < 500 )
		{
			Thread.sleep(10); 
			l2.setBounds(x, y, size.width, size.height );
			add(l2);
			moving();
		}
	}
	
	

}
