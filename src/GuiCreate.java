import java.awt.*;

import javax.swing.*;

public class GuiCreate extends JFrame{
	JFrame gamewindow = new JFrame();;
	Container window = gamewindow.getContentPane();
	
	public void beginningPane(){
		setSize(300,400);
		setVisible(true);
		window.setLayout(new GridLayout(2,1));
		JLabel textdisplay = new JLabel();
		JPanel buttonbox = new JPanel();
		
		gamewindow.add(textdisplay);
		
		
	}

}
