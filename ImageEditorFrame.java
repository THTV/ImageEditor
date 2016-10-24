import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ImageEditorFrame extends JFrame{

	
	 public ImageEditorFrame(){
		 createMenuBar();
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setSize(400, 300);
		 setVisible(true);
		 setTitle("fancy title over 9000");
		 ImageEditorPanel panel = new ImageEditorPanel();
		 add(panel);	
	 }
	 
	 private void onOpen1(){
		 ImageEditorPanel panel = null;
		 JFileChooser fileChooser = new JFileChooser();
		 fileChooser.showOpenDialog(this);
		 File file = fileChooser.getSelectedFile();
		 BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 panel.setImage(image);
	 }

	 private void setDummyImage(){ 
		 	ImageEditorPanel panel = new ImageEditorPanel();
	 		BufferedImage bufferedImage = 
	 		new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB); 
	 		Graphics g = bufferedImage.getGraphics(); 
	 		g.setColor(Color.YELLOW); 
	 		g.fillOval(10, 10, 380, 280); 
	 		panel.setImage(bufferedImage); 
		 	setVisible(true);		
		 	setTitle("fancy title over 9000");
	 }

	 
	 private void createMenuBar(){
		 
		 JMenuBar menuBar = new JMenuBar();
		 setJMenuBar(menuBar);
		 JMenu menuFile = new JMenu("File");
		 menuBar.add(menuFile);
		 JMenuItem menuItemOpen = new JMenuItem("Open");
		 menuFile.add(menuItemOpen);
		 menuItemOpen.addActionListener(
			 new ActionListener() {
				 public void actionPerformed(ActionEvent e){
					 onOpen1();
				}
			 }
		 );
	}
				private void onOpen(){
					JOptionPane.showMessageDialog(this, "Open Selected");
				}

}
