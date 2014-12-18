import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


public class EnterName extends JFrame implements ActionListener {
	
	private JLabel l1=new JLabel(new ImageIcon("SMario/Welcome.png"));
	private JLabel l2=new JLabel(new ImageIcon("SMario/EnterName.png"));
	public TextField t1=new TextField(15);
	public JButton b1=new JButton("OK");
	public String name;
	
	private JButton b2 = new JButton("", new ImageIcon("SMario/htpButton.png")); 
	
	public EnterName()
	{
		setContentPane(new JLabel(new ImageIcon("SMario/enter2.jpg")));
		setTitle("Mario");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500,500);
		setLayout(new FlowLayout());
			
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		l2.setFont(new Font("Serif", Font.BOLD, 40));
		t1.setFont(new Font("Serif", Font.BOLD, 20));
		add(l1);
		add(l2);
		add(t1);
		add(b1);
		add(b2);
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		t1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=t1.getText();
				dispose();
				new Enter(name);
			   }
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1){
			name=t1.getText();
			dispose();
			new Enter(name);			
		}
		if(e.getSource()==b2){
			dispose();
			new Instruction();			
		}
	}

}
