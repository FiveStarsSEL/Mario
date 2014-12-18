import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Enter extends JFrame implements ActionListener{
	
	private JLabel l0=new JLabel(new ImageIcon("SMario/Welcome2.png"));
	private JLabel l1;
	private JLabel l2=new JLabel(new ImageIcon("SMario/choosechar.png"));
	private ImageIcon character1 = new ImageIcon("SMario/char1.png");
    private JButton b1 = new JButton (character1);
    private ImageIcon character2 = new ImageIcon("SMario/char2.png");
    private JButton b2 = new JButton (character2);
       
	public Enter(String cName){
		
		setContentPane(new JLabel(new ImageIcon("SMario/Mario_back2.jpg")));
		setTitle("Mario");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); 
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		l1=new JLabel(cName + ",");
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		l2.setFont(new Font("Serif", Font.BOLD, 40));
		add(l0);
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
			dispose();
			new Frame1(1);
		}
		if(e.getSource()==b2){
			dispose();
			new Frame1(2);
		}
	}
		
}

	  

