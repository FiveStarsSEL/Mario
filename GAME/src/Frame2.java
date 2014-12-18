import javax.swing.JFrame;


public class Frame2 {
	public Frame2(int charc){
		JFrame frame=new JFrame();
		frame.add(new Board2(charc, frame));
		frame.setTitle("Mario");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
	
		
	}

}
