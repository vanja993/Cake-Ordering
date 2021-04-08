import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class DatePanel extends JPanel{

	public JRadioButton yesRadioButton;
	public JRadioButton noRadioButton;
	public JTextField addressTextField;
	public ButtonGroup addressButtonGroup;
	private Image background;
	public JDateChooser dateChooser;
	
	DatePanel(){

		this.setBounds(500,500,300,150);
		this.setBackground(Color.PINK);
		this.setLayout(null);
		
		background=new ImageIcon("back7.jpg").getImage();
		
		JLabel dayLabel = new JLabel("Day of delivery:");
		dayLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		dayLabel.setBounds(10, 15, 126, 26);
		add(dayLabel);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(146, 15, 127, 26);
		add(dateChooser);
		
		JLabel deliveryLabel = new JLabel("Home delivery:");
		deliveryLabel.setBounds(10, 55, 132, 26);
		add(deliveryLabel);
		
		yesRadioButton= new JRadioButton("yes");
		yesRadioButton.setBounds(146, 57, 51, 23);
		yesRadioButton.setContentAreaFilled(false);
		yesRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		add(yesRadioButton);
		
		noRadioButton = new JRadioButton("no");
		noRadioButton.setBounds(210, 56, 44, 23);
		noRadioButton.setContentAreaFilled(false);
		noRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		add(noRadioButton);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(10, 92, 127, 14);
		addressLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		add(addressLabel);
		
		addressButtonGroup=new ButtonGroup();
		addressButtonGroup.add(yesRadioButton);
		addressButtonGroup.add(noRadioButton);
	
		addressTextField = new JTextField();
		addressTextField.setBounds(10, 117, 280, 26);
		addressTextField.setColumns(10);
		add(addressTextField);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
		g.drawLine(0, 50, 300, 50);
	}
}
