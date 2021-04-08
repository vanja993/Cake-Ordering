import java.awt.*;
import javax.swing.*;

public class FlavorPanel extends JPanel{

	public JComboBox<String> flavorComboBox;
	public JComboBox<String> fillingComboBox;
	public JComboBox<String> jamComboBox;
	public JComboBox<String> fruitComboBox;
	public JCheckBox jamCheckBox;
	public ButtonGroup toppingButtonGroup;
	public JCheckBox fruitCheckBox;
	public JRadioButton fondantRadioButton;
	public JRadioButton frostingRadioButton;
	private Image background;
	
	FlavorPanel(){
		
		this.setBounds(10,450,400,200);
		this.setBackground(new Color(255,204,255));
		this.setLayout(null);
		
		background=new ImageIcon("back7.jpg").getImage();
		Font font=new Font(null,Font.PLAIN,15);
		
		JLabel flavorLabel=new JLabel("Sponge Flavor:");
		flavorLabel.setBounds(5, 5, 150, 20);
		flavorLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(flavorLabel);
		
		String[] flavors= {"Chocolate","Vanilla","Strawberry","Coconut","Lemon"};
	    flavorComboBox=new JComboBox<String>(flavors);
	    flavorComboBox.setBounds(170, 7, 150, 20);
	    this.add(flavorComboBox);
        
	    JLabel fillingLabel=new JLabel("Fillings:");
	    fillingLabel.setBounds(5,40,100,20);
		fillingLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(fillingLabel);
	    
	    String[] fillIn= {"Vanilla","Chocolate","Cococnut",
	        		      "Lemon raspberry","Orange","Blueberry","Strawberry","Passion fruit","Pinaple",
	        		      "Rum"};
	    fillingComboBox=new JComboBox<String>(fillIn);
	    fillingComboBox.setBounds(220,40,100,20);
	    this.add(fillingComboBox);
	       
	    JLabel creamLabel=new JLabel("Cream: ");
	    creamLabel.setBounds(110,40,100,20);
	    creamLabel.setFont(new Font("Dialog", Font.BOLD, 15));
	    this.add(creamLabel);
	    
	    JLabel jamLabel=new JLabel("Jam: ");
	    jamLabel.setBounds(110,70,50,20);
		jamLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		this.add(jamLabel);
	    	  
	    String[] jamIn= {"Strawberry","Plum","Apple","Apricot","Pinaple","Lemon-Raspberry"};
	    jamComboBox=new JComboBox<String>(jamIn);
	    jamComboBox.setBounds(220,70,100,20);
	    this.add(jamComboBox);
	    	
	    JLabel fruitLabel=new JLabel("Fruit");
	    fruitLabel.setBounds(110,100,50,20);
	    fruitLabel.setFont(new Font("Dialog", Font.BOLD, 15));
	    this.add(fruitLabel);
	    	
	    String[] fruitIn= {"Orange","Strawberry","Bannana","Pinaple","Cherry","Kiwi","Peaches"};
	    fruitComboBox=new JComboBox<String>(fruitIn);
	    fruitComboBox.setBounds(220,100,100,20);
	    this.add(fruitComboBox);
   
		JLabel toppingLabel = new JLabel("Toppings:");
		toppingLabel.setSize(85, 20);
		toppingLabel.setLocation(5, 152);
		toppingLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		add(toppingLabel);
			
		jamCheckBox = new JCheckBox("");
		jamCheckBox.setBounds(170, 67, 30, 23);
		jamCheckBox.setContentAreaFilled(false);
		add(jamCheckBox);
			
		fruitCheckBox = new JCheckBox("");
		fruitCheckBox.setBounds(170, 101, 30, 23);
		fruitCheckBox.setContentAreaFilled(false);
		add(fruitCheckBox);
			
		toppingButtonGroup=new ButtonGroup();
		fondantRadioButton = new JRadioButton("fondant");
		fondantRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		fondantRadioButton.setBounds(110, 153, 109, 23);
		fondantRadioButton.setContentAreaFilled(false);
		add(fondantRadioButton);
			
		frostingRadioButton = new JRadioButton("frosting");
		frostingRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		frostingRadioButton.setBounds(221, 153, 109, 23);
		frostingRadioButton.setContentAreaFilled(false);
		add(frostingRadioButton);
			
		toppingButtonGroup=new ButtonGroup();
		toppingButtonGroup.add(fondantRadioButton);
		add(fondantRadioButton);
		toppingButtonGroup.add(frostingRadioButton);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
		g.drawLine(0, 32, 400, 32);
		g.drawLine(0, 140, 400, 140);
	}
}