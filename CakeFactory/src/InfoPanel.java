import java.awt.*;
import javax.swing.*;

public class InfoPanel extends JPanel{

	private Image background;
	Costumer costumer1;
	
	InfoPanel(Costumer costumer) throws ClassNotFoundException{
		
		background=new ImageIcon("back7.jpg").getImage();
		
		JLabel firstNameLabel=new JLabel("First name:               "+costumer.firstName);
		JLabel lastNameLabel=new JLabel("Last name:               "+costumer.lastName);
		JLabel idNumberLabel=new JLabel("Id number:               "+costumer.idNumber);
		JLabel contactNumberLabel=new JLabel("Contact number:    "+costumer.contactNumber);
		
		firstNameLabel.setBounds(10,29,400,20);
		lastNameLabel.setBounds(10,60,400,20);
		idNumberLabel.setBounds(10,88,400,20);
		contactNumberLabel.setBounds(10,119,400,20);
		
		
		lastNameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		idNumberLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		contactNumberLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		firstNameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		
		firstNameLabel.setVerticalAlignment(JLabel.TOP);
		lastNameLabel.setVerticalAlignment(JLabel.TOP);
		idNumberLabel.setVerticalAlignment(JLabel.TOP);
		contactNumberLabel.setVerticalAlignment(JLabel.TOP);
		
	    this.setBounds(10,10,400,150);
		this.setBackground(new Color(255,204,255));
        this.setLayout(null);
        this.add(firstNameLabel);
		this.add(lastNameLabel);
		this.add(idNumberLabel);
		this.add(contactNumberLabel);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
	}
}
