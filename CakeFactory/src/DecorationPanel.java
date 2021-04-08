import java.awt.*;
import javax.swing.*;

public class DecorationPanel extends JPanel{

	public JTextArea decorationTextArea;
	private Image background;
	
	DecorationPanel(){
		
		this.setBounds(500,60,320,400);
		this.setBackground(Color.RED);
		this.setLayout(null);
		
		background=new ImageIcon("back7.jpg").getImage();
		
		JLabel descriptionLabel = new JLabel("Description of a decoration");
		descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		descriptionLabel.setBounds(22, 11, 204, 14);
		add(descriptionLabel);
		
		JLabel exampleLabel = new JLabel("(color,theme,decorational objects....)");
		exampleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		exampleLabel.setBounds(22, 29, 288, 14);
		add(exampleLabel);
		
		decorationTextArea = new JTextArea();
		decorationTextArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		decorationTextArea.setBounds(22, 54, 275, 310);
		add(decorationTextArea);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
	}
}