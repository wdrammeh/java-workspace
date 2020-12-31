package gui.design;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class InnerFrames extends JFrame {
	
	public static void main(String args[]) {
		new InnerFrames();
		
//		JInternalFrame ji = new JInternalFrame(title, resizable, closable, maximizable, iconifiable)
	}
	
	public InnerFrames() {
		CustomDesktopPane desktopPane = new CustomDesktopPane();
		Container contentPane = this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.display(desktopPane);
		setTitle("JDesktopPane Example");
		setSize(300,350);
		setVisible(true);
	}

}
	@SuppressWarnings("serial")
	class CustomDesktopPane extends JDesktopPane {
		int numFrames = 3, x = 30, y = 30;
		
		public void display(CustomDesktopPane dp) {
			
			for(int i = 0; i < numFrames; ++i ) {
				
			JInternalFrame jframe = new JInternalFrame("Internal Frame " + i , true, true, true, true);
			jframe.setBounds(x, y, 250, 85);
			Container c1 = jframe.getContentPane() ;
			c1.add(new JLabel("I love my country"));
			dp.add(jframe);
			jframe.setVisible(true);
			y += 85;
	}
  }
}
