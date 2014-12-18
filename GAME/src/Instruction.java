
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Instruction extends JFrame implements ActionListener {
	
	private JButton b1 = new JButton("Back");
	
	public Instruction()
	{
		setContentPane(new JLabel(new ImageIcon("SMario/Mario_Inst.jpg")));
		
		setTitle("Mario");
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); 
		
		setLayout(null);
		add(b1);
		Dimension size = b1.getPreferredSize();
		b1.setBounds(420, 10, size.width, size.height );
		b1.setBackground(Color.WHITE);
		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1){
			dispose();
			new EnterName();
		}
	}

}
