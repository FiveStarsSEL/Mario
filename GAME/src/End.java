import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class End extends JFrame implements ActionListener{
	
	private Mario mario;
	private JLabel l1=new JLabel(new ImageIcon("SMario/GameOverW.png"));
	private JLabel l2=new JLabel(new ImageIcon("SMario/replay.png"));
    private JButton b1 = new JButton ("Yes");
    private JButton b2 = new JButton ("No");
    
	public End(int charc){
		mario=new Mario(charc);
		setTitle("Mario");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); 
		//setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("SMario/gameOver.png")));
		setLayout(new FlowLayout());
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		l2.setFont(new Font("Serif", Font.BOLD, 40));
		l1.setForeground(Color.YELLOW);
		l2.setForeground(Color.YELLOW);
		add(l1);
		add(l2);
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
				mario.coin=0;
				mario.fireballNum=0;
				mario.life=2;
				dispose();
					new EnterName();
		}
		else if(e.getSource()==b2){
			System.exit(0);
		}
	}
		
}

	  

