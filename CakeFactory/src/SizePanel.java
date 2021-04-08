import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SizePanel extends JPanel{

	JRadioButton squareRadioButton;
	JRadioButton circleRadioButton;
	ButtonGroup shapeButtonGroup;
	JRadioButton smallRadioButton;
	JRadioButton mediumRadioButton;
	JRadioButton largeRadioButton;
	ButtonGroup sizeButtonGroup;
	JRadioButton oneRadioButton;
	JRadioButton twoRadioButton;
	JRadioButton threeRadioButton;
	ButtonGroup numberButtonGroup;
	Image background;
	
	SizePanel(){
		
		background=new ImageIcon("back7.jpg").getImage();
		
		JLabel shapeLabel=new JLabel("Shape: ");
		shapeLabel.setBounds(5,5,60,20);
		shapeLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(shapeLabel);
		
		squareRadioButton=new JRadioButton("square");
		squareRadioButton.setContentAreaFilled(false);
		squareRadioButton.setBounds(220,0, 135, 30);
		squareRadioButton.setBackground(new Color(255,204,255));
		squareRadioButton.setFocusable(false);
		squareRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(squareRadioButton);
		
		circleRadioButton=new JRadioButton("circle");
		circleRadioButton.setContentAreaFilled(false);
		circleRadioButton.setBounds(130, 0, 80, 30);
		circleRadioButton.setBackground(new Color(255,204,255));
		circleRadioButton.setFocusable(false);
		circleRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(circleRadioButton);
		
		shapeButtonGroup=new ButtonGroup();
    	shapeButtonGroup.add(squareRadioButton);
		shapeButtonGroup.add(circleRadioButton);
			
		JLabel sizeLabel=new JLabel("Size of a cake:");
		sizeLabel.setBounds(5, 45, 120, 20);
		sizeLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(sizeLabel);
		
		smallRadioButton=new JRadioButton("small");
		smallRadioButton.setContentAreaFilled(false);
		smallRadioButton.setBounds(130, 40, 80, 30);
		smallRadioButton.setBackground(new Color(255,204,255));
		smallRadioButton.setFocusable(false);
		smallRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(smallRadioButton);
		
		mediumRadioButton=new JRadioButton("medium");
		mediumRadioButton.setContentAreaFilled(false);
		mediumRadioButton.setBounds(220, 40, 80, 30);
		mediumRadioButton.setFocusable(false);
		mediumRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(mediumRadioButton);
		
		
		largeRadioButton=new JRadioButton("large");
		largeRadioButton.setContentAreaFilled(false);
		largeRadioButton.setBounds(310, 40, 80, 30);
		largeRadioButton.setBackground(new Color(255,204,255));
		largeRadioButton.setFocusable(false);
		largeRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(largeRadioButton);
			
		sizeButtonGroup=new ButtonGroup();
		sizeButtonGroup.add(smallRadioButton);
		sizeButtonGroup.add(mediumRadioButton);
		sizeButtonGroup.add(largeRadioButton);
		
		JLabel teirLabel=new JLabel("Number of teris:");
		teirLabel.setBounds(5, 85, 120, 20);
		teirLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(teirLabel);
		
		oneRadioButton=new JRadioButton("one");
		oneRadioButton.setContentAreaFilled(false);
		oneRadioButton.setBounds(130, 80, 80, 30);
		oneRadioButton.setBackground(new Color(255,204,255));
		oneRadioButton.setFocusable(false);
		oneRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(oneRadioButton);
		
		twoRadioButton=new JRadioButton("two");
		twoRadioButton.setContentAreaFilled(false);
		twoRadioButton.setBounds(220, 80, 80, 30);
		twoRadioButton.setBackground(new Color(255,204,255));
		twoRadioButton.setFocusable(false);
		twoRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(twoRadioButton);
	
		threeRadioButton=new JRadioButton("three");
		threeRadioButton.setContentAreaFilled(false);
		threeRadioButton.setBounds(310, 80, 80, 30);
		threeRadioButton.setBackground(new Color(255,204,255));
		threeRadioButton.setFocusable(false);
		threeRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(threeRadioButton);
		
		numberButtonGroup=new ButtonGroup();
		numberButtonGroup.add(oneRadioButton);
		numberButtonGroup.add(twoRadioButton);
		numberButtonGroup.add(threeRadioButton);
		
	    this.setBounds(10,240,400,120);
	    this.setBackground(new Color(255,204,255));
	    this.setLayout(null);		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
		g.drawLine(0,40,400,40);
		g.drawLine(0,80,400,80);
	}
}
